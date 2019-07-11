package ca.n4dev.collector.event

import org.springframework.web.bind.annotation.*
import java.time.ZonedDateTime
import java.util.*

/**
 *
 * EventController.java
 * TODO(rguillemette) Add description.
 *
 * @author rguillemette
 * @since 2.0.0 - Jul 10 - 2019
 *
 */
@RestController
@RequestMapping("/event")
class EventConsumer(val eventRepository: EventRepository) {

    @PostMapping("/{app}/{eventType}")
    fun collectAppEvent(@PathVariable app: String, @PathVariable eventType: String, @RequestBody event: Any): EventResponse {

        val eventEntity = eventRepository.save(EventEntity(null, app, eventType, event.toString()))

        return EventResponse(eventEntity.id.toString(),
                             app,
                             eventType,
                             ZonedDateTime.now())
    }

    @GetMapping("")
    fun getEvents() : List<EventResponse> {
        val allEvents = eventRepository.findAll()

        val list = allEvents.map { eventEntity -> EventResponse(eventEntity.id.toString(), eventEntity.applicationName, eventEntity.eventType, ZonedDateTime.now()) }

        return list
    }

    data class EventResponse(val id: String, val application: String, val eventType: String, val createAt: ZonedDateTime)
}