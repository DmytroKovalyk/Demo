package com.example.demo.model;

import com.example.demo.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {
    @Id
    private String id;
    private String firstName;
    private String lastName;

    public User(UserDto userDto) {
        firstName = userDto.getFirstName();
        lastName = userDto.getLastName();
    }
}
