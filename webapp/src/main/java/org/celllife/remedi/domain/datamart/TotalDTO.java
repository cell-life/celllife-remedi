package org.celllife.remedi.domain.datamart;		


public class TotalDTO {
	
	private Long totalVisits;

	public Long getTotalVisits() {
		return totalVisits;
	}

	public void setTotalVisits(Long totalVisits) {
		this.totalVisits = totalVisits;
	}

	public TotalDTO(Long totalVisits) {
		this.totalVisits = totalVisits;
	}
	
	public TotalDTO() {
		
	}

}
