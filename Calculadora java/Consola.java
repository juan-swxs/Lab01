import java.util.Scanner;

public class Consola{

    public Consola(){
        Scanner entrada = new Scanner(System.in);

        System.out.println("\t\t~~Calculadora de Consola~~");
        System.out.println("Ingrese alguna operacion (Ejm: 12 + 5, 12 - 5, sin 90) o 'salir' para terminar.");

        while(true){
            System.out.print("Operacion: ");
            String operation = entrada.nextLine();
            String newopString = operation.toLowerCase();

            if(newopString.contains("salir")){
                System.out.println("¡¡Calculadora finalizada!!. Gracias por usar la calculadora grafica.");
                break;
            }

            if(newopString.contains("sin")||newopString.contains("cos")||newopString.contains("tan")||newopString.contains("sqrt")){
                String [] choose = newopString.split(" ");
                if(choose.length != 2){
                    System.out.println("Entrada invalida. Formato a seguir | Funcion - valor |.");
                    continue;
                }

                try {
                    String operador = choose[0];
                    Double num1 = Double.parseDouble(choose[1]);
                    Double result = 0.0;

                    switch (operador) {
                        case "sin":
                            result = Funciones.Sen(num1);
                            break;
                        case "cos":
                            result = Funciones.Cos(num1);
                            break;
                        case "tan":
                            result = Funciones.tang(num1);
                            break;
                        case "sqrt":
                            result = Funciones.radical(num1);
                            break;
                        default:
                            System.out.println("Operador trigonometrico inválido. Use sin, cos, tan, o sqrt.");
                            continue;
                }
                System.out.println("\t----------------------------------------");
                System.out.println("\tResultado: " + operador + " " + num1 + " " + "= " + result);
                System.out.println("\t----------------------------------------");
                
                } catch (NumberFormatException e) {
                    System.out.println("Error: Entrada inválida. Asegúrese de ingresar números válidos.");
                } 

            }else{
                String [] choose2 = newopString.split(" ");
                if(choose2.length != 3){
                    System.out.println("Entrada invalida. Formato a seguir | numero - operador - numero |.");
                    continue;
                }
                    try {
                        Double num1 = Double.parseDouble(choose2[0]);
                        String operator = choose2[1];
                        Double num2 = Double.parseDouble(choose2[2]);
                        Double result = 0.0;

                        switch (operator) {
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
                                    continue;
                                }
                                break;
                            case "^":
                                result = Funciones.Power(num1, num2);
                                break;
                            case "iva":
                                result = Funciones.iva(num1, num2);
                                break;
                            default:
                                System.out.println("Operador inválido. Use +, -, *, /, ^, o iva.");
                                continue;
                    }
                System.out.println("\t--------------------------");
                System.out.println("\tResultado: " + num1 + " " + operator + " " + num2 + " = " + result);
                System.out.println("\t--------------------------");
                } catch (NumberFormatException e) {
                     System.out.println("Error: Entrada inválida. Asegúrese de ingresar números válidos.");
                }
            }
        }  
       entrada.close();
    }
}

