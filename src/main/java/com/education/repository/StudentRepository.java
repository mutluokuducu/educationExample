package com.education.repository;

import com.education.repository.entity.Students;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
  public interface StudentRepository extends JpaRepository<Students, Integer> {
    Optional<Students> findByFullName(String fullName);
    void deleteByIdAndFullName(Integer id,String fullName);

}


//public interface StudentRepository extends CrudRepository<Students, Integer> {
//  Optional<Students> findByFullName(String fullName);
//
//}