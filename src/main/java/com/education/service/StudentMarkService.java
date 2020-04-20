package com.education.service;

import com.education.dto.StudentMarkDto;
import com.education.dto.StudentsDto;
import com.education.exeption.StudentException;
import com.education.repository.StudentMarkRepository;
import com.education.repository.StudentRepository;
import com.education.repository.entity.StudentMark;
import com.education.repository.entity.Students;
import com.education.utility.RoundUp;
import com.education.utility.StudentIdGenerator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import javassist.NotFoundException;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentMarkService {

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private StudentMarkRepository studentMarkRepository;

  public List<StudentMark> getAllMark() {

    Iterable<StudentMark> studentsList = studentMarkRepository.findAll();
    return (List<StudentMark>) studentsList;
  }
/*
  public void setStudentMark(StudentMarkDto studentMarkdto, Integer studentId) {
    Optional<Students> studentOpt = studentRepository.findByStudentId(studentId);



    if (studentOpt.isPresent()) {

      StudentMark studentMarks = new StudentMark();

      List<Integer> list = new ArrayList<>();
      list.add(studentMarkdto.getMark1());
      list.add(studentMarkdto.getMark2());
      list.add(studentMarkdto.getMark3());

      Double average = list
          .stream()
          .mapToDouble(x -> x.doubleValue())
          .average()
          .orElse(0.0);

      studentMarks.setStudentId(studentId);
      studentMarks.setMark1(studentMarkdto.getMark1());
      studentMarks.setMark2(studentMarkdto.getMark2());
      studentMarks.setMark3(studentMarkdto.getMark3());
      studentMarks.setLesson(studentMarkdto.getLesson());
      studentMarks.setAverage(RoundUp.roundUpTwo(average));
      //create method for letter
      /*
      avg>=80 A
      avg>=60 between avg<80 B
      avg>=40 between avg<60 C
      avg<40 D


      List<String> list1=new ArrayList();
      List<String> list12=new LinkedList<>();

      Set<String> set=new HashSet<>();

      studentMarkRepository.save(studentMarks);
    }
  }

 */



  //lambd examle

  public void setStudentMark(StudentMarkDto studentMarkdto, Integer studentId)
      throws StudentException {
    studentRepository.findByStudentId(studentId)
        .ifPresentOrElse(students ->
            {
              setMark(studentMarkdto, studentId);
            },
            () -> {
              throw new StudentException("Student not founded:" + studentId);
            });
  }



  private void setMark(StudentMarkDto studentMarkdto, Integer studentId) {
    StudentMark studentMarks = new StudentMark();
    List<Integer> list = new ArrayList<>();
    list.add(studentMarkdto.getMark1());
    list.add(studentMarkdto.getMark2());
    list.add(studentMarkdto.getMark3());

    Double average = list
        .stream()
        .mapToDouble(x -> x.doubleValue())
        .average()
        .orElse(0.0);

    studentMarks.setStudentId(studentId);
    studentMarks.setMark1(studentMarkdto.getMark1());
    studentMarks.setMark2(studentMarkdto.getMark2());
    studentMarks.setMark3(studentMarkdto.getMark3());
    studentMarks.setLesson(studentMarkdto.getLesson());
    studentMarks.setAverage(RoundUp.roundUpTwo(average));

    //create method for letter
      /*
      avg>=80 A
      avg>=60 between avg<80 B
      avg>=40 between avg<60 C
      avg<40 D

       */
    studentMarkRepository.save(studentMarks);
  }
}
    /*
    if (!getStudent.isPresent()) {
      return null;
    }
    return ofNullable(getStudent.get());
  }

  List<BookOrder> bookOrderList = bookOrderService.getBookOrderByIdTest(orderId);
        Double sumTotal= RoundUp.roundUpTwo (bookOrderList.stream().mapToDouble(value -> value.getTotalPrice()).sum());

        String orderName=bookOrderList
                .stream()
                .map(l->l.getOrderName())
                .findFirst()
                .get();

                ///////////
                Iterable<BookOrder> findOrder = bookOrderRepository.findByOrderId(orderStatusRequest.getOrderId());

        for (BookOrder orderStatus : findOrder) {

            orderStatus.setOrderStatus(orderStatusRequest.getStatus());
            //orderStatus.setMessageFromSeller(orderStatusRequest.getMessageFromSeller());
            orderStatus.setStatusDate(LocalDate.now());


            bookOrderRepository.save(orderStatus);

        }

         List<String> lines = Arrays.asList("spring", "node", "mkyong");

        List<String> result = lines.stream()                // convert list to stream
                .filter(line -> !"mkyong".equals(line))     // we dont like mkyong
                .collect(Collectors.toList());              // collect the output and convert streams to a List

        result.forEach(System.out::println);



     */
