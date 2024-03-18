package StudentWithServlet3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;



import StudentWithServlet3.dto.Student;

public class StudentDao  {
	
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("vinod").createEntityManager();
		
	}
	
	public void saveStudent(Student student) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		}
	
	public List<Student>getAllStudents(){
		EntityManager entityManager=getEntityManager();
		Query query = entityManager.createQuery("Select s from Student s");
		List<Student>list=query.getResultList();
		return list;
		
	}
	
	public Student getStudentById(int id) {
		EntityManager entityManager = getEntityManager();
		Student student=entityManager.find(Student.class, id);
		if(student!=null) {
//			id is present
			return student;
		}else {
			return null;
		}
	}
	public Student deleteStudent(int id) {
		EntityManager entityManager = getEntityManager();
		Student student=entityManager.find(Student.class, id);
		if(student!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
			return student;
		}
		return null;
	}
	
	public Student updateStudent(int id, Student student) {
		EntityManager entityManager = getEntityManager();
		Student dbStudent=entityManager.find(Student.class, id);
		if(dbStudent!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			
			student.setId(id);
			entityManager.merge(student);
			entityTransaction.commit();
			return student;
		}
		return null;
	}
	
}
