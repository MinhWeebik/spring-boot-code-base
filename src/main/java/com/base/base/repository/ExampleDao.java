package com.base.base.repository;

import com.base.base.model.ExampleMongo;
import com.base.base.model.ExampleSQL;

import java.util.List;

public interface ExampleDao {
    List<ExampleMongo> getExampleMongo();
    List<ExampleSQL> getExampleSQL();
}
