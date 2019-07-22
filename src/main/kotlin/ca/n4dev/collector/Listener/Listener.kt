package ca.n4dev.collector.Listener

import ca.n4dev.collector.event.EventEntity

/**
 *
 * Listener.java
 * TODO(rguillemette) Add description.
 *
 * @author rguillemette
 * @since 2.0.0 - Jul 17 - 2019
 *
 */
interface Listener {
    fun notify(ev : EventEntity)
}