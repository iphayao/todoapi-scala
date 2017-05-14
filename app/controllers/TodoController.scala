package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._
import play.api.data._
import play.api.data.Forms._

import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.collection.mutable._
import scala.util._

import models._

/**
 * This controller creates an 'Action' to handle HTTP requests to the
 * application's Todo API
 */

object TodoAction extends ActionBuilder[Request] {
    def invokeBlock[A](request: Request[A], block: (Request[A]) => Future[Result]) = {
        Logger.info("Calling Action")
        block(request)
    }
}

case class TaskData(id: String, subject: String, content: String, status: String)

object TaskData {
    implicit val implicitWrite = new Writes[TaskData] {
        // Mapping to write a TaskData out as a JSON value.
        def writes(item: TaskData): JsValue = {
            Json.obj(
                "id" -> item.id,
                "subject" -> item.subject,
                "content" -> item.content,
                "status" -> item.status
            )
        }
    }
}

@Singleton
class TodoController @Inject()(handle: TodoRepository) extends Controller {
    /**
     * Create an Action to rander an HTML pages.
     * 
     * The configuration in the 'routes' file means that this method
     * will be called when the application receives a 'GET' request with
     * a part of '/api'
     */

    val userForm = Form(
        mapping (
            "id" -> text,
            "subject" -> text,
            "content" -> text,
            "status" -> text
        )(TaskData.apply)(TaskData.unapply)
    )
    
    def hello(name: String) = Action {
        Ok("Hello -> " + name)
    }

    def getTasks() = TodoAction.async { implicit request => 
        handle.list() map { tasks => 
            Ok {
                Json toJson {
                    tasks map { case (k, v) => createTaskData(k, v) }
                }
            }
        }
    }

    def getTask(id: String) = TodoAction.async { implicit request =>
        handle.get(TaskId(id)) map { tasks =>
            Ok {
                Json toJson {
                    tasks map { case (k, v) => createTaskData(k, v) }
                }
            }
        }
    }

    def deleteTask(id: String) = TodoAction.async { implicit request =>
        handle.delete(TaskId(id)) map { x =>
            Ok
        } 
    }

    def addTask() = TodoAction.async { implicit request => 
        val t = userForm.bindFromRequest.get
        handle.create(TaskId(t.id), TaskItem( t.subject, t.content, TaskStatus.pending )) map { result =>
            if(result) 
                Created
             else
                Conflict 
        }
    }

    def editTask() = TodoAction.async { implicit request =>
        val t = userForm.bindFromRequest.get
        handle.update(TaskId(t.id), TaskItem( t.subject, t.content, TaskStatus.pending )) map { result =>
            if(result)
                Ok
            else
                BadRequest
        }
    }

    def modifyTask(id: String, status: String) = TodoAction.async { implicit request => 
        handle.modify(TaskId(id), TaskStatus.done) map { x =>
            Ok
        }
    }

    private def createTaskData(k:TaskId, v:TaskItem): TaskData = {
        TaskData(k.toString, v.subject, v.content, v.status.toString)
    }
}