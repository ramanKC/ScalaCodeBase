package org.coding

import scala.io._
import java.util.Scanner

object CityWalk {
  def main(args: Array[String]) {
    val sc = new Scanner(System.in)

    val S = sc.nextInt()
    val X = sc.nextInt()
    val N = sc.nextInt()
    var dist = 0;
    var days = 0;

    var i = 1;
    for (i <- 1 to N) {
      sc.nextInt()
      dist += sc.nextInt();
      days += 1

      if (dist >= S) {
        println(days);
        return ;
      }
    }

    if (S - dist > 0) {
      val moreDays = ((S - dist) * 1.0) / X;
      val moreIntDays = moreDays.toInt
      if (moreDays > (moreIntDays * 1.0)) {
        days += moreIntDays + 1;
      } else {
        days += moreIntDays;
      }
    }
    println(days)
    return

  }
}