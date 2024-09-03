package ar.edu.unju.fi.poo.model;

import ar.edu.unju.fi.poo.constantes.ImportesConstantes;

import java.time.LocalDate;
import java.time.Period;

public abstract class Empleado {
    private Integer id;
    private String legajo;
    private String nombre;
    private Integer cantidadHijos;
    private LocalDate fechaNacimiento;
    private Integer antiguedad;

    public Empleado(Integer id, String legajo, String nombre, Integer cantidadHijos,
                    LocalDate fechaNacimiento, Integer antiguedad) {
        this.id = id;
        this.legajo = legajo;
        this.nombre = nombre;
        this.cantidadHijos = cantidadHijos;
        this.fechaNacimiento = fechaNacimiento;
        this.antiguedad = antiguedad;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", legajo='" + legajo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cantidadHijos=" + cantidadHijos +
                ", fechaNacimiento=" + fechaNacimiento +
                ", antiguedad=" + antiguedad +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadHijos() {
        return cantidadHijos;
    }

    public void setCantidadHijos(Integer cantidadHijos) {
        this.cantidadHijos = cantidadHijos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad(){
        Period edad = Period.between(fechaNacimiento, LocalDate.now());
        return edad.getYears();
    }

    public Integer getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Integer antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Float getRemunerativosBonificables() {
        return ImportesConstantes.SUELDO_BASICO + (ImportesConstantes.VALOR_ANTIGUEDAD * getAntiguedad());
    }

    public Float getSalarioFamiliar(){
        return ImportesConstantes.VALOR_HIJO * getCantidadHijos();
    }

    public float calcularDescuento(float remunerativo){
        return remunerativo * ImportesConstantes.PORCENTAJE_DESCUENTOS;
    }

    public abstract Float getAdicionales();
    public abstract Float getSueldo();
}
