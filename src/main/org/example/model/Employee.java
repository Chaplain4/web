package main.org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
@ToString
public class Employee  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private int age;

    @ManyToOne(fetch = FetchType.EAGER)
    private Office office;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id", referencedColumnName = "id")
    private Passport passport;

    @Column(name = "updated_ts")
    private Timestamp updatedTs;

    @Column(name = "created_ts")
    private Timestamp createdTs;
}
