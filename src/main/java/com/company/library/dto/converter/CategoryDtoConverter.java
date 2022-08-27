package com.company.library.dto.converter;

import com.company.library.dto.CategoryDto;
import com.company.library.model.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryDtoConverter {

    public CategoryDto convert(Category from){
        return new CategoryDto(
                from.getId(),
                from.getName()
        );
    }

    public List<CategoryDto> convert(List<Category> fromList){
        return fromList.stream()
                .map(this::convert).collect(Collectors.toList());
    }
}
