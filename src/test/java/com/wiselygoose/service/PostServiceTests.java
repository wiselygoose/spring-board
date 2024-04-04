package com.wiselygoose.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wiselygoose.model.Post;

@SpringBootTest
class PostServiceTests {

	@Autowired
	private PostService postService;

	@Test
	void test() {
		Post post1 = new Post();
		post1.setTitle("테스트1");
		post1.setContents("나랏말싸미 듕귁에 달아...");
		post1.setWriter("USER1");

		postService.insertPost(post1);

		Post result1 = postService.selectPostById(post1.getId());

		assertEquals(post1.getTitle(), result1.getTitle());
		assertEquals(post1.getContents(), result1.getContents());
		assertEquals(post1.getWriter(), result1.getWriter());

		Post post2 = new Post();
		post2.setId(post1.getId());
		post2.setTitle("테스트2");
		post2.setContents("문자와로 서르 사맛디 아니할쎄");
		post2.setWriter("USER2");

		postService.updatePost(post2);

		Post result2 = postService.selectPostById(post1.getId());

		assertEquals(post2.getTitle(), result2.getTitle());
		assertEquals(post2.getContents(), result2.getContents());
		assertEquals(post2.getWriter(), result2.getWriter());
	}

}
