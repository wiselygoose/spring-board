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

	public Criteria() {
		this.page = 1;
		this.amount = 10;
	}

	public Criteria(int page, int amount) {
		this.page = page;
		this.amount = amount;
	}

	public int getLimit() {
		return (page - 1) * this.amount;
	}

}
