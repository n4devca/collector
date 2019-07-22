package ca.n4dev.collector.event

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime
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
@RequestMapping("/events")
class EventController(val eventRepository: EventRepository) {

    @PostMapping("/{app}/{eventType}")
    fun collectAppEvent(@PathVariable app: String, @PathVariable eventType: String, @RequestBody event: Any): EventResponse {

        val eventEntity = eventRepository.save(EventEntity(null, app, eventType, event.toString(), LocalDateTime.now()))

        return toEventResponse(eventEntity);
    }

    @GetMapping("")
    fun getEvents() : List<EventResponse> {
        val allEvents = eventRepository.findAll()

        val list = allEvents.map { eventEntity ->
                                    EventResponse(eventEntity.id.toString(),
                                                  eventEntity.applicationName,
                                                  eventEntity.eventType,
                                                  eventEntity.eventTime) }

        return list
    }

    @GetMapping("/{eventId}")
    fun getOneEvent(@PathVariable eventId: Long) : ResponseEntity<EventResponse> {
        return eventRepository.findById(eventId)
                              .map { ResponseEntity(toEventResponse(it), HttpStatus.OK) }
                              .orElse(ResponseEntity(HttpStatus.NOT_FOUND));
    }

}

data class EventResponse(val id: String,
                         val application: String,
                         val eventType: String,
                         val createAt: LocalDateTime,
                         val eventData: Any = "")

fun toEventResponse(ev : EventEntity) : EventResponse {
    return EventResponse(ev.id.toString(), ev.applicationName, ev.eventType, ev.eventTime, ev.eventData);
}