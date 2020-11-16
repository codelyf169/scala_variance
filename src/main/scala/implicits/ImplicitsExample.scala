package implicits

object ImplicitsExample {

  // implicit val
  implicit val i: Int = 6

  def printInt(name: String)(implicit j: Int) = {
    println(s"$name has $j apples!")
  }

  implicit def IntToStr(k: Int) = s"Int value is: $k"
  def printMessage(str: String) = str

  implicit def str2int(str: String): Int = Integer.parseInt(str)

  def plusOne(add: Int): Int = add + 1

  def main(args: Array[String]) = {
    printInt("Raj")(7)
    println(printMessage(4))
    print(plusOne("foo"))
  }
}
