package org.celllife.remedi.domain;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Date;

public interface UssdServiceHitRepository extends PagingAndSortingRepository<UssdServiceHit, String>  {

    @Query("select new org.celllife.remedi.domain.UssdHitsDTO(svc.serviceId, svc.serviceTitle, COUNT(serviceId), COUNT(smsId)) " +
            "from UssdServiceHit svc " +
            "where (date between :startDate and :endDate) " +
            "group by serviceId")
    Collection<UssdHitsDTO> findTotalHits(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}