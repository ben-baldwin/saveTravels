package com.ben.savetravels.controllers;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ben.savetravels.models.Expense;
import com.ben.savetravels.services.ExpenseService;

@RestController
public class ExpenseApi {
private final ExpenseService expenseService;
 public ExpenseApi(ExpenseService expenseService){
     this.expenseService = expenseService;
 }
 @RequestMapping("/api/expenses")
 public List<Expense> index() {
     return expenseService.allExpenses();
 }
 
 @RequestMapping(value="/api/expenses", method=RequestMethod.POST)
 public Expense create(
		 @RequestParam(value="expense") String expense, 
		 @RequestParam(value="vendor") String vendor, 
		 @RequestParam(value="amount") Double amount, 
		 @RequestParam(value="description") String description) {
     Expense newExpense = new Expense(expense, vendor, amount, description);
     return expenseService.createExpense(newExpense);
 }
 
 @RequestMapping("/api/expenses/{id}")
 public Expense show(@PathVariable("id") Long id) {
     Expense expense = expenseService.findExpense(id);
     return expense;
 }
}
