package es.edataconsulting.restapi.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import es.edataconsulting.restapi.entity.TmUsers;
import es.edataconsulting.restapi.repository.TmUsersRepository;
import es.edataconsulting.restapi.service.TmUsersService;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TmUsersServiceImplTest { 
	private final int id=1;
	@TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
  
        @Bean
        public TmUsersService tmUsersService() {
            return new TmUsersServiceImpl();
        }
    }
    @Autowired
    private TmUsersService tmUsersService;
 
    @MockBean
    private TmUsersRepository tmUsersRepository;
    
    //inserts into the repository a test object
    @Before
    public void setUp() {
        TmUsers test = new TmUsers();
        test.setId(id);
        
        Mockito.when(tmUsersRepository.findById(test.getId())).thenReturn(test);
    }
    //check if the service returns the test object added in setUp
    @Test
    public void whenValidIdthenTmUsersShouldBeFound() {
        TmUsers found = tmUsersService.findById(id);
        assertThat(found.getId(),is(1));
     }
}	
