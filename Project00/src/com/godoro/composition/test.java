package com.godoro.composition;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {

		School schoolA = new School(801, "Godoro Üniversitesi");
		schoolA.setStudentList(new ArrayList<>());
		
		Student student1 = new Student(401,"Teoman Alpay",46.7);
		student1.setSchool(schoolA);
		schoolA.getStudentList().add(student1);
		
		Student student2 = new Student(402,"Yusuf Nalkesen",78.9);
		student2.setSchool(schoolA);
		schoolA.getStudentList().add(student2);
		
		Student student3 = new Student(402,"Avni Anıl",66.1);
		student3.setSchool(schoolA);
		schoolA.getStudentList().add(student3);
		
		System.out.println(schoolA.getSchoolId() + " " + schoolA.getSchoolName());
		for(Student student : schoolA.getStudentList()) {
			System.out.println("\t" + student.getStudentId() + " "
					+student.getStudentName() + " "
					+student.getAverageMark());
		}
	}

}
