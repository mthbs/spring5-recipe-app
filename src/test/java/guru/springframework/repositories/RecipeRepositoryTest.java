package guru.springframework.repositories;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class RecipeRepositoryTest extends TestCase {

    @Autowired
    private RecipeRepository recipeRepository;

    @Test
    public void changeUrl(){
        String newUrl = "guacamole/index.html";
        String id = "1";
        recipeRepository.updateStudentNameByEmailId(newUrl,id);
        System.out.println(id);
    }

}