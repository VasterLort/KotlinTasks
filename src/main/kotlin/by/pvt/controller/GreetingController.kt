package by.pvt.controller

import by.pvt.pojo.Greeting
import by.pvt.pojo.GreetingDate
import by.pvt.pojo.Healthcheck
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/api")
class GreetingController {

    @GetMapping("/{name}")
    fun brackets(@PathVariable name: String) =
            Greeting("Hello, $name")

    @GetMapping
    fun param(@RequestParam(value = "name", defaultValue = "") name: String) =
            if (name.isEmpty()) {
                val dt = System.currentTimeMillis()/1000
                GreetingDate("Hello", "$dt")
            } else {
                Greeting("Hello, $name")
            }

    @GetMapping("/healthcheck")
    fun healthCheck(@RequestParam(value = "name", defaultValue = "") name: String) : Healthcheck {
        val dt = System.currentTimeMillis()/1000
        return Healthcheck("github-api", "1.0", "$dt")
    }

    @GetMapping("/timemachine/logs/mcfly")
    fun easterEgg(@RequestParam(value = "name", defaultValue = "") name: String) : List<Healthcheck> {
        val dt = System.currentTimeMillis()/1000
        val maxL = Long.MAX_VALUE;
        val items = listOf(Healthcheck("I go to the future and my mom end up with the wrong guy", "2.0", "-$dt"),
                Healthcheck("I go to the future and my mom end up with the wrong guy", "2.0", "$dt"),
                Healthcheck("I go to the past and you will not believe what happens next", "3.0", "-$maxL"))

        return items
    }
}