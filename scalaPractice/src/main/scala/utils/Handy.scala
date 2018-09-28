package utils

class Handy {
  // You can use parameters names to specify them in different order
  def subtract(x: Int, y: Int): Int = x - y
  def square(x: Int): Int = x * x
  //add with defaults
  def addWithDefault(x: Int, y: Int = 5) = x + y

  // Anonymous functions look like this:
  (x: Int) => x * x * x

  // Unlike defs, even the input type of anonymous functions can be omitted if the
  // context makes it clear. Notice the type "Int => Int" which means a function
  // that takes Int and returns Int.
  val sq: Int => Int = x => x * x

  // If each argument in your anonymous function is
  // used only once, Scala gives you an even shorter way to define them. These
  // anonymous functions turn out to be extremely common, as will be obvious in
  // the data structure section.
  val addOne: Int => Int = _ + 1
  val weirdSum: (Int, Int) => Int = (_ * 2 + _ * 3)

  addOne(5) // => 6
  weirdSum(2, 4) // => 16

  // The return keyword exists in Scala, but it only returns from the inner-most
  // def that surrounds it.
  // WARNING: Using return in Scala is error-prone and should be avoided.
  // It has no effect on anonymous functions. For example:
  def foo(x: Int): Int = {
    val anonFunc: Int => Int = { z =>
      if (z > 5)
        return z // This line makes z the return value of foo!
      else
        z + 2 // This line is the return value of anonFunc
    }
    anonFunc(x) // This line is the return value of foo
  }
  /////////////////////////////////////////////////
  // 3. Flow Control
  /////////////////////////////////////////////////
  // Below foreachLoop1 looks like func. but they are essentially immutable constant final variable.
  //  val foreachLoop1 = {
  //    println("foreachLoop1..")
  //    var idx = 1 to 5
  //    idx foreach { x => println(x) }
  //
  //  }
  //
  //  val foreachLoop2 = {
  //    println("foreachLoop2..")
  //    var idx = 1 to 5
  //    idx foreach { println }
  //  }
  //  val foreachLoop3 = {
  //    println("foreachLoop3..")
  //    var idx = 1 to 5
  //    idx foreach  println
  //  }
  //  val foreachLoop4 = {
  //    println("foreachLoop4..")
  //    var idx = 1 to 5
  //    idx.foreach(println)
  //  }
  //  var foreachLoop5 = {
  //   println("foreachLoop5..")
  //   (1.to(5)).foreach(println)
  //
  //   println("or")
  //    1 to 5 foreach println
  //  }
  //

  def whileLoop() = {
    var i = 0
    //    while(i<5) { println(s"i is $i"); i+=1}
    while (i < 5) { println(s"i is $i"); i += 1 }
    println(s"After loop i is $i")
  }
  def foreachLoop6 = {
    (1.to(5)).foreach(x => print(x + s" "))
  }

  def doWhileLoop = {
    var i = 0;
    do {
      print(s" " + i)
    } while (i.<(5))
  }

  // Recursive functions need an explicit return type, the compiler can't infer it.
  // Here it's Unit, which is analagous to a `void` return type in Java
  def recursiveVersionOfLoop(start: Int, end: Int, step: Int): Unit = {
    print(s" " + start)
    if (start < end) {
      recursiveVersionOfLoop(start + step, end, step)
    }
  }
  
///////////////////////////////////////////////////
// 4. Data Structures: Tuple, Array, Set, Map
/////////////////////////////////////////////////
 
  //function with return type TUPLES
  def divideInts = (x:Int, y:Int) => (x/y, x%y)
  
  /////////////////////////////////////////////////
// 5. Object Oriented Programming
/////////////////////////////////////////////////

/*
  Aside: Everything we've done so far in this tutorial has been simple
  expressions (values, functions, etc). These expressions are fine to type into
  the command-line interpreter for quick tests, but they cannot exist by
  themselves in a Scala file. For example, you cannot have just "val x = 5" in
  a Scala file. Instead, the only top-level constructs allowed in Scala are:

  - objects
  - classes
  - case classes
  - traits

  And now we will explain what these are.
*/
  
}