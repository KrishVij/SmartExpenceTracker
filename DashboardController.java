package org.example.Controller;

import org.example.Entity.PlanEntity;
import org.example.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/")
    public String homeDashboard(Model model) {
        PlanEntity plan = expenseService.getPlan();
        double monthlySpent = expenseService.getCurrentMonthTotal();

        model.addAttribute("monthlySpent", monthlySpent);
        model.addAttribute("plan", plan);
        model.addAttribute("remainingBudget",
                plan.getMonthlyBudget() - monthlySpent);
        model.addAttribute("categoryTotals",
                expenseService.getCurrentMonthCategoryTotals());
        model.addAttribute("expenses", expenseService.findAllExpenses());

        return "dashboard";
    }
}
