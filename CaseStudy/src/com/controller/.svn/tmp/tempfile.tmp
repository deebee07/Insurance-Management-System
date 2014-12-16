package com.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

import com.model.Customer;
import com.model.HealthPolicy;
import com.model.VehiclePolicy;
import com.util.Service;

public class PolicyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PolicyController() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action1=request.getParameter("registerAction");
		System.out.println("ACTION    BY IMAGE "+action1);
		if("pieChart".equals(action1))
		{
			
			System.out.println("makePiechart");
			
			
			OutputStream out = response.getOutputStream(); /* Get the output stream from the response object */
	        response.setContentType("image/png"); /* Set the HTTP Response Type */
	        
	        
	        com.util.PieChart_AWT piechart=new com.util.PieChart_AWT("YoYo");
	        
	        
	        JFreeChart chart =piechart.getPolicyChart();
	       // Create chart
	         
	        ChartUtilities.writeChartAsPNG(out,chart , 500, 600);/* Write the data to the output stream */
			
		}
	

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PolicyController:: doPost invoked");

		if (request.getSession(false).getAttribute("userid") == null) {

			response.sendRedirect(request.getContextPath() + "/LoginPage.jsp");

		}

		Service s = new Service();

		// String action = request.getParameter("action");
		// System.out.println("User action received by controller: " + action);

		// /////////////////////// Health Policy Registration ///////////////

		HttpSession session = request.getSession(true);
		String action = (String) session.getAttribute("healthAction");

		if ("registerHealthPolicy".equals(action)) {

			String errorMsg = null;
			if (request.getParameter("id").equals(null)
					|| request.getParameter("id").equals("")) {
				errorMsg = "CustomerId cannot be null or empty";
			}
			if (request.getParameter("pid").equals(null)
					|| request.getParameter("pid").equals("")) {
				errorMsg = "PolicyId cannot be null or empty";
			}
			if (request.getParameter("tenure").equals(null)
					|| request.getParameter("tenure").equals("")) {
				errorMsg = "Tenure cannot be null or empty";
			}
			if (request.getParameter("cDate").equals(null)
					|| request.getParameter("cDate").equals("")) {
				errorMsg = "Commencement Date cannot be null or empty";
			}
			if (request.getParameter("eDate").equals(null)
					|| request.getParameter("eDate").equals("")) {
				errorMsg = "End Date cannot be null or empty";
			}
			if (request.getParameter("pMode").equals(null)
					|| request.getParameter("pMode").equals("")) {
				errorMsg = "Payment Mode cannot be null or empty";
			}
			if (request.getParameter("pFrequency").equals(null)
					|| request.getParameter("pFrequency").equals("")) {
				errorMsg = "Payment Frequency cannot be null or empty";
			}
			if (request.getParameter("pAmount").equals(null)
					|| request.getParameter("pAmount").equals("")) {
				errorMsg = "Payment Amount cannot be null or empty";
			}
			if (errorMsg != null) {
				RequestDispatcher rd = request
						.getRequestDispatcher("/Insurance Policy Registration/HealthInsuranceScheme/HealthInsuranceRegistration.jsp");
				request.setAttribute("msg",
						"This field cannot be null or empty");
				rd.forward(request, response);

			} else {

				HttpSession officerSession = request.getSession(true);
				String officer = (String) officerSession.getAttribute("userid");
				System.out.println("officer:" + officer);
				if (officer.substring(0, 2).equals("IO")) {

					int custId = Integer.parseInt(request.getParameter("id"));
					boolean checkCustId = false;
					boolean checkPolicyID = false;

					ArrayList<Customer> customers = s.allCustomer();

					for (Customer customer : customers) {

						if (customer.getCustomerId() == custId) {
							checkCustId = true;
							System.out.println("Show" + custId);
						}
					}
					if (checkCustId) {
						String policyID = request.getParameter("pid");

						ArrayList<HealthPolicy> policies = s.viewPolicy();
						for (HealthPolicy hp : policies) {

							if (hp.getPolicyId().equals(policyID)) {

								checkPolicyID = true;
								System.out.println("Show" + policyID);
							}
						}
						if (checkPolicyID) {
							String dateInString = request.getParameter("cDate");
							System.out.println(dateInString);

							SimpleDateFormat sdf = new SimpleDateFormat(
									"dd/mm/yyyy");

							HealthPolicy hp = new HealthPolicy();

							hp.setCustomerId(Integer.parseInt(request
									.getParameter("id")));
							hp.setPolicyId(request.getParameter("pid"));
							int tenure = Integer.parseInt(request
									.getParameter("tenure"));
							hp.setPolicytenure(tenure);
							hp.setPolicyCommDate(request.getParameter("cDate"));
							String date = request.getParameter("cDate");

							String[] parts = date.split("/");
							parts[2] = Integer.toString(tenure
									+ Integer.parseInt(parts[2]));

							date = parts[0] + "/" + parts[1] + "/" + parts[2];
							Date dateInDateFormat = null;

							try {
								dateInDateFormat = sdf.parse(date);
								System.out.println(dateInDateFormat);
							} catch (ParseException e) {
								e.printStackTrace();
							}
							hp.setPolicyEndDate(request.getParameter("eDate"));
							if (request.getParameter("eDate").equals(date)) {
								hp.setPaymentMode(request.getParameter("pMode"));

								hp.setPaymentFreq(request
										.getParameter("pFrequency"));
								hp.setPremiumAmount(Double.parseDouble(request
										.getParameter("pAmount")));

								String polRefNum = s.registerHealthPolicy(hp);

								request.setAttribute("polRefNum", polRefNum);
								System.out.println("hello" + polRefNum);
								if (polRefNum != null) {
									RequestDispatcher rd = request
											.getRequestDispatcher("/Insurance Policy Registration/HealthInsuranceScheme/createHealthResult.jsp");
									rd.forward(request, response);
								} else {
									RequestDispatcher rd = request
											.getRequestDispatcher("/Insurance Policy Registration/HealthInsuranceScheme/HealthInsuranceRegistration.jsp");
									request.setAttribute(
											"msg",
											"This policy already exists for this customer or this policy Id is invalid for health ");
									rd.forward(request, response);

								}

							} else {
								RequestDispatcher rd = request
										.getRequestDispatcher("/Insurance Policy Registration/HealthInsuranceScheme/HealthInsuranceRegistration.jsp");
								request.setAttribute("msg",
										"EndDate is not valid.Please enter a valid End Date");
								rd.forward(request, response);
							}
						} else {

							RequestDispatcher rd = request
									.getRequestDispatcher("/Insurance Policy Registration/HealthInsuranceScheme/HealthInsuranceRegistration.jsp");
							request.setAttribute("msg",
									"Policy Id does not exist.Please enter a valid Policy Id");
							rd.forward(request, response);
						}
					} else {
						RequestDispatcher rd = request
								.getRequestDispatcher("/Insurance Policy Registration/HealthInsuranceScheme/HealthInsuranceRegistration.jsp");
						request.setAttribute("msg",
								"Customer Id does not exist");
						rd.forward(request, response);

					}
				} else {
					RequestDispatcher rd = request
							.getRequestDispatcher("/Insurance Policy Registration/HealthInsuranceScheme/HealthInsuranceRegistration.jsp");
					request.setAttribute("msg", "No rights to register");
					rd.forward(request, response);
				}
			}
		}

		// ///////////////////////// Vehicle Policy Registration /////////////

		else if ("registerVehiclePolicy".equals(action)) {
			String errorMsg = null;
			if (request.getParameter("id").equals(null)
					|| request.getParameter("id").equals("")) {
				errorMsg = "CustomerId cannot be null or empty";
			}
			if (request.getParameter("pid").equals(null)
					|| request.getParameter("pid").equals("")) {
				errorMsg = "PolicyId cannot be null or empty";
			}

			if (request.getParameter("cDate").equals(null)
					|| request.getParameter("cDate").equals("")) {
				errorMsg = "Commencement Date cannot be null or empty";
			}
			if (request.getParameter("vNum").equals(null)
					|| request.getParameter("vNum").equals("")) {
				errorMsg = "Vehicle Number cannot be null or empty";
			}
			if (request.getParameter("lNum").equals(null)
					|| request.getParameter("lNum").equals("")) {
				errorMsg = "license Number cannot be null or empty";
			}

			if (request.getParameter("vType").equals(null)
					|| request.getParameter("vType").equals("")) {
				errorMsg = "Vehicle type cannot be null or empty";
			}

			if (request.getParameter("pMode").equals(null)
					|| request.getParameter("pMode").equals("")) {
				errorMsg = "Payment Mode cannot be null or empty";
			}
			if (request.getParameter("pFrequency").equals(null)
					|| request.getParameter("pFrequency").equals("")) {
				errorMsg = "Payment Frequency cannot be null or empty";
			}
			if (request.getParameter("pAmount").equals(null)
					|| request.getParameter("pAmount").equals("")) {
				errorMsg = "Payment Amount cannot be null or empty";
			}
			if (errorMsg != null) {
				RequestDispatcher rd = request
						.getRequestDispatcher("/Insurance Policy Registration/VehicleInsuranceScheme/VehicleInsuranceRegistration.jsp");
				request.setAttribute("msg",
						"This field cannot be null or empty");
				rd.forward(request, response);

			} else {
				HttpSession officerSession = request.getSession(true);
				String officer = (String) officerSession.getAttribute("userid");
				System.out.println("officer:" + officer);
				if (officer.substring(0, 2).equals("FO")) {

					int custId = Integer.parseInt(request.getParameter("id"));
					boolean checkCustId = false;
					boolean checkPolicyID = false;

					ArrayList<Customer> customers = s.allCustomer();

					for (Customer customer : customers) {

						if (customer.getCustomerId() == custId) {
							checkCustId = true;
							System.out.println("Show" + custId);
						}
					}
					if (checkCustId) {
						String policyID = request.getParameter("pid");

						ArrayList<HealthPolicy> policies = s.viewPolicy();
						for (HealthPolicy hp : policies) {

							if (hp.getPolicyId().equals(policyID)) {

								checkPolicyID = true;
								System.out.println("Show" + policyID);
							}
						}
						if (checkPolicyID) {

							String dateInString = request.getParameter("cDate");
							System.out.println(dateInString);

							SimpleDateFormat sdf = new SimpleDateFormat(
									"dd/mm/yyyy");

							VehiclePolicy vp = new VehiclePolicy();

							vp.setCustomerId(Integer.parseInt(request
									.getParameter("id")));
							vp.setPolicyId(request.getParameter("pid"));
							vp.setPolicyCommDate(request.getParameter("cDate"));

							String date = request.getParameter("cDate");

							String[] parts = date.split("/");
							parts[2] = Integer.toString(1 + Integer
									.parseInt(parts[2]));

							date = parts[0] + "/" + parts[1] + "/" + parts[2];
							Date dateInDateFormat = null;
							vp.setPolicyEndDate(date);
							try {
								dateInDateFormat = sdf.parse(date);
								System.out.println(dateInDateFormat);
							} catch (ParseException e) {
								e.printStackTrace();
							}
							vp.setVehicleNum(request.getParameter("vNum"));
							System.out.println(request.getParameter("lNum"));
							vp.setLicenseNum(request.getParameter("lNum"));
							vp.setVehicleType(request.getParameter("vType"));

							vp.setPaymentMode(request.getParameter("pMode"));
							vp.setPaymentFreq(request
									.getParameter("pFrequency"));
							vp.setPremiumAmount(Double.parseDouble(request
									.getParameter("pAmount")));

							String polRefNum = s.registerVehiclePolicy(vp);

							request.setAttribute("polRefNum", polRefNum);
							request.setAttribute("endDate", date);

							System.out.println("hello" + polRefNum);

							if (polRefNum != null) {
								RequestDispatcher rd = request
										.getRequestDispatcher("/Insurance Policy Registration/VehicleInsuranceScheme/createVehicleResult.jsp");
								rd.forward(request, response);
							} else {
								RequestDispatcher rd = request
										.getRequestDispatcher("/Insurance Policy Registration/VehicleInsuranceScheme/VehicleInsuranceRegistration.jsp");
								request.setAttribute(
										"msg",
										"This policy already exists for this customer or this policy Id is invalid for vehicle ");
								rd.forward(request, response);

							}
						} else {
							RequestDispatcher rd = request
									.getRequestDispatcher("/Insurance Policy Registration/VehicleInsuranceScheme/VehicleInsuranceRegistration.jsp");
							request.setAttribute("msg",
									"Policy Id does not exist.Please enter a valid Policy Id");
							rd.forward(request, response);
						}
					}     else {
						RequestDispatcher rd = request
								.getRequestDispatcher("/Insurance Policy Registration/VehicleInsuranceScheme/VehicleInsuranceRegistration.jsp");
						request.setAttribute("msg",
								"Customer Id does not exist");
						rd.forward(request, response);

					}
				} else {
					RequestDispatcher rd = request
							.getRequestDispatcher("/Insurance Policy Registration/VehicleInsuranceScheme/VehicleInsuranceRegistration.jsp");
					request.setAttribute("msg", "No rights to register");
					rd.forward(request, response);
				}
			}
		}

		// ///////////////////////// Modify Health Policy /////////////

		else if ("modifyHealthPolicy".equals(action)) {
			String errorMsg = null;
			if (request.getParameter("ID").equals(null)
					|| request.getParameter("ID").equals("")) {
				errorMsg = "Policy Reference number cannot be null or empty";
			}

			if (request.getParameter("pMode").equals(null)
					|| request.getParameter("pMode").equals("")) {
				errorMsg = "Payment Mode cannot be null or empty";
			}
			if (request.getParameter("pFrequency").equals(null)
					|| request.getParameter("pFrequency").equals("")) {
				errorMsg = "Payment Frequency cannot be null or empty";
			}

			if (errorMsg != null) {
				RequestDispatcher rd = request
						.getRequestDispatcher("/Insurance Policy Registration/HealthInsuranceScheme/HealthModifyPayment.jsp");
				request.setAttribute("msg",
						"This field cannot be null or empty");
				rd.forward(request, response);

			} else {
				boolean checkPolicyNum = false;

				HttpSession officerSession = request.getSession(true);
				String officer = (String) officerSession.getAttribute("userid");
				System.out.println(" The officer:" + officer);
				if (officer.substring(0, 2).equals("IO")) {
					String policyRefNum = request.getParameter("ID");

					System.out.println("In Modify Controller" + policyRefNum);
					ArrayList<HealthPolicy> policies = s.viewCustomerPolicy();
					for (HealthPolicy hp : policies) {

						if (hp.getPolicyRefNum().equals(policyRefNum)) {

							checkPolicyNum = true;
							System.out.println("Show" + policyRefNum);
						}
					}
					if (checkPolicyNum) {

						HealthPolicy hp = new HealthPolicy();

						hp.setPolicyRefNum(request.getParameter("ID"));

						hp.setPaymentMode(request.getParameter("pMode"));
						hp.setPaymentFreq(request.getParameter("pFrequency"));

						boolean b = s.modifyHealthPolicy(hp);
						System.out.println("show" + b);
						if (b == true) {
							RequestDispatcher rd = request
									.getRequestDispatcher("/Insurance Policy Registration/HealthInsuranceScheme/ModifyHealthResult.jsp");
							rd.forward(request, response);
						} else {
							RequestDispatcher rd = request
									.getRequestDispatcher("/Insurance Policy Registration/HealthInsuranceScheme/HealthModifyPayment.jsp");
							request.setAttribute("msg",
									"No Authority!!! You cannot modify this policy ");
							rd.forward(request, response);
						}

					} else {
						RequestDispatcher rd = request
								.getRequestDispatcher("/Insurance Policy Registration/HealthInsuranceScheme/HealthModifyPayment.jsp");
						request.setAttribute("msg",
								"Policy Reference Number does not exist");
						rd.forward(request, response);

					}
				} else {
					RequestDispatcher rd = request
							.getRequestDispatcher("/Insurance Policy Registration/HealthInsuranceScheme/HealthModifyPayment.jsp");
					request.setAttribute("msg", "No rights to register");
					rd.forward(request, response);
				}
			}
		}

		// ///////////////////////// Modify Vehicle Policy /////////////

		else if ("modifyVehiclePolicy".equals(action)) {
			String errorMsg = null;
			if (request.getParameter("ID").equals(null)
					|| request.getParameter("ID").equals("")) {
				errorMsg = "Policy Reference Number cannot be null or empty";
			}

			if (request.getParameter("pMode").equals(null)
					|| request.getParameter("pMode").equals("")) {
				errorMsg = "Payment Mode cannot be null or empty";
			}
			if (request.getParameter("pFrequency").equals(null)
					|| request.getParameter("pFrequency").equals("")) {
				errorMsg = "Payment Frequency cannot be null or empty";
			}

			if (errorMsg != null) {
				RequestDispatcher rd = request
						.getRequestDispatcher("/Insurance Policy Registration/VehicleInsuranceScheme/VehicleInsuranceRegistration.jsp");
				request.setAttribute("msg",
						"This field cannot be null or empty");
				rd.forward(request, response);

			} else {
				boolean checkPolicyNum = false;

				HttpSession officerSession = request.getSession(true);
				String officer = (String) officerSession.getAttribute("userid");
				System.out.println(" The officer:" + officer);
				if (officer.substring(0, 2).equals("FO")) {
					String policyRefNum = request.getParameter("ID");

					System.out.println("In Modify Controller" + policyRefNum);
					ArrayList<HealthPolicy> policies = s.viewCustomerPolicy();
					for (HealthPolicy hp : policies) {

						if (hp.getPolicyRefNum().equals(policyRefNum)) {

							checkPolicyNum = true;
							System.out.println("Show" + policyRefNum);
						}
					}
					if (checkPolicyNum) {

						VehiclePolicy vp = new VehiclePolicy();

						vp.setPolicyRefNum(request.getParameter("ID"));

						vp.setPaymentMode(request.getParameter("pMode"));
						vp.setPaymentFreq(request.getParameter("pFrequency"));

						boolean b = s.modifyVehiclePolicy(vp);
						System.out.println("show" + b);
						if (b == true) {

							RequestDispatcher rd = request
									.getRequestDispatcher("/Insurance Policy Registration/VehicleInsuranceScheme/ModifyVehicleResult.jsp");
							rd.forward(request, response);
						} else {
							RequestDispatcher rd = request
									.getRequestDispatcher("/Insurance Policy Registration/VehicleInsuranceScheme/VehicleModifyPayment.jsp");
							request.setAttribute("msg",
									"No Authority!!! You cannot modify this policy");
							rd.forward(request, response);
						}

					} else {
						RequestDispatcher rd = request
								.getRequestDispatcher("/Insurance Policy Registration/VehicleInsuranceScheme/VehicleModifyPayment.jsp");
						request.setAttribute("msg",
								"Policy Reference Number does not exist");
						rd.forward(request, response);

					}
				} else {
					RequestDispatcher rd = request
							.getRequestDispatcher("/Insurance Policy Registration/VehicleInsuranceScheme/VehicleInsuranceRegistration.jsp");
					request.setAttribute("msg", "No rights to register");
					rd.forward(request, response);
				}
			}

		}
		// ///////////////////////// View Health Policy /////////////

		else if ("viewHealthPolicy".equals(action)) {
			String errorMsg = null;
			if (request.getParameter("id").equals(null)
					|| request.getParameter("id").equals("")) {
				errorMsg = "CustomerId cannot be null or empty";
			}
			if (errorMsg != null) {
				RequestDispatcher rd = request
						.getRequestDispatcher("/Insurance Policy Registration/HealthInsuranceScheme/HealthInsuranceRegistration.jsp");
				request.setAttribute("msg",
						"This field cannot be null or empty");
				rd.forward(request, response);

			} else {
				HttpSession officerSession = request.getSession(true);
				String officer = (String) officerSession.getAttribute("userid");
				System.out.println("officer:" + officer);
				if (officer.substring(0, 2).equals("IO")) {

					int custId = Integer.parseInt(request.getParameter("id"));
					boolean checkCustId = false;

					ArrayList<Customer> customers = s.allCustomer();

					for (Customer customer : customers) {

						if (customer.getCustomerId() == custId) {
							checkCustId = true;
							System.out.println("Show" + custId + checkCustId);
						}
					}
					if (checkCustId) {

						int customerId = Integer.parseInt(request
								.getParameter("id"));
						// Call service layer to do customer search

						Service service = new Service();

						ArrayList<HealthPolicy> viewHealthPolicyList = service
								.viewHealthPolicy(customerId);

						// Share the matched customers details with view
						System.out.println(viewHealthPolicyList.size());
						request.setAttribute("viewHealthPolicyList",
								viewHealthPolicyList);
						if (viewHealthPolicyList.size() != 0) {
							RequestDispatcher rd = request
									.getRequestDispatcher("/Insurance Policy Registration/HealthInsuranceScheme/viewHealthPolicyResult.jsp");
							rd.forward(request, response);
						} else {
							RequestDispatcher rd = request
									.getRequestDispatcher("/Insurance Policy Registration/HealthInsuranceScheme/HealthViewDetails.jsp");
							request.setAttribute("msg",
									"No Policy in the Database");
							rd.forward(request, response);

						}

					} else {
						RequestDispatcher rd = request
								.getRequestDispatcher("/Insurance Policy Registration/HealthInsuranceScheme/HealthViewDetails.jsp");
						request.setAttribute("msg",
								"Customer Id does not exist");
						rd.forward(request, response);

					}
				} else {
					RequestDispatcher rd = request
							.getRequestDispatcher("/Insurance Policy Registration/HealthInsuranceScheme/HealthViewDetails.jsp");
					request.setAttribute("msg", "No rights to Field Officer");
					rd.forward(request, response);
				}
			}
		}
		// ///////////////////////// View Vehicle Policy /////////////
		else if ("viewVehiclePolicy".equals(action)) {
			String errorMsg = null;
			if (request.getParameter("ID").equals(null)
					|| request.getParameter("ID").equals("")) {
				errorMsg = "CustomerId cannot be null or empty";
			}
			if (errorMsg != null) {
				RequestDispatcher rd = request
						.getRequestDispatcher("/Insurance Policy Registration/VehicleInsuranceScheme/VehicleInsuranceRegistration.jsp");
				request.setAttribute("msg",
						"This field cannot be null or empty");
				rd.forward(request, response);

			} else {
				HttpSession officerSession = request.getSession(true);
				String officer = (String) officerSession.getAttribute("userid");
				System.out.println("officer:" + officer);
				if (officer.substring(0, 2).equals("FO")) {

					int custId = Integer.parseInt(request.getParameter("ID"));
					boolean checkCustId = false;

					ArrayList<Customer> customers = s.allCustomer();

					for (Customer customer : customers) {

						if (customer.getCustomerId() == custId) {
							checkCustId = true;
							System.out.println("Show" + custId + checkCustId);
						}
					}
					if (checkCustId) {

						int customerId = Integer.parseInt(request
								.getParameter("ID"));

						// Call service layer to do customer search

						Service service = new Service();

						ArrayList<VehiclePolicy> viewVehiclePolicyList = service
								.viewVehiclePolicy(customerId);

						// Share the matched customers details with view
						System.out.println(viewVehiclePolicyList.size());
						request.setAttribute("viewVehiclePolicyList",
								viewVehiclePolicyList);
						if (viewVehiclePolicyList.size() != 0) {
							RequestDispatcher rd = request
									.getRequestDispatcher("/Insurance Policy Registration/VehicleInsuranceScheme/viewVehiclePolicyResult.jsp");
							rd.forward(request, response);

						} else {
							RequestDispatcher rd = request
									.getRequestDispatcher("/Insurance Policy Registration/VehicleInsuranceScheme/VehicleViewDetails.jsp");
							request.setAttribute("msg",
									"Customer Id does not exist");
							rd.forward(request, response);

						}
					} else {
						RequestDispatcher rd = request
								.getRequestDispatcher("/Insurance Policy Registration/VehicleInsuranceScheme/VehicleViewDetails.jsp");
						request.setAttribute("msg",
								"No rights to Insurance Officer");
						rd.forward(request, response);
					}
				}
			}
		}
		// ///////////////////////// Delete Policy Registration /////////////

		else if ("deleteHealthPolicy".equals(action)) {
			String errorMsg = null;
			if (request.getParameter("PID").equals(null)
					|| request.getParameter("PID").equals("")) {
				errorMsg = "CustomerId cannot be null or empty";
			}
			if (errorMsg != null) {
				RequestDispatcher rd = request
						.getRequestDispatcher("/Insurance Policy Registration/HealthInsuranceScheme/HealthInsuranceRegistration.jsp");
				request.setAttribute("msg",
						"This field cannot be null or empty");
				rd.forward(request, response);

			} else {
				boolean checkPolicyNum = false;

				HttpSession officerSession = request.getSession(true);
				String officer = (String) officerSession.getAttribute("userid");
				System.out.println(" The officer:" + officer);
				if (officer.substring(0, 2).equals("IO")) {
					String policyRefNum = request.getParameter("PID");

					System.out.println("In DeleteController" + policyRefNum);
					ArrayList<HealthPolicy> policies = s.viewCustomerPolicy();
					for (HealthPolicy hp : policies) {

						if (hp.getPolicyRefNum().equals(policyRefNum)) {

							checkPolicyNum = true;
							System.out.println("Show" + policyRefNum);
						}
					}
					if (checkPolicyNum) {

						HealthPolicy hp = new HealthPolicy();

						String polNum = request.getParameter("PID");
						hp.setPolicyRefNum(polNum);

						boolean status = s.deleteHealthPolicy(hp);
						System.out.println(status);

						if (status == true) {
							RequestDispatcher rd = request
									.getRequestDispatcher("/Insurance Policy Registration/HealthInsuranceScheme/DeleteHealthResult.jsp");
							rd.forward(request, response);
						} else {
							RequestDispatcher rd = request
									.getRequestDispatcher("/Insurance Policy Registration/HealthInsuranceScheme/HealthDeletePolicy.jsp");
							request.setAttribute("msg",
									"You cannot delete this policy");
							rd.forward(request, response);
						}
					} else {
						RequestDispatcher rd = request
								.getRequestDispatcher("/Insurance Policy Registration/HealthInsuranceScheme/HealthDeletePolicy.jsp");
						request.setAttribute("msg",
								"Policy Reference Number does not exist");
						rd.forward(request, response);

					}
				} else {
					RequestDispatcher rd = request
							.getRequestDispatcher("/Insurance Policy Registration/HealthInsuranceScheme/HealthInsuranceRegistration.jsp");
					request.setAttribute("msg", "No rights to delete");
					rd.forward(request, response);

				}
			}
		}

		else if ("deleteVehiclePolicy".equals(action)) {
			String errorMsg = null;
			if (request.getParameter("PID").equals(null)
					|| request.getParameter("PID").equals("")) {
				errorMsg = "CustomerId cannot be null or empty";
			}
			if (errorMsg != null) {
				RequestDispatcher rd = request
						.getRequestDispatcher("/Insurance Policy Registration/VehicleInsuranceScheme/VehicleInsuranceRegistration.jsp");
				request.setAttribute("msg",
						"This field cannot be null or empty");
				rd.forward(request, response);

			} else {
				boolean checkPolicyNum = false;

				HttpSession officerSession = request.getSession(true);
				String officer = (String) officerSession.getAttribute("userid");
				System.out.println(" SHow officer:" + officer);
				if (officer.substring(0, 2).equals("FO")) {
					String policyRefNum = request.getParameter("PID");
					System.out.println("IN CONTROLLER" + policyRefNum);
					ArrayList<HealthPolicy> policies = s.viewCustomerPolicy();
					for (HealthPolicy hp : policies) {

						if (hp.getPolicyRefNum().equals(policyRefNum)) {

							checkPolicyNum = true;
							System.out.println("Show" + policyRefNum);
						}
					}
					if (checkPolicyNum) {
						VehiclePolicy vp = new VehiclePolicy();

						String polNum = request.getParameter("PID");
						vp.setPolicyRefNum(polNum);

						boolean status = s.deleteVehiclePolicy(vp);
						System.out.println(status);
						if (status == true) {
							RequestDispatcher rd = request
									.getRequestDispatcher("/Insurance Policy Registration/VehicleInsuranceScheme/DeleteVehicleResult.jsp");
							rd.forward(request, response);

						} else {
							RequestDispatcher rd = request
									.getRequestDispatcher("/Insurance Policy Registration/VehicleInsuranceScheme/VehicleDeletePolicy.jsp");
							request.setAttribute("msg",
									"No Authority!!!You cannot delete health policy");
							rd.forward(request, response);
						}
					} else {
						RequestDispatcher rd = request
								.getRequestDispatcher("/Insurance Policy Registration/VehicleInsuranceScheme/VehicleDeletePolicy.jsp");
						request.setAttribute("msg",
								"Policy Reference Number does not exist");
						rd.forward(request, response);

					}
				} else {
					RequestDispatcher rd = request
							.getRequestDispatcher("/Insurance Policy Registration/VehicleInsuranceScheme/VehicleInsuranceRegistration.jsp");
					request.setAttribute("msg", "No rights to delete");
					rd.forward(request, response);

				}
			}
		}
	}
}
