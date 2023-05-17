package com.peknight.ciris.instances.http4s

import ciris.ConfigDecoder
import com.comcast.ip4s.Host

trait HostInstances:
  given ConfigDecoder[String, Host] = ConfigDecoder.identity[String].mapOption("Host")(Host.fromString)
end HostInstances
object HostInstances extends HostInstances
