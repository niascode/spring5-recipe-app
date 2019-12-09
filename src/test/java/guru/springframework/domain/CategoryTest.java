package guru.springframework.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class CategoryTest {

    public Category category;

    @Before
    public void setUp(){
        category= new Category();
    }

    @Test
    public void getId() {
        Long myID = 4L;
        category.setId(myID);
        assertEquals(myID,category.getId());
    }

    @Test
    public void getDescription() {
        String myDesc = "What my description is...";
        category.setDescription(myDesc);
        assertEquals(myDesc,category.getDescription());
    }

    @Test
    public void getRecipes() {
        Set<Recipe> recipeSet = new HashSet<>();
        Recipe rec1 = new Recipe();
        rec1.setId(1L);
        recipeSet.add(rec1);
        category.setRecipes(recipeSet);
        assertEquals(recipeSet.size(),1);
    }
}