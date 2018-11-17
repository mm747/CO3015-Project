package portal.controller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import portal.PortalApp;

public class IndexFormDto {
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private LocalDate date = PortalApp.getSystemDate();

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
