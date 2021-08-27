package com.csi.service;

import java.util.List;

import com.csi.dao.EmployeeDao;
import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao employeeDaoImpl = new EmployeeDaoImpl();
	
	public void signup(Employee employee) {
		// TODO Auto-generated method stub
		employeeDaoImpl.signup(employee);
	}

	@Override
	public boolean signin(String empEmailId, String empPassword) {
		// TODO Auto-generated method stub
		return employeeDaoImpl.signin(empEmailId, empPassword);
		
	}

	@Override
	public void updateEmployeeData(int empId, Employee employee) {
		// TODO Auto-generated method stub
		employeeDaoImpl.updateEmployeeData(empId, employee);
		
	}

	@Override
	public void deleteEmployeeData(int empId) {
		// TODO Auto-generated method stub
		employeeDaoImpl.deleteEmployeeData(empId);
		
	}

	@Override
	public List<Employee> getAllEmployeeData() {
		// TODO Auto-generated method stub
		return employeeDaoImpl.getAllEmployeeData();
	}

	@Override
	public Employee getDataById(int empId) {
		// TODO Auto-generated method stub
		return employeeDaoImpl.getDataById(empId);
	}

}
