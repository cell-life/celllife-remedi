package org.celllife.remedi.domain;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface UssdServiceHitRepository extends PagingAndSortingRepository<UssdServiceHit, String>  {

    @Query("select new org.celllife.remedi.domain.ServiceHitsDTO(svc.serviceId, svc.serviceTitle, COUNT(serviceId), COUNT(smsId)) " +
            "from UssdServiceHit svc " +
            //"where (submissionDate between :startDate and :endDate) and" +
            "group by serviceId")
    Iterable<UssdServiceHit> findTotalHits();

}