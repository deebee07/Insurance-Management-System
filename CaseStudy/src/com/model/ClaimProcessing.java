package com.model;

import java.util.Date;

public class ClaimProcessing 
{
private double claimAmount;
private String claimSubmissionDate;
private String claimStatus;
private String claimId;
private String benName;
private String benAddress;
private String benEmail;
private long benContactNo;
private int benAge;
private String rejReason;


public String getRejReason() {
	return rejReason;
}

public void setRejReason(String rejReason) {
	this.rejReason = rejReason;
}

public ClaimProcessing() {
	super();
	
}

public double getClaimAmount() {
	return claimAmount;
}

public void setClaimAmount(double claimAmount) {
	this.claimAmount = claimAmount;
}

public String getClaimSubmissionDate() {
	return claimSubmissionDate;
}

public void setClaimSubmissionDate(String claimSubmissionDate) {
	this.claimSubmissionDate = claimSubmissionDate;
}

public String getClaimStatus() {
	return claimStatus;
}

public void setClaimStatus(String claimStatus) {
	this.claimStatus = claimStatus;
}

public String getClaimId() {
	return claimId;
}

public void setClaimId(String claimId) {
	this.claimId = claimId;
}

public String getBenName() {
	return benName;
}

public void setBenName(String benName) {
	this.benName = benName;
}

public String getBenAddress() {
	return benAddress;
}

public void setBenAddress(String benAddress) {
	this.benAddress = benAddress;
}

public String getBenEmail() {
	return benEmail;
}

public void setBenEmail(String benEmail) {
	this.benEmail = benEmail;
}

public long getBenContactNo() {
	return benContactNo;
}

public void setBenContactNo(long benContactNo) {
	this.benContactNo = benContactNo;
}

public int getBenAge() {
	return benAge;
}

public void setBenAge(int benAge) {
	this.benAge = benAge;
}


}
