package ca.n4dev.collector.event

import org.springframework.web.bind.annotation.*
import java.time.ZonedDateTime
import java.util.*

/**
 *
 * EventController.java
 * TODO(rguillemette) Add description.
 *
 * @author shaika-dzari
 * @since 2.0.0 - Jul 10 - 2019
 *
 */
@RestController
@RequestMapping("/event")
class EventConsumer {

    @PostMapping("/{app}/{eventType}")
    fun collectAppEvent(@PathVariable app: String, @PathVariable eventType: String, @RequestBody event: Any): EventResponse {
        return EventResponse(UUID.randomUUID().toString(),
                             app,
                             eventType,
                             ZonedDateTime.now())
    }

    data class EventResponse(val id: String, val application: String, val eventType: String, val createAt: ZonedDateTime)
}