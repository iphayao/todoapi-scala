
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/Phayao/Development/github/todoapi-scala/conf/routes
// @DATE:Sun May 14 12:53:15 ICT 2017

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:8
  class ReverseTodoController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def getTasks: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TodoController.getTasks",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/tasks"})
        }
      """
    )
  
    // @LINE:10
    def deleteTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TodoController.deleteTask",
      """
        function(id0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "api/task/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id0))})
        }
      """
    )
  
    // @LINE:11
    def addTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TodoController.addTask",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "api/task"})
        }
      """
    )
  
    // @LINE:13
    def modifyTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TodoController.modifyTask",
      """
        function(id0,status1) {
          return _wA({method:"PATCH", url:"""" + _prefix + { _defaultPrefix } + """" + "api/task/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id0)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("status", encodeURIComponent(status1))})
        }
      """
    )
  
    // @LINE:12
    def editTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TodoController.editTask",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "api/task"})
        }
      """
    )
  
    // @LINE:9
    def getTask: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TodoController.getTask",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/task/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id0))})
        }
      """
    )
  
  }

  // @LINE:7
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:16
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
