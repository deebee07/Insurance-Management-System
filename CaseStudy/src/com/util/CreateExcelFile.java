package com.util;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;

import com.model.Customer;

public class CreateExcelFile {

	public static void createXML(ArrayList<Customer> customers) {
		try {

			String filename = "D:/data_customer.xls";
			HSSFWorkbook hwb = new HSSFWorkbook();
			HSSFSheet sheet = hwb.createSheet("new sheet");

			HSSFRow rowhead = sheet.createRow((short) 0);

			rowhead.createCell((short) 0).setCellValue("CUST_ID");

			rowhead.createCell((short) 1).setCellValue("CUST_NAME");

			rowhead.createCell((short) 2).setCellValue("CUST_DOB");

			rowhead.createCell((short) 3).setCellValue("CUST_EMAIL");

			rowhead.createCell((short) 4).setCellValue("CUST_ADDRESS");

			rowhead.createCell((short) 5).setCellValue("CUST_CONTACTNUM");
			rowhead.createCell((short) 6).setCellValue("PHOTOPROOF");
			rowhead.createCell((short) 7).setCellValue("PHOTOPROOF_ID");

			rowhead.createCell((short) 8).setCellValue("ADDRESSPROOF");
			rowhead.createCell((short) 9).setCellValue("ADDRESSPROOF_ID");

			rowhead.createCell((short) 10).setCellValue("CUST_REGDATE");
			Class.forName("oracle.jdbc.driver.OracleDriver");
//
//			Connection con = DriverManager.getConnection(
//					"jdbc:oracle:thin:@172.26.132.40:1521:orclilp", "ja41e",
//					"ja41e");
//
//			Statement st = con.createStatement();
//
//			ResultSet rs = st.executeQuery("SELECT * FROM GROUPE_CUSTOMER");
//
			int i = 1;

			
			for(Customer cust:customers){
			

				HSSFRow row = sheet.createRow((short) i);

				row.createCell((short) 0).setCellValue(
						Integer.toString(cust.getCustomerId()));
				row.createCell((short) 1).setCellValue(
						cust.getCustomerName());
				row.createCell((short) 2)
						.setCellValue(cust.getCustomerDob());
				row.createCell((short) 3).setCellValue(
						cust.getCustomerEmail());
				row.createCell((short) 4).setCellValue(
						cust.getCustomerAddress());
				row.createCell((short) 5).setCellValue(
						Long.toString(cust.getCustomerContactNumber()));
				row.createCell((short) 6).setCellValue(
						cust.getPhoto_Proof());
				row.createCell((short) 7).setCellValue(
						cust.getPhoto_Proof_Id());
				row.createCell((short) 8).setCellValue(
						cust.getAddress_Proof());
				row.createCell((short) 9).setCellValue(
						cust.getAddress_Proof_Id());
				row.createCell((short) 10).setCellValue(
						cust.getCustomerRegisterationDate());
				i++;
				
			}
			FileOutputStream fileOut = new FileOutputStream(filename);
			hwb.write(fileOut);
			fileOut.close();
			System.out.println("Your excel file has been generated!");

		}

		catch (Exception ex) {
			System.out.println(ex);

		}
	}
}
