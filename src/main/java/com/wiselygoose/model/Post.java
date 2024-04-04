package com.wiselygoose.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Post {

	private Long id;

	private String title;

	private String contents;

	private String writer;

	private LocalDateTime createdDate;

	private LocalDateTime lastModifiedDate;

}
