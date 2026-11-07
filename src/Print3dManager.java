import java.util.Scanner;

public class Print3dManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Orçamento de Impressão 3D ===");

        System.out.println("Nome do cliente:");
        String customerName = scanner.nextLine();

        System.out.println("Arquivo do modelo:");
        String modelFile = scanner.nextLine();

        String technology;
        String material;
        String unit;
        String priceUnit;

        while (true) {
            System.out.println("Tecnologia (Filamento ou Resina):");
            technology = scanner.nextLine();

            if (technology.equalsIgnoreCase("Filamento")) {
                while (true) {
                    System.out.println("Escolha o material: PLA, ABS, PETG ou TPU");
                    material = scanner.nextLine();
                    if (material.equalsIgnoreCase("PLA") || material.equalsIgnoreCase("ABS") 
                        || material.equalsIgnoreCase("PETG") || material.equalsIgnoreCase("TPU")) {
                        unit = "g";
                        priceUnit = "kg";
                        break;
                    } else {
                        System.out.println("Material inválido. Use PLA, ABS, PETG ou TPU.");
                    }
                }
                break;
            } else if (technology.equalsIgnoreCase("Resina")) {
                material = "Resina";
                unit = "ml";
                priceUnit = "litro";
                break;
            } else {
                System.out.println("Tecnologia inválida. Use Filamento ou Resina.");
            }
        }
        while (true) {
            System.out.println("Quantidade de material (" + unit + "):");
            double materialAmount = Double.valueOf(scanner.nextLine().replace(",", "."));
            if (materialAmount > 0) {
                break;
            } else if (materialAmount <= 0) {
                System.out.println("Quantidade inválida. Use um valor maior que 0.");
            }
        }

        System.out.println("Tempo de impressão (horas):");
        double printHours = Double.valueOf(scanner.nextLine().replace(",", "."));

        System.out.println("Com pintura? (sim/não)");
        String paintingAnswer = scanner.nextLine();
        boolean needsPainting = paintingAnswer.equalsIgnoreCase("sim");

        double paintingHours = 0;
        double paintingHourRate = 0;

        if (needsPainting) {
            System.out.println("Horas de pintura:");
            paintingHours = Double.valueOf(scanner.nextLine().replace(",", "."));

            System.out.println("Valor da hora de pintura (R$):");
            paintingHourRate = Double.valueOf(scanner.nextLine().replace(",", "."));
        }

        System.out.println("Preço do material (R$ por " + priceUnit + "):");
        double materialPrice = Double.valueOf(scanner.nextLine().replace(",", "."));

        System.out.println("Valor da hora de máquina (R$):");
        double machineHourRate = Double.valueOf(scanner.nextLine().replace(",", "."));

        System.out.println("Margem de lucro (%):");
        int profitMargin = Integer.valueOf(scanner.nextLine());

        System.out.println();
        System.out.println("--- Resumo do pedido ---");
        System.out.println("Cliente: " + customerName);
        System.out.println("Modelo: " + modelFile);
        System.out.println("Tecnologia: " + technology);
        System.out.println("Material: " + material);
        System.out.println("Quantidade de material: " + materialAmount + " " + unit);
        System.out.println("Tempo de impressão: " + printHours + " h");
        if (needsPainting) {
            System.out.println("Pintura: Sim");
        } else {
            System.out.println("Pintura: Não");
        }
        System.out.println("Status: orçamento calculado");

        // amount in grams (filament) or ml (resin); price per kg or per liter
        double materialCost = materialAmount * materialPrice / 1000;
        double machineCost = printHours * machineHourRate;
        double paintingCost = paintingHours * paintingHourRate;
        double totalCost = materialCost + machineCost + paintingCost;
        double finalPrice = totalCost * (1 + profitMargin / 100.0);

        System.out.println();
        System.out.println("--- Orçamento ---");
        System.out.println("Material: R$ " + String.format("%.2f", materialCost));
        System.out.println("Máquina: R$ " + String.format("%.2f", machineCost));

        if (needsPainting) {
            System.out.println("Pintura: R$ " + String.format("%.2f", paintingCost));
        }

        System.out.println("Custo total: R$ " + String.format("%.2f", totalCost));
        System.out.println("Margem: " + profitMargin + "%");
        System.out.println("Preço final: R$ " + String.format("%.2f", finalPrice));
    }
}