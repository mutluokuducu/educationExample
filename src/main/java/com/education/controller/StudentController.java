package com.education.controller;

import com.education.dto.StudentsDto;
import com.education.repository.StudentRepository;
import com.education.repository.entity.Students;
import com.education.service.StudentService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping(value = "/v1")
public class StudentController {

  @Autowired
  private StudentService studentService;


  @RequestMapping(value = "/student", method = RequestMethod.GET)
  public List<Students> getAllStudent() {
    System.out.printf("test123");
    return studentService.getAllStudent();

  }

  @RequestMapping(value = "/student/{studentName}", method = RequestMethod.GET)
  public ResponseEntity<?> getStudent(@PathVariable String studentName) {
    Optional<Students> students = studentService.getStudent(studentName);
    if (students.isPresent()) {
      return new ResponseEntity(students, HttpStatus.OK);

    } else {
      return new ResponseEntity(students, HttpStatus.NOT_FOUND);
    }
  }

  @RequestMapping(value = "student/{id}", method = RequestMethod.DELETE)
  public ResponseEntity<?> deleteStudentById(@PathVariable Integer id){
    studentService.deleteStudentById(id);
    List<Students> getAllList=studentService.getAllStudent();
    return new ResponseEntity(getAllList, HttpStatus.OK);
  }

  @RequestMapping(value = "student", method = RequestMethod.POST)
  public ResponseEntity<StudentsDto> setStudent(@RequestBody StudentsDto studentsDto){
    studentService.setStudent(studentsDto);

    List<Students> getAllList=studentService.getAllStudent();
    return new ResponseEntity(getAllList, HttpStatus.OK);
  }

}
/*

@RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public ResponseEntity<?> createBook(@RequestBody BookDto bookDto) throws URISyntaxException {

        BookDto newBook = bookService.createBook(bookDto);
        return new ResponseEntity<>(newBook, HttpStatus.OK);

    }



 @RequestMapping(value = "/student/{studentName}", method = RequestMethod.GET)
  public ResponseEntity<?> getStudent(@PathVariable String studentName) {
    Optional<Students> students= studentService.getStudent(studentName);
    return new ResponseEntity(students, HttpStatus.OK);

    CRUD :
    C:CREATE =POST
    R:READ =GET
    U:UPDATE=UPDATE
    D:DELETE=DELETE


  }
 */