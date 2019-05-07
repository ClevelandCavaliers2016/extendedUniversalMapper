package com.nn.study.test;


import com.nn.study.service.EmployeeService;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tk.mybatis.mapper.entity.Example;

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
    public void getEmployeeById(){
        Employee employee=employeeService.getEmployeeById(1);
        System.out.println(employee);
    }
    @Test
    public void isExists(){
        boolean flag=employeeService.isExists(1);
        System.out.println(flag);
    }
    @Test
    public void saveEmployee(){
        Employee employee=new Employee();
        employee.setEmpAge(12);
       // employee.setEmpName("nnn");
       // employee.setEmpSalary(123.0);

        employeeService.saveEmployee(employee);
       // INSERT INTO tabple_emp ( emp_id,emp_name,emp_salary,emp_age ) VALUES( ?,?,?,? )
       //  null, null, 123.0(Double), 12(Integer)

        employeeService.saveEmployeeSelective(employee);
        //INSERT INTO tabple_emp ( emp_id,emp_salary,emp_age ) VALUES( ?,?,? )
       // null, 123.0(Double), 12(Integer)
       System.out.println(employee.getEmpId());
    }


    @Test
    public void getEmpListByExample(){

        //1.创建Example对象
        Example example = new Example(Employee.class);
        //排序
        example.setOrderByClause("emp_salary desc");
        //去重
        example.setDistinct(true);

        //2.通过Example对象创建Criteria对象
        Example.Criteria criteria01 = example.createCriteria();
        criteria01.andGreaterThan("empSalary",4000)
                .andGreaterThan("empAge",38);
        //方法一：
//       example.or().andLessThan("empSalary",200)
//               .andLessThan("empAge",10);
       //方法二：
        Example.Criteria criteria02 = example.createCriteria();
        criteria02.andLessThan("empSalary",200)
                .andLessThan("empAge",10);
        example.or(criteria02);
        //5.执行查询
        List<Employee> empList = employeeService.getEmpListByExample(example);

        for (Employee employee : empList) {
            System.out.println(employee);
        }
    }

    @Test
    public void testSelectByRowBounds() {

        int pageNo = 1;
        int pageSize = 5;
        int index = (pageNo - 1) * pageSize;
        RowBounds rowBounds = new RowBounds(index, pageSize);
        List<Employee> empList = employeeService.getEmpListByRowBounds(rowBounds);
        for (Employee employee : empList) {
            System.out.println(employee);
        }

    }
}
