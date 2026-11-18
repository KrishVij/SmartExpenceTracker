package org.example.Controller;

import org.example.Entity.PlanEntity;
import org.example.Service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlanController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/plan")
    public String showPlan(Model model) {
        model.addAttribute("plan", expenseService.getPlan());
        return "plan";
    }

    @PostMapping("/plan/save")
    public String savePlan(@RequestParam double monthlyBudget,
                           @RequestParam String goalName,
                           @RequestParam double goalTarget,
                           @RequestParam double goalSaved) {

        PlanEntity plan = new PlanEntity(1L, monthlyBudget,
                goalName, goalTarget, goalSaved);

        expenseService.savePlan(plan);
        return "redirect:/plan";
    }
}
