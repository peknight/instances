package com.peknight.circe.instances.ip4s

import com.comcast.ip4s.Port
import io.circe.Decoder.Result
import io.circe.DecodingFailure.Reason.WrongTypeExpectation
import io.circe.{Codec, DecodingFailure, HCursor, Json}

trait PortInstances:
  given Codec[Port] with
    def apply(c: HCursor): Result[Port] =
      val json = c.value
      json.asNumber.flatMap(_.toInt).flatMap(Port.fromInt)
        .orElse(json.asString.flatMap(Port.fromString))
        .fold(Left(DecodingFailure(WrongTypeExpectation("Port", json), c.history)))(Right.apply)
    def apply(a: Port): Json = Json.fromInt(a.value)
  end given
end PortInstances
object PortInstances extends PortInstances
