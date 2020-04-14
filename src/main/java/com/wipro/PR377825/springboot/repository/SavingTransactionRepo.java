package com.wipro.PR377825.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.PR377825.springboot.entity.SavingAccTransaction;
import com.wipro.PR377825.springboot.entity.SavingAccount;

@Repository
public interface SavingTransactionRepo extends JpaRepository<SavingAccTransaction, Long> 
{
	List<SavingAccTransaction> findBysavingAccNumber(SavingAccount accNum);
}
