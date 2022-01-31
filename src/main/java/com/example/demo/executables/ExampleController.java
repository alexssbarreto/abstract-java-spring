package com.example.demo.executables;

import com.example.demo.resources.AbstractResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/examples")
public class ExampleController extends AbstractResource<ExampleEntity, ExampleDTO> {

    @Autowired
    public ExampleController(ExampleService service) {
        super(service);
    }
}
