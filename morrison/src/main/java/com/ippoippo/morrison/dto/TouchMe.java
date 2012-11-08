package com.ippoippo.morrison.dto;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;

public class TouchMe implements Serializable {

	private static final long serialVersionUID = -2274802222305717128L;

	//@NotEmpty
	//@Digits(integer=8, fraction=0)
	@Min(1)
	@Max(99999999)
	Integer id;

	@Length(min=1, max=16)
	String name;

	Boolean touch;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TouchMe other = (TouchMe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "touchme [id=" + id + ", name=" + name + ", touch=" + touch + "]";
	}
	public Boolean isTouch() {
		return touch;
	}
	public void setTouch(Boolean touch) {
		this.touch = touch;
	}
}
