package by.pvt.controller

import by.pvt.pojo.GreetingDate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("/")
class HomeController {

    @GetMapping
    fun param(@RequestParam(value = "name", defaultValue = "") name: String): GreetingDate {
        val dt = System.currentTimeMillis()/1000
        return GreetingDate("Hello", "$dt")
    }
}