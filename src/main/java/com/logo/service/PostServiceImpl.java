package com.logo.service;

import com.logo.entity.Post;
import com.logo.exception.ResourceNotFound;
import com.logo.payload.PostDto;
import com.logo.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto);
        Post savedPost = postRepository.save(post);
        PostDto dto = mapToDto(savedPost);
        return dto;
    }

    @Override
    public void deletePostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(
                ()->new ResourceNotFound("post not found with id :"+id)
        );
        postRepository.deleteById(id);
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(
                ()->new ResourceNotFound("post not found with id:"+id)
        );
        return mapToDto(post);

    }

    @Override
    public PostDto updatePost(long id, PostDto postDto) {
        Post post = postRepository.findById(id).orElseThrow(
                ()->new ResourceNotFound("post not found with id:"+id)
        );
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
       Post savedPost =  postRepository.save(post);
       PostDto dto = mapToDto(savedPost);
        return dto;
    }

    PostDto mapToDto(Post savedPost){
        PostDto postDto = new PostDto();
        postDto.setId(savedPost.getId());
        postDto.setTitle(savedPost.getTitle());
        postDto.setDescription(savedPost.getDescription());
        postDto.setContent(savedPost.getContent());
        return postDto;
    }
    Post mapToEntity(PostDto postDto){
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }
}
