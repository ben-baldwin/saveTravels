package com.ben.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ben.savetravels.models.Expense;

//...
@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long>{
 // this method retrieves all the expenses from the database
 List<Expense> findAll();
 // this method finds expenses with descriptions containing the search string
 List<Expense> findByDescriptionContaining(String search);
 // this method counts how many expenses contain a certain string
 Long countByExpenseContaining(String search);
 // this method deletes a expense that starts with a specific title
 Long deleteByExpenseStartingWith(String search);
}
