package com.example.demo.executables;

import com.example.demo.entities.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExampleEntity extends AbstractEntity {

    private String nome;
    private String categoria;

    public ExampleEntity(Integer id, String nome, String categoria) {
        super(id);
        this.nome = nome;
        this.categoria = categoria;
    }
}
