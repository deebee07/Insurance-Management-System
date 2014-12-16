package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.model.Customer;
import com.model.HealthPolicy;
import com.model.Policy;
import com.model.VehiclePolicy;

public class PolicyDao {
	private Connection connect = null;
	private PreparedStatement pst = null;
	private PreparedStatement pst1 = null;
	private ResultSet rs = null;
	

	// ///////////////////////// Health Policy Registration
	// //////////////////////////

	public String registerHealthPolicy(HealthPolicy hp) {

		String polRefNum = null;
		boolean flag = false;
		connect = DBConnection.getConnection();
		// Insert Details using bean object
		String checkPolicy = "SELECT POLICY_TYPE FROM GROUPE_POLICY WHERE POLICY_ID =?";
		try {
			pst = connect.prepareStatement(checkPolicy);
			pst.setString(1, hp.getPolicyId());
			rs = pst.executeQuery();
			while (rs.next()) {
				String policyType = rs.getString("POLICY_TYPE");

				hp.setPolicyType(policyType);
				System.out.println("Show" + hp.getPolicyType());
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		if (hp.getPolicyType().equals("Health")) {
			System.out.println("inside health");
			String checkPolicyId = "SELECT Distinct POLICY_ID FROM GROUPE_CUSTOMERPOLICY WHERE  CUST_ID =?";
		
			ArrayList<String> policy = new ArrayList<String>();
			
			
			try {
				
				pst = connect.prepareStatement(checkPolicyId);
				pst.setInt(1, hp.getCustomerId());
				System.out.println("inside try");
				rs = pst.executeQuery();
				while (rs.next()) {
					
					String polId = rs.getString(1);
					System.out.println(polId);
					policy.add(polId);
						for(String s:policy){
						System.out.println(s);}
						
					} 
				
				}
			 catch (SQLException e1) {

				e1.printStackTrace();
			}
 
              for(String s:policy)
			{
        	   if (hp.getPolicyId().equals(s)) 
        	   {
        		   //System.out.println(s);
        		   //System.out.println(hp.getPolicyId());
			    flag=true;
			   // System.out.println(flag);
        	   }
			}
           if(flag==false)
           { 
				String createCustomerQuery = "INSERT INTO GROUPE_CUSTOMERPOLICY VALUES ('H'||CUSTOMERPOLICY_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";

				try {

					pst = connect.prepareStatement(createCustomerQuery);

					pst.setString(1, hp.getPolicyId());
					pst.setInt(2, hp.getCustomerId());

					pst.setString(3, hp.getPolicyCommDate());
					pst.setString(4, hp.getPolicyEndDate());

					pst.setString(5, hp.getPaymentMode());
					pst.setString(6, hp.getPaymentFreq());
					pst.setDouble(7, hp.getPremiumAmount());
					pst.setInt(8, hp.getPolicytenure());

					pst.executeUpdate();

					connect.commit();

					PreparedStatement pStmt = connect
							.prepareStatement("SELECT 'H' || CUSTOMERPOLICY_SEQ.CURRVAL AS ID FROM DUAL");
					rs = pStmt.executeQuery();

					while (rs.next()) {

						polRefNum = rs.getString("ID");
						System.out.println(polRefNum);
					}
				}

				catch (SQLException e) {
					System.out
							.println("Exception occured while performing create customer operation");
					e.printStackTrace();
				} finally {

					DBConnection.closeStatement(pst);

					DBConnection.closeConnection(connect);

				}
			}
           else
           {
        	   return polRefNum;
        	   
           }
		} 
		else   
		    {
			System.out.println("Sorry! No Authority");
		    }
		return polRefNum;
	}

	// ///////////////////////// Vehicle Policy Registration
	// //////////////////////////

	public String registerVehiclePolicy(VehiclePolicy vp) {

		String polRefNum = null;
		boolean flag = false;
		connect = DBConnection.getConnection();
		// Insert Details using bean object
		String checkPolicy = "SELECT POLICY_TYPE FROM GROUPE_POLICY WHERE POLICY_ID =?";
		try {
			pst = connect.prepareStatement(checkPolicy);
			pst.setString(1, vp.getPolicyId());
			rs = pst.executeQuery();
			while (rs.next()) {
				String policyType = rs.getString("POLICY_TYPE");

				vp.setPolicyType(policyType);
				System.out.println("Show" + vp.getPolicyType());
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		if (vp.getPolicyType().equals("Vehicle")) {
			String checkPolicyId = "SELECT Distinct POLICY_ID FROM GROUPE_CUSTOMERPOLICY WHERE CUST_ID =?";
		
			ArrayList<String> policy = new ArrayList<String>();
			
			
			try {
				pst = connect.prepareStatement(checkPolicyId);
				pst.setInt(1, vp.getCustomerId());
				rs = pst.executeQuery();
				while (rs.next()) {

					String polId = rs.getString("POLICY_ID");
					policy.add(polId);
						for(String s:policy){
						System.out.println(s);}
						
					} 
				
				}
			 catch (SQLException e1) {

				e1.printStackTrace();
			}
 
              for(String s:policy)
			{
        	   if (vp.getPolicyId().equals(s)) 
        	   {
        		   System.out.println(s);
        		   System.out.println(vp.getPolicyId());
			    flag=true;
			    System.out.println(flag);
        	   }
			}
           if(flag==false)
           { 
					
        	   String createCustomerQuery = "INSERT INTO GROUPE_CUSTOMERPOLICY VALUES ('V'||CUSTOMERPOLICY_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
        	   
        	   try{
					pst = connect.prepareStatement(createCustomerQuery);

					pst.setString(1, vp.getPolicyId());
					pst.setInt(2, vp.getCustomerId());

					pst.setString(3, vp.getPolicyCommDate());
					pst.setString(4, vp.getPolicyEndDate());
					pst.setString(5, vp.getPaymentMode());
					pst.setString(6, vp.getPaymentFreq());
					pst.setDouble(7, vp.getPremiumAmount());
					pst.setInt(8, 1);

					pst.executeUpdate();

					PreparedStatement pStmt = connect
							.prepareStatement("SELECT 'V' || CUSTOMERPOLICY_SEQ.CURRVAL AS ID FROM DUAL");
					rs = pStmt.executeQuery();

					if (rs.next()) {

						polRefNum = rs.getString("ID");
					}

					String createVehicleQuery = "INSERT INTO GROUPE_VEHICLEPOLICY VALUES(?,?,?,?)";
					pst1 = connect.prepareStatement(createVehicleQuery);
					System.out.println("djghfkjgdhhkl" + vp.getLicenseNum());
					pst1.setString(1, polRefNum);
					pst1.setString(2, vp.getVehicleNum());
					pst1.setString(3, vp.getLicenseNum());
					pst1.setString(4, vp.getVehicleType());

					pst1.executeUpdate();
					connect.commit();
				}

				catch (SQLException e) {
					System.out
							.println("Exception occured while performing create customer operation");
					e.printStackTrace();
				} finally {

					DBConnection.closeStatement(pst);

					DBConnection.closeConnection(connect);

				}
			}
		} else {
			System.out.println("Sorry! No Authority");
		}
		return polRefNum;
	}

	// /////////////////////////view Policy /////////////////////////////////
	public ArrayList<HealthPolicy> viewPolicy() {
		ArrayList<HealthPolicy> policyList = new ArrayList<HealthPolicy>();
		connect = DBConnection.getConnection();
		String createCustomerQuery = "SELECT * FROM GROUPE_POLICY";

		try {
			pst = connect.prepareStatement(createCustomerQuery);

			rs = pst.executeQuery();
			while (rs.next()) {
				HealthPolicy hp = new HealthPolicy();

				String policyId = rs.getString("POLICY_ID");
				String policyType = rs.getString("POLICY_TYPE");
				hp.setPolicyId(policyId);
				hp.setPolicyType(policyType);
				policyList.add(hp);
			}
		} catch (SQLException e) {
			System.out
					.println("Exception occured while performing create customer operation");
			e.printStackTrace();
		} finally {

			DBConnection.closeStatement(pst);

			DBConnection.closeConnection(connect);
		}
		return policyList;
	}

	public ArrayList<HealthPolicy> viewCustomerPolicy() {
		ArrayList<HealthPolicy> pList = new ArrayList<HealthPolicy>();
		connect = DBConnection.getConnection();
		String createCustomerQuery = "SELECT POLICY_REFNUM FROM GROUPE_CUSTOMERPOLICY";

		try {
			pst = connect.prepareStatement(createCustomerQuery);

			rs = pst.executeQuery();
			while (rs.next()) {
				HealthPolicy hp = new HealthPolicy();

				String policyNum = rs.getString("POLICY_REFNUM");

				hp.setPolicyRefNum(policyNum);

				pList.add(hp);
				System.out.println(pList.toString());
			}
		} catch (SQLException e) {
			System.out
					.println("Exception occured while performing create customer operation");
			e.printStackTrace();
		} finally {

			DBConnection.closeStatement(pst);

			DBConnection.closeConnection(connect);
		}
		System.out.println("IN VIEW CUSTOMER POLICY");
		return pList;
	}

	// /////////// Modify Health Policy ////////////////////////
	public boolean modifyHealthPolicy(HealthPolicy hp) {
		connect = DBConnection.getConnection();
		boolean b = false;
		String checkPolicy = "SELECT POLICY_TYPE FROM GROUPE_POLICY WHERE POLICY_ID IN(SELECT POLICY_ID FROM GROUPE_CUSTOMERPOLICY WHERE POLICY_REFNUM =?)";
		try {
			pst = connect.prepareStatement(checkPolicy);
			pst.setString(1, hp.getPolicyRefNum());
			rs = pst.executeQuery();
			while (rs.next()) {
				String policyType = rs.getString("POLICY_TYPE");

				hp.setPolicyType(policyType);

			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		System.out.println("Show" + hp.getPolicyType());
		if (hp.getPolicyType().equals("Health")) {
		
			
			
			
				try {
					String modifyPolicy = "UPDATE GROUPE_CUSTOMERPOLICY SET PAYMENT_MODE=?,PAYMENT_FREQ=? where POLICY_REFNUM=?";

					System.out.println("Inside try");
					pst = connect.prepareStatement(modifyPolicy);
					pst.setString(1, hp.getPaymentMode());
					pst.setString(2, hp.getPaymentFreq());
					pst.setString(3, hp.getPolicyRefNum());
					
					pst.executeUpdate();
					System.out.println("Before catch");
					b = true;
				} catch (SQLException e) {
					System.out
							.println("Exception occured while performing modify policy operation");
					e.printStackTrace();
				} finally {

					DBConnection.closeStatement(pst);

					DBConnection.closeConnection(connect);

				}
			} else {
				System.out.println("Policy ID is not valid for this customer");
			}
		
		return b;

	}

	// /////////// Modify Vehicle Policy ////////////////////////
	public boolean modifyVehiclePolicy(VehiclePolicy vp) {
		connect = DBConnection.getConnection();
		boolean b = false;
		String checkPolicy = "SELECT POLICY_TYPE FROM GROUPE_POLICY WHERE POLICY_ID IN(SELECT POLICY_ID FROM GROUPE_CUSTOMERPOLICY WHERE POLICY_REFNUM =?)";
		try {
			pst = connect.prepareStatement(checkPolicy);
			pst.setString(1, vp.getPolicyRefNum());
			rs = pst.executeQuery();
			while (rs.next()) {
				String policyType = rs.getString("POLICY_TYPE");

				vp.setPolicyType(policyType);

			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		System.out.println("Show" + vp.getPolicyType());
		if (vp.getPolicyType().equals("Vehicle")) {
		
			
			
			
				try {
					String modifyPolicy = "UPDATE GROUPE_CUSTOMERPOLICY SET PAYMENT_MODE=?,PAYMENT_FREQ=? where POLICY_REFNUM=?";

					System.out.println("Inside try");
					pst = connect.prepareStatement(modifyPolicy);
					pst.setString(1, vp.getPaymentMode());
					pst.setString(2, vp.getPaymentFreq());
					pst.setString(3, vp.getPolicyRefNum());
					
					pst.executeUpdate();
					System.out.println("Before catch");
					b = true;
				} catch (SQLException e) {
					System.out
							.println("Exception occured while performing modify policy operation");
					e.printStackTrace();
				} finally {

					DBConnection.closeStatement(pst);

					DBConnection.closeConnection(connect);

				}
			} else {
				System.out.println("Policy ID is not valid for this customer");
			}
		
		return b;
	}

	// ////////////// View Health Policy //////////////////////////

	public ArrayList<HealthPolicy> viewHealthPolicy(int customerId) {

		// initialize the list
		ArrayList<HealthPolicy> healthPolicyList = new ArrayList<HealthPolicy>();

		// execute search query using prepared statement
		Connection conn = DBConnection.getConnection();
		PreparedStatement viewHealhPolicy = null;
		ResultSet rs = null;

		HealthPolicy hp = new HealthPolicy();
		String checkPolicy = "SELECT POLICY_TYPE FROM GROUPE_POLICY WHERE POLICY_ID IN(SELECT POLICY_ID FROM GROUPE_CUSTOMERPOLICY WHERE CUST_ID=?)";
		try {
			System.out.println("Inside view try");
			viewHealhPolicy = conn.prepareStatement(checkPolicy);
			viewHealhPolicy.setInt(1, customerId);
			rs = viewHealhPolicy.executeQuery();

			while (rs.next()) {
				String policyType = rs.getString("POLICY_TYPE");

				hp.setPolicyType(policyType);
				System.out.println("Show " + hp.getPolicyType());
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		if(hp.getPolicyType().equals("Health")){
		String viewHealthPolicyQuery = "SELECT * FROM GROUPE_CUSTOMERPOLICY WHERE POLICY_ID IN(SELECT POLICY_ID FROM GROUPE_POLICY WHERE POLICY_TYPE=?) AND CUST_ID=?";

		try {

			viewHealhPolicy = conn.prepareStatement(viewHealthPolicyQuery);
			viewHealhPolicy.setString(1, hp.getPolicyType());
			viewHealhPolicy.setInt(2, customerId);
			rs = viewHealhPolicy.executeQuery();

			while (rs.next()) {

				int cid = rs.getInt("CUST_ID");
				System.out.println("Details of customer are :" + " " + cid);

				String policyRefNum = rs.getString("POLICY_REFNUM");
				String policyId = rs.getString("POLICY_ID");
				String policyCommDate = rs.getString("POLICY_COMMDATE");
				String policyEndDate = rs.getString("POLICY_ENDDATE");
				String paymentMode = rs.getString("PAYMENT_MODE");
				String paymentFrequency = rs.getString("PAYMENT_FREQ");
				double premiumAmount = rs.getInt("PREMIUM_AMOUNT");
				int policyTenure = rs.getInt("POLICY_TENURE");

				HealthPolicy hpBean = new HealthPolicy();

				hpBean.setCustomerId(cid);
				hpBean.setPolicyRefNum(policyRefNum);
				hpBean.setPolicyId(policyId);
				hpBean.setPolicyCommDate(policyCommDate);
				hpBean.setPolicyEndDate(policyEndDate);
				hpBean.setPaymentMode(paymentMode);
				hpBean.setPaymentFreq(paymentFrequency);
				hpBean.setPremiumAmount(premiumAmount);
				hpBean.setPolicytenure(policyTenure);

				healthPolicyList.add(hpBean);
			}
		}

		catch (SQLException e) {
			System.out.println("Error while searching the element");
			e.printStackTrace();
		}

		finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(viewHealhPolicy);
			DBConnection.closeConnection(conn);
		}
		}
		System.out.println("Number of customers matched: "
				+ healthPolicyList.size());

		return healthPolicyList;

	}

	// ////////////// View Vehicle Policy //////////////////////////

	public ArrayList<VehiclePolicy> viewVehiclePolicy(int customerId) {

		// initialize the list
		ArrayList<VehiclePolicy> vehiclePolicyList = new ArrayList<VehiclePolicy>();

		// execute search query using prepared statement
		Connection conn = DBConnection.getConnection();
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		VehiclePolicy vp = new VehiclePolicy();
		String checkPolicy = "SELECT POLICY_TYPE FROM GROUPE_POLICY WHERE POLICY_ID IN(SELECT POLICY_ID FROM GROUPE_CUSTOMERPOLICY WHERE CUST_ID=?)";
		try {
			System.out.println("Inside view try");
			pStmt = conn.prepareStatement(checkPolicy);
			pStmt.setInt(1, customerId);
			rs = pStmt.executeQuery();

			while (rs.next()) {
				String policyType = rs.getString("POLICY_TYPE");

				vp.setPolicyType(policyType);
				System.out.println("Show " + vp.getPolicyType());
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		String viewVehiclePolicyQuery = "SELECT * FROM GROUPE_CUSTOMERPOLICY T1,GROUPE_VEHICLEPOLICY T2 WHERE T1.POLICY_REFNUM=T2.POLICY_REFNUM AND CUST_ID=?";
		try {

			pStmt = conn.prepareStatement(viewVehiclePolicyQuery);
			pStmt.setInt(1, customerId);
			rs = pStmt.executeQuery();

			while (rs.next()) {

				int cid = rs.getInt("CUST_ID");
				System.out.println("Details of customer are :" + " " + cid);

				String policyRefNum = rs.getString("POLICY_REFNUM");
				String policyId = rs.getString("POLICY_ID");
				String policyCommDate = rs.getString("POLICY_COMMDATE");
				String policyEndDate = rs.getString("POLICY_ENDDATE");
				String paymentMode = rs.getString("PAYMENT_MODE");
				String paymentFrequency = rs.getString("PAYMENT_FREQ");
				double premiumAmount = rs.getInt("PREMIUM_AMOUNT");
				String policyTenure = rs.getString("POLICY_TENURE");
				String vehicleNum = rs.getString("VEHICLE_NUM");
				String licenceNum = rs.getString("LICENCE_NUM");
				String vehicleType = rs.getString("VEHICLE_TYPE");
				
				VehiclePolicy vpBean = new VehiclePolicy();

				vpBean.setCustomerId(cid);
				vpBean.setPolicyRefNum(policyRefNum);
				vpBean.setPolicyId(policyId);
				vpBean.setPolicyCommDate(policyCommDate);
				vpBean.setPolicyEndDate(policyEndDate);
				vpBean.setPaymentMode(paymentMode);
				vpBean.setPaymentFreq(paymentFrequency);
				vpBean.setPremiumAmount(premiumAmount);

				vpBean.setVehicleNum(vehicleNum);
				vpBean.setLicenseNum(licenceNum);
				vpBean.setVehicleType(vehicleType);

				vehiclePolicyList.add(vpBean);

			}
		}

		catch (SQLException e) {
			System.out.println("Error while searching the element");
			e.printStackTrace();
		}

		finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(pStmt);
			DBConnection.closeConnection(conn);
		}

		System.out.println("Number of customers matched: "
				+ vehiclePolicyList.size());

		return vehiclePolicyList;
	}

	// ////////Delete Health Policy ///////

	public boolean deleteHealthPolicy(HealthPolicy hp) {
		connect = DBConnection.getConnection();
		boolean b = false;
		String checkPolicy = "SELECT POLICY_TYPE FROM GROUPE_POLICY WHERE POLICY_ID IN(SELECT POLICY_ID FROM GROUPE_CUSTOMERPOLICY WHERE POLICY_REFNUM =?)";
		try {
			pst = connect.prepareStatement(checkPolicy);
			pst.setString(1, hp.getPolicyRefNum());
			rs = pst.executeQuery();
			while (rs.next()) {
				String policyType = rs.getString("POLICY_TYPE");

				hp.setPolicyType(policyType);

			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		System.out.println("Show" + hp.getPolicyType());
		if (hp.getPolicyType().equals("Health")) {

			String getPolicy = "SELECT POLICY_COMMDATE FROM GROUPE_CUSTOMERPOLICY WHERE POLICY_REFNUM =?";
			try {
				pst = connect.prepareStatement(getPolicy);
				pst.setString(1, hp.getPolicyRefNum());
				rs = pst.executeQuery();
				while (rs.next()) {
					String policycommdate = rs.getString("POLICY_COMMDATE");

					hp.setPolicyCommDate(policycommdate);
					System.out.println("Show" + hp.getPolicyCommDate());
				}
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			String commDate = hp.getPolicyCommDate();

			SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
			Date date = null;
			try {
				date = sdf.parse(commDate);
				System.out.println("show me date" + date.toString());
			} catch (ParseException e1) {
				e1.printStackTrace();
				System.out.println("No data Found");
			}
			Calendar now = Calendar.getInstance();
			now.add(Calendar.DATE, -14);
			System.out.println("Inside delete");
			Date todate1 = now.getTime();
			System.out.println("Inside todate1" + todate1.toString());

			if (todate1.after(date)) {

				String deletePolicy = "DELETE FROM GROUPE_CUSTOMERPOLICY WHERE POLICY_REFNUM=?";
				try {
					System.out.println("Inside query");
					pst = connect.prepareStatement(deletePolicy);
					pst.setString(1, hp.getPolicyRefNum());
					pst.executeUpdate();
					b = true;

				} catch (SQLException e) {
					System.out
							.println("Exception occured while performing delete operation");
					e.printStackTrace();
				} finally {

					DBConnection.closeStatement(pst);

					DBConnection.closeConnection(connect);

				}
			} else {
				System.out.println("Sorry! No Authority");
			}
		}
		return b;
	}

	// ////////Delete Vehicle Policy ///////
	public boolean deleteVehiclePolicy(VehiclePolicy vp) {
		connect = DBConnection.getConnection();
		boolean b = false;
		String checkPolicy = "SELECT POLICY_TYPE FROM GROUPE_POLICY WHERE POLICY_ID IN(SELECT POLICY_ID FROM GROUPE_CUSTOMERPOLICY WHERE POLICY_REFNUM =?)";
		try {
			pst = connect.prepareStatement(checkPolicy);
			pst.setString(1, vp.getPolicyRefNum());
			rs = pst.executeQuery();
			while (rs.next()) {
				String policyType = rs.getString("POLICY_TYPE");

				vp.setPolicyType(policyType);

			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		System.out.println("Show" + vp.getPolicyType());
		if (vp.getPolicyType().equals("Vehicle")) {
			String getPolicy = "SELECT POLICY_COMMDATE FROM GROUPE_CUSTOMERPOLICY WHERE POLICY_REFNUM =?";
			try {
				pst = connect.prepareStatement(getPolicy);
				pst.setString(1, vp.getPolicyRefNum());

				rs = pst.executeQuery();
				while (rs.next()) {
					String policycommdate = rs.getString("POLICY_COMMDATE");

					vp.setPolicyCommDate(policycommdate);
					System.out.println("Show" + vp.getPolicyCommDate());
				}
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			String commDate = vp.getPolicyCommDate();

			SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
			Date date = null;
			try {
				date = sdf.parse(commDate);
				System.out.println("show me date" + date.toString());
			} catch (ParseException e1) {

				e1.printStackTrace();
			}
			Calendar now = Calendar.getInstance();
			now.add(Calendar.DATE, -14);
			System.out.println("Inside delete");
			Date todate1 = now.getTime();
			System.out.println("Inside todate1" + todate1.toString());

			if (todate1.after(date)) {

				try {
					String deletePolicy = "DELETE FROM GROUPE_VEHICLEPOLICY WHERE POLICY_REFNUM=?";

					System.out.println("Inside vehicle query");
					pst = connect.prepareStatement(deletePolicy);
					pst.setString(1, vp.getPolicyRefNum());
					pst.executeUpdate();
					String deletePolicy1 = "DELETE FROM GROUPE_CUSTOMERPOLICY WHERE POLICY_REFNUM=?";

					System.out.println("Inside vehicle query");
					pst = connect.prepareStatement(deletePolicy1);
					pst.setString(1, vp.getPolicyRefNum());
					pst.executeUpdate();
					b = true;

				} catch (SQLException e) {
					System.out
							.println("Exception occured while performing delete operation");
					e.printStackTrace();
				} finally {

					DBConnection.closeStatement(pst);

					DBConnection.closeConnection(connect);

				}

			}
		} else {
			System.out.println("Sorry! No Authority");
		}

		return b;
	}
	public ArrayList<Object[]> pieChart()
	{   
		
		ArrayList<Object[]> allClaimId=new ArrayList<Object[]>();
		
		try
		{
			connect= DBConnection.getConnection();
			pst=connect.prepareStatement("SELECT count(custpolicy.POLICY_REFNUM) COUNT,policy.POLICY_TYPE FROM GROUPE_POLICY policy, GROUPE_CUSTOMERPOLICY custpolicy WHERE policy.POLICY_ID = custpolicy.policy_id GROUP BY policy.POLICY_TYPE ");
			
			rs=pst.executeQuery();
			while(rs.next())
			{
				Object[] row = new Object[2];
				row[0] = rs.getInt("COUNT");
				System.out.println(row[0]);
				row[1] = rs.getString("POLICY_TYPE");
				System.out.println(row[1]);
				allClaimId.add(row);
			}
		
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(pst);
			DBConnection.closeConnection(connect);
		}
		
		return allClaimId;


public ArrayList<Customer> allCustomers() {
	
	ArrayList<Customer> customers = new ArrayList<Customer>();
	
	try{
		connect = DBConnection.getConnection();
		

	PreparedStatement query=connect.prepareStatement("SELECT CUST_ID FROM GROUPE_CUSTOMERPOLICY");
	rs=query.executeQuery();
	
	while(rs.next()){
		Customer tempcust=new Customer();
		
		
		
		int customerId=rs.getInt("CUST_ID");
		
		tempcust.setCustomerId(customerId);
	
		
		
		
		customers.add(tempcust);
		
		}
	
	}
	catch(Exception e)
	{
	e.printStackTrace();
	}
	
finally
{
	DBConnection.closeResultSet(rs);
	DBConnection.closeStatement(pst);
	DBConnection.closeConnection(connect);
	
}
<<<<<<< .mine
}
=======
	return customers;
	
}
}>>>>>>> .r10284
