/* @(#)StudentController.java

StudentController handles http request and responses*/

package com.byndr.boot.controller;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.byndr.boot.entity.Student;
import com.byndr.boot.service.StudentService;

/**
 * handles HTTP request and responses
 * @author RAHUL
 * @version 1.0.0
 * @category restcontroller
 *
 */
@RestController
public class StudentController {
	/**
	 * Depends on service
	 */
	@Autowired 
	StudentService service;

	/**
	 * @param pageNum
	 * @return students in List
	 * @throws InterruptedException
	 */
	@RequestMapping("/students/{pageNum}")
	@ResponseBody
	public Stream<Student> findAllStudents(@PathVariable Integer pageNum) throws InterruptedException
	{
		return service.findAllStudentsService(pageNum);
	}
	
	
	/**
	 * @return String 
	 * @throws InterruptedException
	 */
	@RequestMapping("/transact")
	@ResponseBody
	public String updateStudentName() throws InterruptedException
	{
		return service.updateStudentName();
	}
	
}
