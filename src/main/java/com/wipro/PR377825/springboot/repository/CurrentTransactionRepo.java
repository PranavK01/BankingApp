package com.wipro.PR377825.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.PR377825.springboot.entity.CurrentAccTransaction;

@Repository
public interface CurrentTransactionRepo extends JpaRepository<CurrentAccTransaction, Long>{

}
