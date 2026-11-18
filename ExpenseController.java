package org.example.Controller;

import org.example.Entity.ExpenseEntity;
import org.example.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expenses")
    public String showExpenses(Model model) {
        model.addAttribute("expenses", expenseService.findAllExpenses());
        model.addAttribute("expense", new ExpenseEntity());
        return "expenses";
    }

    @PostMapping("/expenses/save")
    public String saveExpense(
            @RequestParam String title,
            @RequestParam String category,
            @RequestParam double amount,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                    LocalDate expenseDate) {

        ExpenseEntity expense =
                new ExpenseEntity(title, category, amount, expenseDate);

        expenseService.saveExpense(expense);
        return "redirect:/expenses";
    }

    @GetMapping("/expenses/delete")
    public String deleteExpense(@RequestParam Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/expenses";
    }
}
