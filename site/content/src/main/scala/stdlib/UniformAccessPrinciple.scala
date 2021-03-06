package stdlib

import UniformAccessPrincipleHelper._
import org.scalatest._

/** @param name uniform_access_principle
  *
  */
object UniformAccessPrinciple extends FlatSpec with Matchers with exercise.Section {

  /** The Scala language implements a programming concept known as the [Uniform Access Principle](http://en.wikipedia.org/wiki/Uniform_access_principle) which was first put forth by Bertrand Meyer, inventor of the Eiffel programming language.
    *
    * This principle states that variables and parameterless functions should be accessed using the same syntax. Scala supports this principle by not allowing parentheses to be placed at call sites of parameterless functions. As a result, a parameterless function definition can be changed to a val, or vice versa, without affecting client code.
    *
    * Let's look at some code:
    *
    * {{{
    * class CalculatesAgeUsingMethod(var currentYear: Int, birthYear: Int) {
    *
    * def age = currentYear - birthYear
    *
    * // calculated when method is called
    * }
    *
    * class CalculatesAgeUsingProperty(var currentYear: Int, birthYear: Int) {
    * // does age stay up to date if defined as a var instead of a val?
    * val age = currentYear - birthYear
    * // calculated at instantiation, returns property when called
    * }
    * }}}
    * Can access age as parameterless method:
    */
  def uniformAccessPrincipleUniformAccessPrinciple(res0: Int) {
    val me = new CalculatesAgeUsingMethod(2010, 2003)
    me.age should be(res0)

    /** Cannot add parameter to Method invocation:
      *
      * {{{
      * val me = new CalculatesAgeUsingMethod(2010, 2003)
      * //me.age() should be (7)
      * }}}
      */
  }

  /** Can access age as property:
    */
  def asPropertyUniformAccessPrinciple(res0: Int) {
    val me = new CalculatesAgeUsingProperty(2010, 2003)
    me.age should be(res0)
  }

  /** What happens when I update current year using property
    */
  def updatingPropertyUniformAccessPrinciple(res0: Int) {
    val me = new CalculatesAgeUsingProperty(2010, 2003)

    me.currentYear = 2011
    me.age should be(res0)
  }

  /** What happens when I update current year using method:
    */
  def updateUsingMethodUniformAccessPrinciple(res0: Int) {
    val me = new CalculatesAgeUsingMethod(2010, 2003)

    me.currentYear = 2011
    me.age should be(res0)
  }

}
