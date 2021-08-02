package workbench.traits

trait MessageConfig {
   val name: String = "Thando"
}

class PersonConfig extends MessageConfig

class TeacherConfig(var n: String = "Thomas") extends MessageConfig {
  override val name: String = n
}

object PersonConfig {

  def name() =  "Thando Mafela"

  def apply(): PersonConfig = new PersonConfig()
}

