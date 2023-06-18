package nl.filmland.filmland.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import nl.filmland.repository.CategoryDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CategoryDaoTests {

  @Autowired
  CategoryDao subject;

  @Test
  void getCategoryFromH2() {
    assertEquals("Dutch Films", subject.findCategoryById(1L).getCategoryName());
    assertEquals(8.0, subject.findCategoryById(3L).getCategoryPrice());
    assertEquals("International Films", subject.findAllByCategoryPrice(8.0).getCategoryName());
  }

}
