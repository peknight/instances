package com.peknight.cats.instances.time

import cats.Order

import java.time.Instant

trait InstantInstances:
  given Order[Instant] with
    def compare(x: Instant, y: Instant): Int = x.compareTo(y)
  end given
end InstantInstances
object InstantInstances extends InstantInstances


