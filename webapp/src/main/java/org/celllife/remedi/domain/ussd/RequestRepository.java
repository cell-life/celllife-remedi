package org.celllife.remedi.domain.ussd;

import javax.persistence.QueryHint;

import org.celllife.remedi.framework.logging.LogLevel;
import org.celllife.remedi.framework.logging.Loggable;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

/**
 * Repository for the USSD request object - used for persistence
 */
@Loggable(LogLevel.DEBUG)
@RestResource(path = "requests")
public interface RequestRepository extends PagingAndSortingRepository<Request, Long> {

    @QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
    Iterable<Request> findByUssdSessionId(@Param("ussdSessionId") String ussdSessionId);

}
