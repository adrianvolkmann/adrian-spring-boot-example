package com.volkmann.adrian_spring_boot_example;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

import com.volkmann.adrian_spring_boot_example.flyway.FlywayConfigTeste;

@SpringBootTest
//@ActiveProfiles("test")
//@DataJpaTest
@Import(FlywayConfigTeste.class)
class AdrianSpringBootExampleApplicationTests {

	@Autowired
    private Environment environment;
	
	@Test
	void contextLoads() {
		
		String[] activeProfiles = environment.getActiveProfiles();
		
		if (activeProfiles.length > 0) {
            System.out.println("Active profiles: " + String.join(", ", activeProfiles));
        } else {
            System.out.println("No active profiles");
        }
	}
	//documentar a configuração que foi feita nos testes

}
