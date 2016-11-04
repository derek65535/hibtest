package com.github.dmandg.entity;

import com.github.dmandg.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;


public class EmployeeEntityTest
{
    @Test
    public void test()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        // Add new Employee object
        EmployeeEntity emp = new EmployeeEntity();
        emp.setEmployeeId(1);
        emp.setEmail("demo-user@mail.com");
        emp.setFirstName("demo");
        emp.setLastName("user");
        session.save(emp);
        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}