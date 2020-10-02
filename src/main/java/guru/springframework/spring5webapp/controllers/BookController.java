package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//At runtime when spring gets a request to the url "/books" it is going to execute the
// get books method add will provide that method a model object and our code is saying
// for that model will will add the attribute called books and execute book repository
// .findAll which will return us a list of books, the model will get returned back to
// the view layer with an attribute books and a list of books that we can utilize to
// set up our view layer to apply teh necessary view that we will return to the client

//we tell spring this is a controller
@Controller
public class BookController {

    //bring in a dependency fo book repository
    private final BookRepository bookRepository;

    //spring will instantiate bookrepository
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //tell it to set this getBooks method to "/books" url
    @RequestMapping("/books")
    public String getBooks(Model model){

        // at runtime this function will pull all the books from the books repository
        model.addAttribute("books", bookRepository.findAll());
        //going to return books to or view in order to display correct page, and look
        // for the list component
        return "books";
    }

}
