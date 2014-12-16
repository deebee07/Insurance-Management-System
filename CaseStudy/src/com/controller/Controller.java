package com.controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.model.Customer;
import com.util.CreateExcelFile;
import com.util.Service;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		
		String action=request.getParameter("action");
		System.out.println(action);
		
		if(action.equals("downloadXLS"))
		{
			String filename = "D:\\data_customer.xls";
	        ServletOutputStream out = response.getOutputStream();
	        FileInputStream in = new FileInputStream(filename);

	        response.setContentType("application/vnd.ms-excel");
	        response.addHeader("content-disposition","attachment; filename=" + filename);

	        int octet;
	        while((octet = in.read()) != -1)
	            out.write(octet);

	        in.close();
	        out.close();
		}
		else if (action.equals("Submit File"))
		{	
			String filePath = getServletContext().getInitParameter("file-upload");
			System.out.println(filePath);
			Service service = new Service();
			File file;
			// Check that we have a file upload request
		      boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		      
		      response.setContentType("text/html");
		      java.io.PrintWriter out = response.getWriter( );
		      if( !isMultipart ){
		         out.println("<html>");
		         out.println("<head>");
		         out.println("<title>Servlet upload</title>");  
		         out.println("</head>");
		         out.println("<body>");
		         out.println("<p>No file uploaded</p>"); 
		         out.println("</body>");
		         out.println("</html>");
		         return;
		      }
		      
		      DiskFileItemFactory factory = new DiskFileItemFactory();
		      // maximum size that will be stored in memory
		      int maxMemSize=4 * 1024;
		      factory.setSizeThreshold(maxMemSize);
		      
		      // Location to save data that is larger than maxMemSize.
		      factory.setRepository(new File("c:\\temp"));

		      // Create a new file upload handler
		      ServletFileUpload upload = new ServletFileUpload(factory);
		      // maximum file size to be uploaded.
		      int maxFileSize = 50 * 1024;
		      upload.setSizeMax( maxFileSize );

		      try{ 
		      // Parse the request to get file items.
		      List fileItems = upload.parseRequest(request);
			
		      // Process the uploaded file items
		      Iterator i = fileItems.iterator();
		      out.println("<html>");
		      out.println("<head>");
		      out.println("<title>Servlet upload</title>");  
		      out.println("</head>");
		      out.println("<body>");
		      while ( i.hasNext () ) 
		      {
		         FileItem fi = (FileItem)i.next();
		         if ( !fi.isFormField () )	
		         {
		            // Get the uploaded file parameters
		            String fieldName = fi.getFieldName();
		            String fileName = fi.getName();
		            String contentType = fi.getContentType();
		            boolean isInMemory = fi.isInMemory();
		            long sizeInBytes = fi.getSize();
		            // Write the file
		            if( fileName.lastIndexOf("\\") >= 0 ){
		               file = new File( filePath + 
		               fileName.substring( fileName.lastIndexOf("\\"))) ;
		            }else{
		               file = new File( filePath + 
		               fileName.substring(fileName.lastIndexOf("\\")+1)) ;
		            }
		            fi.write( file ) ;
		            out.println("Uploaded Filename: " + fileName + "<br>");
		         }
		      }
		      out.println("</body>");
		      out.println("</html>");
		   }catch(Exception ex) {
		       System.out.println(ex);
		   }
		   }
		      	
