object InvarianceExample {
  def main(args: Array[String]): Unit = {
    val hank = DEAAgent("Hank Schrader")
    val heisenberg = new BreakingBadCharacter {
      override def name: String = "Heisenberg"
    }

    thisIsMyJobAsCop(new DEA(hank))

    /**
    This gives ERROR!
    thisIsMyJobAsCop(new DEA(heisenberg))

    As you can see its a strict Typing, Heisenberg cannot become a part of DEA as cop!
    **/

    thisIsMyJobAsCivilian(new CivilianInAlbuquerque(heisenberg))

    /**
    This gives ERROR!
    thisIsMyJobAsCivilian(new CivilianInAlbuquerque[DEAAgent](hank))

    type mismatch;
    found   : CivilianInAlbuquerque[DEAAgent]
    required: CivilianInAlbuquerque[BreakingBadCharacter]
    Note: DEAAgent <: BreakingBadCharacter, but class CivilianInAlbuquerque is invariant in type T.
    You may wish to define T as +T instead. (SLS 4.5)
    thisIsMyJobAsCivilian(new CivilianInAlbuquerque[DEAAgent](hank))
    **/

    // However this works!
    // Implicitly Hank is made a BreakingBadCharacter out of its DEAAgent uniform to behave as civilian
    thisIsMyJobAsCivilian(new CivilianInAlbuquerque(hank))
  }

  def thisIsMyJobAsCop(cop: DEA[DEAAgent]): Unit = {
    println(cop.catchTheGuys)
  }

  def thisIsMyJobAsCivilian(
      civilian: CivilianInAlbuquerque[BreakingBadCharacter]
  ): Unit = {
    println(civilian.mindingMyBusiness)
  }
}

class DEA[T <: BreakingBadCharacter](agent: T) {
  def catchTheGuys = s"I am ${agent.name} from DEA, I catch bad guys"
}

class CivilianInAlbuquerque[T <: BreakingBadCharacter](character: T) {
  def mindingMyBusiness = s"I am ${character.name}, just mind my own business!"
}

case class DEAAgent(name: String) extends BreakingBadCharacter