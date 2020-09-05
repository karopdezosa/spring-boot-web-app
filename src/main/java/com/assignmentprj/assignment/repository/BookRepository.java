package com.assignmentprj.assignment.repository;

import com.assignmentprj.assignment.Domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface   BookRepository extends CrudRepository<Book,Long> {
}
