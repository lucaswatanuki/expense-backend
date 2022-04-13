package com.finances.expenses.service;

import com.finances.expenses.dto.CategoryDto;
import com.finances.expenses.repositories.CategoryRepository;
import com.finances.expenses.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService implements SimpleService<CategoryDto> {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public CategoryDto get(String id) {
        return categoryRepository.findById(id)
                .map(Converter::mapToCategoryDto)
                .orElse(null);
    }

    @Override
    public List<CategoryDto> getAll() {
        return categoryRepository.findAll()
                .stream()
                .map(Converter::mapToCategoryDto)
                .collect(Collectors.toList());
    }

    @Override
    public void create(CategoryDto body) {
        categoryRepository.save(Converter.mapToCategory(body));
    }

    @Override
    public void update(String id, CategoryDto body) {
        categoryRepository.findById(id)
                .ifPresent(category -> categoryRepository.save(Converter.mapToCategory(body).toBuilder()
                        .id(category.getId())
                        .build()));
    }

    @Override
    public void delete(String id) {
        categoryRepository.findById(id)
                .ifPresent(categoryRepository::delete);
    }

    @Override
    public void deleteAll() {
        categoryRepository.deleteAll();
    }
}
