package by.brandwatch.catalogmanagerservice.repository.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    boolean existsAllByIdIn(Set<Long> ids);
}
