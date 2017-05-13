package com.zhuoshi.Test.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.zhuoshi.Test.DB.DBsource;
import com.zhuoshi.Test.bean.Student;

public class Studao {

	
	@Test
	public List<Student> SelectAll() {
		
		List<Student>students = new ArrayList<Student>();
		DBsource dBsource = new DBsource();
		SqlSession sqlSession = dBsource.getSession();
		students = sqlSession.selectList("student.SelectAll");
		sqlSession.close();
		
		return students;
	}
	
public Student SelectOne(int id) {
		
		Student student = new Student();
		DBsource dBsource = new DBsource();
		SqlSession sqlSession = dBsource.getSession();
		student = sqlSession.selectOne("SelectOne", 101);
		sqlSession.close();
		
		return student;
	}

public int DeleteOne(int id) {
	
	int rows=0;
	DBsource dBsource = new DBsource();
	SqlSession sqlSession = dBsource.getSession();
	rows = sqlSession.delete("DeleteOne", 101);
	sqlSession.commit();
	sqlSession.close();
	
	return rows;
}

public int Insert(Student student) {
	
	int rows=0;
	DBsource dBsource = new DBsource();
	SqlSession sqlSession = dBsource.getSession();
	rows = sqlSession.insert("Insert", student);
	sqlSession.commit();
	sqlSession.close();
	
	return rows;
}

public Student SelectOnes(Student stu) {
	
	Student student = new Student();
	DBsource dBsource = new DBsource();
	SqlSession sqlSession = dBsource.getSession();
	student = sqlSession.selectOne("SelectOnes", stu);
	sqlSession.close();
	
	return student;
}




	public static void main(String[] args) {
		Studao studao = new Studao();
		Student student = new Student();
		/*List<Student>list=new Studao().SelectAll();
		for (Student student : list) {
			System.out.println(student.getName());
		}
		
		Student student = new Studao().SelectOne(101);
		System.out.println(student.getName());
	
		if (studao.DeleteOne(101)>0) {
			System.out.println("…æÔøΩÔøΩÔøΩ…πÔøΩ");
		}
		else {
			System.out.println("…æÔøΩÔøΩ ßÔøΩÔøΩ");
			
		}
		Student student = new Studao().SelectOne(101);
		System.out.println(student.getName());*/
	/*	student.setId(11140);
		student.setName("∏¬ «µƒª∞æÕø™ º");
		student.setAge("75");
		if (studao.Insert(student)>0) {
			System.out.println("ÃÌº”≥…π¶");
		}
		else {
			System.out.println("ÃÌº” ß∞‹");
		}*/
		Student s= new Student();
		s.setName("¿ÓÀ∂");
		student=studao.SelectOnes(s);
		System.out.println(student.getName()+"\t"+student.getAge());
	}
}
