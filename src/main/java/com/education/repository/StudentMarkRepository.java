package com.education.repository;

import com.education.repository.entity.StudentMark;
import com.education.repository.entity.Students;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
  public interface StudentMarkRepository extends JpaRepository<StudentMark, Integer> {

}


//public interface StudentRepository extends CrudRepository<Students, Integer> {
//  Optional<Students> findByFullName(String fullName);
//
//}