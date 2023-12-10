package main.org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stat {
    private Integer id;
    private String name;
    private String email;
    private Integer age;
    private String education;
    private String wouldRecommend;
    private String languagesKnown;
    private String comments;
}
