
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/dabbu/IdeaProjects/scala-project/conf/routes
// @DATE:Mon Mar 19 13:35:45 IST 2018

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
    def getCityReportDownload: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getCityReportDownload",
      """
        function(city0,state1,fromDate2,toDate3) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "leads/HomeController/getCityReportDownload" + _qS([(city0 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("city", city0)), (state1 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("state", state1)), (fromDate2 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("fromDate", fromDate2)), (toDate3 == null ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("toDate", toDate3))])})
        }
      """
    )
  
  }


}
