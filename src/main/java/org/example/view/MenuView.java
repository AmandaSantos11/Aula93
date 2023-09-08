package org.example.view;
import org.example.controller.AlunoController;
import org.example.controller.CursoController;
import java.util.Scanner;
public class MenuView {
    AlunoController alunoController;
    CursoController cursoController;
    Scanner scanner;
    public MenuView() {
        alunoController = new AlunoController();
        cursoController = new CursoController();
        scanner = new Scanner(System.in);
    }
    public void menuPrincipal(){
        int escolha=0;
        do {
            menuOpcoes();
            System.out.println("\nOpção:");
            escolha=scanner.nextInt();
            switch (escolha){
                case 1:
                    System.out.print("Informe o nome do curso: ");
                    scanner.nextLine();
                    String nome_curso = scanner.nextLine();
                    System.out.println("Curso: "+nome_curso);
                    System.out.println("Aluno(s) matriculado(s):");
                    alunoController.consultaDeAlunosMatriculadosEmUmCursoEspecifico(nome_curso);
                    break;

                case 2:
                    System.out.print("Informe o nome do professor: ");
                    scanner.nextLine();
                    String nome_professor = scanner.nextLine();
                    System.out.println("Professor(a): "+nome_professor);
                    System.out.println("Curso(s):");
                    cursoController.consultaDeCursosMinistradosPorUmProfessor(nome_professor);
                    break;

                case 3:
                    System.out.println("Aluno(s) que não estão matriculado(s) em nenhum curso:");
                    alunoController.consultaDeAlunosQueNaoEstaoMatriculadosEmNenhumCurso();
                    break;

                case 4:
                    System.out.println("Curso(s) sem alunos matriculado(s):");
                    cursoController.consultaDeCursosSemAlunosMatriculados();
                    break;

                case 5:
                    System.out.println("Aluno(s) matriculado(s) em mais de um curso:");
                    alunoController.consultaDeAlunosMatriculadosEmMaisDeUmCurso();
                    break;

                case 0:
                    System.out.println("Obrigada por utilizar nosso sistema!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida");
            }
        }while (escolha!=0);
    }
    public void menuOpcoes(){
        System.out.println("\nVocê deseja:");
        System.out.println("1-Consulta de alunos matriculados em um curso específico");
        System.out.println("2-Consulta de cursos ministrados por um professor");
        System.out.println("3-Consulta de alunos que não estão matriculados em nenhum curso");
        System.out.println("4-Consulta de cursos sem alunos matriculados");
        System.out.println("5-Consulta de alunos matriculados em mais de um curso");
    }
}