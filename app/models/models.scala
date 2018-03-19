package models

import java.time.LocalDateTime

import play.api.libs.json.{Json, OFormat}


case class ReportAtCityLevel (
                             city:String,
                             state:String,
                             fromDate:String,
                             toDate:String
                            )


case class CityLevelModel(
                           mobile:String,
                           name:String,
                           city:String,
                           partnerID:String,
                           amount:String,
                           registrationNum:String,
                           paymentStatus:String,
                           makerStatus:String,
                           checkerStatus:String,
                           confirmStatus:String,
                           channel:String,
                           eventOccurredOn:LocalDateTime
                         )

case class LeadsReportByPage(city:String,
                             channelPartner:String,
                             fromDate:String,
                             toDate:String,
                             pageNo: Int,
                             pageSize:Int
                            )


object Formats {
  implicit val ReportAtCityLevelTOFmt: OFormat[ReportAtCityLevel] = Json.format[ReportAtCityLevel]
  implicit val CityLevelModelTOFmt: OFormat[CityLevelModel] = Json.format[CityLevelModel]
  implicit val LeadsReportByPageTOFmt: OFormat[LeadsReportByPage] = Json.format[LeadsReportByPage]

}