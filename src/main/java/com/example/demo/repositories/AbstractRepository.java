package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.AbstractEntity;

public interface AbstractRepository<E extends AbstractEntity, I extends Number> extends JpaRepository<E, I> {

}