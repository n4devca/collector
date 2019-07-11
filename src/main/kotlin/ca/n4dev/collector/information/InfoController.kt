package ca.n4dev.collector.information

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.PropertySource
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 *
 * InfoController.java
 * TODO(rguillemette) Add description.
 *
 * @author rguillemette
 * @since 2.0.0 - Jul 10 - 2019
 *
 */
@RestController
@PropertySource("classpath:application.yml")
@ConfigurationProperties("n4dev.collector")
@RequestMapping("/info")
class InfoController {

    lateinit var version : String

    @GetMapping("/version")
    fun info() : InfoResponse {
        return InfoResponse(version);
    }
}