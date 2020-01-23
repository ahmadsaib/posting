package com.devskiller.tasks.blog.rest;

import com.devskiller.tasks.blog.model.dto.CommentDto;
import com.devskiller.tasks.blog.model.dto.NewCommentDto;
import com.devskiller.tasks.blog.model.dto.PostDto;
import com.devskiller.tasks.blog.service.CommentService;
import com.devskiller.tasks.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("/posts")
public class CommentController {

	private final CommentService commentService;

	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}

	@GetMapping(value = "/{id}/comments")
	@ResponseStatus(HttpStatus.OK)
	public List<CommentDto> getComments(@PathVariable Long id) {
		return commentService.getCommentsForPost(id);
	}

	@PostMapping(value = "/{id}/comments")
	@ResponseStatus(HttpStatus.CREATED)
	public Long newComment(@RequestBody NewCommentDto newCommentDto) {
		return commentService.addComment(newCommentDto);
	}
}
