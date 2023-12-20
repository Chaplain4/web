package main.org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String descr;

    @Column
    private String priority;

    @Column
    private String status;

    @Column
    private Date deadline;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "employees_tasks",
//            joinColumns = @JoinColumn(name = "task_id"),
//            inverseJoinColumns = @JoinColumn(name = "employee_id"))
//    private Set<Employee> tasks = new HashSet<>();

//    @ManyToMany(mappedBy = "tasks")
//    private Set<Employee> tasks = new HashSet<>();
}
