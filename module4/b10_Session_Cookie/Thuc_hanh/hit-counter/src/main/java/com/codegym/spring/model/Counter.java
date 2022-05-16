package com.codegym.spring.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Counter {

    @Id
    private int count;

    public Counter() {
    }

    public Counter(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int increment() {
        return count++;
    }
}
