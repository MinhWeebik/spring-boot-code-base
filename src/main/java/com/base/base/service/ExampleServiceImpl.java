package com.base.base.service;

import com.base.base.model.ExampleMongo;
import com.base.base.repository.ExampleDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExampleServiceImpl implements ExampleService {

    private final ExampleDao exampleDao;

    public ExampleServiceImpl(ExampleDao exampleDao) {
        this.exampleDao = exampleDao;
    }

    @Override
    public Map<String, Object> getExamples(String type) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        List<?> items = type.equals("mongo") ? exampleDao.getExampleMongo() : type.equals("sql") ? exampleDao.getExampleSQL() : new ArrayList<>();
        map.put("data", items);
        map.put("message", "success");
        return map;
    }
}
