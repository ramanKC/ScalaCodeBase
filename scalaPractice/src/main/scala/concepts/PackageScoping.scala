package scala.concepts

object PackageScoping {
  def name = "I am PackageScoping  Object"
  def main(args: Array[String]) {
    println(foo.FooObject.name)
  }
}

package concepts {
  object FooObject {
    def name = "I am Foo Object"
    val x = PackageScoping.name
    def main(args: Array[String]) {
      println(x)
    }
  }
  
}