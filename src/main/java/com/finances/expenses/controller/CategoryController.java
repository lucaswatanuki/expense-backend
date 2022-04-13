package com.finances.expenses.controller;

import com.finances.expenses.dto.CategoryDto;
import com.finances.expenses.service.SimpleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController extends SimpleController<CategoryDto>{

    @Autowired
    public CategoryController(SimpleService<CategoryDto> service) {
        super(service);
    }
}
