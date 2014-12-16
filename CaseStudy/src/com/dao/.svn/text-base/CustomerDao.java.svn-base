package com.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.model.ClaimProcessing;
import com.model.Customer;

public class CustomerDao {

	static Logger log = Logger.getLogger(CustomerDao.class.getName());

	private Connection connect = null;
	private PreparedStatement pst = null;

	private ResultSet rs = null;

	public int addCustomer(Customer customer) {

		BasicConfigurator.configure();
		log.debug("IN CUSTOMER DAO");
		log.info("Hello this is an info message");
		log.error("Hello");

		int custId = 0;
		try {
			connect = DBConnection.getConnection();
			// Insert Details using bean object

			String sql = "INSERT INTO GROUPE_CUSTOMER VALUES(GROUPE_SEQ_CUSTOMER.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";

			pst = connect.prepareStatement(sql);
			pst.setString(1, customer.getCustomerName());
			pst.setString(2, customer.getCustomerDob());
			pst.setString(3, customer.getCustomerEmail());
			pst.setString(4, customer.getCustomerAddress());
			pst.setLong(5, customer.getCustomerContactNumber());
			pst.setString(6, customer.getPhoto_Proof());
			pst.setString(7, customer.getPhoto_Proof_Id());
			pst.setString(8, customer.getAddress_Proof());
			pst.setString(9, customer.getAddress_Proof_Id());

			pst.setString(10, customer.getCustomerRegisterationDate());
			pst.executeUpdate();

			connect.commit();

			PreparedStatement queryexecu = connect
					.prepareStatement("SELECT GROUPE_SEQ_CUSTOMER.CURRVAL AS ID FROM DUAL");
			rs = queryexecu.executeQuery();

			if (rs.next()) {

				custId = rs.getInt("ID");
			}

			DBConnection.closeStatement(pst);
			DBConnection.closeConnection(connect);
		} catch (Exception e) {
			System.out
					.println("Exception occurred while performing create customer operation");
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(pst);
			DBConnection.closeConnection(connect);

		}

		return custId;

	}

