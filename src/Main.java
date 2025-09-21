//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Se crea dos pilas Undo y Redo
        Stack<String> pilaUndo = new Stack<>();
        Stack<String> pilaRedo = new Stack<>();

        int opcion;
        // Se crea la consola de texto con las opciones a escoger y
        //Ciclo principal, se repite hasta que se elija salir (opción 5)
        do{
            System.out.println("\n-----MENU-----");
            System.out.println("1. Escribir texto");
            System.out.println("2. Deshacer");
            System.out.println("3. Rehacer");
            System.out.println("4. Mostrar texto actual");
            System.out.println("5. Salir");
            System.out.println("Elija una opcion");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    // Opción 1: Se escribe un nuevo texto
                    System.out.println("Escriba texto: ");
                    String texto = sc.nextLine();
                    // Guardamos el texto en la pila de Undo
                    pilaUndo.push(texto);
                    // Cada vez que se escribe algo nuevo, se vacía la pila de Redo
                    pilaRedo.clear();
                    break;

                case 2:
                    // Opción 2: deshacer la última acción
                    if (!pilaUndo.isEmpty()){
                        // Sacamos el último texto escrito de Undo
                        String deshecho = pilaUndo.pop();
                        // Guardamos ese texto en Redo para poder rehacerlo después
                        pilaRedo.push(deshecho);
                        System.out.println("Deshecho: " + deshecho);
                    } else {
                        System.out.println("Nada que deshacer");
                    }
                    break;


                case 3:
                    // Opción 3: rehacer la última acción deshecha
                    if (!pilaRedo.isEmpty()) {
                        // Sacamos el último texto de Redo
                        String rehecho = pilaRedo.pop();
                        // Lo volvemos a poner en Undo
                        pilaUndo.push(rehecho);
                        System.out.println("Rehecho: " + rehecho);
                    } else {
                        System.out.println("Nada que rehacer");
                    }
                    break;


                case 4:
                    // Opción 4: mostrar el texto actual
                    if (!pilaUndo.isEmpty()) {
                        // El texto actual es el que está en la cima de Undo
                        System.out.println("Texto actual: " + pilaUndo.peek());
                    } else {
                        System.out.println("No hay texto en la pila");
                    }
                    break;


                case 5:
                    // Opción 5: salir del programa
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    // Si el usuario ingresa un número fuera del menú
                    System.out.println("Opción no válida");
            }
        } while (opcion != 5);// El ciclo se repite hasta que se elige salir

        sc.close();// Cerramos el scanner
    }
}