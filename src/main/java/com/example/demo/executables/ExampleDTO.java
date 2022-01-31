package com.example.demo.executables;

import com.example.demo.dto.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExampleDTO extends AbstractDTO {

    private String nome;
    private String categoria;

    public ExampleDTO(ExampleEntity example) {
        this.id = example.getId();
        this.nome = example.getNome();
        this.categoria = example.getCategoria();
    }
}
