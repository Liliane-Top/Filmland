package nl.filmland.filmland.repository;

import nl.filmland.filmland.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends JpaRepository<Category, Long> {

  Category findCategoryById(Long id);

  Category findAllByCategoryPrice(double categoryPrice);


}
