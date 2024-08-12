import java.util.Scanner;

public class Consola{
    
    public Consola() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("\t~~Calculadora de Consola~~\n");

        while (true) {
            System.out.print("Ingrese la operación (por ejemplo, 12 + 5) o 'salir' para terminar: ");
            String input = entrada.nextLine();

            if (input.equalsIgnoreCase("salir")) {
                System.out.println("Calculadora finalizada.");
                break;
            }

            String[] tokens = input.split(" ");
            if (tokens.length != 3) {
                System.out.println("Entrada inválida. Asegúrese de usar el formato 'número operador número'.");
                continue;
            }

            try {
                double num1 = Double.parseDouble(tokens[0]);
                String operador = tokens[1];
                double num2 = Double.parseDouble(tokens[2]);

                double resultado = 0;

                switch (operador) {
                    case "+":
                        resultado = Funciones.additon(num1,num2);
                        break;
                    case "-":
                        resultado = Funciones.remaind(num1,num2);
                        break;
                    case "*":
                        resultado = Funciones.multiply(num1,num2);
                        break;
                    case "/":
                        if (num2 != 0) {
                            resultado = Funciones.split(num1,num2);
                        } else {
                            System.out.println("Error: División por cero no permitida.");
                            continue;
                        }
                        break;
                    case "^":
                        resultado = Funciones.Power(num1,num2);
                        break;
                    default:
                        System.out.println("Operador inválido. Use +, -, *, /, o ^.");
                        continue;
                }

                System.out.println("Resultado: " + num1 + " " + operador + " " + num2 + " = " + resultado);

            } catch (NumberFormatException e) {
                System.out.println("Error: Entrada inválida. Asegúrese de ingresar números válidos.");
            }
        }

       entrada.close();
    }
}

