package com.arthurlevi.payroll.entities;

public class Payment {
	
	private String name;
	private Integer days;
	private Double dailyIncome;
	
	public Payment() {
	}

	public Payment(String name, Integer days, Double dailyIncome) {
		super();
		this.name = name;
		this.days = days;
		this.dailyIncome = dailyIncome;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public Double getDailyIncome() {
		return dailyIncome;
	}

	public void setDailyIncome(Double dailyIncome) {
		this.dailyIncome = dailyIncome;
	}
	
	public double getTotal() {
		return dailyIncome * days;
	}
}

