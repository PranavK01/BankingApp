package com.wipro.PR377825.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.PR377825.springboot.entity.CurrentAccTransaction;
import com.wipro.PR377825.springboot.entity.CurrentAccount;


@Repository
public interface CurrentTransactionRepo extends JpaRepository<CurrentAccTransaction, Long>
{
	List<CurrentAccTransaction> findBycurrentaccNumber(CurrentAccount accNum);
}
