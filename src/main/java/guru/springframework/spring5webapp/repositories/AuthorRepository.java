package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

//creates data repository for author class spring will see this and implement what is
// necessary, we just have to create the instance

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