//		      service.importXLS("C:\\data_customer.xls");
			
			
			
		}
		
        
        
    
		
		

	
	
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		System.out.println("UPLOAD ACTION   "+request.getParameter("action1"));

      
		Service service = new Service();
		System.out.println("CUSTOMER CONTROLLER::doPost invoked");

		HttpSession session = request.getSession(true);
		String action = (String) session.getAttribute("custAction");

		System.out.println("User action received by controller " + action);
		
		if ("addCustomer".equals(action)) {
			System.out.println("In add customer");
			String x=(String)	session.getAttribute("action1");
			 
			
			if (x.equals("SubmitFile"))
				{	
					String filePath = getServletContext().getInitParameter("file-upload");
					System.out.println(filePath);
					Service service1 = new Service();
					File file;
					// Check that we have a file upload request
				      boolean isMultipart = ServletFileUpload.isMultipartContent(request);
				      
				      response.setContentType("text/html");
				      java.io.PrintWriter out = response.getWriter( );
				      if( !isMultipart ){
				         out.println("<html>");
				         out.println("<head>");
				         out.println("<title>Servlet upload</title>");  
				         out.println("</head>");
				         out.println("<body>");
				         out.println("<p>No file uploaded</p>"); 
				         out.println("</body>");
				         out.println("</html>");
				         return;
				      }
				      
				      DiskFileItemFactory factory = new DiskFileItemFactory();
				      // maximum size that will be stored in memory
				      int maxMemSize=4 * 1024;
				      factory.setSizeThreshold(maxMemSize);
				      
				      // Location to save data that is larger than maxMemSize.
				      factory.setRepository(new File("D:\\xlsFilesUploaded"));

				      // Create a new file upload handler
				      ServletFileUpload upload = new ServletFileUpload(factory);
				      // maximum file size to be uploaded.
				      int maxFileSize = 50 * 1024;
				      upload.setSizeMax( maxFileSize );
				      
				      try{ 
				    	  
				    	  System.out.println("EXECUTION TILL THIS");
				    // Parse the request to get file items.
				     List<FileItem> fileItems = upload.parseRequest(request);
				     System.out.println("A TILL THIS");
				      // Process the uploaded file items
				      Iterator i = fileItems.iterator();
				      out.println("<html>");
				      out.println("<head>");
				      out.println("<title>Servlet upload</title>");  
				      out.println("</head>");
				      out.println("<body>");
				      while ( i.hasNext () ) 
				      {
				         FileItem fi = (FileItem)i.next();
				         if ( !fi.isFormField () )	
				         {
				            // Get the uploaded file parameters
				            String fieldName = fi.getFieldName();
				            String fileName = fi.getName();
				            String contentType = fi.getContentType();
				            boolean isInMemory = fi.isInMemory();
				            long sizeInBytes = fi.getSize();
				            // Write the file
				            if( fileName.lastIndexOf("\\") >= 0 ){
				               file = new File( filePath + 
				               fileName.substring( fileName.lastIndexOf("\\"))) ;
				            }else{
				               file = new File( filePath + 
				               fileName.substring(fileName.lastIndexOf("\\")+1)) ;
				            }
				            fi.write( file ) ;
				            out.println("Uploaded Filename: " + fileName + "<br>");
				         }
				      }
				      out.println("</body>");
				      out.println("</html>");
				   }catch(Exception ex) {
				       System.out.println(ex);
				   }
				   }
			
			
			
			
			
			
			
//			boolean emailCheck = false;
//			ArrayList<String> emails = service.allEmail();
//			
//			String errorMsg = null;
//
//			if(request.getParameter("addrproof") == null || request.getParameter("addrproof").equals("")){
//				errorMsg = "Address proof can't be null or empty.";
//			}
//			if(request.getParameter("addressid")== null || request.getParameter("addressid").equals("")){
//				errorMsg = "Address id can't be null or empty.";
//			}
//			if(request.getParameter("address") == null || request.getParameter("address").equals("")){
//				errorMsg = "Address can't be null or empty.";
//			}
//			if(request.getParameter("number") == null || request.getParameter("number").equals("")){
//				errorMsg = "Contact number can't be null or empty.";
//			}
//			if(request.getParameter("dob") == null || request.getParameter("dob").equals("")){
//				errorMsg = "Date of birth can't be null or empty.";
//			}
//			if(request.getParameter("email") == null || request.getParameter("email").equals("")){
//				errorMsg = "Email can't be null or empty.";
//			}
//			if(request.getParameter("name") == null || request.getParameter("name").equals("")){
//				errorMsg = "Name can't be null or empty.";
//			}
//			if(errorMsg != null){
//				RequestDispatcher rd = getServletContext().getRequestDispatcher("/Customer Management/CustomerRegistration.jsp");
//				request.setAttribute("invalid", "Server says Fields cant be null");
//				
//				rd.forward(request, response);
//			}
//			else
//			{
//			
//			for (String email : emails) {
//				System.out.println(email);
//				if (request.getParameter("email").equals(email)) {
//					emailCheck = true;
//					break;
//				}
//			}

//			System.out.println(emailCheck);
//			if (!emailCheck) {
//				Customer customer = new Customer();
//
//				customer.setAddress_Proof(request.getParameter("addrproof"));
//				customer.setAddress_Proof_Id(request.getParameter("addressid"));
//				customer.setCustomerAddress(request.getParameter("address"));
//				customer.setCustomerContactNumber(Long.parseLong(request.getParameter("number")));
//				customer.setCustomerDob(request.getParameter("dob"));
//				customer.setCustomerEmail(request.getParameter("email"));
//				customer.setCustomerName(request.getParameter("name"));
//
//				customer.setPhoto_Proof(request.getParameter("photoproof"));
//				customer.setPhoto_Proof_Id(request.getParameter("photoid"));
//
//				
//
//					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//					Date current = new Date();
//					String currentDate = sdf.format(current);
//
//					customer.setCustomerRegisterationDate(currentDate);
//					int customerId = service.addCustomer(customer);
//
//					request.setAttribute("customerId", customerId);
//					System.out.println("hello" + customerId);
//					RequestDispatcher reqDispatcher = request
//							.getRequestDispatcher("/Customer Management/RegistrationSuccessful.jsp");
//					reqDispatcher.forward(request, response);
//				}
//			
//					else {
//
//						RequestDispatcher reqDispatcher = request
//								.getRequestDispatcher("Customer Management/CustomerRegistration.jsp");
//						request.setAttribute("invalid", "Email-id already exists");
//						reqDispatcher.include(request, response);
//
//					     }
//				}
		}
		 else if ("viewCustomerDate".equals(action)) {

			System.out.println("in viewCustomerDate");
			String date1 = request.getParameter("date1");
			String date2 = request.getParameter("date2");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date Date1, Date2, regiDate;

			try {
				Date1 = sdf.parse(date1);
				Date2 = sdf.parse(date2);

				ArrayList<Customer> customers = service.allCustomer();
				ArrayList<Customer> datecustomers = new ArrayList<Customer>();

				for (Customer customer : customers) {
					String regDate = customer.getCustomerRegisterationDate();
					regiDate = sdf.parse(regDate);

					if (Date1.compareTo(regiDate) * regiDate.compareTo(Date2) > 0) {
						datecustomers.add(customer);
					}
				}
				CreateExcelFile create= new CreateExcelFile();
				create.createXML(datecustomers);
				request.setAttribute("customerList", datecustomers);
				request.setAttribute("date1", date1);
				request.setAttribute("date2", date2);
				RequestDispatcher reqDispatcher = request
						.getRequestDispatcher("Customer Management/View Customers.jsp");
				reqDispatcher.forward(request, response);
			} 
			catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else if ("searchCustomer".equals(action)) {

			System.out.println("in updateCustomer");

			int custId = Integer.parseInt(request.getParameter("customerId"));

			boolean checkcustId = false;

			ArrayList<Customer> customers = service.allCustomer();

			for (Customer customer : customers) {

				if (customer.getCustomerId() == custId) {
					checkcustId = true;
				}
			}

			if (checkcustId) {
				RequestDispatcher reqDispatcher = request
						.getRequestDispatcher("Customer Management/UpdateForm.jsp");
				request.setAttribute("custId", custId);
				reqDispatcher.forward(request, response);
			} else {
				RequestDispatcher reqDispatcher = request
						.getRequestDispatcher("Customer Management/UpdateCustomer.jsp");
				request.setAttribute("invalid",
						"NO SUCH CUSTOMER ID IN DATABASE");
				reqDispatcher.forward(request, response);
			}

		} else if ("updateCustomer".equals(action)) {

			Customer upCustomer = new Customer();
			upCustomer.setCustomerName(request.getParameter("name"));
			upCustomer.setCustomerDob(request.getParameter("dob"));
			upCustomer.setCustomerEmail(request.getParameter("email"));
			upCustomer.setCustomerAddress(request.getParameter("address"));
			upCustomer.setCustomerContactNumber(Long.parseLong(request.getParameter("number")));
			
			
			
			int custId = (Integer) session.getAttribute("custID");
			System.out.println(custId);
			
			
			String strEmail=request.getParameter("email");
			ArrayList<Customer>customers=service.allCustomer();
			
			
			boolean checkEnteredEmail=false;
			for(Customer c:customers)
			{
				if(c.getCustomerId()==custId)
				{
				if(c.getCustomerEmail().equals(strEmail))
				{
					checkEnteredEmail=true;
					break;
				}
				else
				{
					checkEnteredEmail=false;
					break;
				}
					
				}
			}
			
			
			ArrayList<String> emails=service.allEmail();
			boolean emailCheck=false;
			
			for(String email:emails)
			{
			if(upCustomer.getCustomerEmail().equals(email))
			{
				emailCheck=true;
				break;
			}
			}
			
			
			
			if(emailCheck&&!checkEnteredEmail)
			{
				RequestDispatcher reqDispatcher = request.getRequestDispatcher("Customer Management/UpdateForm.jsp");
				request.setAttribute("invalid","EMAIL ID ALREADY EXIST IN THE DATABASE");
				request.setAttribute("custId",custId);
				reqDispatcher.forward(request, response);
			}
			else
			{
				boolean check = service.updateCustomer(upCustomer, custId);

				if (check) {
				RequestDispatcher reqDispatcher = request
						.getRequestDispatcher("Customer Management/UpdateSuccessful.jsp");
				request.setAttribute("custId", custId);
				reqDispatcher.forward(request, response);
				} else {
				RequestDispatcher reqDispatcher = request
						.getRequestDispatcher("Customer Management/UpdateForm.jsp");
				request.setAttribute("invalid",
						"NO SUCH CUSTOMER ID IN DATABASE");
				reqDispatcher.forward(request, response);
						}
			
			}

		} else  {

			System.out.println("in removeCustomer");

			int custId = Integer.parseInt(request.getParameter("customerId"));

			ArrayList<Customer> customers = service.allCustomer();
			
			boolean check =false;
			boolean check2=false;

			for (Customer customer : customers) 
			{
				
				if (customer.getCustomerId() == custId)
				{	
					customer.setHealthPolicyStatus(service.setHealthStatus(customer.getCustomerId()));
					customer.setVehiclePolicyStatus(service.setVehicleStatus(customer.getCustomerId()));
					check=true;
					if (!customer.isHealthPolicyStatus()&& !customer.isVehiclePolicyStatus())
					{ 
						request.setAttribute("custId", customer.getCustomerId());
						check2=service.deleteCustomer(customer.getCustomerId());
						System.out.println(check2); 
						if(check2)
						{
						RequestDispatcher reqDispatcher = request.getRequestDispatcher("Customer Management/RemoveSuccessful.jsp");
						reqDispatcher.forward(request, response);
						return;
						}
						else
						{
						RequestDispatcher reqDispatcher = request.getRequestDispatcher("Customer Management/RemoveCustomer.jsp");
						request.setAttribute("invalid","CUSTOMER IS IN DATABASE BUT IS NOT DELETED \"CHILD RECORD FOUND\"");
						reqDispatcher.forward(request, response);
						
						
						}
						
					}
					break;
				}
			}
				
			if(check)
			{
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("Customer Management/RemoveCustomer.jsp");
			request.setAttribute("invalid","CUSTOMER WAS NOT DELETED AS HE HAS ACTIVE POLICIES ");
			reqDispatcher.include(request, response);
			
			}
			
			else
			{
			RequestDispatcher reqDispatcher = request.getRequestDispatcher("Customer Management/RemoveCustomer.jsp");
			request.setAttribute("invalid","NO SUCH CUSTOMER ID IN DATABASE");
			reqDispatcher.include(request, response);
			return;
			}
			
			
			
			
			
			
			

		}
		
		
		
		

	}

}