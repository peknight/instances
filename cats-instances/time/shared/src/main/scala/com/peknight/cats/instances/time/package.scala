package com.peknight.cats.instances

package object time:
  object all extends InstantInstances with LocalDateInstances with YearInstances
  object instant extends InstantInstances
  object localDate extends LocalDateInstances
  object year extends YearInstances
end time
