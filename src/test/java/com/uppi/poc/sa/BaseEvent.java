package com.uppi.poc.sa;

import java.io.Serializable;

public abstract class BaseEvent implements Serializable{
	
	protected String eventName;
	protected Long fpAccountId;
	protected Long programId;
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public Long getFpAccountId() {
		return fpAccountId;
	}
	public void setFpAccountId(Long fpAccountId) {
		this.fpAccountId = fpAccountId;
	}
	public Long getProgramId() {
		return programId;
	}
	public void setProgramId(Long programId) {
		this.programId = programId;
	}

	public abstract Integer getOrder();
}
