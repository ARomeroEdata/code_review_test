package es.edataconsulting.restapi.repository;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import es.edataconsulting.restapi.entity.TmUsers;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TmUsersRepositoryTest {
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private TmUsersRepository tmUsersRepository;
    
    //Check findById
    @Test
    public void whenFindByIdThenReturnTmUsers() {
        TmUsers test = new TmUsers();
        test.setName("testName");
        entityManager.persist(test);
        entityManager.flush();
     
        TmUsers found = tmUsersRepository.findById(test.getId());
     
        assertThat(found.getName(),is(test.getName()));
        assertThat(found.getId(),is(test.getId()));
    }
}
