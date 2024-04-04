package com.wiselygoose.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Criteria {

	/**
	 * 현재 페이지 번호
	 */
	private int page;

	/**
	 * 한 화면에 표시할 페이지 수
	 */
	private int amount;

	/**
	 * 검색한 단어
	 */
	private String keyword;

	/**
	 * 검색 유형
	 */
	private String type;

	public Criteria() {
		this.page = 1;
		this.amount = 10;
	}

	public Criteria(int page, int amount, String keyword, String type) {
		this.page = page;
		this.amount = amount;
		this.keyword = keyword;
		this.type = type;
	}

	public int getLimit() {
		return (page - 1) * this.amount;
	}

}
