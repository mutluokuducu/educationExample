package com.education.repository;

import com.education.repository.entity.Students;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Students, Integer> {
  Optional<Students> findByFullName(String fullName);

}
