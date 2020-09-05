package com.assignmentprj.assignment.repository;

import com.assignmentprj.assignment.Domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
