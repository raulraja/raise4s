package in.rcard.raise4s

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class BuildersSpec extends AnyFlatSpec with Matchers {

  "The either builder" should "create a Left instance" in {
    val failure: Raise[String] ?=> () => String = () => raise("error")
    either(failure) should be(Left("error"))
  }

  it should "create a Right instance" in {
    val success: Raise[String] ?=> () => String = () => "success"
    either { success } should be(Right("success"))
  }
}