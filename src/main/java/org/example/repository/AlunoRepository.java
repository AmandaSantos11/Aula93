package org.example.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.example.connection.ConnectionDB.connect;
public class AlunoRepository {
    public AlunoRepository(){}
    public AlunoRepository(Connection connection){
        this.connection = connection;
    }
    private Connection connection = connect();
    public boolean consultaDeAlunosMatriculadosEmUmCursoEspecifico(String nome_curso){
        String sql = "SELECT alunos.nome FROM alunos " +
                "INNER JOIN matriculas ON alunos.id_aluno = matriculas.id_aluno " +
                "INNER JOIN cursos ON cursos.id_curso = matriculas.id_curso " +
                "WHERE cursos.nome = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome_curso);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                System.out.println("-" + result.getString("nome"));
            }
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean consultaDeAlunosQueNaoEstaoMatriculadosEmNenhumCurso(){
        String sql = "SELECT alunos.nome FROM matriculas " +
                "RIGHT JOIN alunos ON alunos.id_aluno = matriculas.id_aluno " +
                "WHERE matriculas.id_curso IS NULL;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                System.out.println("-" + result.getString("nome"));
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean consultaDeAlunosMatriculadosEmMaisDeUmCurso(){
        String sql = "SELECT DISTINCT alunos.nome " +
                "FROM alunos " +
                "INNER JOIN matriculas M1 ON alunos.id_aluno = M1.id_aluno " +
                "INNER JOIN matriculas M2 ON alunos.id_aluno = M2.id_aluno " +
                "WHERE M1.id_curso <> M2.id_curso ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                System.out.println("-" + result.getString("nome"));
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}