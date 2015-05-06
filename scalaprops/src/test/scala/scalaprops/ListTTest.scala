package scalaprops

import scalaz._
import scalaz.std.anyVal._
import scalaz.std.list._

object ListTTest extends Scalaprops {

  val testMaybe =
    scalazlaws.monad.all[({type l[a] = ListT[Maybe, a]})#l]

  // https://github.com/scalaz/scalaz/issues/921
  val disableTestList =
    scalazlaws.bind.laws[({type l[a] = ListT[IList, a]})#l].andThenParam(Param.maxSize(2))

}
