package com.nn.study.customMapper;

import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

public interface ExtendBatchUpdatesMapper<T> {

    @UpdateProvider(type=ExtendBatchUpdatesProvider.class, method="dynamicSQL")
    void batchUpdate(List<T> list);
}