	public ArrayList<String> allEmail() {

		ArrayList<String> emails = new ArrayList<String>();

		try {
			connect = DBConnection.getConnection();

			PreparedStatement query = connect
					.prepareStatement("SELECT CUST_EMAIL AS EMAIL FROM GROUPE_CUSTOMER");
			rs = query.executeQuery();

			while (rs.next()) {

				String email = rs.getString("EMAIL");

				emails.add(email);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(pst);
			DBConnection.closeConnection(connect);

		}
		return emails;

	}

	public ArrayList<Customer> allCustomer() {

		ArrayList<Customer> customers = new ArrayList<Customer>();

		try {
			connect = DBConnection.getConnection();

			PreparedStatement query = connect
					.prepareStatement("SELECT * FROM GROUPE_CUSTOMER");
			rs = query.executeQuery();

			while (rs.next()) {
				Customer tempcust = new Customer();

				String address_Proof = rs.getString("ADDRESS_PROOF");
				String address_Proof_Id = rs.getString("ADDRESS_PROOF_ID");

				long customerContactNumber = rs.getLong("CUST_CONTACTNUM");

				String customerDob = rs.getString("CUST_DOB");
				String customerName = rs.getString("CUST_NAME");
				String customerRegisterationDate = rs.getString("CUST_REGDATE");

				String photo_Proof = rs.getString("PHOTO_PROOF");
				String photo_Proof_Id = rs.getString("PHOTO_PROOF_ID");
				String customerAddress = rs.getString("CUST_ADDRESS");

				int customerId = rs.getInt("CUST_ID");
				String customerEmail = rs.getString("CUST_EMAIL");

				tempcust.setAddress_Proof(address_Proof);
				tempcust.setAddress_Proof_Id(address_Proof_Id);

				tempcust.setCustomerAddress(customerAddress);
				tempcust.setCustomerContactNumber(customerContactNumber);
				tempcust.setCustomerDob(customerDob);
				tempcust.setCustomerName(customerName);

				tempcust.setCustomerRegisterationDate(customerRegisterationDate);

				tempcust.setPhoto_Proof(photo_Proof);
				tempcust.setPhoto_Proof_Id(photo_Proof_Id);

				tempcust.setCustomerId(customerId);
				tempcust.setCustomerEmail(customerEmail);

				customers.add(tempcust);
				System.out.println("DAO COMPLETE");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(pst);
			DBConnection.closeConnection(connect);

		}
		return customers;

	}

	public boolean deleteCustomer(int custId) {
		System.out.println("in delete customer with custid " + custId);
		boolean check = false;
		try {
			connect = DBConnection.getConnection();
			// Insert Details using bean object

			String sql = "DELETE FROM GROUPE_CUSTOMER WHERE CUST_ID=?";

			pst = connect.prepareStatement(sql);

			pst.setInt(1, custId);
			System.out.println("asdsadasdasdsada before execute update");
			int x = pst.executeUpdate();

			if (x != 0)
				check = true;

			connect.commit();

		} catch (Exception e) {
			System.out
					.println("Exception occurred while performing delete customer operation");
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(pst);
			DBConnection.closeConnection(connect);

		}

		return check;

	}

	public boolean updateCustomer(Customer customer, int custUpdateId) {

		boolean check = false;
		try {
			connect = DBConnection.getConnection();
			// Insert Details using bean object

			String sql = "UPDATE GROUPE_CUSTOMER SET CUST_NAME=?,CUST_DOB=?, CUST_EMAIL=?, CUST_ADDRESS=?, CUST_CONTACTNUM=?  WHERE CUST_ID=?";

			pst = connect.prepareStatement(sql);

			pst.setString(1, customer.getCustomerName());
			pst.setString(2, customer.getCustomerDob());
			pst.setString(3, customer.getCustomerEmail());
			pst.setString(4, customer.getCustomerAddress());

			pst.setLong(5, customer.getCustomerContactNumber());

			pst.setInt(6, custUpdateId);

			int x = pst.executeUpdate();

			if (x != 0)
				check = true;

			connect.commit();

		}

		catch (Exception e) {
			System.out
					.println("Exception occurred while performing update customer operation");
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(pst);
			DBConnection.closeConnection(connect);

		}

		return check;

	}

	public boolean setHealthStatus(int custId) {

		boolean check = false;
		int countActivePolicy = 0;
		try {
			connect = DBConnection.getConnection();
			// Insert Details using bean object

			String sql = "SELECT COUNT(POLICY_REFNUM) AS COUNT FROM GROUPE_CUSTOMERPOLICY WHERE CUST_ID=?";

			pst = connect.prepareStatement(sql);
			pst.setInt(1, custId);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				countActivePolicy = rs.getInt("COUNT");
				System.out.println("check method" + countActivePolicy);
			}

			if (countActivePolicy > 0)
				check = true;

			connect.commit();

		}

		catch (Exception e) {
			System.out
					.println("Exception occurred while performing update customer operation");
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(pst);
			DBConnection.closeConnection(connect);

		}

		System.out.println("Set health status" + check);
		return check;

	}

	public boolean setVehicleStatus(int custId) {

		boolean check = false;
		int countActivePolicy = 0;
		try {
			connect = DBConnection.getConnection();
			// Insert Details using bean object

			String sql = "SELECT COUNT(GROUPE_VEHICLEPOLICY.POLICY_REFNUM) AS COUNT FROM GROUPE_VEHICLEPOLICY,GROUPE_CUSTOMERPOLICY WHERE GROUPE_VEHICLEPOLICY.POLICY_REFNUM=GROUPE_CUSTOMERPOLICY.POLICY_REFNUM AND CUST_ID=?";

			pst = connect.prepareStatement(sql);
			pst.setInt(1, custId);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				countActivePolicy = rs.getInt("COUNT");
				System.out.println("check method" + countActivePolicy);
			}

			if (countActivePolicy > 0)
				check = true;

			connect.commit();

		}

		catch (Exception e) {
			System.out
					.println("Exception occurred while performing update customer operation");
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(pst);
			DBConnection.closeConnection(connect);

		}

		System.out.println("Set vehicle status" + check);
		return check;
	}

