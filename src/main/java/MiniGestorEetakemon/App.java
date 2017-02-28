package MiniGestorEetakemon;

//1. Añadir Eetakemon
//2. Borrar Eetakemon por id
//3. Listar
//4. Buscar por nombre
//* id autogenerado
//* tiene que haber 3 clases (modelo - Eetakemon, controlador - lógica del programa, la lista, vista - ofrecer opciones

import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        Controlador miControlador = new Controlador();

        Scanner sc = new Scanner(System.in);
        int option = 99;

        while (option != 0) {

            System.out.println("\n1. Añadir Eetakemon");
            System.out.println("2. Borrar Eetakemon");
            System.out.println("3. Mostrar todos los Eetakemon");
            System.out.println("4. Buscar Eetakemon");
            System.out.println("5. Buscar Eetakemon por aproximación \n");
            System.out.print("Seleccione una opción indicando el número: ");
            
            option = Integer.parseInt(sc.nextLine());


            switch (option) {
                case 1:
                    Eetakemon nuevo = new Eetakemon();
                    System.out.print("Introduce el nombre del Eetakemon: ");
                    nuevo.name = sc.nextLine();
                    System.out.print("Introduce el nivel del Eetakemon: ");
                    nuevo.level = Integer.parseInt(sc.nextLine());
                    miControlador.addEetakemon(nuevo);
                    break;
                case 2:
                    System.out.print("¿Que identificador quieres borrar?");
                    int delId = Integer.parseInt(sc.nextLine());
                    miControlador.delEetakemon(delId);
                    break;
                case 3:
                    Enumeration<Eetakemon> mostrar = miControlador.getList();
                    Eetakemon mostrarE;
                    while (mostrar.hasMoreElements()) {
                        mostrarE = mostrar.nextElement();
                        System.out.println("Nombre: " + mostrarE.name + " | Nivel: " + mostrarE.level + " | ID: " + mostrarE.getId());
                    }
                    break;
                case 4:
                    System.out.print("Introduce el nombre del Eetakemon: ");
                    String nombre = sc.nextLine();
                    Eetakemon finded = miControlador.searchByName(nombre);
                    if (finded == null) {
                        System.out.println("No hay resultados");
                    } else {
                        System.out.println("Nombre: " + finded.name + " | Nivel: " + finded.level + " | ID: " + finded.getId());
                    }
                    break;
                case 5:
                    System.out.print("Introduce una parte del nombre: ");
                    String aprox = sc.nextLine();
                    List<Eetakemon> resultado = miControlador.searchAprox(aprox);

                    if (resultado.size() == 0) {
                        System.out.println("No hay resultados");
                    } else {
                        System.out.println(resultado.size() + " Eetakemon encontrados: ");
                        for (int i = 0; i < resultado.size(); i++) {
                            System.out.println("Nombre: " + resultado.get(i).name + " | Nivel: " + resultado.get(i).level +
                                    " | ID: " + resultado.get(i).getId());
                        }
                    }
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;

            }
        }

    }
}
