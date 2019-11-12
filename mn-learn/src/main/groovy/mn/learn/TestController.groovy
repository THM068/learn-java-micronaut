package mn.learn

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.reactivex.Maybe

@Controller
class TestController {

    @Get("/test")
    Maybe<String> test() {
        Maybe.
    }
}
