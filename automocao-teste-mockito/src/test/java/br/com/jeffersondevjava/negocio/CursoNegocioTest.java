package br.com.jeffersondevjava.negocio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.jeffersondevjava.service.CursoServico;
import br.com.jeffersondevjava.service.stubs.CursoServiceStubs;

class CursoNegocioTest {

	@Test
	void testCursoRelacionadoSpring_Quando_UsamosStub() {

		// Given
		CursoServico stubServico = new CursoServiceStubs();
		CursoNegocio negocio = new CursoNegocio(stubServico);

		// when
		var filtroCursos = negocio.recuperarCursosSobreSpring("Jefferson");

		// then
		assertEquals(4, filtroCursos.size());
	}

	@Test
	void testCursoRelacionadoSpring_Quado_UsamoFooBarEstudante() {

		// Given
		CursoServico stubServico = new CursoServiceStubs();
		CursoNegocio negocio = new CursoNegocio(stubServico);

		// when
		var filtroCursos = negocio.recuperarCursosSobreSpring("Foo Bar");

		// then
		assertEquals(0, filtroCursos.size());
	}
}
