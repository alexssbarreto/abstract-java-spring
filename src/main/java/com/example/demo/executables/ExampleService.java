package com.example.demo.executables;

import com.example.demo.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleService extends AbstractService<ExampleEntity, ExampleDTO> {

    @Autowired
    public ExampleService(ExampleRepository repository) {
        super(repository);
    }

    @Override
    public ExampleEntity fromDTO(ExampleDTO objDto) {
        return new ExampleEntity(objDto.getId(), objDto.getNome(), objDto.getCategoria());
    }
}
