package com.gl.javafsd.studentmanager.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gl.javafsd.studentmanager.entity.Student;

@Repository
public class StudentServiceImpl implements StudentService {

	private Session session;

	@Autowired
	StudentServiceImpl(SessionFactory sessionFactory) {
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException exception) {
			session = sessionFactory.openSession();

		}
	}

	@Override
	@Transactional
	public List<Student> listAll() {
		Transaction transaction = session.beginTransaction();
		List<Student> students = session.createQuery("from Student").list();
		transaction.commit();
		return students;
	}

	@Transactional
	public void save(Student student) {
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(student);
		transaction.commit();
	}
	
	@Transactional
	public Student findById(int id) {
		Student student = new Student();
		Transaction transaction = session.beginTransaction();
		student = session.get(Student.class, id);
		transaction.commit();
		return student;
		}
	
	@Transactional
    public void deleteById(int id) {
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.delete(student);
        transaction.commit();
    }
	
    @Transactional
	public List<Student> searchBy(String name, String department) {
		Transaction transaction = session.beginTransaction();
		String hiberateQuery = "";		
		if (name.length() != 0 && department.length() != 0) {			
			// name like '%A%'
			hiberateQuery = "from Student where name like '%" + name + "%'" +
					" or author like '%" + department + "%'";				
		}else if (name.length() != 0) {
			hiberateQuery = "from Student where name like '%" + name + "%'";
		}else if (department.length() != 0) {
			hiberateQuery = "from Student where department like '%" + department + "%'";
		}else {
			System.out.println("Control wont come here...");
		}
		
		List<Student> students = session.createQuery(hiberateQuery).list();
		
		transaction.commit();				

		return students;
	}

	


}
