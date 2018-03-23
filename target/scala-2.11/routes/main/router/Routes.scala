
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/dabbu/IdeaProjects/scala-project/conf/routes
// @DATE:Thu Mar 22 19:52:15 IST 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_1: controllers.HomeController,
  // @LINE:8
  HomeController_0: javax.inject.Provider[controllers.HomeController],
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_1: controllers.HomeController,
    // @LINE:8
    HomeController_0: javax.inject.Provider[controllers.HomeController]
  ) = this(errorHandler, HomeController_1, HomeController_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, HomeController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """v1/echo""", """controllers.HomeController.echo"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """v1/getName""", """@controllers.HomeController@.getName"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """v1/HomeController/getCityReportDownload""", """@controllers.HomeController@.getCityReportDownload(city:String ?= "", state:String ?= "", fromDate:String ?= "", toDate:String ?= "")"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """v1/getJsonFromExcel""", """@controllers.HomeController@.getJsonFromExcel()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_1.index,
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

  // @LINE:7
  private[this] lazy val controllers_HomeController_echo1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("v1/echo")))
  )
  private[this] lazy val controllers_HomeController_echo1_invoker = createInvoker(
    HomeController_1.echo,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "echo",
      Nil,
      "GET",
      """""",
      this.prefix + """v1/echo"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_HomeController_getName2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("v1/getName")))
  )
  private[this] lazy val controllers_HomeController_getName2_invoker = createInvoker(
    HomeController_0.get.getName,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getName",
      Nil,
      "POST",
      """""",
      this.prefix + """v1/getName"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_HomeController_getCityReportDownload3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("v1/HomeController/getCityReportDownload")))
  )
  private[this] lazy val controllers_HomeController_getCityReportDownload3_invoker = createInvoker(
    HomeController_0.get.getCityReportDownload(fakeValue[String], fakeValue[String], fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getCityReportDownload",
      Seq(classOf[String], classOf[String], classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """v1/HomeController/getCityReportDownload"""
    )
  )

  // @LINE:12
  private[this] lazy val controllers_HomeController_getJsonFromExcel4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("v1/getJsonFromExcel")))
  )
  private[this] lazy val controllers_HomeController_getJsonFromExcel4_invoker = createInvoker(
    HomeController_0.get.getJsonFromExcel(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getJsonFromExcel",
      Nil,
      "POST",
      """""",
      this.prefix + """v1/getJsonFromExcel"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_1.index)
      }
  
    // @LINE:7
    case controllers_HomeController_echo1_route(params) =>
      call { 
        controllers_HomeController_echo1_invoker.call(HomeController_1.echo)
      }
  
    // @LINE:8
    case controllers_HomeController_getName2_route(params) =>
      call { 
        controllers_HomeController_getName2_invoker.call(HomeController_0.get.getName)
      }
  
    // @LINE:10
    case controllers_HomeController_getCityReportDownload3_route(params) =>
      call(params.fromQuery[String]("city", Some("")), params.fromQuery[String]("state", Some("")), params.fromQuery[String]("fromDate", Some("")), params.fromQuery[String]("toDate", Some(""))) { (city, state, fromDate, toDate) =>
        controllers_HomeController_getCityReportDownload3_invoker.call(HomeController_0.get.getCityReportDownload(city, state, fromDate, toDate))
      }
  
    // @LINE:12
    case controllers_HomeController_getJsonFromExcel4_route(params) =>
      call { 
        controllers_HomeController_getJsonFromExcel4_invoker.call(HomeController_0.get.getJsonFromExcel())
      }
  }
}
