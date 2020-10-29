package ru.safronova.skills.entity;

import java.util.List;

public class Vacancies {

    private List<Vacancy> items;

    public Vacancies() {
    }

    public List<Vacancy> getItems() {
        return items;
    }

    public void setItems(List<Vacancy> items) {
        this.items = items;
    }
}
