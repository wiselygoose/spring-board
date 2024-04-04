package com.wiselygoose.model;

import lombok.Getter;

@Getter
public class Pagination {

	/**
	 * 시작 페이지 번호
	 */
	private int start;

	/**
	 * 끝 페이지 번호
	 */
	private int end;

	/**
	 * 이전, 다음 페이지 존재 여부
	 */
	private boolean prev, next;

	/**
	 * 전체 데이터 수
	 */
	private int total;

	private Criteria criteria;

	public Pagination(int total, Criteria criteria) {
		this.total = total;
		this.criteria = criteria;
		this.end = (int) (Math.ceil(criteria.getPage() / 10.0)) * 10;
		this.start = this.end - 9;

		int actuallyEnd = (int) (Math.ceil((total * 1.0) / criteria.getAmount()));

		if (actuallyEnd < this.end) {
			this.end = actuallyEnd;
		}

		this.prev = this.start > 1;
		this.next = this.end < actuallyEnd;
	}

}
