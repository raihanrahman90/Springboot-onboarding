package com.example.onboarding.poc2.dto;

import java.time.LocalDateTime;
import java.time.ZoneId;

import com.example.onboarding.poc2.model.BooksModel;

public class JobRequestDTO {
    private LocalDateTime dateTime;
    private ZoneId timeZone;
    private String scheduleType;
    
	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public ZoneId getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(ZoneId timeZone) {
		this.timeZone = timeZone;
	}

	public String getScheduleType() {
		return scheduleType;
	}

	public void setScheduleType(String scheduleType) {
		this.scheduleType = scheduleType;
	}

}
