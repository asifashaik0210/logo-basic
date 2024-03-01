package com.logo.controller;

import com.logo.payload.CommentDto;
import com.logo.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping
    public ResponseEntity<CommentDto> createComment(@RequestParam long postid,
                                                    @RequestBody CommentDto commentDto){
        CommentDto dto = commentService.createComment(postid, commentDto);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
