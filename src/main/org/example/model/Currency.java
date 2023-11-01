package main.org.example.model;

import lombok.Data;

@Data
public class Currency {
    private int id;
    private int numcode;
    private String charcode;
    private int Scale;
    private String name;
    private double rate;
}
