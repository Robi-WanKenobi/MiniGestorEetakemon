package MiniGestorEetakemon;

//1. Añadir Eetakemon
//2. Borrar Eetakemon por id
//3. Listar
//4. Buscar por nombre
//* id autogenerado
//* tiene que haber 3 clases (modelo - Eetakemon, controlador - lógica del programa, la lista, vista - ofrecer opciones

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        ListaEetakemon milista = new ListaEetakemon();
        int generatedid = 0;

        Scanner sc = new Scanner(System.in);
        int option = 99;

        while (option != 0) {

            System.out.println("1. Añadir Eetakemon");
            System.out.println("2. Borrar Eetakemon");
            System.out.println("3. Mostrar todos los Eetakemon");
            System.out.println("4. Buscar Eetakemon");
            System.out.println("5. Buscar Eetakemon por aproximación");
            System.out.print("Seleccione una opción indicando el número: ");
            
            option = Integer.parseInt(sc.nextLine());


            switch (option) {
                case 1:
                    Eetakemon nuevo = new Eetakemon();
                    System.out.println("Introduce el nombre del Eetakemon: ");
                    nuevo.name = sc.nextLine();
                    System.out.println("Introduce el nivel del Eetakemon: ");
                    nuevo.level = Integer.parseInt(sc.nextLine());
                    nuevo.setId(generatedid);
                    milista.addEetakemon(nuevo);
                    generatedid++;
                    break;
                case 2:
                    System.out.println("¿Que identificador quieres borrar?");
                    int delId = Integer.parseInt(sc.nextLine());
                    List<Eetakemon> borrar = milista.getList();

                    for (int i = 0; i < borrar.size(); i++) {
                        if (borrar.get(i).getId() == delId)
                        {
                            milista.delEetakemon(i);
                        }
                        else{
                            System.out.println("No hay ningun Eetakemon con ese identificador");
                        }
                    }
                    break;
                case 3:
                    List<Eetakemon> mostrar = milista.getList();

                    if (mostrar.size() == 0){
                        System.out.println("La lista esta vacía");
                    }
                    else {
                        System.out.println("Hay " + mostrar.size() + " Eetakemon: ");
                        for (int i = 0; i < mostrar.size(); i++) {
                            System.out.println("Nombre: " + mostrar.get(i).name + " | Nivel: " + mostrar.get(i).level +
                                    " | ID: " + mostrar.get(i).getId());
                        }
                    }
                    break;
                case 4:
                    System.out.println("Introduce el nombre del Eetakemon: ");
                    String searchedName = sc.nextLine();
                    Eetakemon searchedList = milista.searchByName(searchedName);

                    if (searchedList == null) {
                        System.out.println("No hay Eetakemon con ese nombre");
                    } else {
                        System.out.println("Identificador: " + searchedList.getId());
                        System.out.println("Nombre: " + searchedList.name);
                        System.out.println("Nivel: " + searchedList.level);
                    }
                    break;
                case 5:
                    String aprox = sc.nextLine();
                    List<Eetakemon> resultado = milista.searchAprox(aprox);

                    if (resultado.size() == 0) {
                        System.out.println("La lista esta vacía");
                    } else {
                        System.out.println("Hay " + resultado.size() + " Eetakemon: ");
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
