package com.logo.service;

import com.logo.entity.Comment;
import com.logo.entity.Post;
import com.logo.exception.ResourceNotFound;
import com.logo.payload.CommentDto;
import com.logo.repository.CommentRepository;
import com.logo.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{
    private CommentRepository commentRepo;
    private PostRepository postRepository;

    public CommentServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public CommentServiceImpl(CommentRepository commentRepo) {
        this.commentRepo = commentRepo;
    }

    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        Post post = postRepository.findById(postId).orElseThrow(
                ()->new ResourceNotFound("post not found with id :"+postId)
        );
        Comment comment = mapToEntity(commentDto);
        comment.setPost(post);
        Comment c = commentRepo.save(comment);

        return mapToDto(c);
    }
    Comment mapToEntity(CommentDto commentDto){
        Comment comment = new Comment();
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());
        return comment;
    }
    CommentDto mapToDto(Comment comment){
        CommentDto dto = new CommentDto();
       dto.setName(comment.getName());
        dto.setEmail(comment.getEmail());
        dto.setEmail(comment.getEmail());
        return dto;
    }
}
