package main.org.example.jdbc.abs;

import main.org.example.model.Stat;

import java.util.Set;

public interface StatDAO extends AbstractDAO<Stat, Integer> {

    Set<Stat> all();
}
