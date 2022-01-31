package com.example.demo.resources;

import com.example.demo.dto.AbstractDTO;
import com.example.demo.entities.AbstractEntity;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.services.AbstractService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

public abstract class AbstractResource<T extends AbstractEntity, D extends AbstractDTO> {

    private final AbstractService<T, D> service;

    public AbstractResource(AbstractService<T, D> service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<T> find(@PathVariable Integer id) {
        T obj = this.service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<T>> findAll() {
        List<T> list = this.service.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<T>> findPage(Filter filter) {
        Page<T> list = this.service.findPage(filter);

        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<T> insert(@Valid @RequestBody D objDto) {
        T obj = service.fromDTO(objDto);
        obj = service.insert(obj);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<T> update(@Valid @RequestBody D objDto, @PathVariable Integer id) {
        T obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);

        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        this.service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
