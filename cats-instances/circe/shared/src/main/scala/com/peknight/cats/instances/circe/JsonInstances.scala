package com.peknight.cats.instances.circe

import cats.Show
import io.circe.Json

trait JsonInstances:
  given showJson: Show[Json] with
    def show(t: Json): String = t.deepDropNullValues.noSpaces
  end showJson
end JsonInstances
object JsonInstances extends JsonInstances
