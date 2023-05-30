package com.peknight.cats.instances.time

import cats.Order

import java.time.Year

trait YearInstances:
  given Order[Year] with
    def compare(x: Year, y: Year): Int = x.compareTo(y)
  end given

end YearInstances
object YearInstances extends YearInstances
