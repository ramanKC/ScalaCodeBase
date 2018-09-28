package scala.concepts

/**
 * TAIL RECURSION
 *
 *
 * That difference in the rewriting rules actually translates directly to a difference in the actual execution on a
 * computer. In fact, it turns out that if you have a recursive function that calls itself as its last action, then you
 * can reuse the stack frame of that function. This is called tail recursion.
 *
 * And by applying that trick, a tail recursive function can execute in constant stack space, so it's really just
 * another formulation of an iterative process. We could say a tail recursive function is the functional form of a loop,
 *  and it executes just as efficiently as a loop.
 *
 * If we look back at gcd, we see that in the else part, gcd calls itself as its last action. And that translates to a
 * rewriting sequence that was essentially constant in size, and that will, in the actual execution on a computer,
 * translate into a tail recursive call that can execute in constant space.
 *
 * On the other hand, if you look at factorial again, then you'll see that after the call to factorial(n - 1), there is
 *  still work to be done, namely, we had to multiply the result of that call with the number n. So, that recursive call
 *   is not a tail recursive call, and it becomes evident in the reduction sequence, where you see that actually there’s
 *    a buildup of intermediate results that we all have to keep until we can compute the final value.
 *    So, factorial would not be a tail recursive function.
 *
 * Both factorial and gcd only call itself but in general, of course, a function could call other functions. So the
 * generalization of tail recursion is that, if the last action of a function consists of calling another function,
 * maybe the same, maybe some other function, the stack frame could be reused for both functions. Such calls are called
 * tail calls.
 *
 *
 *  TAIL RECURSION IN SCALA
 * In Scala, only directly recursive calls to the current function are optimized.
 * * One can require that a function is tail-recursive using a @tailrec annotation:
 *
 * @tailrec
 * def gcd(a: Int, b: Int): Int = …
 *
 * If the annotation is given, and the implementation of gcd were not tail recursive, an error would be issued.
 */
object TailRecursion {
  def main(args: Array[String]) {
    gcd(14, 21)

    factorial(4)

    tailRecursiveFactorial(4)
  }

  /**
   * gcd(14, 21)
   * if (21 == 0) 14 else gcd(21, 14 % 21)
   * if (false) 14 else gcd(21, 14 % 21)
   * gcd(21, 14 % 21)
   * gcd(21, 14)
   * if (14 == 0) 21 else gcd(14, 21 % 14)
   * if (false) 21 else gcd(14, 21 % 14)
   * gcd(14, 7)
   * gcd(7, 14 % 7)
   * gcd(7, 0)
   * if (0 == 0) 7 else gcd(0, 7 % 0)
   * if (true) 7 else gcd(0, 7 % 0)
   * 7
   */
  /**
   * Its a TAIL Recursive function.
   */
  def gcd(a: Int, b: Int): Int = {
    println(s"gcd(${a}, ${b})")
    if (b == 0) { println(s"${a}"); a }

    if (b != 0)
      println(s"if(${b}==0) ${a} else gcd(${b}, ${a % b})")

    if (b == 0) a else gcd(b, a % b)

  }

  /**
   * factorial(4)
   * if (4 == 0) 1 else 4 * factorial(4 - 1)
   * 4 * factorial(3)
   * 4 * (3 * factorial(2))
   * 4 * (3 * (2 * factorial(1)))
   * 4 * (3 * (2 * (1 * factorial(0)))
   * 4 * (3 * (2 * (1 * 1)))
   * 24
   */
  /**
   * NOT a tail recursive func as there is buildup of intermediate results. and we have to keep them  until we can compute the final value.
   */
  def factorial(n: Int): Int = {
    println(s"factorial(${n})")
    println(s"if(${n}==0) 1 else ${n} * factorial(${n} -1 )")

    if (n == 0) 1 else n * factorial(n - 1)
  }

  def tailRecursiveFactorial(n: Int): Int = {
    //@tailrec
    def iter(x: Int, result: Int): Int =
      if (x == 0) result
      else iter(x - 1, result * x)

    iter(n, 1)
  }

}

