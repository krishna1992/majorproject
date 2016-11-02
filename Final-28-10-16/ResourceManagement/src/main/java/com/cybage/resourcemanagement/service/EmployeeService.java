package com.cybage.resourcemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cybage.resourcemanagement.dao.IEmployeeDao;
import com.cybage.resourcemanagement.model.Employee;
import com.cybage.resourcemanagement.model.ProjectTable;
import com.cybage.resourcemanagement.model.RoleTable;

@Service("employeeService")
@Transactional
public class EmployeeService implements IEmployeeService 
{
	@Autowired
	private IEmployeeDao empDAO;

	public EmployeeService()
	{
		System.out.println("In Service");
	}

	public Integer getEmployee(String username, String password)
	{
		System.out.println("In Service . . ."+username);
		return empDAO.getEmployee(username,password);
	}


	public Integer loginEmployee(String username, String password)
	{
		System.out.println("In Service . . ."+username);
		return empDAO.loginEmployee(username,password);
	}
	
	public Employee searchEmployee(int rollno)
	{
		System.out.println("In List Service");

		return empDAO.searchEmployee(rollno);
	}
	
	public Integer addEmployee(Employee employee)
	{
		System.out.println("In Service . . ."+employee.getDepartment());
		return empDAO.addEmployee(employee);
	}

	public List<Employee> listEmployee() 
	{
		System.out.println("In List Service");

		return empDAO.listEmployee();
	}
	
	public List<ProjectTable> listProjects()
	{
		System.out.println("In List Service");

		return empDAO.listProjects();
	}
	
	public List<RoleTable> listRoles() 
	{
		System.out.println("In List Service");

		return empDAO.listRoles();
	}


}
