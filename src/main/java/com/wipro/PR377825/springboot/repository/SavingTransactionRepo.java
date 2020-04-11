package com.wipro.PR377825.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.PR377825.springboot.entity.SavingAccTransaction;

public interface SavingTransactionRepo extends JpaRepository<SavingAccTransaction, Long> {

}
