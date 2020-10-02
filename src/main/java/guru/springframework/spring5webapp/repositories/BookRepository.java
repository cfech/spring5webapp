package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

//creates data repository for book class, spring will see this and implement what is
// necessary, we just have to create the instance

public interface BookRepository extends CrudRepository<Book, Long> {
}
