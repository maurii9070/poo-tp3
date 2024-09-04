package ar.edu.unju.fi.poo.manager;

import ar.edu.unju.fi.poo.util.ImportesConstantes;
import ar.edu.unju.fi.poo.dominio.Administrativo;
import ar.edu.unju.fi.poo.dominio.Empleado;
import ar.edu.unju.fi.poo.dominio.Profesional;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpresaManager {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    private static int idAux = 100;
    public static List <Empleado> empleados = new ArrayList<>();

    /**
     * Genera empleados de prueba
     */
    public static void generarEmpleados(){
        empleados.add(new Administrativo(1, "A0001", "Juan Perez", 2,
                                         LocalDate.of(1992, 1, 1), 5, 3));
        empleados.add(new Administrativo(2, "A0002", "Juan Carlos", 1,
                                         LocalDate.of(1996, 4, 23), 1, 3));
        empleados.add(new Administrativo(3, "A0003", "Jose Zapana", 1,
                                         LocalDate.of(2000, 9, 5), 4, 5));
        empleados.add(new Administrativo(4, "A0004", "Mauricio Velazquez", 2,
                                         LocalDate.of(1998, 10, 10), 5, 9));
        empleados.add(new Administrativo(5, "A0005", "Ale Velazquez", 0,
                                         LocalDate.of(1994, 3, 13), 3, 10));
        empleados.add(new Administrativo(6, "A0006", "Rocio De Velazquez", 5,
                                         LocalDate.of(2001, 1, 10), 7, 18));

        empleados.add(new Profesional(7, "P0001", "Maria Lopez", 2,
                                      LocalDate.of(1996, 1, 1), 1, true));
        empleados.add(new Profesional(8, "P0002", "Martin Palermo", 3,
                                      LocalDate.of(1994, 1, 1), 8, true));
        empleados.add(new Profesional(9, "P0003", "Roman Riquelme", 1,
                                      LocalDate.of(2002, 1, 1), 5, true));
        empleados.add(new Profesional(10, "P0004", "Gary Medel", 0,
                                      LocalDate.of(1993, 1, 1), 3, true));
        empleados.add(new Profesional(11, "P0005", "Lionel Messi", 0,
                                      LocalDate.of(1992, 1, 1), 2, true));
        empleados.add(new Profesional(12, "P0006", "Cristian Nodal", 3,
                                      LocalDate.of( 1998, 1, 1), 1, true));
    }

    /**
     * Formatea un valor a moneda
     * @param valor se recibe el valor a formatear
     * @return el valor formateado
     */
    public static String formatearMoneda(float valor){
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance();

        return formatoMoneda.format(valor);
    }

    /**
     * Agrega un empleado a la lista
     */
    public static void agregarEmpleado() {
        String legajo, nombre, tituloStr, tipo;
        int hijos, categoria;
        boolean titulo;

        Scanner sc = new Scanner(System.in);

        idAux += 1;

        do{
            try {
                System.out.print("Es (P)rofesional o (A)dministrativo: ");
                tipo = sc.nextLine().toLowerCase();
            } catch (Exception e){
                System.out.println(ANSI_RED+"Error: " + e.getMessage() + ANSI_RESET);
                tipo = "";
            }
        } while (!tipo.equals("p") && !tipo.equals("a"));

        do{
            System.out.print("Ingrese un legajo: ");
            legajo = sc.nextLine();
            if (legajo.isEmpty()) {
                System.out.println(ANSI_RED+"Legajo no puede estar vacio."+ANSI_RESET);
            }
        } while (legajo.isEmpty());

        do{
            System.out.print("Ingrese un nombre: ");
            nombre = sc.nextLine();
            if (nombre.isEmpty()) {
                System.out.println(ANSI_RED+"Nombre no puede estar vacio."+ANSI_RESET);
            }
        } while (nombre.isEmpty());

        do {
            try {
                System.out.print("Ingrese cantidad de hijos: ");
                hijos = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED+"Error: " + e.getMessage() + ANSI_RESET);
                hijos = -1;
            }
        } while (hijos < 0);

        int dia, mes, anio;
        while (true){
            try {
                System.out.println("Ingrese fecha nacimiento");
                System.out.print("Dia: ");
                dia = Integer.parseInt(sc.nextLine());
                System.out.print("Mes: ");
                mes = Integer.parseInt(sc.nextLine());
                System.out.print("Anio: ");
                anio = Integer.parseInt(sc.nextLine());

                if (dia < 1 || dia > 31 || mes < 1 || mes > 12 || anio < 1950 || anio > 2006) {
                    System.out.println(ANSI_RED+"Fecha invalida."+ANSI_RESET);
                }else {
                    break;
                }
            } catch (NumberFormatException e){
                System.out.println(ANSI_RED+"Error: " + e.getMessage() + ANSI_RESET);;
            }
        }

        int antiguedad = 0; // Es nuevo, no tiene antiguedad
        switch (tipo) {
            case "p":
                do {
                    System.out.print("Tiene titulo (S/N): ");
                    tituloStr = sc.nextLine().toLowerCase();
                } while (!tituloStr.equals("s") && !tituloStr.equals("n"));

                // Si tiene titulo, evalua a true, sino a false
                titulo = tituloStr.equalsIgnoreCase("s");

                Profesional profesional = new Profesional(idAux, legajo, nombre, hijos, LocalDate.of(anio, mes, dia),
                                                          antiguedad, titulo);
                empleados.add(profesional);
                System.out.println(ANSI_GREEN+profesional+ANSI_RESET);
                break;

            case "a":
                do {
                    try{
                        System.out.print("Ingrese categoria [1-20]: ");
                        categoria = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e){
                        System.out.println(ANSI_RED+"Error: " + e.getMessage() + ANSI_RESET);
                        categoria = -1;
                    }
                } while (categoria < 1 || categoria > 20);

                Administrativo administrativo = new Administrativo(idAux, legajo, nombre, hijos,
                                                                   LocalDate.of(anio, mes, dia), antiguedad,
                                                                   categoria);
                empleados.add(administrativo);
                System.out.println(ANSI_GREEN+administrativo+ANSI_RESET);
                break;
            default:
                break;
        }
    }

    /**
     * Muestra los empleados con antiguedad mayor a un valor determinado
     * @param antiguedad se recibe la antiguedad a comparar
     */
    public static void mostrarPorAntiguedadMayorA(int antiguedad){
        float remunerativoAcumulado = 0;
        float salarioFamiliarAcumulado = 0;
        float descuentoAcumulado = 0;
        float importeNetoAcumulado = 0;

        System.out.println(ANSI_GREEN+"Empleados con antiguedad mayor a " + antiguedad + " años"+ANSI_RESET);
        for (Empleado empleado : empleados) {
            if(empleado.getAntiguedad() > antiguedad){
                System.out.println(ANSI_GREEN + empleado + ANSI_RESET);
                remunerativoAcumulado += empleado.getRemunerativosBonificables();
                salarioFamiliarAcumulado += empleado.getSalarioFamiliar();
                descuentoAcumulado += empleado.calcularDescuento(empleado.getRemunerativosBonificables());
                importeNetoAcumulado += empleado.getSueldo();
            }
        }

        System.out.println(ANSI_GREEN+"Remunerativo acumulado: " + formatearMoneda(remunerativoAcumulado)+ANSI_RESET);
        System.out.println(ANSI_GREEN+"Salario familiar acumulado: " + formatearMoneda(salarioFamiliarAcumulado)+ANSI_RESET);
        System.out.println(ANSI_GREEN+"Descuento acumulado: " + formatearMoneda(descuentoAcumulado)+ANSI_RESET);
        System.out.println(ANSI_GREEN+"Importe neto acumulado: " + formatearMoneda(importeNetoAcumulado)+ANSI_RESET);
    }

    /**
     * Muestra los empleados mayores a una edad determinada
     * @param edad se recibe la edad a comparar
     */
    public static void mostrarPorEdadMayoroIgual(int edad){
        float remunerativoAcumulado = 0;
        float salarioFamiliarAcumulado = 0;
        float descuentoAcumulado = 0;
        float importeNetoAcumulado = 0;
        System.out.println(ANSI_GREEN+"Empleados mayores o iguales a " + edad + " años"+ANSI_RESET);
        for (Empleado empleado : empleados) {
            if(empleado.getEdad() > edad){
                System.out.println(ANSI_GREEN + empleado + ANSI_RESET);
                remunerativoAcumulado += empleado.getRemunerativosBonificables();
                salarioFamiliarAcumulado += empleado.getSalarioFamiliar();
                descuentoAcumulado += empleado.calcularDescuento(empleado.getRemunerativosBonificables());
                importeNetoAcumulado += empleado.getSueldo();
            }
        }
        System.out.println(ANSI_GREEN+"---------------------------------------"+ANSI_RESET);
        System.out.println(ANSI_GREEN+"Remunerativo acumulado: " + formatearMoneda(remunerativoAcumulado)+ANSI_RESET);
        System.out.println(ANSI_GREEN+"Salario familiar acumulado: " + formatearMoneda(salarioFamiliarAcumulado)+ANSI_RESET);
        System.out.println(ANSI_GREEN+"Descuento acumulado: " + formatearMoneda(descuentoAcumulado)+ANSI_RESET);
        System.out.println(ANSI_GREEN+"Importe neto acumulado: " + formatearMoneda(importeNetoAcumulado)+ANSI_RESET);
        System.out.println(ANSI_GREEN+"---------------------------------------"+ANSI_RESET);
    }

    /**
     * Muestra el importe neto de los empleados mayores a una edad determinada
     * @param edad se recibe la edad a comparar
     */
    public static void verImporteNetoPorEdadMayoroIgual(int edad){
        float importeNetoAcumulado = 0;

        System.out.println(ANSI_GREEN+"Importe neto de empleados mayores o iguales a " + edad + " años"+ANSI_RESET);
        for (Empleado empleado : empleados) {
            if(empleado.getEdad() >= edad){
                importeNetoAcumulado += empleado.getSueldo();
            }
        }
        System.out.println(ANSI_GREEN+"---------------------------------------"+ANSI_RESET);
        System.out.println(ANSI_GREEN+"Importe neto acumulado: " + formatearMoneda(importeNetoAcumulado)+ANSI_RESET);
        System.out.println(ANSI_GREEN+"---------------------------------------"+ANSI_RESET);
    }

    /**
     * Incrementa el sueldo basico de los empleados por antiguedad menor a un valor determinado
     * @param antiguedad se recibe la antiguedad a comparar
     */
    public static void incrementarSueldoBasicoPorAntiguedad(int antiguedad){
        for (Empleado empleado : empleados) {
            if(empleado.getAntiguedad() < antiguedad){
                // Aumento del 10%
                float aumento = ImportesConstantes.SUELDO_BASICO * 1.10f - ImportesConstantes.SUELDO_BASICO;
                // Nuevo sueldo basico
                float nuevoBasico = ImportesConstantes.SUELDO_BASICO * 1.10f;
                // Nuevo remunerativo bonificable
                float nuevoRemunerativo = empleado.getRemunerativosBonificables() - ImportesConstantes.SUELDO_BASICO + nuevoBasico;
                // Nuevo sueldo neto
                float nuevoSueldo = nuevoRemunerativo + empleado.getSalarioFamiliar() - empleado.calcularDescuento(nuevoRemunerativo);

                System.out.println(ANSI_GREEN+"-----------------------------"+ANSI_RESET);
                System.out.println(ANSI_GREEN+"Empleado: " + empleado.getNombre() + " - Aumento: " + formatearMoneda(aumento)+ANSI_RESET);
                System.out.println(ANSI_GREEN+"Sueldo anterior: " + formatearMoneda(empleado.getSueldo())+ANSI_RESET);
                System.out.println(ANSI_GREEN+"Sueldo actual: " + formatearMoneda(nuevoSueldo)+ANSI_RESET);

            }
        }
        System.out.println("-----------------------------");
    }

    /**
     * Muestra todos los empleados
     */
    public static void mostrarEmpleados() {
        empleados.forEach(empleado -> System.out.println(ANSI_GREEN+empleado+ANSI_RESET));
    }
}
