package com.gn.service;

import java.util.List;

import com.gn.dao.StudentDao;
import com.gn.dto.Student;

public class StudentService {
	//DAO한테 부탁해서 데이터베이스에서 정보 조회,등록,수정,삭제
	private StudentDao dao = new StudentDao();
	
	public List<Student> getStudentList(){
		List<Student> list = dao.selectAll();
		return list;
	}
	
	public Student getStudentDetail(int studentNo) {
		Student student = dao.selectOne(studentNo);
		return student;
	}
	
	public List<Student> getStudentNameList(String name){
		List<Student> list = dao.selectName(name);
		return list;
	}
	
	public int insertStudent(String name, int age){
		// 1. Map : DTO에 없는 필드가 있을 경우, 3개 이하
		// 2. DTO(Student)
		Student param = new Student();
		param.setStudentName(name);
		param.setStudentAge(age);
		
		return dao.insert(param);
	}
	
	// 수정 -> 번호,이름, 나이 전달 받아올꺼에요
	// DAO한테 부탁할때는 Student 바구니에 담아서 전달 할꺼에요.
	// 결과는 int로 반환받고 싶어요
	
	public int updateStudent(int no, String name, int age) {
		Student par = new Student();
		par.setStudentNo(no);
		par.setStudentName(name);
		par.setStudentAge(age);
		
		return dao.update(par);
	}
	
	public int deleteStudent(int no) {
		Student del = new Student();
		del.setStudentNo(no);
		return dao.delete(del);
	}
}
