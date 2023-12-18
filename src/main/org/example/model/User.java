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
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column() // name = "id" . т.к. имя в таблице и модели полностью совпадает, в скобках можно не писать
    private Integer id;
    @Column()
    private String name;
    @Column()
    private String email;
    @Column()
    private String pwd;
    @Column()
    private String details;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role", referencedColumnName = "name")
    private Role role;

    @Column(name = "is_active")
    private Boolean isActive; //default false
    @Column()
    private Timestamp created_ts;
    @Column()
    private Timestamp updated_ts;
}
