/*
 *  @(#)Student.java
 * 
 * entity/model class represents table Student in db
 */

package com.byndr.boot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * entity/model class represents table Student in db
 * @author RAHUL
 * @category Entity 
 *
 */
@Entity
public class Student {
	@Id
	//@GeneratedValue
	private Integer studentId;
	private String  studentName;
	private Integer studentMarks;
	private Integer schoolId;
	private String  schoolName;
	private Integer classId;
	private String  className;
	
	public Student() {
		super();
	}
	
	public Student(Integer studentId, String studentName, Integer studentMarks, Integer schoolId, String schoolName,
			Integer classId, String className) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentMarks = studentMarks;
		this.schoolId = schoolId;
		this.schoolName = schoolName;
		this.classId = classId;
		this.className = className;
	}
	
	public Student(String studentName, Integer studentMarks, Integer schoolId, String schoolName, Integer classId,
			String className) {
		super();
		this.studentName = studentName;
		this.studentMarks = studentMarks;
		this.schoolId = schoolId;
		this.schoolName = schoolName;
		this.classId = classId;
		this.className = className;
	}
	
	public Integer getStudentId() {
		return studentId;
	}
	
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	public Integer getStudentMarks() {
		return studentMarks;
	}
	
	public void setStudentMarks(Integer studentMarks) {
		this.studentMarks = studentMarks;
	}
	
	public Integer getSchoolId() {
		return schoolId;
	}
	
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	
	public String getSchoolName() {
		return schoolName;
	}
	
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	public Integer getClassId() {
		return classId;
	}
	
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	
	public String getClassName() {
		return className;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentMarks=" + studentMarks
				+ ", schoolId=" + schoolId + ", schoolName=" + schoolName + ", classId=" + classId + ", className="
				+ className + "]";
	}
	
	

}
