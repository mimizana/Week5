package com.example.demo;

import com.sun.istack.NotNull;
import org.springframework.boot.autoconfigure.batch.BatchProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;


    @OneToMany(mappedBy = "user",
            cascade = CascadeType.REMOVE,
            fetch = FetchType.EAGER)
    private Set<Job> jobs;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Job> getJobs() {
        return jobs;
    }

    public void setJobs(Set<Job> jobs) {
        this.jobs = jobs;
    }
}