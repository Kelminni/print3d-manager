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
        double paintingHours = 0;
        double paintingHourRate = 0;

        if (needsPainting) {
            System.out.println("Horas de pintura:");
            paintingHours = Double.valueOf(scanner.nextLine());

            System.out.println("Valor da hora de pintura (R$):");
            paintingHourRate = Double.valueOf(scanner.nextLine());
        }
        System.out.println("Preço do material (R$ por kg ou por litro):");
        double materialPrice = Double.valueOf(scanner.nextLine());

        System.out.println("Valor da hora de máquina (R$):");
        double machineHourRate = Double.valueOf(scanner.nextLine());

        System.out.println("Margem de lucro (%):");
        int profitMargin = Integer.valueOf(scanner.nextLine());

        System.out.println();
        System.out.println("--- Resumo do pedido ---");
        System.out.println("Cliente: " + customerName);
        System.out.println("Modelo: " + modelFile);
        System.out.println("Tecnologia: " + technology);
        System.out.println("Material: " + material);
        System.out.println("Quantidade de material: " + materialAmount);
        System.out.println("Tempo de impressão: " + printHours + " h");
        System.out.println("Pintura: " + needsPainting);
        System.out.println("Status: orçamento calculado");

        // amount in grams (filament) or ml (resin); price per kg or per liter
        double materialCost = materialAmount * materialPrice / 1000;
        double machineCost = printHours * machineHourRate;
        double paintingCost = paintingHours * paintingHourRate;
        double totalCost = materialCost + machineCost + paintingCost;
        double finalPrice = totalCost * (1 + profitMargin / 100.0);

        System.out.println();
        System.out.println("--- Orçamento ---");
        System.out.println("Material: R$ " + materialCost);
        System.out.println("Máquina: R$ " + machineCost);
        if (needsPainting) {
            System.out.println("Pintura: R$ " + paintingCost);
        }
        System.out.println("Custo total: R$ " + totalCost);
        System.out.println("Margem: " + profitMargin + "%");
        System.out.println("Preço final: R$ " + finalPrice);
    }
}