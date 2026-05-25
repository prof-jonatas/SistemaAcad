import java.util.Scanner;
import java.util.ArrayList;

public class SistemaAcadPlus {

    static Scanner scanner     = new Scanner(System.in);
    static ArrayList<String> nomes  = new ArrayList<>();
    static ArrayList<Double> notas  = new ArrayList<>();

    public static void main(String[] args) {
        int opcao = -1;
        while (opcao != 0) {
            exibirMenu();
            opcao = Integer.parseInt(scanner.nextLine());
            switch (opcao) {
                case 1 -> cadastrarAluno();
                case 2 -> listarAlunos();
                case 3 -> exibirEstatisticas();
                case 0 -> System.out.println("Sistema encerrado. Até mais!");
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    static void exibirMenu() {
        System.out.println("\n=== SistemaAcad v0.2 ===");
        System.out.println("[1] Cadastrar aluno");
        System.out.println("[2] Listar alunos");
        System.out.println("[3] Estatísticas da turma");
        System.out.println("[0] Sair");
        System.out.print("Escolha: ");
    }

    static void cadastrarAluno() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Nota: ");
        double nota = Double.parseDouble(scanner.nextLine());
        nomes.add(nome);
        notas.add(nota);
        System.out.println("✅ " + nome + " cadastrado com sucesso!");
    }

    static void listarAlunos() {
        if (nomes.isEmpty()) { System.out.println("Nenhum aluno cadastrado."); return; }
        System.out.println("\n--- Lista de Alunos ---");
        for (int i = 0; i < nomes.size(); i++) {
            System.out.println((i+1) + ". " + nomes.get(i)
                + " | Nota: " + notas.get(i)
                + " | " + verificarSituacao(notas.get(i)));
        }
    }

    static void exibirEstatisticas() {
        if (notas.isEmpty()) { System.out.println("Sem dados."); return; }
        double soma = 0; int aprovados = 0, recuperacao = 0, reprovados = 0;
        for (double nota : notas) {
            soma += nota;
            if      (nota >= 7.0) aprovados++;
            else if (nota >= 5.0) recuperacao++;
            else                  reprovados++;
        }
        System.out.println("\n--- Estatísticas ---");
        System.out.printf("Média da turma: %.2f%n", soma / notas.size());
        System.out.println("Aprovados: "    + aprovados);
        System.out.println("Recuperação: "  + recuperacao);
        System.out.println("Reprovados: "   + reprovados);
    }

    static String verificarSituacao(double nota) {
        if (nota >= 7.0) return "✅ Aprovado";
        if (nota >= 5.0) return "⚠️  Recuperação";
        return "❌ Reprovado";
    }
}