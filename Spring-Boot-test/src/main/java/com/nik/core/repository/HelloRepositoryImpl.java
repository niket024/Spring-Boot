package com.nik.core.repository;

import org.springframework.stereotype.Repository;

@Repository
public class HelloRepositoryImpl implements HelloRepository {
    @Override
    public String get() {
    	//DB connection
        return "Hello JUnit 5";
    }
}
