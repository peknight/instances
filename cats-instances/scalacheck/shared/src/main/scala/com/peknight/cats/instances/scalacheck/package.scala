package com.peknight.cats.instances

package object scalacheck:
  object all extends GenInstances with CogenInstances
  object gen extends GenInstances
  object cogen extends CogenInstances
end scalacheck
