package controllers

import play.api.libs.concurrent.Akka
import play.api.mvc.{Action, Controller}
import utils.{Contexts, Logging}
import scala.concurrent.{ExecutionContext, Future}

class CustomContext extends Controller with Logging {

  // http://localhost:9000/db
  def db = Action.async {
    implicit val ec = Contexts.db

    val dbFuture = Future("Markus Jura") // Blocking DB Call
    dbFuture.map { result =>
      Ok(s"User name in DB is $result")
    }
  }

  // http://localhost:9000/pi/5
  def calcPi(number: Long) = Action.async {
    implicit val ec = Contexts.cpu

    import Contexts.cpu
    val piFuture = Future(pi(number))
    piFuture.map { result =>
      Ok(s"Pi of $number is : $result")
    }
  }

  private def pi(m: Long) = {
    def gregoryLeibnitz(n: Long) = 4.0 * (1 - (n % 2) * 2) / (n * 2 + 1)
    var n = 0
    var acc = BigDecimal(0.0)
    while (n < m) {
      acc += gregoryLeibnitz(n)
      n += 1
    }
    acc
  }
}
