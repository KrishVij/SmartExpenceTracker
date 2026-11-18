package org.example.Service;

import org.example.Entity.ExpenseEntity;
import org.example.Entity.PlanEntity;
import java.util.List;
import java.util.Map;

public interface ExpenseService {

    ExpenseEntity saveExpense(ExpenseEntity expense);

    List<ExpenseEntity> findAllExpenses();

    void deleteExpense(Long id);

    double getCurrentMonthTotal();

    Map<String, Double> getCurrentMonthCategoryTotals();

    PlanEntity getPlan();

    PlanEntity savePlan(PlanEntity plan);
}
