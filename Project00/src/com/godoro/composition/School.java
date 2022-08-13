package com.godoro.composition;

import java.util.List;

public class School {
	
	private long schoolId;
	
	private String schoolName;
	
	private List<Student> studentList;

	public School(long schoolId, String schoolName) {
		this.schoolId = schoolId;
		this.schoolName = schoolName;
	}

	public long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(long schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	
}
