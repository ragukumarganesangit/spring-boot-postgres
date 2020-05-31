package guru.springframework.repositories;

import guru.springframework.domain.Itemtable;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt on 1/10/17.
 */
public interface ProductRepository extends CrudRepository<Itemtable, Long> {
}
