package controllers

import javax.inject.Inject
import play.api.mvc.{Action, AnyContent, Controller}
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.concurrent.duration.Duration


class HomeController @Inject()() extends Controller {

  def index: Action[AnyContent] = Action.async {
    Future(Ok("Hello world!"))
  }
}