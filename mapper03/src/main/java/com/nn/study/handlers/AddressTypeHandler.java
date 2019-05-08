package com.nn.study.handlers;

import com.nn.study.entities.Address;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressTypeHandler extends BaseTypeHandler<Address> {
    /**
     * 将object转换成string
     *
     * @param preparedStatement
     * @param i
     * @param address
     * @param jdbcType
     * @throws SQLException
     */
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Address address, JdbcType jdbcType) throws SQLException {
        if (address==null) {
            return;
        }

        //获取属性
         String province=address.getProvince();
         String city=address.getCity();
         String street=address.getStreet();

         //将属性拼接成字符串
         StringBuilder builder=new StringBuilder();
         builder.append(province)
                 .append(",")
                 .append(city)
                 .append(",")
                 .append(street);
         String addressString =builder.toString();

         //将字符串放入preparedStatement对象的i位置
         preparedStatement.setString(i,addressString);
    }

    /**
     * 将string字符串转换成Java对象
     *
     * @param resultSet
     * @param resultSet
     * @return
     * @throws SQLException
     */
    public Address getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        //1、根据字段名获取字段值
        String columValue=resultSet.getString(columnName);

        //2、验证字段值是否有效
        if(columValue==null&&columValue==""&!columValue.contains(",")){
            return null;
        }

        //3、分割字符串
        String[] split=columValue.split(",");

        String province=split[0];
        String city=split[1];
        String street=split[2];

        Address address=new Address(province,city,street);
        return address;
    }

    public Address getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        //1、根据字段名获取字段值
        String columValue=resultSet.getString(columnIndex);

        //2、验证字段值是否有效
        if(columValue==null&&columValue==""&!columValue.contains(",")){
            return null;
        }

        //3、分割字符串
        String[] split=columValue.split(",");

        String province=split[0];
        String city=split[1];
        String street=split[2];

        Address address=new Address(province,city,street);
        return address;
    }

    public Address getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        //1、根据字段名获取字段值
        String columValue=callableStatement.getString(columnIndex);

        //2、验证字段值是否有效
        if(columValue==null&&columValue==""&!columValue.contains(",")){
            return null;
        }

        //3、分割字符串
        String[] split=columValue.split(",");

        String province=split[0];
        String city=split[1];
        String street=split[2];

        Address address=new Address(province,city,street);
        return address;
    }
}
