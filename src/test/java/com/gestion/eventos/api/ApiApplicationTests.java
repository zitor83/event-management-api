package com.gestion.eventos.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
		"spring.datasource.url=jdbc:h2:mem:testdb",
		"spring.datasource.driver-class-name=org.h2.Driver",
		"spring.datasource.username=sa",
		"spring.datasource.password=",
		"spring.jpa.database-platform=org.hibernate.dialect.H2Dialect",

		// ¡NUEVO! Simulamos las variables del .env para que la seguridad no explote
		"JWT_SECRET=unSecretoFalsoParaTestsQueSeaLoSuficientementeLargo1234567890",
		"JWT_EXPIRATION=600000"
})
class ApiApplicationTests {

	@Test
	void contextLoads() {
		// Test vacío intencionadamente
	}
}