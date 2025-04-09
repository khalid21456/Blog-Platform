package com.Edaoudi.blog.mappers;


import com.Edaoudi.blog.domain.DTOs.CategoryDto;
import com.Edaoudi.blog.domain.DTOs.CreateCategoryRequest;
import com.Edaoudi.blog.domain.PostStatus;
import com.Edaoudi.blog.domain.entities.Category;
import com.Edaoudi.blog.domain.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.List;


@SuppressWarnings("unused")
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {


    @Named("calculatePostCount")
    default long calculatePostCount(List<Post> posts) {
        if (posts == null) {
            return 0;
        }
        return posts.stream()
                .filter(post -> PostStatus.PUBLISHED.equals(post.getPostStatus()))
                .count();
    }

    @Mapping(target = "postCount", expression = "java(calculatePostCount(category.getPosts()))")
    CategoryDto toDto(Category category);

    Category toEntity(CreateCategoryRequest createCategoryRequest);

}
