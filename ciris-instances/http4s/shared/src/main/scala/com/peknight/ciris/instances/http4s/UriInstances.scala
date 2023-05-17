package com.peknight.ciris.instances.http4s

import ciris.ConfigDecoder
import org.http4s.Uri

trait UriInstances:
  given ConfigDecoder[String, Uri] =
    ConfigDecoder.identity[String].mapOption("Uri")(Uri.fromString(_).toOption)
end UriInstances
object UriInstances extends UriInstances

