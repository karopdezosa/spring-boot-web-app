package com.assignmentprj.assignment.bootstrap;

import com.assignmentprj.assignment.Domain.Author;
import com.assignmentprj.assignment.Domain.Book;
import com.assignmentprj.assignment.Domain.Publisher;
import com.assignmentprj.assignment.repository.AuthorRepository;

import com.assignmentprj.assignment.repository.BookRepository;
import com.assignmentprj.assignment.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository booksRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository booksRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.booksRepository = booksRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Bootstrap is Started:");
        Publisher dks = new Publisher();
        dks.setName("kaekeke");
        dks.setAddressLine("123annao");
        dks.setCity("hosur");
        dks.setState("tamilnadu");
        dks.setZip("635124");

        publisherRepository.save(dks);
        System.out.println("publisher: " + publisherRepository.count());

        Author eric = new Author("eric", "evans");
        Book ddd = new Book("hi id te", "1");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(dks);
        dks.getBooks().add(ddd);

        authorRepository.save(eric);
        booksRepository.save(ddd);
        publisherRepository.save(dks);

        Author kds = new Author("karop", "dezosa");
        Book dd = new Book("hi id thaaaa", "2");

        kds.getBooks().add(dd);
        dd.getAuthors().add(kds);
        dd.setPublisher(dks);
        dks.getBooks().add(dd);
        authorRepository.save(kds);
        booksRepository.save(dd);
        publisherRepository.save(dks);

        System.out.println("Number of books:" + booksRepository.count());
        System.out.println("number of publishers book: " + dks.getBooks().size());
    }

}

