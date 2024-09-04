package ar.edu.unju.fi.poo.main;

import ar.edu.unju.fi.poo.manager.EmpresaManager;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmpresaManager.generarEmpleados();

        int opcion;
        do {
            menu();
            System.out.print("Ingrese una opcion -> ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion){
                case 1:
                    EmpresaManager.agregarEmpleado();
                    break;
                case 2:
                    while (true) {
                        try{
                            System.out.print("Ingrese la antiguedad: ");
                            int antiguedad = Integer.parseInt(sc.nextLine());
                            if (antiguedad < 0){
                                System.out.println("La antiguedad no puede ser negativa.");
                            } else {
                                EmpresaManager.mostrarPorAntiguedadMayorA(antiguedad);
                                break;
                            }
                        } catch (NumberFormatException e){
                            System.out.println("Debe ingresar un numero.");
                        }
                    }
                    break;
                case 3:
                    while (true) {
                        try{
                            System.out.print("Ingrese la edad: ");
                            int edad = Integer.parseInt(sc.nextLine());
                            if (verificarEdad(edad)) {
                                EmpresaManager.mostrarPorEdadMayoroIgual(edad);
                                break;
                            }
                        } catch (NumberFormatException e){
                            System.out.println("Debe ingresar un numero.");
                        }
                    }
                    break;
                case 4:
                    while (true) {
                        try{
                            System.out.print("Ingrese la edad: ");
                            int edad = Integer.parseInt(sc.nextLine());
                            if (verificarEdad(edad)) {
                                EmpresaManager.verImporteNetoPorEdadMayoroIgual(edad);
                                break;
                            }
                        } catch (NumberFormatException e){
                            System.out.println("Debe ingresar un numero.");
                        }
                    }
                    break;
                case 5:
                    int antiguedadAumento = 2; // 2 anios
                    EmpresaManager.incrementarSueldoBasicoPorAntiguedad(antiguedadAumento);
                    break;
                case 6:
                    EmpresaManager.mostrarEmpleados();
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (opcion != 7);

        sc.close();
    }

    public static void menu(){
        System.out.println("1. Agregar Empleado.");
        System.out.println("2. Mostrar empleados con antiguedad mayor a un valor determinado.");
        System.out.println("3. Mostrar empleados mayores a una edad determinada.");
        System.out.println("4. Ver importe neto de empleados mayores a una edad determinada.");
        System.out.println("5. Incrementar S. Basico de empleados menor o igual a 2 anios.");
        System.out.println("6. Ver todos los empleados.");
        System.out.println("7. Salir.");
    }

    /**
     * Verifica si la edad es mayor o igual a 18 y menor o igual a 65.
     * @param edad Edad a verificar.
     * @return True si la edad es mayor o igual a 18 y menor o igual a 65, false en caso contrario.
     */
    public static boolean verificarEdad(int edad){
        return edad >= 18 && edad <= 65;
    }

}
