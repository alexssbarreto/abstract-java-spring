package com.example.demo.resources;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Filter {

    private Integer page = 0;
    private Integer linesPerPage = 24;
    private String orderBy = "id";
    private String direction = "ASC";
}
