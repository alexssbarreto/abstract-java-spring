package com.example.demo.services;

import com.example.demo.dto.AbstractDTO;
import com.example.demo.entities.AbstractEntity;
import com.example.demo.repositories.AbstractRepository;
import com.example.demo.resources.Filter;
import com.example.demo.services.exceptions.DataIntegrityException;
import com.example.demo.services.exceptions.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T extends AbstractEntity, D extends AbstractDTO> {

    private AbstractRepository<T, Integer> repository;

    public AbstractService(AbstractRepository repository) {
        this.repository = repository;
    }

    public T find(Integer id) {
        Optional<T> obj = this.repository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException(String.format("Objeto não encontrado! Id: %s", id)));
    }

    public List<T> findAll() {
        return this.repository.findAll();
    }

    public Page<T> findPage(Filter filter) {
        PageRequest pageRequest = PageRequest.of(
                filter.getPage(),
                filter.getLinesPerPage(),
                Direction.valueOf(filter.getDirection().toUpperCase()),
                filter.getOrderBy());

        return this.repository.findAll(pageRequest);
    }

    public T insert(T obj) {
        obj.setId(null);

        return this.repository.save(obj);
    }

    public T update(T obj) {
        return this.repository.save(obj);
    }

    public void delete(Integer id) {
        find(id);

        try {
            this.repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir este registro por ter dependência.");
        }
    }

    abstract public T fromDTO(D objDto);
}
