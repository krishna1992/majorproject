package com.cybage.resourcemanagement.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cybage.resourcemanagement.model.Employee;
import com.cybage.resourcemanagement.model.ProjectTable;
import com.cybage.resourcemanagement.model.RoleTable;


@Repository("empDAO")
public class EmployeeDao implements IEmployeeDao 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session	session;
	
	public EmployeeDao()
	{
		System.out.println("In Dao Default constr . . .");
	}

	public Integer getEmployee(String username, String password) 
	{
		session =  sessionFactory.getCurrentSession();
		System.out.println(username+""+password);
		String hql = "from employee where employee.username = 'username' and employee.password = 'password'";
		Query query = session.createQuery(hql);
		int id = query.executeUpdate();
		System.out.println("Record Updated : "+id);
		return id;
	}
	
	public Integer loginEmployee(String username, String password) 
	{
		session =  sessionFactory.getCurrentSession();
		System.out.println(username+""+password);
		String hql = "from Employee where username =:username and password =:password";
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		query.setParameter("password", password);
		Employee emp = (Employee) query.uniqueResult();
		System.out.println(emp.getEmpid());
		
		String hql1 = "select RPT.projectTable.proj_id,RPT.projectTable.proj_name from ResourceProjectTable RPT where RPT.employee.empid =:id";	  
		Query query1 = session.createQuery(hql1);
		query1.setParameter("id", emp.getEmpid());
		
        List<Object> objs = (List<Object>)query1.list();
        for (Object obj : objs) {
            Object[] o = (Object[]) obj;
            String proj_id =  String.valueOf(o[0]);
            String proj_name =  String.valueOf(o[1]);
            System.out.println(proj_id +"   " + proj_name );
        }
        
		return emp.getEmpid();
	}
	
	public Employee searchEmployee(int rollno)
	{
		 session = sessionFactory.getCurrentSession();
		
		 Employee s = (Employee) session.get(Employee.class, rollno);
		 return s;
	}
	
	public Integer addEmployee(Employee employee) 
	{
		Integer id = (Integer) sessionFactory.getCurrentSession().save(employee);
		System.out.println("Object Saved");
		return id;	
	}
	
	public List<Employee> listEmployee() 
	{
		 session = sessionFactory.getCurrentSession();
		
		List<Employee> personsList = session.createQuery("from Employee").list();
		
		return personsList;
	}
	
	public List<ProjectTable> listProjects() 
	{
		 session = sessionFactory.getCurrentSession();
		
		List<ProjectTable> projectLlist = session.createQuery("from ProjectTable").list();
		
		return projectLlist;
	}
	
	public List<RoleTable> listRoles() 
	{
		 session = sessionFactory.getCurrentSession();
		
		List<RoleTable> roleList = session.createQuery("from RoleTable").list();
		
		return roleList;
	}
	
}
