package org.example.controller;
import org.example.model.CursoModel;
import org.example.repository.AlunoRepository;
public class AlunoController {
    AlunoRepository alunoRepository = new AlunoRepository();
    CursoModel cursoModel = new CursoModel();
    public boolean consultaDeAlunosMatriculadosEmUmCursoEspecifico(String nome_curso){
        cursoModel.setNome_curso(nome_curso);
        return alunoRepository.consultaDeAlunosMatriculadosEmUmCursoEspecifico(cursoModel.getNome_curso());
    }
    public boolean consultaDeAlunosQueNaoEstaoMatriculadosEmNenhumCurso(){
        return alunoRepository.consultaDeAlunosQueNaoEstaoMatriculadosEmNenhumCurso();
    }
    public boolean consultaDeAlunosMatriculadosEmMaisDeUmCurso(){
        return alunoRepository.consultaDeAlunosMatriculadosEmMaisDeUmCurso();
    }
}