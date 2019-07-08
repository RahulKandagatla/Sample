/*
 *  @(#)Marks.java
 * 
 * entity/model class represents table Marks in db
 */

package com.byndr.boot.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
/**
 * entity/model class represents table Marks in db
 * @author RAHUL
 * @category Entity 
 *
 */
@Entity
public class Marks {

	@Id
	//@GeneratedValue
	private Integer studentId;
	private Integer totalMarks;
	private Integer english;
	private Integer hindi;
	private Integer telugu;
	private Integer maths;
	private Integer physics;
	private Integer chemistry;
	
	@OneToOne(cascade=CascadeType.ALL)//update in both table
	@JoinColumn(name="studentId",referencedColumnName="student_id")
	private Student student;

	public Marks() {
		super();
	}

	/**
	 * @param studentId
	 * @param totalMarks
	 * @param english
	 * @param hindi
	 * @param telugu
	 * @param maths
	 * @param physics
	 * @param chemistry
	 * @param student
	 */
	public Marks(Integer studentId, Integer totalMarks, Integer english, Integer hindi, Integer telugu, Integer maths,
			Integer physics, Integer chemistry, Student student) {
		super();
		this.studentId = studentId;
		this.totalMarks = totalMarks;
		this.english = english;
		this.hindi = hindi;
		this.telugu = telugu;
		this.maths = maths;
		this.physics = physics;
		this.chemistry = chemistry;
		this.student = student;
	}

	public Marks(Integer totalMarks, Integer english, Integer hindi, Integer telugu, Integer maths, Integer physics,
			Integer chemistry, Student student) {
		super();
		this.totalMarks = totalMarks;
		this.english = english;
		this.hindi = hindi;
		this.telugu = telugu;
		this.maths = maths;
		this.physics = physics;
		this.chemistry = chemistry;
		this.student = student;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(Integer totalMarks) {
		this.totalMarks = totalMarks;
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

	public Integer getMaths() {
		return maths;
	}

	public void setMaths(Integer maths) {
		this.maths = maths;
	}

	public Integer getPhysics() {
		return physics;
	}

	public void setPhysics(Integer physics) {
		this.physics = physics;
	}

	public Integer getChemistry() {
		return chemistry;
	}

	public void setChemistry(Integer chemistry) {
		this.chemistry = chemistry;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Marks [studentId=" + studentId + ", totalMarks=" + totalMarks + ", english=" + english + ", hindi="
				+ hindi + ", telugu=" + telugu + ", maths=" + maths + ", physics=" + physics + ", chemistry="
				+ chemistry + ", student=" + student + "]";
	}
	
	
	
}