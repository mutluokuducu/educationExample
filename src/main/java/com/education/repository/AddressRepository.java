package com.education.repository;

import com.education.repository.entity.Address;
import com.education.repository.entity.Students;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
  public interface AddressRepository extends JpaRepository<Address, Integer> {

}


//public interface StudentRepository extends CrudRepository<Students, Integer> {
//  Optional<Students> findByFullName(String fullName);
//
//}