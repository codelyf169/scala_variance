object ContravarianceExample {
  def main(args: Array[String]): Unit = {
    val heisenberg = MaleCharacter("Heisenberg")
    val maleStylist = new CastStylist[MaleCharacter]
    val leadStylist = new CastStylist[BreakingBadCharacter]

    println("I am a Male Stylist")
    println(designMaleCostumes(maleStylist, heisenberg))
    println("I am a Lead Stylist")
    println(designMaleCostumes(leadStylist, heisenberg))
  }

  def designMaleCostumes(
      castStylist: CastStylist[MaleCharacter],
      character: MaleCharacter
  ): String = s"${castStylist.design} ${character.name}!!"

  /***
  This won't work -

  def designCostumes(
    castStylist: CastStylist[BreakingBadCharacter],
    character: BreakingBadCharacter
  ): String = s"${castStylist.design} ${character.name}!!"

  We designed this class(CastStylist) keeping in mind that Stylists are if experts for male
  dressing(CastStylist[MaleCharacter]) exists, they can be trusted only for male Actors, whereas
  LeadStylists(CastStylist[BreakingBadCharacter]) can do for both male and female Actors.
   ***/
}

class CastStylist[-T] {
  def design: String = "I am designing Costume for"
}
