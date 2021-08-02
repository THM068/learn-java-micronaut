package workbench.traits

object Main extends App {

  val personConfig =  PersonConfig()
  val teacherConfig = new TeacherConfig(n = "Alexandra")
  println(personConfig.name)
  println(teacherConfig.name)


}
