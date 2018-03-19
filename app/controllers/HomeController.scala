package controllers

import java.io.{File, FileOutputStream}
import javax.inject.Inject

import Util.Helpers
import dao.PostgresDAO
import models.{CityLevelModel, ReportAtCityLevel}
import models.Formats._
import org.apache.poi.xssf.usermodel.{XSSFCell, XSSFWorkbook}
import play.api.libs.json.{JsArray, Json}
import play.api.mvc.{Action, AnyContent, Controller}

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent._
import scala.concurrent.duration.Duration


class HomeController @Inject()(implicit val postGreDao: PostgresDAO) extends Controller {

  def index: Action[AnyContent] = Action.async {
    Future(Ok("Hello world!"))
  }


  def getCityReportDownload(city: String, state: String, fromDate: String, toDate: String) = Action.async {
    request => {
      if (Helpers.isNotBlank(Some(city)) && Helpers.isNotBlank(Some(state)) && Helpers.isNotBlank(Some(fromDate)) && Helpers.isNotBlank(Some(toDate))) {
        val dto = ReportAtCityLevel(
          city = city,
          state= state,
          fromDate = fromDate,
          toDate = toDate
        )
        val folderPath: String = Thread.currentThread.getContextClassLoader.getResource("templates").getPath
        val file: File = new File(folderPath.concat("/").concat("CityLevelData.xlsx"))
        file.createNewFile
        val fileOut = new FileOutputStream(file, false)
        val wb = new XSSFWorkbook
        val sheet = wb.createSheet("Sheet1")
        var row0 = sheet.createRow(0)
        val cell00 = row0.createCell(0)
        cell00.setCellValue("MOBILE")
        val cell01 = row0.createCell(1)
        cell01.setCellValue("NAME")
        val cell02 = row0.createCell(2)
        cell02.setCellValue("CITY")
        val cell03 = row0.createCell(3)
        cell03.setCellValue("AMOUNT")
        val cell04 = row0.createCell(4)
        cell04.setCellValue("REGISTRATION_NUM")
        val cell05 = row0.createCell(5)
        cell05.setCellValue("PAYMENT_STATUS")
        val cell06= row0.createCell(6)
        cell06.setCellValue("EVENT_OCCURRED_ON")
        val s: Seq[CityLevelModel] = Await.result(postGreDao.LeadsDB.getLeadLevelSalesDetails(dto), Duration.Inf)
        val size = Json.toJson(s).as[JsArray].value.size
        var i = 1
        val a = Array.ofDim[XSSFCell](size + 1, 5)
        while (i <= size) {
          s map {
            store =>
              var row = sheet.createRow(i)
              a(i)(0) = row.createCell(0)
              a(i)(0).setCellValue(store.mobile)
              a(i)(1) = row.createCell(1)
              a(i)(1).setCellValue(store.name)
              a(i)(2) = row.createCell(2)
              a(i)(2).setCellValue(store.city)
              a(i)(3) = row.createCell(3)
              a(i)(3).setCellValue(store.amount)
              a(i)(4) = row.createCell(4)
              a(i)(4).setCellValue(store.registrationNum)
              a(i)(5) = row.createCell(5)
              a(i)(5).setCellValue(store.paymentStatus)
              a(i)(6) = row.createCell(6)
              a(i)(6).setCellValue(store.eventOccurredOn.toString)
              i = i + 1
          }
        }
        wb.write(fileOut)
        fileOut.close()
        Future(Ok.sendFile(content = file, inline = false))
      }
      else Future(Ok(Json.obj("code" -> 1, "message" -> "Some of the input parameters are missing")))
    }
  }
}