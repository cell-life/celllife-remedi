package org.celllife.remedi.domain.datamart;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Date;

public interface UssdVisitsStoreRepository extends PagingAndSortingRepository<UssdPageVisit, String>  {

    @Query("select new org.celllife.remedi.domain.datamart.UssdServiceVisitsDTO(svc.serviceId, svc.serviceTitle, COUNT(serviceId), COUNT(smsId), svc.themeId)  " +
            "from UssdPageVisit svc " +
            "where (date between :startDate and :endDate) " +
            "and (serviceId is not null) " +
            "group by serviceId, themeId")
    Collection<UssdServiceVisitsDTO> findTotalVisitsPerService(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("select new org.celllife.remedi.domain.datamart.UssdServiceVisitsDTO(svc.serviceId, svc.serviceTitle, COUNT(serviceId), COUNT(smsId), svc.themeId)  " +
            "from UssdPageVisit svc " +
            "where (date between :startDate and :endDate) " +
            "and (themeId = :themeId) " +
            "and (serviceId is not null) " +
            "group by serviceId, themeId")
    Collection<UssdServiceVisitsDTO> findTotalVisitsPerServiceInTheme(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("themeId") Integer themeId);


    @Query("select new org.celllife.remedi.domain.datamart.UssdThemeVisitsDTO(svc.themeId, svc.themeTitle, COUNT(themeId)) " +
            "from UssdPageVisit svc " +
            "where (date between :startDate and :endDate) " +
            "and (serviceId is null) " +
            "group by themeId, themeTitle")
    Collection<UssdThemeVisitsDTO> findTotalVisitsPerTheme(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}