package br.com.jeffersondevjava.negocio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.jeffersondevjava.service.CursoServico;
import br.com.jeffersondevjava.service.stubs.CursoServiceStubsTest;

class CursoNegocioMockTest {
	

	CursoServico mockServico;
	CursoNegocio negocio;
	List<String> cursos;
	
	@BeforeEach
	void setup() {
		// Given
		mockServico = mock(CursoServico.class);
		negocio = new CursoNegocio(mockServico);
		
		cursos = Arrays.asList(
                "REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "Spotify Engineering Culture Desmistificado",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
                "Docker do Zero à Maestria - Contêinerização Desmistificada",
                "Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
                "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
                "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
                "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker"
            );
	}
	
	@Test
	void testCursoRelacionadoSpring_Quando_UsamosMock() {
		
		when(mockServico.recuperarCursos("Jefferson")).thenReturn(cursos);

		// when
		var filtroCursos = negocio.recuperarCursosSobreSpring("Jefferson");

		// then
		assertEquals(4, filtroCursos.size());
	}

	@Test
	void testCursoRelacionadoSpring_Quado_UsamoFooBarEstudante() {

		// Given
		CursoServico stubServico = new CursoServiceStubsTest();
		CursoNegocio negocio = new CursoNegocio(stubServico);

		// when
		var filtroCursos = negocio.recuperarCursosSobreSpring("Foo Bar");

		// then
		assertEquals(0, filtroCursos.size());
	}
}
