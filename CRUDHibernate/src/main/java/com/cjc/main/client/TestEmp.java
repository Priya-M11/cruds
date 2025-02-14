package com.cjc.main.client;

import java.util.*;
import org.hibernate.Session;

import com.cjc.main.config.HibernateUtil;
import com.cjc.main.model.Employee;

public class TestEmp {
	
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		while(true)
		{
		System.out.println("1.Add employee \n2.View Employee \n3.Update Employee \n4.Delete Employee");
		System.out.println("--------------------------");
		System.out.println("enter ypur choice:");
		int ch=sc.nextInt();
		switch (ch) {
		case 1:	addEmployee();	
				break;
				
		case 2:	viewEmployee();	
				break;
				
		case 3:	updateEmployee();	
				break;
		
		case 4:	deleteEmployee();	
				break;
		
		default:
			break;
		}
		}
	}

	private static void deleteEmployee() {
		Scanner sc =new Scanner(System.in);
		Session ss=HibernateUtil.getSessionFactory().openSession();
		System.out.println("enter eid:");
		int empid=sc.nextInt();
		Employee e=ss.get(Employee.class, empid);
		if(e!=null)
		{
			ss.delete(e);
			System.out.println(empid+ " Record Deleted ");
		}
		else
		{
			System.out.println(empid +"Id Not found");
		}
		ss.beginTransaction().commit();
		
	}

	private static void updateEmployee() {
		Scanner sc =new Scanner(System.in);
		Session ss=HibernateUtil.getSessionFactory().openSession();
		System.out.println("enter eid:");
		int empid=sc.nextInt();
		Employee e=ss.get(Employee.class, empid);
		System.out.println("Enter New Name:");
		e.setName(sc.next());
		System.out.println("Enter New Address:");
		e.setAddress(sc.next());
		System.out.println("Enter New Mobno:");
		e.setMobno(sc.nextLong());
		
		ss.update(e);
		System.out.println(e);
		ss.beginTransaction().commit();
		
	}

	private static void addEmployee() {
		
		Employee e=new Employee();
			Scanner sc =new Scanner(System.in);
			System.out.println("Enter EId:");
         e.setEmpid(sc.nextInt());
         System.out.println("Enter Name:");
		//String name=sc.next();
	    e.setName(sc.next());
		System.out.println("Enter Address:");
		//String address=sc.next();
		e.setAddress(sc.next());
		System.out.println("Enter Mobno:");
		//long mobno=sc.nextLong();
	     e.setMobno(sc.nextLong());
		Session ss=HibernateUtil.getSessionFactory().openSession();
		ss.persist(e);
		ss.beginTransaction().commit();
	}
	

	private static void viewEmployee() {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter EId:");
		int empid=sc.nextInt();
		Session ss=HibernateUtil.getSessionFactory().openSession();
		Employee e=ss.get(Employee.class, empid);
		if(e!=null)
		{
			System.out.println(e.getEmpid()+" |"+e.getName()+" |"+e.getAddress()+" |"+e.getMobno());
			System.out.println("--------------------------");
	    }
		else
		{
			System.out.println("record deleted");
		}
		
		ss.beginTransaction().commit();	
	}

}
