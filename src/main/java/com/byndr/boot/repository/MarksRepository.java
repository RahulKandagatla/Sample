/*  @(#)MarksRepository.java
 * 
 * communicates with Marks table in db
*/
package com.byndr.boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.byndr.boot.entity.Marks;

/**
 * interface communicates with Marks table in db
 * 
 * @author RAHUL
 * @category repository
 *
 */
public interface MarksRepository extends JpaRepository<Marks, Integer> {

	/**
	 * retrieves total marks of a student by studentId
	 * @param studentId
	 * @return only totalMarks
	 */
	@Query(value ="select m.totalMarks from Marks m where m.studentId= :studentId")
	public Integer findtotalMarks(Integer studentId );
	
	
	/**
	 * Dynamic Projection 
	 * interface for only sending {@code english,hindi,telugu} inspite of 
	 * sending all varibles in marks object
	 * @author RAHUL
	 *
	 */
	interface Languages{
		
		Integer getEnglish();
		Integer getHindi();
		Integer getTelugu();
	}
	
	/**
	 * @param clz
	 * @param studentId
	 * @return student
	 */
	public <Student> List<Student> findByStudentId(Class<Student> student, Integer studentId);
	
	/**
	 * retrieve only languages marks by studentId
	 * @param studentId
	 * @return english,hindi,telugu marks
	 */
	@Query(value="select english,hindi,telugu from Marks  where student_id= :studentId", nativeQuery=true)
	public List<Object[]> findAllLanguages( Integer studentId);
}
