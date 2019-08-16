package com.henggao.mongeostore_version1.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Data
@ToString
@Document(collection = "t_user")
public class Users  implements Serializable {

    @Id //指定id
    private int id;
    @Field("username") // 指定域名，覆盖默认
    private String username;
    @Field("password") // 指定域名，覆盖默认
    private String password;
}
