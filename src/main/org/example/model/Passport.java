package main.org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "passport")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column() // name = "id" . т.к. имя в таблице и модели полностью совпадает, в скобках можно не писать
    private int id;

    @Column(name = "personal_id")
    private String personalID;

    @Column(name = "ind_id")
    private String indID;

    @Column(name = "exp_ts")
    private Date expTS;

    @Column(name = "created_ts")
    private Timestamp createdTS;
}
