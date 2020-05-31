package guru.springframework.services;

import guru.springframework.commands.ProductForm;
import guru.springframework.domain.Itemtable;

import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
public interface ProductService {

    List<Itemtable> listAll();

    Itemtable getById(Long id);

    Itemtable saveOrUpdate(Itemtable product);

    void delete(Long id);

    Itemtable saveOrUpdateProductForm(ProductForm productForm);
}
