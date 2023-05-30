package com.peknight.doobie.instances.time

import doobie.Meta
import java.time.Year

trait YearInstances:
  given Meta[Year] = Meta.IntMeta.timap[Year](Year.of)(_.getValue)
end YearInstances
object YearInstances extends YearInstances
