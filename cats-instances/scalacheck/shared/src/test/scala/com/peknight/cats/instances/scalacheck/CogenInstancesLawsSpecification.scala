package com.peknight.cats.instances.scalacheck

import cats.laws.discipline.{ContravariantSemigroupalTests, MonoidKTests}
import com.peknight.cats.instances.scalacheck.cogen.given
import com.peknight.cats.instances.scalacheck.test.cogen.given
import org.scalacheck.{Cogen, Properties, Test}

class CogenInstancesLawsSpecification extends Properties("CogenInstancesLaws"):
  override def overrideParameters(p: Test.Parameters): Test.Parameters =
    p.withMaxSize(16).withMinSuccessfulTests(16)

  include(ContravariantSemigroupalTests[Cogen].contravariant[Int, String, Boolean].all)
  include(MonoidKTests[Cogen].monoidK[Int].all)
