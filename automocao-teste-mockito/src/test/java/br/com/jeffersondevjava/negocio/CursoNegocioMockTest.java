package br.com.jeffersondevjava.negocio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.jeffersondevjava.service.CursoServico;
import br.com.jeffersondevjava.service.stubs.CursoServiceStubsTest;

class CursoNegocioMockTest {
	

	CursoServico mockServico;
	CursoNegocio negocio;
	
	@BeforeEach
	void stup() {
		// Given
		mockServico = new CursoServiceStubsTest();
		negocio = new CursoNegocio(mockServico);
	}
	
	@Test
	void testCursoRelacionadoSpring_Quando_UsamosMock() {

		CursoServico mockServico = mock(CursoServico.class);
		CursoNegocio negocio = new CursoNegocio(mockServico);

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
