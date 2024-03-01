package com.logo.service;

import com.logo.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);
    void deletePostById(long id);
    PostDto getPostById(long id);
    PostDto updatePost(long id,PostDto postDto);
}
