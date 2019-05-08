package com.nn.study.mappers;

import com.nn.study.customMapper.BaseMapper;
import com.nn.study.entities.Employee;

import org.apache.ibatis.annotations.CacheNamespace;


@CacheNamespace
public interface EmployeeMapper extends BaseMapper<Employee> {
}
