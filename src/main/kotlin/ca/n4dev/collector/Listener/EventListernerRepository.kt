package ca.n4dev.collector.Listener

import org.springframework.data.repository.CrudRepository

/**
 *
 * EventListernerRepository.java
 * TODO(rguillemette) Add description.
 *
 * @author rguillemette
 * @since 2.0.0 - Jul 17 - 2019
 *
 */
interface EventListernerRepository : CrudRepository<ListenerEntity, Long> {
}