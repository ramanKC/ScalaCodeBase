package scala.concepts

object NestedFunc {
  def main(args: Array[String]) {
    val num = 3.0
    val objOfSqrtClass = new SqrtClass(num)

    println(s"Square root of ${num} is ${objOfSqrtClass.sqrt(num)}")
    println(s"Square root of ${num} is ${objOfSqrtClass.sqrt2(num)}")
    
    println(s"Scala Objects are like Java static classes: " + SqrtObject.myVal)
    
  }
}

object SqrtObject {
  val myVal = 1
  def myMethod = 2
}

class SqrtClass(num: Double){
   val number = num
   val sqrtVal = {
    def sqrt3(x: Double): Double = {
      def sqrtIter(guess: Double): Double = {
        if (isGoodEnough(guess))
          guess
        else
          sqrtIter(improveGuess(guess))
      }

      def improveGuess(guess: Double) = {
        (guess + (x / guess)) / 2
      }

      def isGoodEnough(guess: Double): Boolean = {
        Math.abs((guess * guess) - x) < 0.001
      }

      sqrtIter(1.0);
    }
  }

  def sqrt(x: Double): Double = {

    def sqrtIter(guess: Double, x: Double): Double = {
      if (isGoodEnough(guess, x))
        guess
      else
        sqrtIter(improveGuess(guess, x), x)
    }

    def improveGuess(guess: Double, x: Double) = {
      (guess + (x / guess)) / 2
    }

    def isGoodEnough(guess: Double, x: Double): Boolean = {
      Math.abs((guess * guess) - x) < 0.001
    }

    sqrtIter(1.0, x);
  }

  def sqrt2(x: Double): Double = {

    def sqrtIter(guess: Double): Double = {
      if (isGoodEnough(guess))
        guess
      else
        sqrtIter(improveGuess(guess))
    }

    def improveGuess(guess: Double) = {
      (guess + (x / guess)) / 2
    }

    def isGoodEnough(guess: Double): Boolean = {
      Math.abs((guess * guess) - x) < 0.001
    }

    sqrtIter(1.0);
  }
}