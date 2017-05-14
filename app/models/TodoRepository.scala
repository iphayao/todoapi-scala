package models

import javax.inject._
import play.api._
import play.api.mvc._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.collection.mutable._

object TaskStatus extends Enumeration {
    type TaskStatus = Value
    val pending, done = Value
}

import TaskStatus._

final case class TaskItem(subject: String, content: String, status: TaskStatus)

class TaskId private (val underlying: Int) extends AnyVal {
    override def toString: String = underlying.toString
}

object TaskId {
    def apply(raw: String): TaskId = {
        require(raw != null)
        new TaskId(Integer.parseInt(raw))
    }
}

trait TodoRepository {
    def list(): Future[Map[TaskId, TaskItem]]
    def get(id: TaskId): Future[Map[TaskId, TaskItem]]
    def create(id: TaskId, value: TaskItem): Future[Boolean]
    def update(id: TaskId, value: TaskItem): Future[Boolean]
    def modify(id: TaskId, status: TaskStatus): Future[Boolean]
    def delete(id: TaskId): Future[Boolean]
}

@Singleton
class TodoRepositoryImp @Inject() extends TodoRepository {

    private var taskMap = Map(
        TaskId("1") -> TaskItem("Subject1", "Content1", TaskStatus.pending),
        TaskId("2") -> TaskItem("Subject2", "Content2", TaskStatus.pending)
    )

    override def list(): Future[Map[TaskId, TaskItem]] = {
        Future.successful {
            taskMap
        }
    }

    override def get(id: TaskId): Future[Map[TaskId, TaskItem]] = {
        Future.successful {
            Map() ++ (taskMap filterKeys (_ == id))
        }
    }

    override def create(id: TaskId, value: TaskItem): Future[Boolean] = {
        Future.successful {
            if(taskMap contains id) {
                false
            }
            else {
                taskMap put (id, value)
                true
            }
        }
    }

    override def update(id: TaskId, value: TaskItem): Future[Boolean] = {
        Future.successful {
            if(taskMap contains id) {
                taskMap put (id , value)
                true                
            }
            else {
                false
            }
        }
    }

    override def modify(id: TaskId, status: TaskStatus): Future[Boolean] = {
        Future.successful {
            if(taskMap contains id) {
                var t = taskMap(id)
                var yaskItem = TaskItem(t.subject, t.content, status)
                taskMap(id) = yaskItem
                true
            }
            else {
                false
            }
        }
    }

    override def delete(id: TaskId): Future[Boolean] = {
        Future.successful {
            if(taskMap contains id) {
                taskMap -= id
                true
            }
            else {
                false
            }
        }
    }
}

