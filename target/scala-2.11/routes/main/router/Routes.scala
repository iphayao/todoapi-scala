
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/Phayao/Development/github/todoapi-scala/conf/routes
// @DATE:Sun May 14 12:53:15 ICT 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  HomeController_0: controllers.HomeController,
  // @LINE:8
  TodoController_2: controllers.TodoController,
  // @LINE:16
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    HomeController_0: controllers.HomeController,
    // @LINE:8
    TodoController_2: controllers.TodoController,
    // @LINE:16
    Assets_1: controllers.Assets
  ) = this(errorHandler, HomeController_0, TodoController_2, Assets_1, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, TodoController_2, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/tasks""", """controllers.TodoController.getTasks"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/task/""" + "$" + """id<[^/]+>""", """controllers.TodoController.getTask(id:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/task/""" + "$" + """id<[^/]+>""", """controllers.TodoController.deleteTask(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/task""", """controllers.TodoController.addTask"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/task""", """controllers.TodoController.editTask"""),
    ("""PATCH""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/task/""" + "$" + """id<[^/]+>/""" + "$" + """status<[^/]+>""", """controllers.TodoController.modifyTask(id:String, status:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      """ An example controller showing a sample home page""",
      this.prefix + """"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_TodoController_getTasks1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/tasks")))
  )
  private[this] lazy val controllers_TodoController_getTasks1_invoker = createInvoker(
    TodoController_2.getTasks,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TodoController",
      "getTasks",
      Nil,
      "GET",
      """""",
      this.prefix + """api/tasks"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_TodoController_getTask2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/task/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TodoController_getTask2_invoker = createInvoker(
    TodoController_2.getTask(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TodoController",
      "getTask",
      Seq(classOf[String]),
      "GET",
      """""",
      this.prefix + """api/task/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_TodoController_deleteTask3_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/task/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TodoController_deleteTask3_invoker = createInvoker(
    TodoController_2.deleteTask(fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TodoController",
      "deleteTask",
      Seq(classOf[String]),
      "DELETE",
      """""",
      this.prefix + """api/task/""" + "$" + """id<[^/]+>"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_TodoController_addTask4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/task")))
  )
  private[this] lazy val controllers_TodoController_addTask4_invoker = createInvoker(
    TodoController_2.addTask,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TodoController",
      "addTask",
      Nil,
      "POST",
      """""",
      this.prefix + """api/task"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_TodoController_editTask5_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/task")))
  )
  private[this] lazy val controllers_TodoController_editTask5_invoker = createInvoker(
    TodoController_2.editTask,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TodoController",
      "editTask",
      Nil,
      "PUT",
      """""",
      this.prefix + """api/task"""
    )
  )

  // @LINE:13
  private[this] lazy val controllers_TodoController_modifyTask6_route = Route("PATCH",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/task/"), DynamicPart("id", """[^/]+""",true), StaticPart("/"), DynamicPart("status", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TodoController_modifyTask6_invoker = createInvoker(
    TodoController_2.modifyTask(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TodoController",
      "modifyTask",
      Seq(classOf[String], classOf[String]),
      "PATCH",
      """""",
      this.prefix + """api/task/""" + "$" + """id<[^/]+>/""" + "$" + """status<[^/]+>"""
    )
  )

  // @LINE:16
  private[this] lazy val controllers_Assets_versioned7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned7_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_HomeController_index0_route(params) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index)
      }
  
    // @LINE:8
    case controllers_TodoController_getTasks1_route(params) =>
      call { 
        controllers_TodoController_getTasks1_invoker.call(TodoController_2.getTasks)
      }
  
    // @LINE:9
    case controllers_TodoController_getTask2_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_TodoController_getTask2_invoker.call(TodoController_2.getTask(id))
      }
  
    // @LINE:10
    case controllers_TodoController_deleteTask3_route(params) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_TodoController_deleteTask3_invoker.call(TodoController_2.deleteTask(id))
      }
  
    // @LINE:11
    case controllers_TodoController_addTask4_route(params) =>
      call { 
        controllers_TodoController_addTask4_invoker.call(TodoController_2.addTask)
      }
  
    // @LINE:12
    case controllers_TodoController_editTask5_route(params) =>
      call { 
        controllers_TodoController_editTask5_invoker.call(TodoController_2.editTask)
      }
  
    // @LINE:13
    case controllers_TodoController_modifyTask6_route(params) =>
      call(params.fromPath[String]("id", None), params.fromPath[String]("status", None)) { (id, status) =>
        controllers_TodoController_modifyTask6_invoker.call(TodoController_2.modifyTask(id, status))
      }
  
    // @LINE:16
    case controllers_Assets_versioned7_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned7_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
