package com.education.service;

import static java.time.LocalTime.now;

import com.education.dto.StudentsDto;
import com.education.repository.StudentRepository;
import com.education.repository.entity.Students;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  @Autowired
  private StudentRepository studentRepository;

  public List<Students> getAllStudent() {

    Iterable<Students> studentsList = studentRepository.findAll();
    return (List<Students>) studentsList;
  }

  public Optional<Students> getStudent(String name) {

    Optional<Students> getStudent = studentRepository.findByFullName(name);
    return getStudent.map(Optional::ofNullable).orElse(null);
  }

  public void deleteStudentByIdAndName(Integer id,String name){
    studentRepository.deleteByIdAndFullName(id,name);
  }

  public void deleteStudentById(Integer id){
    studentRepository.deleteById(id);

  }

  public void  setStudent(StudentsDto studentsDto){
    LocalDate date=LocalDate.now();
    Students students=new Students();
    students.setAddress(studentsDto.getAddress());
    students.setFullName(studentsDto.getFullName());
    students.setDate(date);

    studentRepository.save(students);
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
