
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/dabbu/IdeaProjects/scala-project/conf/routes
// @DATE:Mon Mar 19 13:35:45 IST 2018

import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index(): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix)
    }
  
    // @LINE:7
    def getCityReportDownload(city:String = "", state:String = "", fromDate:String = "", toDate:String = ""): Call = {
      import ReverseRouteContext.empty
      Call("GET", _prefix + { _defaultPrefix } + "leads/HomeController/getCityReportDownload" + queryString(List(if(city == "") None else Some(implicitly[QueryStringBindable[String]].unbind("city", city)), if(state == "") None else Some(implicitly[QueryStringBindable[String]].unbind("state", state)), if(fromDate == "") None else Some(implicitly[QueryStringBindable[String]].unbind("fromDate", fromDate)), if(toDate == "") None else Some(implicitly[QueryStringBindable[String]].unbind("toDate", toDate)))))
    }
  
  }


}
