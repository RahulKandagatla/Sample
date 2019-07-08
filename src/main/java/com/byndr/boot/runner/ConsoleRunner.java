/*
 * @(#)ConsoleRunner.java
 * 
 * this runner was used for inserting some sample records in to student and marks table
 * and it executes only one time when Project is executed
 */

package com.byndr.boot.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.byndr.boot.entity.Marks;
import com.byndr.boot.entity.Student;
import com.byndr.boot.repository.MarksRepository;
import com.byndr.boot.repository.StudentRepository;

/**
 * this runner was used for inserting some sample records in to student and marks table
 * and it executes only one time when Project is executed
 * @author RAHUL
 * @category runner
 *
 */
@Component
public class ConsoleRunner implements CommandLineRunner {
	/**
	 * @see com.byndr.boot.repository.StudentRepository
	 */
	@Autowired
	StudentRepository studentRepo;
	
	/**
	 * @see com.byndr.boot.repository.MarksRepository
	 */
	@Autowired
	MarksRepository marksRepo;
	
	/* (non-Javadoc)
	 * @see org.springframework.boot.CommandLineRunner#run(java.lang.String[])
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED ,readOnly=false)
	public void run(String... args) throws Exception {
		/*insertion to student table*/
		studentRepo.save(new Student(1,"rahul", 520, 111, "rishi", 11, "1st"));
		studentRepo.save(new Student(2,"ajay", 550, 222, "oasis", 11, "1st"));
		studentRepo.save(new Student(3,"manoj", 430, 111, "rishi", 22, "2nd"));
		studentRepo.save(new Student(4,"uday", 333, 555, "model", 11, "1st"));
		studentRepo.save(new Student(5,"vishwa", 420, 333, "sunrise", 22, "2nd"));
		studentRepo.save(new Student(6,"madhu", 570, 111, "rishi", 11, "1st"));
		studentRepo.save(new Student(7,"arjun", 450, 555, "model", 33, "3rd"));
		studentRepo.save(new Student(8,"akil", 350, 111, "rishi", 44, "4th"));
		studentRepo.save(new Student(9,"ramesh", 300, 444, "spoorthi", 11, "1st"));
		Integer studentId=10;			//to test exception response i used it
		if(studentId== null) 
			throw new RuntimeException("Roll me back");
		studentRepo.save(new Student(studentId,"sohail", 350, 111, "rishi", 44, "4th"));
		studentRepo.save(new Student(11,"sabeel", 350, 111, "rishi", 33, "3th"));
		studentRepo.save(new Student(12,"bhagi", 350, 111, "rishi", 55, "5th"));
		studentRepo.save(new Student(13,"jona", 350, 111, "rishi", 44, "4th"));
		studentRepo.save(new Student(14,"surya", 350, 111, "rishi", 22, "2th"));
		studentRepo.save(new Student(15,"varun", 350, 111, "rishi", 11, "1th"));
		
		/* insertion to marks table */
		marksRepo.save(new Marks(1,555, 80, 20, 50, 90, 60, 70, null));
		marksRepo.save(new Marks(2,564, 80, 20, 50, 90, 60, 70, null));
		marksRepo.save(new Marks(3,520, 80, 20, 50, 90, 60, 70, null));
		marksRepo.save(new Marks(4,454, 80, 20, 50, 90, 60, 70, null));
		marksRepo.save(new Marks(5,464, 80, 20, 50, 90, 60, 70, null));
		marksRepo.save(new Marks(6,400, 80, 20, 50, 90, 60, 70, null));
		marksRepo.save(new Marks(7,300, 80, 20, 50, 90, 60, 70, null));
		marksRepo.save(new Marks(8,434, 80, 20, 50, 90, 60, 70, null));
		marksRepo.save(new Marks(9,421, 80, 20, 50, 90, 60, 70, null));
	}

}
