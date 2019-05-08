package com.nn.study.customMapper;

import tk.mybatis.mapper.common.base.insert.InsertMapper;
import tk.mybatis.mapper.common.base.select.SelectAllMapper;
import tk.mybatis.mapper.common.base.select.SelectOneMapper;
import tk.mybatis.mapper.common.example.DeleteByExampleMapper;
import tk.mybatis.mapper.common.example.SelectByExampleMapper;

public interface BaseMapper<T> extends
        SelectAllMapper<T>,
        SelectByExampleMapper<T>,
        SelectOneMapper<T>,
        ExtendBatchUpdatesMapper<T>{
}
