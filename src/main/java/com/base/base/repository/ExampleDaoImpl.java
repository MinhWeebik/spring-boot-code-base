package com.base.base.repository;

import com.base.base.model.ExampleMongo;
import com.base.base.model.ExampleSQL;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
@Log4j2
public class ExampleDaoImpl implements ExampleDao {

    private final MongoOperations mongoOperations;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ExampleDaoImpl(MongoOperations mongoOperations,  NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.mongoOperations = mongoOperations;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }


    @Override
    public List<ExampleMongo> getExampleMongo() {
        try
        {
            return mongoOperations.findAll(ExampleMongo.class);
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    @Override
    public List<ExampleSQL> getExampleSQL() {
        try
        {
            String sql = "SELECT * FROM example";
            SqlParameterSource param = new MapSqlParameterSource();
            List<ExampleSQL> list = namedParameterJdbcTemplate.query(sql, param,
                    (rs, rowNum) -> ExampleSQL.builder()
                            .name(rs.getString("name"))
                            .age(rs.getInt("age"))
                            .build());
            return list;
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
        }
        return new ArrayList<>();
    }
}
