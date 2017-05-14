
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/Phayao/Development/github/todoapi-scala/conf/routes
// @DATE:Sun May 14 12:53:15 ICT 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
