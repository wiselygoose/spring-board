package com.wiselygoose.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.wiselygoose.model.Criteria;
import com.wiselygoose.model.Post;

@Mapper
public interface PostMapper {

	void insertPost(Post post);

	List<Post> selectPostsList(Criteria criteria);

	int selectPostsCount();

	Post selectPostById(Long id);

	void updatePost(Post post);

	void deletePostById(Long id);
}
