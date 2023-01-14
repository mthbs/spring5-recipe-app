package guru.springframework.repositories;

import guru.springframework.domain.Recipe;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    @Modifying
    @Transactional
    @Query(
            value = "update recipe set url = ?1 where id = ?2 ",
            nativeQuery = true
    )
    public int updateStudentNameByEmailId(String newUrl, String id);

}
