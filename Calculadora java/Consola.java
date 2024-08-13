import java.util.Scanner;

public class Consola{

    public Consola(){
        Scanner entrada = new Scanner(System.in);

        System.out.println("\t\t~~Calculadora de Consola~~");
        System.out.println("Ingrese alguna operacion (Ejm: 12 + 5, 12 - 5, sin 90) o 'salir' para terminar.");

        while(true){
            System.out.print("Operacion: ");
            String operation = entrada.nextLine();

            if(operation.contains("salir")){
                System.out.println("¡¡Calculadora finalizada!!. Gracias por usar la calculadora grafica.");
                break;
            }

            String [] choose = operation.split(" ");
            if(choose.length != 3){
                System.out.println("Entrada invalida.Formato a seguir | numero - operador - numero |.");
                continue;
            }

            try {

                Double num1 = Double.parseDouble(choose[0]);
                String operador = choose[1];
                Double num2 = Double.parseDouble(choose[2]);
                Double result = 0.0;

                switch (operador) {
                    case "+":
                        result = Funciones.additon(num1, num2);
                        break;
                    case "-":
                        result = Funciones.remaind(num1, num2);
                        break;
                    case "*":
                        result = Funciones.multiply(num1, num2);
                        break;
                    case "/":
                        if(num2 != 0){
                            result = Funciones.split(num1, num2);
                        }else{
                            System.out.println("Error: División por cero no permitida.");
                        }
                        continue;
                    case "^":
                        result = Funciones.Power(num1, num2);
                    default:
                        System.out.println("Operador inválido. Use +, -, *, /, o ^.");
                        continue;
                }
                System.out.println("\t--------------------------");
                System.out.println("\tResultado: " + num1 + " " + operador + " " + num2 + " = " + result);
                System.out.println("\t--------------------------");
                
            } catch (NumberFormatException e) {
                System.out.println("Error: Entrada inválida. Asegúrese de ingresar números válidos.");
            }

        }
            
       entrada.close();
    }
}

