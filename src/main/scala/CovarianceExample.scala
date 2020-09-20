object CovarianceExample {
  def main(args: Array[String]): Unit = {
    val maleCharacters: List[MaleCharacter] = List(
      MaleCharacter("Heisenberg"),
      MaleCharacter("Jesse Pinkman"),
      MaleCharacter("Gus Fring")
    )
    val femaleCharacters: List[FemaleCharacter] =
      List(FemaleCharacter("Skyler White"), FemaleCharacter("Marie Schrader"))

    println("First printing Male characters!")
    sayMyName(maleCharacters)

    println("Second printing Female characters!")
    sayMyName(femaleCharacters)
  }

  def sayMyName(characters: List[BreakingBadCharacter]): Unit =
    characters.foreach { character =>
      println(s"My Name is ${character.name}")
    }
}

abstract class BreakingBadCharacter {
  def name: String
}

case class MaleCharacter(name: String) extends BreakingBadCharacter

case class FemaleCharacter(name: String) extends BreakingBadCharacter