	public Customer getCustomerPolicy(String policyRefNum) {

		Customer customer = null;
		try {
			connect = DBConnection.getConnection();
			pst = connect
					.prepareStatement("SELECT CUST_NAME,CUST_ID FROM GROUPE_CUSTOMER WHERE CUST_ID IN (SELECT CUST_ID FROM GROUPE_CUSTOMERPOLICY WHERE POLICY_REFNUM=?)");
			pst.setString(1, policyRefNum);

			rs = pst.executeQuery();
			while (rs.next()) {
				customer = new Customer();
				customer.setCustomerName(rs.getString("CUST_NAME"));
				customer.setCustomerId(rs.getInt("CUST_ID"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeResultSet(rs);
			DBConnection.closeStatement(pst);
			DBConnection.closeConnection(connect);
		}

		return customer;
	}

	
	
	
    public static Vector read(String fileName)    {
        Vector cellVectorHolder = new Vector();
        try{
                FileInputStream myInput = new FileInputStream(fileName);
                POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
                HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);
                HSSFSheet mySheet = myWorkBook.getSheetAt(0);
                Iterator rowIter = mySheet.rowIterator(); 
                while(rowIter.hasNext()){
                						HSSFRow myRow = (HSSFRow) rowIter.next();
                						Iterator cellIter = myRow.cellIterator();
                						Vector cellStoreVector=new Vector();
                						while(cellIter.hasNext()){
                													HSSFCell myCell = (HSSFCell) cellIter.next();
                													cellStoreVector.addElement(myCell);
                												}
                  cellVectorHolder.addElement(cellStoreVector);
          }
        }
        
        catch (Exception e){e.printStackTrace(); }
        
        return cellVectorHolder;
    }
     
    
    
    
    

     public static String cellToString(HSSFCell cell) {  
    	    int type;
    	    Object result;
    	    type = cell.getCellType();

    	    switch (type) {
    	    
    	    
    	    case 0: // numeric value in Excel
                result = cell.getNumericCellValue();
                break;
            case 1: // String Value in Excel 
                result = cell.getStringCellValue();
                break;
            default:  
                throw new RuntimeException("There is no support for this type of cell");                        
        }

        return result.toString();
    }
		// TODO Auto-generated method stub
	
	
	
	
     public static void saveToDatabase(Vector dataHolder) {
	 		String username="";
         String password="";
         int custId=0;
         String custName="",custDob="",custEmail="",custAddress="",custphotoProof="",custphotoProofId="",custaddrProof="",custaddrProofId="",custRegDate="";
         long custContactNum=0;
         
         System.out.println("SIZZEEEEEEEEEEE"+dataHolder.size());
         for (int i=1;i<dataHolder.size(); i++){
         	
         		Vector cellStoreVector=(Vector)dataHolder.elementAt(i);
                 for (int j=0; j < cellStoreVector.size();j++)
                 {
   		
                         HSSFCell myCell = (HSSFCell)cellStoreVector.elementAt(j);
                         String st = cellToString( myCell);
                 	    
                         switch (j) {
                 	    
                 	    
                 	    case 0: 
                 	    	custId=(int)Float.parseFloat(st);
                             System.out.println("custId"+custId);
                             
                 	    	break;
                         case 1:  
                         	custName = st;
                             break;
                         case 2:  
                         	custDob = st;
                             break;
                         case 3:  
                         	custEmail = st;
                             break;
                             
                         case 4:  
                         	custAddress = st;
                             break;
                         case 5:  
                         	custContactNum = (long)Double.parseDouble(st);
                         	System.out.println(custContactNum);
                             break;
                         case 6:  
                         	custphotoProof = st;
                             break;
                         case 7:  
                         	custphotoProofId = st;
                             break;
                         case 8:  
                         	custaddrProof = st;
                             break;
                         case 9:  
                         	custaddrProofId = st;
                             break;
                         case 10:  
                         	custRegDate = st;
                             break;
                         default:  
                             throw new RuntimeException("Default case of switch"); 
                         }
                         
                 }        
                         
                      
                 try{
                 	Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
                 	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@172.26.132.40:1521:orclilp","ja41e", "ja41e");
                 	
 
                 	
                     
 String sql="INSERT INTO GROUPE_CUSTOMER  VALUES (?, ?, ?,?,?,?,?,?,?,?,?)";
 
 PreparedStatement pst = con.prepareStatement(sql);
 
 pst.setInt(1, custId);
 pst.setString(2, custName);
 pst.setString(3, custDob);
 pst.setString(4, custEmail);
 pst.setString(5, custAddress);
 pst.setLong(6, custContactNum);
 pst.setString(7, custphotoProof);
 pst.setString(8, custphotoProofId);
 pst.setString(9, custaddrProof);
 pst.setString(10, custaddrProofId);
 pst.setString(11, custRegDate);
 

 int k=pst.executeUpdate();
 con.commit();
 
 
 System.out.println("Data is inserted");
pst.close();

 con.close();
 }
 catch(Exception e){
 	e.printStackTrace();}
                 }
 
 }

	
	
	
	
	
	
	
	
}
