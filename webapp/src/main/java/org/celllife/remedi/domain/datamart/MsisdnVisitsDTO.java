package org.celllife.remedi.domain.datamart;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Data Transfer Object (DTO) used to contain Msisdn/User specific USSD request data
 */
public class MsisdnVisitsDTO {
	
	private static Logger log = LoggerFactory.getLogger(MsisdnVisitsDTO.class);

	private String ussdSessionId;
	private Date start;
	private Date end;
	private String msisdn;
	private MobileNetwork mobileNetwork;
	
	public MsisdnVisitsDTO() {
		
	}
	
	public MsisdnVisitsDTO(String ussdSessionId, Date start, Date end, String msisdn, MobileNetwork mno) {
		this.ussdSessionId =ussdSessionId;
		this.start = start;
		this.end = end;
		this.msisdn = msisdn;
		this.mobileNetwork = mno;
	}
	
	public MsisdnVisitsDTO(String ussdSessionId, Date start, Date end, String msisdn, int mno_code) {
		this.ussdSessionId =ussdSessionId;
		this.start = start;
		this.end = end;
		this.msisdn = msisdn;
		this.mobileNetwork = MobileNetwork.convert(mno_code);
		if (this.mobileNetwork == null) {
			log.warn("Ignoring invalid mno_code (Mobile Network Operator) '"+mno_code+"' for ussdSessionId="+ussdSessionId);
		}
	}

	public MsisdnVisitsDTO(String ussdSessionId, Date start, Date end, String msisdn, String mno_code) {
		this.ussdSessionId =ussdSessionId;
		this.start = start;
		this.end = end;
		this.msisdn = msisdn;
		if (mno_code != null) {
			try {
				this.mobileNetwork = MobileNetwork.convert(Integer.parseInt(mno_code));
			} catch (NumberFormatException e) {
				log.warn("Ignoring invalid mno_code (Mobile Network Operator) '"+mno_code+"' for ussdSessionId="+ussdSessionId);
			}
		}
	}

	/**
	 * MobileNetwork mapping for the AAT codes
	 */
	public enum MobileNetwork {
	    MTN("MTN"), VODACOM("Vodacom"), CELLC("Cell C/Virgin/Red Bull Mobile"), TELKOM("Telkom Mobile");
	    
	    private String description;
	    
	    MobileNetwork(String description) {
	    	this.description = description; 
	    }
	    
		/**
		 * <p>
		 * 1 = Vodacom <br/>
		 * 2 = MTN <br/>
		 * 3 = Cell C /Virgin/ Red Bull Mobile <br/>
		 * 4 = Telkom Mobile
		 * </p>
		 */
	    public static MobileNetwork convert(int i) {
	    	switch(i) {
	    		case 1 : return VODACOM;
	    		case 2 : return MTN;
	    		case 3 : return CELLC;
	    		case 4 : return TELKOM;
	    	}
	    	return null;
	    }
	    
	    public String getDescription() {
	    	return description;
	    }
	}


	public String getUssdSessionId() {
		return ussdSessionId;
	}


	public void setUssdSessionId(String ussdSessionId) {
		this.ussdSessionId = ussdSessionId;
	}

	public Date getStart() {
		return start;
	}


	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}


	public void setEnd(Date end) {
		this.end = end;
	}
	
	public String getDuration() {
		long duration = 0;
		if (end != null && start != null) {
			duration = (end.getTime() - start.getTime()) / 1000;
		}
		int hours = (int) (duration / 3600);    
		duration = duration % 3600;
		int mins = (int) (duration / 60);
		duration = duration % 60;
		return hours + ":" + mins;
	}

	public String getMsisdn() {
		return msisdn;
	}


	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}


	public MobileNetwork getMobileNetwork() {
		return mobileNetwork;
	}


	public void setMobileNetwork(MobileNetwork mobileNetwork) {
		this.mobileNetwork = mobileNetwork;
	}

	@Override
	public String toString() {
		return "MsisdnVisitsDTO [ussdSessionId=" + ussdSessionId + ", start=" + start + ", end=" + end + ", msisdn="
				+ msisdn + ", mobileNetwork=" + mobileNetwork + "]";
	}
	
}
