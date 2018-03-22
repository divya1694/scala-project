
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/dabbu/IdeaProjects/scala-project/conf/routes
// @DATE:Thu Mar 22 18:16:49 IST 2018


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
