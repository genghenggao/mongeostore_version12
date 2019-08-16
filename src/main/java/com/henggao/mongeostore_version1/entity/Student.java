package com.henggao.mongeostore_version1.entity;


import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "t_student")
public class Student {
    @Id
    private String _id;
    private String name;
    private int age;
}
