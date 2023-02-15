package com.peknight.cats.instances

package object scalacheck:
  object all extends ArbitraryInstances with GenInstances with CogenInstances
  object arbitrary extends ArbitraryInstances
  object gen extends GenInstances
  object cogen extends CogenInstances
end scalacheck
