package com.henggao.mongeostore_version1.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "t_test")
public class Test {
    @Id
    private ObjectId objectId;
    private String title;
    private String description;
    private Integer likes;
    private String by;
}
