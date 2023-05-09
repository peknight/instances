package com.peknight.cats.instances.scalacheck

import cats.data.NonEmptyList
import cats.kernel.laws.discipline.{MonoidTests, SemigroupTests}
import cats.laws.discipline.{AlternativeTests, FunctorFilterTests, MonadTests}
import com.peknight.cats.instances.scalacheck.gen.given
import com.peknight.cats.instances.scalacheck.test.gen.given
import com.peknight.scalacheck.instances.cats.data.nonEmptyList.given
import org.scalacheck.{Gen, Properties, Test}

class GenInstancesLawsSpecification extends Properties("GenInstancesLaws"):
  override def overrideParameters(p: Test.Parameters): Test.Parameters =
    p.withMaxSize(16).withMinSuccessfulTests(16)

  include(MonadTests[Gen].monad[Int, String, Boolean].all)
  include(AlternativeTests[Gen].alternative[Int, String, Boolean].all)
  include(FunctorFilterTests[Gen].functorFilter[Int, String, Boolean].all)
  include(MonoidTests[Gen[String]].monoid.all)
  include(SemigroupTests[Gen[NonEmptyList[Int]]].semigroup.all)
