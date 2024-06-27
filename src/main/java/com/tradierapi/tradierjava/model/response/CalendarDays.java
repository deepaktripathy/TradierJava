package com.tradierapi.tradierjava.model.response;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author deepak tripathy created on 06/26/2024
 *
 */
public class CalendarDays {
    @JsonProperty("day")
    private List<CalendarDay> days;

    public CalendarDays() {
    }

    public List<CalendarDay> getDays() {
        return this.days;
    }

    protected boolean canEqual(Object other) {
        return other instanceof CalendarDays;
    }

	@Override
	public int hashCode() {
		return Objects.hash(days);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CalendarDays other = (CalendarDays) obj;
		return Objects.equals(days, other.days);
	}

	@Override
	public String toString() {
		return "CalendarDays [days=" + days + "]";
	}

}