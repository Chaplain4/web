package main.org.example.model;

import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class Passport {
    private int id;
    private String personalID;
    private String indID;
    private Date expTS;
    private Timestamp createdTS;
}
