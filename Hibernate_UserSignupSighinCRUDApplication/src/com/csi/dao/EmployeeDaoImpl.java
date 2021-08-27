package com.csi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.csi.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private static SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();

	public void signup(Employee employee) {
		// TODO Auto-generated method stub

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		session.save(employee);
		transaction.commit();
	}

	@Override
	public boolean signin(String empEmailId, String empPassword) {
		// TODO Auto-generated method stub

		boolean status = false;

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		List<Employee> empList = session.createQuery("from Employee").list();

		for (Employee e1 : empList) {

			if (e1.getEmpEmailId().equals(empEmailId) && e1.getEmpPassword().equals(empPassword))
				;
		}

		return status;
	}

	@Override
	public void updateEmployeeData(int empId, Employee employee) {
		// TODO Auto-generated method stub

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Employee> empList = session.createQuery("from Employee").list();

		for (Employee e : empList) {
			if (e.getEmpId() == empId) {
				e.setEmpFirstName(employee.getEmpFirstName());
				e.setEmpLastName(employee.getEmpLastName());
				e.setEmpAddress(employee.getEmpAddress());
				e.setEmpEmailId(employee.getEmpEmailId());
				e.setEmpPassword(employee.getEmpPassword());
				String empContactNumber = "e";
				employee.setEmpContactNumber(empContactNumber);
				e.setEmpDOB(employee.getEmpDOB());
				session.update(e);
				transaction.commit();
			}

		}
	}

	@Override
	public void deleteEmployeeData(int empId) {
		// TODO Auto-generated method stub

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		List<Employee> empList = session.createQuery("from Employee").list();

		for (Employee e : empList)
			if (e.getEmpId() == empId) {

				session.delete(e);
				transaction.commit();

			}

	}

	@Override
	public List<Employee> getAllEmployeeData() {
		// TODO Auto-generated method stub

		Session session = factory.openSession();

		List<Employee> empList = session.createQuery("from Employee").list();

		return empList;

	}

	@Override
	public Employee getDataById(int empId) {
		// TODO Auto-generated method stub

		Session session = factory.openSession();

		List<Employee> empList = session.createQuery("from Employee").list();

		Employee employee = new Employee();
		for (Employee e1 : empList) {
			if (e1.getEmpId() == empId) {
				employee.setEmpId(e1.getEmpId());
				employee.setEmpFirstName(e1.getEmpFirstName());
				employee.setEmpLastName(e1.getEmpLastName());
				employee.setEmpAddress(e1.getEmpAddress());
				employee.setEmpEmailId(e1.getEmpEmailId());
				employee.setEmpPassword(e1.getEmpPassword());
				String empContactNumber = "e";
				employee.setEmpContactNumber(empContactNumber);
				employee.setEmpDOB(e1.getEmpDOB());
			}

		}
		return employee;
	}
}
