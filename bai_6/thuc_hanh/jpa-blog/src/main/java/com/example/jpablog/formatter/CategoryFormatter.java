package com.example.jpablog.formatter;

import com.example.jpablog.model.Category;
import com.example.jpablog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class CategoryFormatter implements Formatter<Category> {
    private final ICategoryService categoryService;
    @Autowired
    public CategoryFormatter(ICategoryService categoryService){
        this.categoryService = categoryService;
    }
    @Override
    public Category parse(String id, Locale locale) throws ParseException {
        Optional<Category> categoryOptional = Optional.ofNullable(categoryService.findById(Long.parseLong(id)));
        return categoryOptional.orElse(null);
    }

    @Override
    public String print(Category object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
