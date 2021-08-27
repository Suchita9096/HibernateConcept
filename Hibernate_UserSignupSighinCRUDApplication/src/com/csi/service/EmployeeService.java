package com.csi.service;

import java.util.List;

import com.csi.model.Employee;

public interface EmployeeService {

	public void signup(Employee employee);

	public boolean signin(String empEmailId, String empPassword);

	public void updateEmployeeData(int empId, Employee employee);

	public void deleteEmployeeData(int empId);

	public List<Employee> getAllEmployeeData();

	public Employee getDataById(int empId);

}
