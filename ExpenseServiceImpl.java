package org.example.Service;

import org.example.Entity.ExpenseEntity;
import org.example.Entity.PlanEntity;
import org.example.Repository.ExpenseRepository;
import org.example.Repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private PlanRepository planRepository;

    @Override
    public ExpenseEntity saveExpense(ExpenseEntity expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public List<ExpenseEntity> findAllExpenses() {
        return expenseRepository.findAllByOrderByExpenseDateDesc();
    }

    @Override
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    @Override
    public double getCurrentMonthTotal() {
        LocalDate today = LocalDate.now();
        LocalDate firstDay = today.withDayOfMonth(1);
        return expenseRepository.findByExpenseDateBetween(firstDay, today)
                .stream()
                .mapToDouble(ExpenseEntity::getAmount)
                .sum();
    }

    @Override
    public Map<String, Double> getCurrentMonthCategoryTotals() {
        LocalDate today = LocalDate.now();
        LocalDate firstDay = today.withDayOfMonth(1);
        List<ExpenseEntity> expenses =
                expenseRepository.findByExpenseDateBetween(firstDay, today);

        Map<String, Double> totals = new LinkedHashMap<String, Double>();

        for (ExpenseEntity expense : expenses) {
            String category = expense.getCategory();
            Double currentTotal = totals.get(category);

            if (currentTotal == null) {
                currentTotal = 0.0;
            }

            totals.put(category, currentTotal + expense.getAmount());
        }

        return totals;
    }

    @Override
    public PlanEntity getPlan() {
        return planRepository.findById(1L).orElseGet(() ->
                planRepository.save(new PlanEntity(1L, 20000,
                        "Emergency Fund", 50000, 0)));
    }

    @Override
    public PlanEntity savePlan(PlanEntity plan) {
        plan.setPlanId(1L);
        return planRepository.save(plan);
    }
}
