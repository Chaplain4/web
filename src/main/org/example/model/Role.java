package main.org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column() // name = "id" . т.к. имя в таблице и модели полностью совпадает, в скобках можно не писать
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "details")
    private String details;

    @Column(name = "created_ts")
    private Timestamp created_ts;

    @Column(name = "updated_ts")
    private Timestamp updated_ts;
}