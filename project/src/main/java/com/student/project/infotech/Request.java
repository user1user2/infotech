package com.student.project.infotech;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Request {
	
	
	@Autowired
	private  StudentRepo studentRepo;


	@GetMapping("/students")
	public  ResponseEntity<?> getStudents(){
		List<Student> out = studentRepo.findAll();
		return new ResponseEntity<>(out,HttpStatus.OK);
		
		
	}
	//pathParam , pathVariable
	
	@GetMapping("/marks/{id}")
	public ResponseEntity<?> getStudent(@PathVariable int id){
		Optional<Student> s = studentRepo.findById(id);
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
	

	
	
	@PostMapping("/student")
	public ResponseEntity<?> addSt(@RequestBody Student stu){
		float sum = stu.getMath()+stu.getChem()+stu.getScience();
		stu.setMarks(sum);
		stu.setPercent((sum/300)*100);
		if(studentRepo.existsById(stu.getRollno())) {
			return new ResponseEntity<>("Ths Student already exists",HttpStatus.OK);
		}
		studentRepo.save(stu);
		return new ResponseEntity<>("The Student added succesfull ID : "+stu.getRollno(),HttpStatus.OK);
		
	}
	
	
	@PutMapping("/marks/{id}")
	public ResponseEntity<?> updateS(@PathVariable int id, @RequestBody Student stu){
		if(studentRepo.existsById(id)) {
			float sum = stu.getMath()+stu.getChem()+stu.getScience();
			stu.setMarks(sum);
			stu.setPercent((sum/300)*100);
			studentRepo.save(stu);
			return new ResponseEntity<>("Student succesfully updated with ID :"+stu.getRollno(),HttpStatus.OK);
		}else {
			return new ResponseEntity<>("No student exist with ID :"+stu.getRollno(),HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> studentR(@PathVariable int id){
	
		if(studentRepo.existsById(id)) {
			studentRepo.deleteById(id);
			return new ResponseEntity<>("Student deleted sucessfully ID :"+id,HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>("Student not exist ID :"+id,HttpStatus.OK);
		}
	}
	
	
	
	
	
	
	
	
	
	
//	@PutMapping("/percent/{id}")
//	public ResponseEntity<?> student(@PathVariable int id, @RequestParam("su") List<Integer> data){
//		Student s  = (Student)studentRepo.getReferenceById(id);
//		int sum = 0;
//		for(int i : data) {
//			sum = sum+i;
//		}
//		
//		s.setMarks(sum);
//		float p = ((float)sum/300)*100 ;
//		
//
//		
//
//		s.setPercent(p);
//		studentRepo.save(s);
//		return new ResponseEntity<>(s.getPercent()+"student percentage", HttpStatus.OK);
//	}

	
//	@PostMapping("/")
//	public  ResponseEntity<?> addStudent(@RequestBody Student st){
//		studentRepo.save(st);
//		
//		return new ResponseEntity<>("Student Added Succesfully",HttpStatus.OK);
//		
//	}
	
	
//	@PostMapping("/sub")
//	public ResponseEntity<?> addStudent(@RequestBody Student s,@RequestParam("su") List<Integer> sub){
//		int sum = 0;
//		for(int i : sub) {
//			sum = sum+i;
//		}
//		s.setMarks(sum);
//		s.setPercent((sum/300)*100);
//		studentRepo.save(s);
//		return new ResponseEntity<>(s.getPercent(),HttpStatus.OK);
//	}
	
	
//	
//	public Request(StudentRepo studentRepo){
//		this.studentRepo= studentRepo;
//	}
	
}
