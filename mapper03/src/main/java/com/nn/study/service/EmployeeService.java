package com.nn.study.service;

import com.nn.study.entities.Employee;
import com.nn.study.mappers.EmployeeMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public Employee getOne(Employee employeeQueryCondition) {
        return employeeMapper.selectOne(employeeQueryCondition);
    }

    public  void  batchUpdate(List<Employee> list){
        employeeMapper.batchUpdate(list);
    }

}
