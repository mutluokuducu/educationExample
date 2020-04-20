package com.education.controller;

import com.education.dto.StudentMarkDto;
import com.education.dto.StudentsDto;
import com.education.repository.entity.StudentMark;
import com.education.repository.entity.Students;
import com.education.service.StudentMarkService;
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
public class StudentMarkController {

  @Autowired
  private StudentMarkService studentMarkService;


  @RequestMapping(value = "/studentMark", method = RequestMethod.GET)
  public List<StudentMark> getAllStudentMark() {
    return studentMarkService.getAllMark();

  }

  @RequestMapping(value = "/studentMark/{studentId}", method = RequestMethod.POST)
  public ResponseEntity<StudentMarkDto> setStudent(@RequestBody StudentMarkDto studentsDto,
      @PathVariable Integer studentId) {
    studentMarkService.setStudentMark(studentsDto, studentId);

    List<StudentMark> getAllList = studentMarkService.getAllMark();
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
    *C:CREATE =POST
    *R:READ =GET
    U:UPDATE=UPDATE
    *D:DELETE=DELETE


  }
 */