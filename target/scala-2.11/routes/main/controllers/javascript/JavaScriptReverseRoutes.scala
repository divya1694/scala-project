
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/dabbu/IdeaProjects/scala-project/conf/routes
// @DATE:Thu Mar 22 19:52:15 IST 2018

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def getJsonFromExcel: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getJsonFromExcel",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "v1/getJsonFromExcel"})
        }
      """
    )
  
    // @LINE:10
    def getCityReportDownload: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getCityReportDownload",
      """
        function(city0,state1,fromDate2,toDate3) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "v1/HomeController/getCityReportDownload" + _qS([(city0 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("city", city0)), (state1 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("state", state1)), (fromDate2 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("fromDate", fromDate2)), (toDate3 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("toDate", toDate3))])})
        }
      """
    )
  
    // @LINE:8
    def getName: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getName",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "v1/getName"})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:7
    def echo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.echo",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "v1/echo"})
        }
      """
    )
  
  }


}
