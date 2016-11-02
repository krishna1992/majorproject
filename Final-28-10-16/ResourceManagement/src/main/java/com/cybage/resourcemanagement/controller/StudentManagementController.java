package com.cybage.resourcemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.cybage.resourcemanagement.model.Employee;
import com.cybage.resourcemanagement.model.ProjectTable;
import com.cybage.resourcemanagement.model.RoleTable;
import com.cybage.resourcemanagement.service.IEmployeeService;


@RestController
public class StudentManagementController 
{

	Integer id ;
	
	@Autowired
	IEmployeeService employeeService;
	
	/*@RequestMapping(value = "/employees/", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> getEmployee(@RequestBody Employee employee) 
	{
		System.out.println("In List Student Controller . . . ");
		
		String username = employee.getUsername();
		String password = employee.getPassword();

		Integer id = employeeService.getEmployee(username,password);
		
		if(id > 0)
			return new ResponseEntity<String>("success", HttpStatus.OK);
		else
			return new ResponseEntity<String>("failure", HttpStatus.OK);
	}*/
	
	@RequestMapping(value = "/employees/", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> listAllUsers() 
	{
		System.out.println("In List Student Controller . . . ");
		List<Employee> users = employeeService.listEmployee();

		return new ResponseEntity<List<Employee>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/projects/", method = RequestMethod.GET)
	public ResponseEntity<List<ProjectTable>> listAllProjects() 
	{
		System.out.println("In List Student Controller . . . ");
		List<ProjectTable> projects = employeeService.listProjects();

		return new ResponseEntity<List<ProjectTable>>(projects, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/roles/", method = RequestMethod.GET)
	public ResponseEntity<List<RoleTable>> listAllRoles() 
	{
		System.out.println("In List Student Controller . . . ");
		List<RoleTable> projects = employeeService.listRoles();

		return new ResponseEntity<List<RoleTable>>(projects, HttpStatus.OK);
	}

	@RequestMapping(value = "/login/", method = RequestMethod.POST)
	public ResponseEntity<Void> loginEmployee(@RequestBody Employee employee, UriComponentsBuilder ucBuilder) 
	{
		System.out.println("In login employee Controller . . . "+employee.getUsername()+""+employee.getPassword());
		
		String username = employee.getUsername();
		String password = employee.getPassword();
		
		id = employeeService.loginEmployee(username, password);
		
		System.out.println("Employee Id : ---------------------"+id);
		
		HttpHeaders headers = new HttpHeaders();
		
		return new ResponseEntity<Void> (headers, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/loginSuccess/", method = RequestMethod.GET)
	public ResponseEntity<Integer> loginSuccess() 
	{
		return new ResponseEntity<Integer> (id, HttpStatus.OK);
	}
	
}