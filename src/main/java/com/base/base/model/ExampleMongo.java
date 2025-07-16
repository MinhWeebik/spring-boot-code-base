package com.base.base.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Example")
public class ExampleMongo implements Serializable {

    @Id
    @JsonIgnore
    private String id;

    @Field(value = "name")
    private String name;

    @Field(value = "age")
    private Integer age;

}
