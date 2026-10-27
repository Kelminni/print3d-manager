import java.util.Scanner;

public class Print3dManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Orçamento de Impressão 3D ===");

        System.out.println("Nome do cliente:");
        String customerName = scanner.nextLine();

        System.out.println("Arquivo do modelo:");
        String modelFile = scanner.nextLine();

        System.out.println("Tecnologia (Filamento ou Resina):");
        String technology = scanner.nextLine();

        System.out.println("Material:");
        String material = scanner.nextLine();

        System.out.println("Quantidade de material (g para filamento, ml para resina):");
        double materialAmount = Double.valueOf(scanner.nextLine());

        System.out.println("Tempo de impressão (horas):");
        double printHours = Double.valueOf(scanner.nextLine());

        System.out.println("Com pintura? (true/false)");
        boolean needsPainting = Boolean.valueOf(scanner.nextLine());

        System.out.println();
        System.out.println("--- Resumo do pedido ---");
        System.out.println("Cliente: " + customerName);
        System.out.println("Modelo: " + modelFile);
        System.out.println("Tecnologia: " + technology);
        System.out.println("Material: " + material);
        System.out.println("Quantidade de material: " + materialAmount);
        System.out.println("Tempo de impressão: " + printHours + " h");
        System.out.println("Pintura: " + needsPainting);
        System.out.println("Status: aguardando orçamento");
    }
}