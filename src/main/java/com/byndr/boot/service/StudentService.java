/*@(#)StudentService.java			11-03-2019
 * 
 * copyright (c) 2016-20 Byndr.com
 * 
 * handles business logic & communicates with controller and repository
*/

package com.byndr.boot.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.byndr.boot.entity.Marks;
import com.byndr.boot.entity.Student;
import com.byndr.boot.model.LangAndName;
import com.byndr.boot.repository.MarksRepository;
import com.byndr.boot.repository.StudentRepository;
/**
 * handles business logic & communicates with controller and repository
 * @author	 RAHUL
 * @category service
 */
@Service
public class StudentService {

	private static final Logger log = LogManager.getLogger("StudentService.class");
	
	@Autowired
	public StudentRepository studentRepo;
	
	@Autowired
	public MarksRepository marksRepo;
	
	@Autowired
	LangAndName ln;
	
	public Integer studentId;
	Optional<Marks> marks = null;
	
	/**
	 * 
	 * @param pageNum
	 * @return student
	 * @throws InterruptedException
	 */
	public Stream<Student> findAllStudentsService(Integer pageNum) throws InterruptedException {
		
		long start = System.currentTimeMillis();
		
		/* retrieving all schoolId*/
		List<Integer> listSchools = studentRepo.findAllSchools(); 
		log.info("------------ {}", listSchools);
		Integer schoolId = listSchools.get(0);
		
		/* passing first schoolId and finding all the classes with that schoolId*/
		List<Integer> listClasses = studentRepo.findAllClassesOfSchool(schoolId);
		log.info("------------ {}", listClasses);
		Integer classId=listClasses.get(0);
		
		/* passing first classId and its schoolId to retrieve the students */
		List<Integer>	listStudents = studentRepo.findAllStudentsOfClass(classId,schoolId);
		log.info("------------ {}", listStudents);
		
		/* storing first studentId from class */
		 studentId = listStudents.get(0);
		log.info("------------ {}", studentId);
		
		/* two independent parts are parallelly executed with two threads */
		// Thread one executes and returns only totalmarks
		
		Runnable r1 = () -> {
			long start1 = System.currentTimeMillis();
			Integer totalMarks = marksRepo.findtotalMarks(studentId);
			log.info("------------ {}", totalMarks);
			log.info("time taken by [[thread 1]]    ++++++++++++++++++++> {}",
					System.currentTimeMillis()-start1);
		};
		new Thread(r1).start();
		
		//Thread two executes and returns all subject marks
		
		Runnable r2 = () -> {
			long start2 = System.currentTimeMillis();
			marks = marksRepo.findById(studentId);
			Marks marksList=marks.get();
			log.info("------------ {}",marksList);
			log.info("time taken by [[thread 2]]   +++++++++++++++++++++++> {}",
					System.currentTimeMillis()-start2);
		};
		new Thread(r2).start();
		
		//making main thread to sleep for 200ms to execute above both threads and initialises Marks object mo
		
		Thread.sleep(200);
		log.info("time taken by [[thread Main]]  +++++++++++++++++++++++> {}",
				System.currentTimeMillis() - start);
		  List<Object[]> lang=marksRepo.findAllLanguages(studentId); 
		  String studentName=studentRepo.findStudentName(studentId);
		  log.info("{}", lang.size());
		  ln.setName(studentName);
		  ln.setEnglish((Integer)lang.get(0)[0]);
		  ln.setHindi((Integer)lang.get(0)[1]);
		  ln.setTelugu((Integer)lang.get(0)[2]);
		/*
		 * we can get to service by projections of selected cloumns of
		 * Integer,String,Double... to pass Integer,String,Double,... to Controller in
		 * list object[]
		 */		 
		 // marksRepo.findAll()
		  
		 Page<Student> page = studentRepo.findBySchoolId(111, PageRequest.of(pageNum, 3));		 
		 Stream<Student> sorted = page.stream().sorted((s1, s2)->s2.getStudentId()
								.compareTo(s1.getStudentId()));		 
		  return sorted;	
	}
	
	/**
	 * one object = one record/row in a db
	 * creating three objects and inserting into db
	 * @return success statemnent
	 */
	@SuppressWarnings("unused")
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String updateStudentName() {
		String studentName ="Vinod";
		studentRepo.save(new Student(8, studentName, 350, 111, "rishi", 44, "4th"));
		studentName = "Ramu";
		studentRepo.save(new Student(10, studentName, 350, 111, "rishi", 44, "4th"));
		studentName = null;
		log.info("------");
		
		if (studentName == null) {
			throw new RuntimeException("transaction had rollback");
		}
		studentRepo.save(new Student(14, studentName, 350, 111, "rishi", 44, "4th"));
		log.info("------");
		return "success";
	}	
}





