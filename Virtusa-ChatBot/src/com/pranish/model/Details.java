package com.pranish.model;

import java.io.Serializable;


public class Details implements Serializable {
 
    private static final long serialVersionUID = 1L;
    private String time;
    private String name;
    private String mobile;
	private String loan;
    private String incomesource;
    private String monthincome;
	private String monthemi;
	private String wagecut;
    private String affect;
    private String zone;
    private String rent;
	private String terms;
    private String repay;
    private String adhar;
    private String account_no;
    private String status="Pending";
    public String getTime() {
  		return time;
  	}
  	public void setTime(String time) {
  		this.time = time;
  	}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
	public String getLoan() {
        return loan;
    }
    public void setLoan(String loan) {
        this.loan = loan;
    }
    public String getIncomesource() {
        return incomesource;
    }
    public void setIncomesource(String incomesource) {
        this.incomesource = incomesource;
    }
	public String getMonthincome() {
        return monthincome;
    }
    public void setMonthincome(String monthincome) {
        this.monthincome = monthincome;
    }
	public String getMonthemi() {
        return monthemi;
    }
    public void setMonthemi(String monthemi) {
        this.monthemi = monthemi;
    }
	public String getWagecut() {
        return wagecut;
    }
    public void setWagecut(String wagecut) {
        this.wagecut = wagecut;
    }
	public String getAffect() {
        return affect;
    }
    public void setAffect(String affect) {
        this.affect = affect;
    }
	public String getZone() {
        return zone;
    }
    public void setZone(String zone) {
        this.zone = zone;
    }
	public String getRent() {
        return rent;
    }
    public void setRent(String rent) {
        this.rent = rent;
    }
	public String getTerms() {
        return terms;
    }
    public void setTerms(String terms) {
        this.terms = terms;
    }
	public String getRepay() {
        return repay;
    }
    public void setRepay(String repay) {
        this.repay = repay;
    }
    public String getAdhar() {
        return adhar;
    }
    public void setAdhar(String adhar) {
        this.adhar = adhar;
    }
	public String getAccount() {
		return account_no;
	}
	public void setAccount(String account_no) {
		this.account_no = account_no;
	}
	
	public String getStatus() {
			return status;
	}
}