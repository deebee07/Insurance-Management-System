package com.util;

import java.util.ArrayList;
import java.util.Vector;

import com.dao.ClaimDAO;
import com.dao.CustomerDao;
import com.dao.LoginDao;
import com.dao.PolicyDao;
import com.model.ClaimProcessing;
import com.model.Customer;
import com.model.EmployeeLogin;
import com.model.HealthPolicy;
import com.model.Policy;
import com.model.VehiclePolicy;

public class Service {

	// ////////////////////////////MODULE 1 ////////////////////////////
	public ArrayList<EmployeeLogin> allEmployeeLogIn() {

		LoginDao loginDao = new LoginDao();

		ArrayList<EmployeeLogin> loginList = loginDao.allEmployeeLogin();
		return loginList;
	}
	public String getPassword(String securityAnswer,String empId)
	{ System.out.println("service");
		LoginDao loginDao = new LoginDao();
		return loginDao.getPassword(securityAnswer,empId);
	}
	public int addCustomer(Customer customer) {

		CustomerDao customerDao = new CustomerDao();
		return customerDao.addCustomer(customer);
	}

	public ArrayList<String> allEmail() {
		CustomerDao customerDao = new CustomerDao();
		return customerDao.allEmail();

	}

	public ArrayList<Customer> allCustomer() {

		CustomerDao customerDao = new CustomerDao();
		return customerDao.allCustomer();

	}

	public boolean deleteCustomer(int custId) {

		CustomerDao customerDao = new CustomerDao();
		boolean check = customerDao.deleteCustomer(custId);
		return check;

	}

	public boolean updateCustomer(Customer customer, int custUpdateId)

	{
		CustomerDao customerDao = new CustomerDao();
		boolean check = customerDao.updateCustomer(customer, custUpdateId);
		
		return check;
	}

	public boolean setHealthStatus(int custId) {
		CustomerDao customerDao = new CustomerDao();
		boolean check = customerDao.setHealthStatus(custId);
		return check;
	}

	public boolean setVehicleStatus(int custId) {
		CustomerDao customerDao = new CustomerDao();
		boolean check = customerDao.setVehicleStatus(custId);
		return check;
	}
	
	public Customer getCustomerPolicy(String policyRefNum)
	{
		CustomerDao customerDao = new CustomerDao();
		return customerDao.getCustomerPolicy(policyRefNum);
		
	}

	// //////////////////////////// MODULE 2 ////////////////////////////
	
	public ArrayList<Customer> allCustomers() {

		PolicyDao pDao = new PolicyDao();
		return pDao.allCustomers();

	}

	public ArrayList<HealthPolicy> viewPolicy() {
		PolicyDao pDao = new PolicyDao();
		return pDao.viewPolicy();
	}
	public ArrayList<HealthPolicy> viewCustomerPolicy() {
		PolicyDao pDao = new PolicyDao();
		return pDao.viewCustomerPolicy();
	}

	public String registerHealthPolicy(HealthPolicy hp) {

		PolicyDao pDao = new PolicyDao();
		return pDao.registerHealthPolicy(hp);

	}

	public boolean modifyHealthPolicy(HealthPolicy hp) {
		System.out.println("INSIDE SERVICE");
		PolicyDao pDao = new PolicyDao();
		return pDao.modifyHealthPolicy(hp);

	}

	public ArrayList<HealthPolicy> viewHealthPolicy(int customerId) {

		System.out.println("INSIDE SERVICE");
		PolicyDao pDao = new PolicyDao();
		return pDao.viewHealthPolicy(customerId);

	}

	public boolean deleteHealthPolicy(HealthPolicy hp) {

		PolicyDao pDao = new PolicyDao();
		return pDao.deleteHealthPolicy(hp);

	}

	public String registerVehiclePolicy(VehiclePolicy vp) {

		PolicyDao pDao = new PolicyDao();
		return pDao.registerVehiclePolicy(vp);

	}

	public boolean modifyVehiclePolicy(VehiclePolicy vp) {

		PolicyDao pDao = new PolicyDao();
		return pDao.modifyVehiclePolicy(vp);

	}

	public ArrayList<VehiclePolicy> viewVehiclePolicy(int customerId) {

		PolicyDao pDao = new PolicyDao();
		return pDao.viewVehiclePolicy(customerId);

	}

	public boolean deleteVehiclePolicy(VehiclePolicy vp) {

		PolicyDao pDao = new PolicyDao();
		return pDao.deleteVehiclePolicy(vp);

	}

	// /////////////////////////// MODULE 3 ////////////////////////////

	public String submitClaim(int custId, String policyRefNum,
			ClaimProcessing Obj) {
		ClaimDAO cd = new ClaimDAO();
		return cd.submitClaim(custId, policyRefNum, Obj);

	}

	public boolean modifyClaim(ClaimProcessing obj) {
		ClaimDAO cd = new ClaimDAO();
		return cd.modifyClaim(obj);

	}

	public ClaimProcessing getClaimDetails(String claimId, String officer) {
		ClaimDAO cd = new ClaimDAO();
		return cd.getClaimDetails(claimId, officer);

	}

	public ClaimProcessing getClaimDetailsForAdmin(String claimId) {
		ClaimDAO cd = new ClaimDAO();
		return cd.getClaimDetailsForAdmin(claimId);
	}

	public String approve_Claim(String claimId, String status) {

		System.out.println("service layer work");
		ClaimDAO cd = new ClaimDAO();
		return cd.approve_Claim(claimId, status);

	}

	public String reject_Claim(String claimId, String status,
			String reason) {
		ClaimDAO cd = new ClaimDAO();
		return cd.reject_Claim(claimId, status, reason);
	}

	public boolean deleteClaim(String claimId) {
		ClaimDAO cd = new ClaimDAO();
		return cd.deleteClaim(claimId);

	}
	
	public ClaimProcessing getClaimStatusReason(String claimId,String officer)
	{  
		ClaimDAO cd = new ClaimDAO();
		return cd.getClaimStatusReason(claimId,officer);
	}
	
	public ArrayList<String> getAllPolicyRefNum()
	{   
		ClaimDAO cd = new ClaimDAO();
		return cd.getAllPolicyRefNum();
	}
	/*public ArrayList<String> getAllEmailIds()
	{
		ClaimDAO cd = new ClaimDAO();
		return cd.getAllEmailIds();
	}*/
	
	public ArrayList<String> getAllClaimId()
	{ 
		ClaimDAO cd = new ClaimDAO();
		return cd.getAllClaimId();
	}
	
	
	
	public ArrayList<Object[]> makePieChart(){
		
		ClaimDAO cd = new ClaimDAO();
		return cd.pieChart();
		
	}
public ArrayList<Object[]> makePolicyPieChart(){
		
		PolicyDao pd = new PolicyDao();
		return pd.pieChart();
		
	}



public static void importXLS(String filename)
{
	CustomerDao custDAO=new CustomerDao();
	Vector dataHolder=custDAO.read(filename);
	custDAO.saveToDatabase(dataHolder);
		
}










	
	
	
	
}
