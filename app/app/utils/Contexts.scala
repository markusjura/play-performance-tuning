package utils

import play.api.libs.concurrent.Akka
import play.api.Play.current
import scala.concurrent.ExecutionContext

object Contexts {
  val db: ExecutionContext = Akka.system.dispatchers.lookup("contexts.db-operations")

  val cpu: ExecutionContext = Akka.system.dispatchers.lookup("contexts.cpu-operations")
}
