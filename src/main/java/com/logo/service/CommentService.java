package com.logo.service;

import com.logo.entity.Post;
import com.logo.payload.CommentDto;

public interface CommentService {
   public  CommentDto createComment(long postId, CommentDto commentDto);
}
