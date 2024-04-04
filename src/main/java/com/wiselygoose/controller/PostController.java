package com.wiselygoose.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wiselygoose.model.Post;
import com.wiselygoose.service.PostService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

	private final PostService postService;

	@GetMapping
	public String list(Model model) {
		List<Post> posts = postService.selectPostsList();

		model.addAttribute("posts", posts);

		return "posts/list";
	}

	@GetMapping("/{id}")
	public String detail(@PathVariable Long id, Model model) {
		Post post = postService.selectPostById(id);

		model.addAttribute("post", post);

		return "posts/detail";
	}

	@GetMapping("/create")
	public String createform(@ModelAttribute Post post) {
		return "posts/form";
	}

	@PostMapping("/create")
	public String processCreatePost(Post post) {
		postService.insertPost(post);

		return "redirect:/posts/" + post.getId();
	}

	@GetMapping("/{id}/edit")
	public String updateForm(@PathVariable Long id, Model model) {
		Post post = postService.selectPostById(id);

		model.addAttribute("post", post);

		return "posts/form";
	}

	@PostMapping("/{id}/edit")
	public String processUpdatePost(@PathVariable Long id, Post post) {
		postService.updatePost(post);

		return "redirect:/posts/" + post.getId();
	}

	@PostMapping("/{id}/delete")
	public String processDeletePost(@PathVariable Long id) {
		postService.deletePostById(id);

		return "redirect:/posts";
	}

}
