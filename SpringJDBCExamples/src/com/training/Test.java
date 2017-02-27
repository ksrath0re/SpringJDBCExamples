package com.training;

import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  
public class Test {  

	public static void main(String[] args) {  
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");  
		EmployeeDao dao=(EmployeeDao)ctx.getBean("edao");  
		
		dao.createTable("NewTable5");
		
		int status1=dao.saveEmployee(new Employee(301,"manisha 2222",24000));  
		System.out.println(status1);  

		int status2=dao.saveEmployee(new Employee(302,"KSR",24000));  
		System.out.println(status2); 
		
		/*int status3=dao.updateEmployee(new Employee(301,"Tanish",5000)); 
		System.out.println(status3); */

		int st=dao.displayRecords();
		System.out.println(st);
		
		
		//Employee e=new Employee(); 
	//	e.setId(301); 
		//int st=dao.deleteEmployee(e); 
		//System.out.println(st);
		
		
		//int st=dao.displayRecords();
		//System.out.println(st);
	}  
}