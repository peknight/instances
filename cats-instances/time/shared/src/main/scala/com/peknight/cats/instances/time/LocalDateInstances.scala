package com.peknight.cats.instances.time

import cats.Order

import java.time.LocalDate

private[time] trait LocalDateInstances:
  given Order[LocalDate] with
    override def compare(x: LocalDate, y: LocalDate): Int = x.compareTo(y)
  end given

end LocalDateInstances
object LocalDateInstances extends LocalDateInstances


