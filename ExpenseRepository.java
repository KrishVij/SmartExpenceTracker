package org.example.Repository;

import org.example.Entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {

    List<ExpenseEntity> findAllByOrderByExpenseDateDesc();

    List<ExpenseEntity> findByExpenseDateBetween(LocalDate startDate, LocalDate endDate);
}
