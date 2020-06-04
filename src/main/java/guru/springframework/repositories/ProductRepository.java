package guru.springframework.repositories;

import guru.springframework.domain.Itemtable;
import org.springframework.data.repository.CrudRepository;


public interface ProductRepository extends CrudRepository<Itemtable, Long> {
}
