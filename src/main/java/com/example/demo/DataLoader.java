package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Autowired
    JobRepository jobRepository;

    @Override
    public void run(String... strings) throws Exception {
        User user  = new User();
        user.setName("");

        Job job1 = new Job();
        job1.setTitle("Teacher");
        job1.setDescription("Provide lessons");

        job1.setAuthor("Olga");
        job1.setPhone("3435 768 345");

        Job job2 = new Job();
        job2.setTitle("Pet sitter");
        job2.setDescription("Take care for pets");

        job2.setAuthor("Olga");
        job2.setPhone("3435 768 345");

        userRepository.save(user);
        jobRepository.save(job1);
        jobRepository.save(job2);

    }
}
