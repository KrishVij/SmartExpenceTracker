package org.example.Entity;

import javax.persistence.*;

@Entity
@Table(name = "expense_plan")
public class PlanEntity {

    @Id
    private Long planId;

    private double monthlyBudget;
    private String goalName;
    private double goalTarget;
    private double goalSaved;

    public PlanEntity() {
    }

    public PlanEntity(Long planId, double monthlyBudget, String goalName,
                      double goalTarget, double goalSaved) {
        this.planId = planId;
        this.monthlyBudget = monthlyBudget;
        this.goalName = goalName;
        this.goalTarget = goalTarget;
        this.goalSaved = goalSaved;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public double getMonthlyBudget() {
        return monthlyBudget;
    }

    public void setMonthlyBudget(double monthlyBudget) {
        this.monthlyBudget = monthlyBudget;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public double getGoalTarget() {
        return goalTarget;
    }

    public void setGoalTarget(double goalTarget) {
        this.goalTarget = goalTarget;
    }

    public double getGoalSaved() {
        return goalSaved;
    }

    public void setGoalSaved(double goalSaved) {
        this.goalSaved = goalSaved;
    }
}
