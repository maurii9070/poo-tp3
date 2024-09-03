package ar.edu.unju.fi.poo.main;

import ar.edu.unju.fi.poo.manager.EmpresaManager;
import ar.edu.unju.fi.poo.model.Empleado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Empleado> empleados = new ArrayList<>();
        EmpresaManager.generarEmpleados(empleados);

        int opcion;
        do {
            menu();
            System.out.print("Ingrese una opcion -> ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion){
                case 1:
                    EmpresaManager.agregarEmpleado(empleados);
                    break;
                case 2:
                    System.out.print("Ingrese la antiguedad: ");
                    int antiguedad = Integer.parseInt(sc.nextLine());
                    EmpresaManager.mostrarPorAntiguedadMayorA(empleados, antiguedad);
                    break;
                case 3:
                    System.out.print("Ingrese la edad: ");
                    int edad = Integer.parseInt(sc.nextLine());
                    EmpresaManager.mostrarPorEdadMayoroIgual(empleados, edad);
                    break;
                case 4:
                    System.out.print("Ingrese la edad: ");
                    int edadImporte = Integer.parseInt(sc.nextLine());
                    EmpresaManager.verImporteNetoPorEdadMayoroIgual(empleados, edadImporte);
                    break;
                case 5:
                    int antiguedadAumento = 2;
                    EmpresaManager.incrementarSueldoBasicoPorAntiguedad(empleados, antiguedadAumento);
                    break;
                case 6:
                    EmpresaManager.mostrarEmpleados(empleados);
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
        System.out.println("5. Incrementar sueldo basico de empleados por antiguedad menor a un valor determinado.");
        System.out.println("6. Ver empleados(todos).");
        System.out.println("7. Salir.");
    }

}
