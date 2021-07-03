package com.raghul.expensetracker.dto;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class ResponseDTO<T> {
	
	private Integer from;
	private Integer size;
	private Integer total;
	private List<T> data;
	private T datum;
	public Integer getFrom() {
		return from;
	}
	public void setFrom(Integer from) {
		this.from = from;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public T getDatum() {
		return datum;
	}
	public void setDatum(T datum) {
		this.datum = datum;
	}

	
}
