package ca.n4dev.collector.configuration

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories

/**
 *
 * PersistenceConfiguration.java
 * TODO(rguillemette) Add description.
 *
 * @author rguillemette
 * @since 2.0.0 - Jul 11 - 2019
 *
 */
@Configuration
@EnableJdbcRepositories(basePackages = ["ca.n4dev.collector"])
open class PersistenceConfiguration {
}