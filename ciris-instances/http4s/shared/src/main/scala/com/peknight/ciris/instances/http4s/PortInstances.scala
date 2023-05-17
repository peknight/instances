package com.peknight.ciris.instances.http4s

import ciris.ConfigDecoder
import com.comcast.ip4s.Port

trait PortInstances:
  given ConfigDecoder[String, Port] = ConfigDecoder.identity[String].mapOption("Port")(Port.fromString)
end PortInstances
object PortInstances extends PortInstances

