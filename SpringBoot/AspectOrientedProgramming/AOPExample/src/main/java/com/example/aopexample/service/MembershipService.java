package com.example.aopexample.service;

import org.springframework.stereotype.Service;

@Service
public class MembershipService {

    private String name;

    public void addAccount() {
        System.out.println(getClass().getSimpleName() + ": Doing some work in the membership service.");
    }

    public String getName() {
        return name;
    }

    public MembershipService setName(String name) {
        this.name = name;
        return this;
    }
}
