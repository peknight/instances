package com.peknight.cats.instances.scodec.bits

import cats.Monoid
import scodec.bits.ByteVector

trait ByteVectorInstances:
  given Monoid[ByteVector] with
    def empty: ByteVector = ByteVector.empty
    def combine(x: ByteVector, y: ByteVector): ByteVector = x ++ y
  end given
end ByteVectorInstances
