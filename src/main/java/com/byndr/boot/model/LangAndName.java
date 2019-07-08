/*
 *  @(#)LangName.java
 * 
 * class for only sending {@code name,english,hindi,telugu} inspite of 
 * sending all varibles in marks object
 */

package com.byndr.boot.model;

import org.springframework.stereotype.Component;

/**
 * class for only sending {@code name,english,hindi,telugu} inspite of 
 * sending all varibles in marks object
 * @author RAHUL
 * @category customizedModel
 */
@Component
public class LangAndName{
	
	private String name;
	private Integer english;
	private Integer hindi;
	private Integer telugu;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getEnglish() {
		return english;
	}
	public void setEnglish(Integer english) {
		this.english = english;
	}
	public Integer getHindi() {
		return hindi;
	}
	public void setHindi(Integer hindi) {
		this.hindi = hindi;
	}
	public Integer getTelugu() {
		return telugu;
	}
	public void setTelugu(Integer telugu) {
		this.telugu = telugu;
	}
	public LangAndName(String name, Integer english, Integer hindi, Integer telugu) {
		super();
		this.name = name;
		this.english = english;
		this.hindi = hindi;
		this.telugu = telugu;
	}
	@Override
	public String toString() {
		return "LangAndName [Name=" + name + ", english=" + english + ", hindi=" + hindi + ", telugu=" + telugu + "]";
	}
	public LangAndName() {
		super();
	}
	
}


