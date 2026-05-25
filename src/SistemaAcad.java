import java.util.Scanner;

public class SistemaAcad {

    static Scanner scanner = new Scanner(System.in);

    // ─── PONTO DE ENTRADA ───────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("=== SistemaAcad v0.1 ===");
        System.out.print("Quantos alunos deseja cadastrar? ");
        int quantidade = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= quantidade; i++) {
            System.out.println("\n>>> Cadastro do aluno " + i);
            cadastrarAluno();
        }

        System.out.println("\n=== Cadastro encerrado! ===");
        System.out.println("Total cadastrado: " + quantidade + " aluno(s).");
    }

    // ─── CADASTRO DE UM ALUNO ───────────────────────────────────
    static void cadastrarAluno() {
        System.out.print("Nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        System.out.print("Nota final (0-10): ");
        double nota = Double.parseDouble(scanner.nextLine());

        String situacao = verificarSituacao(nota);

        System.out.println("\n--- Aluno Cadastrado ---");
        System.out.println("Nome.....: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Nota.....: " + nota);
        System.out.println("Situação.: " + situacao);
        System.out.println("------------------------\n");
    }

    // ─── REGRA DE APROVAÇÃO ─────────────────────────────────────
    static String verificarSituacao(double nota) {
        if (nota >= 7.0) return "✅ Aprovado";
        if (nota >= 5.0) return "⚠️  Recuperação";
        return "❌ Reprovado";
    }
}