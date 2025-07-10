package com.wellsfargo.counselor.repository;

import com.wellsfargo.counselor.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}

