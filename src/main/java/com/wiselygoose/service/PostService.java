package com.wiselygoose.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wiselygoose.model.Criteria;
import com.wiselygoose.model.Post;
import com.wiselygoose.repository.PostMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

	private final PostMapper postMapper;

	public void insertPost(Post post) {
		postMapper.insertPost(post);
	}

	public List<Post> selectPostsList(Criteria criteria) {
		return postMapper.selectPostsList(criteria);
	}

	public int selectPostsCount() {
		return postMapper.selectPostsCount();
	}

	public Post selectPostById(Long id) {
		return postMapper.selectPostById(id);
	}

	public void updatePost(Post post) {
		postMapper.updatePost(post);
	}

	public void deletePostById(Long id) {
		postMapper.deletePostById(id);
	}

}
