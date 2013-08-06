package org.celllife.remedi.domain;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Date;

public interface UssdServiceHitRepository extends PagingAndSortingRepository<UssdServiceHit, String>  {

    @Query("select new org.celllife.remedi.domain.UssdServiceHitsDTO(svc.serviceId, svc.serviceTitle, COUNT(serviceId), COUNT(smsId), svc.themeId)  " +
            "from UssdServiceHit svc " +
            "where (date between :startDate and :endDate) " +
            "and (serviceId is not null) " +
            "group by serviceId, themeId")
    Collection<UssdServiceHitsDTO> findTotalHitsPerService(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("select new org.celllife.remedi.domain.UssdThemeHitsDTO(svc.themeId, svc.themeTitle, COUNT(themeId)) " +
            "from UssdServiceHit svc " +
            "where (date between :startDate and :endDate) " +
            "and (serviceId is null) " +
            "group by themeId, themeTitle")
    Collection<UssdThemeHitsDTO> findTotalHitsPerTheme(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}