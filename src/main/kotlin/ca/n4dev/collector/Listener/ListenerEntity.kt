package ca.n4dev.collector.Listener

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

/**
 *
 * ListenerEntity.java
 * TODO(rguillemette) Add description.
 *
 * @author rguillemette
 * @since 2.0.0 - Jul 17 - 2019
 *
 */
@Table("listener")
data class ListenerEntity(
        
    @Id
    val id: Long?,

    @Column("event_type")
    val eventType: String,

    @Column("listener_name")
    val listenerName: String

)