package mn.kot

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("mn.kot")
                .mainClass(Application.javaClass)
                .start()
    }
}