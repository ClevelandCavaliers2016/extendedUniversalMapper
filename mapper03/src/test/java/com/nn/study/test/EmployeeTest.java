package com.nn.study.test;


import com.nn.study.entities.Address;
import com.nn.study.entities.Employee;
import com.nn.study.entities.SeasonEnum;
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
        employee.setEmpId(10);
        employee=employeeService.getOne(employee);
        System.out.println(employee);
    }

    @Test
    public void saveEmployee(){
        Address address=new Address("上海","上海","上海");
        Employee employee=new Employee("ff2",10.0,13,SeasonEnum.AUTUMN,address);
       employeeService.saveEmployee(employee);

    }

}
