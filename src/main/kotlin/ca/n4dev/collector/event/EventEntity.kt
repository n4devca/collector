package ca.n4dev.collector.event

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

/**
 *
 * EventEntity.java
 * TODO(rguillemette) Add description.
 *
 * @author rguillemette
 * @since 2.0.0 - Jul 10 - 2019
 *
 */
@Table("events")
data class EventEntity(

    @Id
    var id: Long?,

    @Column("app_name")
    var applicationName : String,

    @Column("event_type")
    var eventType : String,

    @Column("event_data")
    var eventData : String
)