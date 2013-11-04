package org.celllife.remedi.domain.datamart;


import java.util.Collection;
import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface UssdVisitsStoreRepository extends PagingAndSortingRepository<UssdPageVisit, String>  {

    @Query("select new org.celllife.remedi.domain.datamart.UssdServiceVisitsDTO(ups.serviceId, ups.serviceTitle, COUNT(serviceId), COUNT(smsId), ups.themeId)  " +
            "from UssdPageVisit ups " +
            "where (date between :startDate and :endDate) " +
            "and (serviceId is not null) " +
            "group by serviceId, themeId")
    Collection<UssdServiceVisitsDTO> findTotalVisitsPerService(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    @Query("select new org.celllife.remedi.domain.datamart.UssdServiceVisitsDTO(ups.serviceId, ups.serviceTitle, COUNT(serviceId), COUNT(smsId), ups.themeId)  " +
            "from UssdPageVisit ups " +
            "where (date between :startDate and :endDate) " +
            "and (themeId = :themeId) " +
            "and (serviceId is not null) " +
            "group by serviceId, themeId")
    Collection<UssdServiceVisitsDTO> findTotalVisitsPerServiceInTheme(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("themeId") String themeId);


    @Query("select new org.celllife.remedi.domain.datamart.UssdThemeVisitsDTO(ups.themeId, ups.themeTitle, COUNT(themeId)) " +
            "from UssdPageVisit ups " +
            "where (date between :startDate and :endDate) " +
            "and (serviceId is null) " +
            "group by themeId, themeTitle")
    Collection<UssdThemeVisitsDTO> findTotalVisitsPerTheme(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

	@Query("select new org.celllife.remedi.domain.datamart.MsisdnVisitsDTO(ups.ussdSessionId, ups.date, ups.endDate, ups.msisdn, ups.mnoCode)  " +
            "from UssdPageVisit ups " +
            "where (ups.date between :startDate and :endDate) " +
            " and ups.serviceId = :serviceId ")
    Page<MsisdnVisitsDTO> findMsisdnVisitsByService(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("serviceId") String serviceId, Pageable p);
	
	@Query("select new org.celllife.remedi.domain.datamart.MsisdnVisitsDTO(ups.ussdSessionId, ups.date, ups.endDate, ups.msisdn, ups.mnoCode)  " +
            "from UssdPageVisit ups " +
            "where (ups.date between :startDate and :endDate) " +
            " and ups.themeId = :themeId ")
    Page<MsisdnVisitsDTO> findMsisdnVisitsByTheme(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("themeId") String themeId, Pageable p);

	@Query("select new org.celllife.remedi.domain.datamart.MsisdnVisitsDTO(ups.ussdSessionId, ups.date, ups.endDate, ups.msisdn, ups.mnoCode)  " +
            "from UssdPageVisit ups " +
            "where (date between :startDate and :endDate) ")
    Page<MsisdnVisitsDTO> findMsisdnVisits(@Param("startDate") Date startDate, @Param("endDate") Date endDate, Pageable p);

	@Query("select new org.celllife.remedi.domain.datamart.MsisdnVisitsDTO(ups.ussdSessionId, ups.date, ups.endDate, ups.msisdn, ups.mnoCode)  " +
            "from UssdPageVisit ups " +
            "where (ups.date between :startDate and :endDate) " +
            " and ups.serviceId = :serviceId " +
            " and ups.msisdn like ('%' || :msisdn || '%')")
    Page<MsisdnVisitsDTO> findMsisdnVisitsByServiceAndMsisdn(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("serviceId") String serviceId, @Param("msisdn") String msisdn, Pageable p);
	
	@Query("select new org.celllife.remedi.domain.datamart.MsisdnVisitsDTO(ups.ussdSessionId, ups.date, ups.endDate, ups.msisdn, ups.mnoCode)  " +
            "from UssdPageVisit ups " +
            "where (ups.date between :startDate and :endDate) " +
            " and ups.themeId = :themeId " +
            " and ups.msisdn like ('%' || :msisdn || '%')")
    Page<MsisdnVisitsDTO> findMsisdnVisitsByThemeAndMsisdn(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("themeId") String themeId, @Param("msisdn") String msisdn, Pageable p);

	@Query("select new org.celllife.remedi.domain.datamart.MsisdnVisitsDTO(ups.ussdSessionId, ups.date, ups.endDate, ups.msisdn, ups.mnoCode)  " +
            "from UssdPageVisit ups " +
            "where (ups.date between :startDate and :endDate) " +
            " and ups.msisdn like ('%' || :msisdn || '%')")
    Page<MsisdnVisitsDTO> findMsisdnVisitsByMsisdn(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("msisdn") String msisdn, Pageable p);
}