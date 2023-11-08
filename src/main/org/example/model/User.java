package main.org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String email;
    private String pwd;
    private String details;
    private Role role;
    private Boolean isActive; //default false
    private Timestamp created_ts;
    private Timestamp updated_ts;
}
