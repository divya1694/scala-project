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
      val searchChannelPartner = Helpers.singleQuoteString(citySales.state)

      val action = sql"""SELECT *
                        FROM lead_status_level_reports WHERE city ILIKE #$searchCity AND "channel"=#$searchChannelPartner
                        AND "eventOccuredOn">= #$from AND "eventOccuredOn"<= #$to
                        """.as[(String, String, String, String, String, String, String, String, String, String, String, Timestamp)]

      val s = db.run(action) map { t =>
        t.map { az =>
          CityLevelModel(
            mobile = az._1,
            name = az._2,
            city = az._3,
            partnerID = az._4,
            amount = az._5,
            registrationNum = az._6,
            paymentStatus = az._7,
            makerStatus = az._8,
            checkerStatus = az._9,
            confirmStatus = az._10,
            channel = az._11,
            eventOccurredOn = az._12.toLocalDateTime
          )
        }
      }
      s.map(x => x.toList)
    }


  }
}