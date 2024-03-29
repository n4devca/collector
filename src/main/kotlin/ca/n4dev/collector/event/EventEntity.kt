package ca.n4dev.collector.event

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

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
    val id: Long?,

    @Column("app_name")
    val applicationName: String,

    @Column("event_type")
    val eventType: String,

    @Column("event_data")
    val eventData: String,

    @Column("event_time")
    val eventTime: LocalDateTime
)