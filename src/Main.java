import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String ARQUIVO = "tarefas.txt";
    private static List<String> tarefas = new ArrayList<>();

    public static void main(String[] args) {
        carregarTarefas();

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- GERENCIADOR DE TAREFAS ---");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Remover tarefa");
            System.out.println("4. Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite a tarefa: ");
                    String tarefa = scanner.nextLine();
                    tarefas.add(tarefa);
                    salvarTarefas();
                    System.out.println("✅ Tarefa adicionada e salva!");
                    break;

                case 2:
                    listarTarefas();
                    break;

                case 3:
                    listarTarefas();
                    System.out.print("Digite o número da tarefa para remover: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();

                    if (numero > 0 && numero <= tarefas.size()) {
                        String removida = tarefas.remove(numero - 1);
                        salvarTarefas();
                        System.out.println("🗑️ Tarefa removida: " + removida);
                    } else {
                        System.out.println("❌ Número inválido!");
                    }
                    break;

                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
    }

    private static void listarTarefas() {
        System.out.println("\n--- LISTA DE TAREFAS ---");
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            for (int i = 0; i < tarefas.size(); i++) {
                System.out.println((i + 1) + ". " + tarefas.get(i));
            }
        }
    }

    private static void salvarTarefas() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (String tarefa : tarefas) {
                writer.write(tarefa);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar tarefas: " + e.getMessage());
        }
    }

    private static void carregarTarefas() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                tarefas.add(linha);
            }
        } catch (IOException e) {
            System.out.println("Nenhum arquivo encontrado, criando um novo...");
        }
    }
}
