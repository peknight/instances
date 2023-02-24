# Pek Instances

提供一些自己常用的第三方库的实例对象

## cats-instances

提供Scala函数式编程库cats的第三方库实例对象

### cats-instances/scalacheck

提供scalacheck的cats实例。参考：[davenverse/cats-scalacheck](https://github.com/davenverse/cats-scalacheck)

#### Gen Instances

* `Monad[Gen]`
* `Alternative[Gen]`
* `FunctorFilter[Gen]`
* `Monoid[A] ?=> Monoid[Gen[A]]`
* `Semigroup[A] ?=> Semigroup[Gen[A]]`

#### Cogen Instances

* `ContravariantSemigroupal[Cogen]`
* `MonoidK[Cogen]`

#### Arbitrary Instances

* `Monad[Arbitrary]`
* `Alternative[Arbitrary]`
* `FunctorFilter[Arbitrary]`
* `Monoid[A] ?=> Monoid[Arbitrary[A]]`
* `Semigroup[A] ?=> Semigroup[Arbitrary[A]]`

#### Collection

##### NonEmptyList

* `Arbitrary[A] ?=> Arbitrary[NonEmptyList[A]]`
