package com.peknight.cats.instances.scalacheck

import cats.Semigroup
import org.scalacheck.Gen

private[scalacheck] trait LowPriorityGenInstances:
  given [A: Semigroup]: Semigroup[Gen[A]] with
    def combine(x: Gen[A], y: Gen[A]): Gen[A] =
      for
        xa <- x
        ya <- y
      yield Semigroup[A].combine(xa, ya)
  end given
end LowPriorityGenInstances

