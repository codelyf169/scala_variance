package Lambdas

class LambdaFunx {
  def printFactory[T](f: Int => T)(times: Int) = {
    val valueOfLambda = f(times)
    println(valueOfLambda)
  }
}

object LambdaFunx {
  def main(args: Array[String]): Unit = {
    // Returns Int
    val firstLambda = { (i: Int) =>
      100 * i
    }
    // Returns Double
    val secondLambda = { (i: Int) =>
      (100.00 / i)
    }
    // Returns String
    val thirdLambda = { (i: Int) =>
      val strList = for (j <- 1 to i) yield "hello"
      strList.mkString(",")
    }

    val obj = new LambdaFunx
    // Calling the Factory
    obj.printFactory[Int](firstLambda)(5)
    obj.printFactory[Double](secondLambda)(6)
    obj.printFactory[String](thirdLambda)(10)
  }
}
