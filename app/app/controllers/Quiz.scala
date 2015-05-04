package controllers

import play.api.mvc._
import utils.Logging

/**
 * What is faster?
 *
 * ab -n 1000 -c 10 http://localhost:9000/sync
 * ab -n 1000 -c 10 http://localhost:9000/async
 *
 * ab -n 1000 -c 50 http://localhost:9000/sync
 * ab -n 1000 -c 50 http://localhost:9000/async
 */
class Quiz extends Controller with Logging {

  def sync = Action {
    Ok("Synchronous call")
  }

  def async = Action {
    Ok("Cheater, I am synchronous! Make me asynchronous :-)")
  }
}