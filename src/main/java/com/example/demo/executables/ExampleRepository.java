package com.example.demo.executables;

import com.example.demo.repositories.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleRepository extends AbstractRepository<ExampleEntity, Integer> {
}
