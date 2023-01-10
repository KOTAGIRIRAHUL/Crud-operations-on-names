package com.example.Name.Repository;

import com.example.Name.Model.name;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface nameRepository extends MongoRepository<name, String> {

    public List<name> findBynamesEmail(String namesemail);

    public void delete(name foundnames);
}