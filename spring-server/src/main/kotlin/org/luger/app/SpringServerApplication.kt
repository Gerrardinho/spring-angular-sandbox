package org.luger.app

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
@SpringBootApplication
class SpringServerApplication {

    @GetMapping("/{path:[^\\.]*}")
    fun redirect() = "forward:/"

}

fun main(args: Array<String>) {
    SpringApplication.run(SpringServerApplication::class.java, *args)
}
