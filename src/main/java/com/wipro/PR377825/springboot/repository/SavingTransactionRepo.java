package com.wipro.PR377825.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.PR377825.springboot.entity.SavingAccTransaction;

@Repository
public interface SavingTransactionRepo extends JpaRepository<SavingAccTransaction, Long> {

}
