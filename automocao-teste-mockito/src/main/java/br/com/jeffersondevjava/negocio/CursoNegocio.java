package br.com.jeffersondevjava.negocio;

import java.util.ArrayList;
import java.util.List;

import br.com.jeffersondevjava.service.CursoServico;

// SUT sistema em teste
public class CursoNegocio {

	private CursoServico servico;

	public CursoNegocio(CursoServico servico) {
		super();
		this.servico = servico;
	}
	
	public List<String> recuperarCursosSobreSpring(String estudante) {
		
		var filtroCursos = new ArrayList<String>();	
		if("Foo Bar".equals(estudante)) return filtroCursos;
		var todosCursos = servico.recuperarCursos(estudante);
		
		for (String curso : todosCursos) {
			
			if(curso.contains("Spring")) {
				filtroCursos.add(curso);
			}
		}
		
		return filtroCursos;
	
	}
}
