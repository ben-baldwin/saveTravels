package com.ben.savetravels.controllers;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.ben.savetravels.models.Expense;
import com.ben.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {
	
//	IMPORT OUR SERVICE / DEPENDENCY INJECTION
	@Autowired
	ExpenseService expenseService;

//		GET ONE EXPENSE /{id}")
	@GetMapping("/expenses/{id}")
	public String showOne(
		@PathVariable("id") Long id,
		Model model
		) {
		Expense oneExpense = expenseService.findExpense(id);
		
//		PASS THE INFORMATION TO THE JSP
		model.addAttribute("expense", oneExpense);
		return "oneExpense.jsp";
	}
	
//		GET ALL DATA BINDING
	
    @GetMapping("/expenses")
    public String index(
    		@ModelAttribute("expenseObj") Expense emptyExpenseObj, 
    		Model model) {
        List<Expense> expenses = expenseService.allExpenses();
        model.addAttribute("expenses", expenses);
        return "index.jsp";
    }
    
//    	CREATE ONE DATA BINDING
    
    @PostMapping("/expenses/new")
    public String create(
    		@Valid @ModelAttribute("expenseObj") Expense fullExpenseObj,
    		BindingResult result, Model model) {
    	if (result.hasErrors()) {
//    		List OF expense objects
            List<Expense> expenses = expenseService.allExpenses();
            model.addAttribute("expenses", expenses);
    		return "index.jsp";
    	}
    	else {
    		expenseService.createExpense(fullExpenseObj);
    		return "redirect:/expenses";
    	}
    }
    
	// ------------------ DATA BINDING(UPDATE) ------------------------ //
	
    @GetMapping("/expenses/{id}/edit")
	public String editUser(
		@PathVariable("id") Long expenseId, Model model
	) {
		// GRAB ONE USER FROM DB
		Expense oneExpense = expenseService.findExpense(expenseId);
		// PASS ONE USER TO JSP
		model.addAttribute("expenseObj", oneExpense);
		return "editExpense.jsp";
	}
	@PutMapping("/expenses/{id}/edit")
	public String updateUser(
		@Valid @ModelAttribute("expenseObj") Expense filledExpenseObj,
		BindingResult results
	) {
		if(results.hasErrors()) {
			return "editExpense.jsp";
		}
		expenseService.createExpense(filledExpenseObj);
		return "redirect:/expenses";
	}
	// ------------------ DATA BINDING(DELETE) ------------------------ //
	
	@DeleteMapping("/expenses/{id}")
	public String deleteExpense(@PathVariable("id") Long expenseId) {
		expenseService.deleteExpense(expenseId);
		return "redirect:/expenses";
	}
	
}
