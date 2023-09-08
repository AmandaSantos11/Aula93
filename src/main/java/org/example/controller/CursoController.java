package org.example.controller;
import org.example.model.ProfessorModel;
import org.example.repository.CursoRepository;
public class CursoController {
    ProfessorModel professorModel = new ProfessorModel();
    CursoRepository cursoRepository = new CursoRepository();
    public boolean consultaDeCursosMinistradosPorUmProfessor(String nome_professor){
        professorModel.setNome_professor(nome_professor);
        return cursoRepository.consultaDeCursosMinistradosPorUmProfessor(professorModel.getNome_professor());
    }
    public boolean consultaDeCursosSemAlunosMatriculados(){
       return cursoRepository.consultaDeCursosSemAlunosMatriculados();
    }
}