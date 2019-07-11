package ca.n4dev.collector.event

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

/**
 *
 * EventRepository.java
 * TODO(rguillemette) Add description.
 *
 * @author rguillemette
 * @since 2.0.0 - Jul 10 - 2019
 *
 */
@Repository
interface EventRepository : CrudRepository<EventEntity, Long>
