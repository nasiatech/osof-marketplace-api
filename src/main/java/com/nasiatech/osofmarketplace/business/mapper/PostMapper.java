package com.nasiatech.osofmarketplace.business.mapper;

import com.nasiatech.osofmarketplace.api.dto.PostDto;
import com.nasiatech.osofmarketplace.data.entity.Post;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PostMapper {
    Post postDtoToPost(PostDto postDto);

    PostDto postToPostDto(Post post);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Post updatePostFromPostDto(PostDto postDto, @MappingTarget Post post);
}
