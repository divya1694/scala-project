package dao

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.time.{Instant, LocalDateTime, ZoneId}
import javax.inject._

import Util.Helpers
import akka.actor.ActorRef
import com.google.inject.name.Named
import com.typesafe.config._
import models._
import org.joda.time.DateTime
import play.api.Logger
import play.api.libs.json._
import play.api.libs.ws.WSClient

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

class PostgresDAO @Inject()(
                             implicit val ws: WSClient
                           ) {

  object LeadsDB {
    import scala.concurrent.ExecutionContext.Implicits.global
    import slick.jdbc.PostgresProfile.api._
    val conf: Config = ConfigFactory.load()
    val connectionUrl = conf.getString("postgres_leadsDB")
    val db = Database.forURL(url = connectionUrl, driver = "org.postgresql.Driver")

    def getLeadLevelSalesDetails(citySales:ReportAtCityLevel): Future[List[CityLevelModel]] = {
      var from = Helpers.singleQuoteString(citySales.fromDate.concat(" 00:00:00"))
      var to = Helpers.singleQuoteString(citySales.toDate.concat(" 23:59:59"))
      val searchCity = Helpers.singleQuoteString("%" + citySales.city + "%")
      val searchState = Helpers.singleQuoteString(citySales.state)
      val action = sql"""SELECT *
                        FROM table_name WHERE city ILIKE #$searchCity AND "channel"=#$searchState
                        AND "eventOccuredOn">= #$from AND "eventOccuredOn"<= #$to
                        """.as[(String, String, String, String, String, String, String, String, String, String, String, Timestamp)]
      val s = db.run(action) map { t =>
        t.map { az =>
          CityLevelModel(
            mobile = az._1,
            name = az._2,
            city = az._3,
            amount = az._5,
            registrationNum = az._6,
            eventOccurredOn = az._12.toLocalDateTime
          )
        }
      }
      s.map(x => x.toList)
    }


  }
}