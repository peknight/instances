package com.peknight.cats.instances.scalacheck.collection

import cats.data.NonEmptyList
import cats.syntax.apply.*
import com.peknight.cats.instances.scalacheck.gen.given
import org.scalacheck.Arbitrary

trait NonEmptyListInstances:
  given [A : Arbitrary]: Arbitrary[NonEmptyList[A]] =
    Arbitrary((Arbitrary.arbitrary[A], Arbitrary.arbitrary[List[A]]).mapN(NonEmptyList(_, _)))
  end given
end NonEmptyListInstances
object NonEmptyListInstances extends NonEmptyListInstances
