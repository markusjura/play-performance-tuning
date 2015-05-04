package utils

import play.api.Logger

trait Logging {

  val log = Logger(this.getClass())
}
