package com.csi.controller;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csi.service.EmployeeService;
import com.csi.service.EmployeeServiceImpl;
import com.csi.model.Employee;

@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {

	EmployeeService employeeserviceImpl = new EmployeeServiceImpl();

	private static final long serialVersionUID = 1L;

	public EmployeeController() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String redirect = "";

		String action = request.getParameter("action");

		if (action.equals("signup")) {

			String empFirstName = request.getParameter("empfirstname");

			String empLastName = request.getParameter("emplastname");

			String empAddress = request.getParameter("empadress");

			String empContactNumber = request.getParameter("empcontactnumber");

			String empEmailId = request.getParameter("empemailid");

			String empPassword = request.getParameter("emppassword");

			String empDOB = request.getParameter("empdob");

			Date dob = null;

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			try {
				dob = sdf.parse(empDOB);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			Employee employee = new Employee();

			employee.setEmpFirstName(empFirstName);
			employee.setEmpLastName(empLastName);
			employee.setEmpAddress(empAddress);
			employee.setEmpContactNumber(empContactNumber);
			employee.setEmpEmailId(empEmailId);
			employee.setEmpPassword(empPassword);
			employee.setEmpDOB(dob);

			
			
			
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
