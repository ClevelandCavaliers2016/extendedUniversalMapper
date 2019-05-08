package com.nn.study.test;


import com.nn.study.entities.Employee;
import com.nn.study.service.EmployeeService;
import org.apache.ibatis.logging.jdbc.BaseJdbcLogger;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;


public class EmployeeTest {
    private ApplicationContext appletContext=new ClassPathXmlApplicationContext("spring-context.xml");
    private EmployeeService employeeService = appletContext.getBean(EmployeeService.class);



    @Test
    public void getOne(){
        Employee employee=new Employee();
        employee.setEmpId(1);
        employee=employeeService.getOne(employee);
        System.out.println(employee);
    }

    @Test
    public void batchUpdate(){
        Employee employee1=new Employee(7,"nn1",100.0,11);
        Employee employee2=new Employee(8,"nn2",100.0,11);
        Employee employee3=new Employee(9,"nn3",100.0,11);
        List<Employee> list=new ArrayList<Employee>();
        list.add(employee1);
        list.add(employee2);
        list.add(employee3);
        employeeService.batchUpdate(list);
    }


}
