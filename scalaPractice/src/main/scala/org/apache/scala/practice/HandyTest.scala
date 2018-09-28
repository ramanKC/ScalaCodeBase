package org.apache.scala.practice

import java.util.concurrent.ConcurrentHashMap.MapEntry

object HandyTest {
  val handy = new Handy

  def main(args: Array[String]) {
//    flowControl();
    dataStructure();
  }

  def dataStructure() {
//    Using Tuples data structure 
    val (q,m) = handy.divideInts(11, 4);
    log(s"Quotient : $q");
    log(s"Remainder: $m");
    
    //Using Set
    val set = Set(1,2,3)
    log(s"Set: $set");
//    Using Array
    val arr = Array(1, 2,3 ,4 , 5)
    print(s"Array: ")
    arr.foreach(x => print(s" $x"));
    
    //Using Map
    val map = Map("name" ->  "kanishka", 
                  "company" -> "infa",
                  "country" -> "india",
                  "pinCode" -> 560075, 
                  "age" -> 29)
    print(s"\nMap: ")
    map.foreach(mapEntry => print(mapEntry))
   
    print(s"\nMap Keys only: ")  
    map.foreach(mapEntry => print(s" "+mapEntry._1) );
    print(s"\nMap Values only: ")
    map.foreach(mapEntry => print(s" "+mapEntry._2) );

        
                  
    
  }
  
  def flowControl() {
//    handy.foreachLoop6
    handy.recursiveVersionOfLoop(0, 10, 2)
  }

  def funcAndStatements() {
    println(handy.subtract(10, 2))
    println(handy.subtract(2, 4))

    println(handy.subtract(x = 10, y = 4))
    println(handy.subtract(y = 10, x = 4))

    println(handy.subtract(y = 10, x = 4))
    var a = handy.addWithDefault(1, 2)
    println(a)

    a = handy.sq(4)

    a = handy.addOne(5) // => 6
    log(a)
    a = handy.weirdSum(2, 4) // => 16
    log(a)

    a = handy.foo(2)
    log(a)
  }
  def log: Any => Unit = {
    println(_)
  }

}