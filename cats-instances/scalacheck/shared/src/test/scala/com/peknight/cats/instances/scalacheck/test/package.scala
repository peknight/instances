package com.peknight.cats.instances.scalacheck

package object test:

  object all extends ArbitraryTestInstances with GenTestInstances with CogenTestInstances with SeedTestInstances

  object arbitrary extends ArbitraryTestInstances

  object gen extends GenTestInstances

  object cogen extends CogenTestInstances

  object seed extends SeedTestInstances
end test
