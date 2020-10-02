package guru.springframework.spring5webapp.boostrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//this is for initializing data

//tells spring framework to manage this as a component
@Component
public class BootstrapData implements CommandLineRunner {

    //our depedencies will be injected into the constructor when spring implements the
    // component at run time
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in bootstrap");
        //creating a book and author and adding the book to the author and the author
        // to the book
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "efrkjeb");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        //save the new book and author to our repository
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "kerfkerfkjerhfk");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);


        System.out.println("Number of books " + bookRepository.count());


        //part fo challenge
        Publisher publisher = new Publisher("SFG Publishing", "123 Street", "NY", "NY",
                "00000");

        publisherRepository.save(publisher);
        System.out.println("Publisher count " + publisherRepository.count());

    }
}
