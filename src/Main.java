import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> tarefas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- GERENCIADOR DE TAREFAS ---");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Remover tarefa");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite a tarefa: ");
                    String tarefa = scanner.nextLine();
                    tarefas.add(tarefa);
                    System.out.println("✅ Tarefa adicionada!");
                    break;
                case 2:
                    System.out.println("\n📋 Lista de tarefas:");
                    if (tarefas.isEmpty()) {
                        System.out.println("Nenhuma tarefa cadastrada.");
                    } else {
                        for (int i = 0; i < tarefas.size(); i++) {
                            System.out.println((i + 1) + ". " + tarefas.get(i));
                        }
                    }
                    break;
                case 3:
                    System.out.print("Digite o número da tarefa para remover: ");
                    int index = scanner.nextInt() - 1;
                    if (index >= 0 && index < tarefas.size()) {
                        tarefas.remove(index);
                        System.out.println("🗑️ Tarefa removida!");
                    } else {
                        System.out.println("⚠️ Número inválido.");
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("⚠️ Opção inválida.");
            }
        }
    }
}
