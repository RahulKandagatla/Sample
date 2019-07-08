/* @(#)StudentRepository.java

interface communicates with Student table in db
*/
package com.byndr.boot.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.byndr.boot.entity.Student;

/**
 * interface communicates with Student table in db
 * @author RAHUL
 * @category repository
 *
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {

	
	/**
	 * @return school id
	 */
	@Query(value="select DISTINCT s.schoolId from Student s ")
	public List<Integer> findAllSchools();
	
	/**
	 * @param schoolId
	 * @return class id
	 */
	@Query("select DISTINCT s.classId from Student s where s.schoolId= :schoolId")
	public List<Integer> findAllClassesOfSchool(Integer schoolId );
	
	/**
	 * @param classId
	 * @param schoolId
	 * @return students of that schoolId and classId
	 */
	@Query(value="select s.studentId from Student s where s.classId= :classId and s.schoolId= :schoolId")
	public List<Integer> findAllStudentsOfClass(Integer classId,Integer schoolId);// check nativeQuery
	
	/**
	 * @param studentId
	 * @return student name 
	 */
	@Query("select s.studentName from Student s where s.studentId= :studentId")
	public String findStudentName(Integer studentId);
	
	/**
	 * @param schoolId
	 * @param pageable
	 * @return students of that school according to page number passed
	 */
	@Query("select s from Student s where s.schoolId= :schoolId")
	public Page<Student> findBySchoolId(Integer schoolId, Pageable pageable);
	
}
