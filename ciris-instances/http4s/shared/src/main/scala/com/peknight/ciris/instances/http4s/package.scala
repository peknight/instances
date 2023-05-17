package com.peknight.ciris.instances

package object http4s:
  object all extends HostInstances with PortInstances with UriInstances
  object host extends HostInstances
  object port extends PortInstances
  object uri extends UriInstances
end http4s