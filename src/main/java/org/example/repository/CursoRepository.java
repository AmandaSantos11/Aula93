package org.example.repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.example.connection.ConnectionDB.connect;
public class CursoRepository {
    private Connection connection = connect();
    public CursoRepository(){}
    public CursoRepository(Connection connection){
        this.connection = connection;
    }
    public boolean consultaDeCursosMinistradosPorUmProfessor(String nome_professor){
        String sql = "SELECT cursos.nome " +
                    "FROM cursos " +
                    "LEFT JOIN professores ON cursos.id_professor = professores.id_professor " +
                    "WHERE professores.nome = ? ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nome_professor);

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
    public boolean consultaDeCursosSemAlunosMatriculados(){
        String sql = "SELECT cursos.nome " +
                "FROM cursos " +
                "FULL JOIN matriculas " +
                "ON cursos.id_curso = matriculas.id_curso "+
                "WHERE matriculas.id_aluno IS NULL;";
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