package com.peknight.circe.instances.ip4s

import com.comcast.ip4s.*
import io.circe.*
import io.circe.Decoder.Result
import io.circe.DecodingFailure.Reason.WrongTypeExpectation

trait HostInstances:

  def hostCodec[H <: Host](expectedJsonFieldType: String)(fromString: String => Option[H]): Codec[H] =
    new Codec[H]:
      override def apply(c: HCursor): Result[H] =
        val json = c.value
        json.asString match
          case Some(v) => fromString(v) match
            case Some(host) => Right(host)
            case _ => Left(DecodingFailure(WrongTypeExpectation(expectedJsonFieldType, json), c.history))
          case _ => Left(DecodingFailure(WrongTypeExpectation("string", json), c.history))
      override def apply(a: H): Json = Json.fromString(a.toString)
  end hostCodec

  given Codec[Hostname] = hostCodec[Hostname]("Hostname")(Hostname.fromString)
  given Codec[IDN] = hostCodec[IDN]("IDN")(IDN.fromString)
  given Codec[Ipv4Address] = hostCodec[Ipv4Address]("Ipv4Address")(Ipv4Address.fromString)
  given Codec[Ipv6Address] = hostCodec[Ipv6Address]("Ipv6Address")(Ipv6Address.fromString)
  given Codec[IpAddress] = hostCodec[IpAddress]("IpAddress")(IpAddress.fromString)
  given Codec[Host] = hostCodec[Host]("Host")(Host.fromString)
end HostInstances
object HostInstances extends HostInstances

