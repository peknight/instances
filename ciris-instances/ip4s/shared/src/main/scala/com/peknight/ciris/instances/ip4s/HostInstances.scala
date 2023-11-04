package com.peknight.ciris.instances.ip4s

import ciris.ConfigDecoder
import com.comcast.ip4s.{Host, Hostname, IDN, IpAddress, Ipv4Address, Ipv6Address}

trait HostInstances:
  given ConfigDecoder[String, Hostname] =
    ConfigDecoder.identity[String].mapOption("Hostname")(Hostname.fromString)
  given ConfigDecoder[String, IDN] =
    ConfigDecoder.identity[String].mapOption("IDN")(IDN.fromString)
  given ConfigDecoder[String, Ipv4Address] =
    ConfigDecoder.identity[String].mapOption("Ipv4Address")(Ipv4Address.fromString)
  given ConfigDecoder[String, Ipv6Address] =
    ConfigDecoder.identity[String].mapOption("Ipv6Address")(Ipv6Address.fromString)
  given ConfigDecoder[String, IpAddress] =
    ConfigDecoder.identity[String].mapOption("IpAddress")(IpAddress.fromString)
  given ConfigDecoder[String, Host] =
    ConfigDecoder.identity[String].mapOption("Host")(Host.fromString)
end HostInstances
