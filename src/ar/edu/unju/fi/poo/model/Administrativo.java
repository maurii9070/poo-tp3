package ar.edu.unju.fi.poo.model;

import ar.edu.unju.fi.poo.constantes.ImportesConstantes;

import java.time.LocalDate;

public class Administrativo extends Empleado {
    private Integer categoria;

    public Administrativo(Integer id, String legajo, String nombre, Integer cantidadHijos,
                          LocalDate fechaNacimiento, Integer antiguedad, Integer categoria) {
        super(id, legajo, nombre, cantidadHijos, fechaNacimiento, antiguedad);
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return super.toString() + ", Administrativo{" +
                "categoria=" + categoria +
                '}';
    }

    public Integer getCategoria() {
        return categoria;
    }

    public void setCategoria(Integer categoria) {
        this.categoria = categoria;
    }

    @Override
    public Float getAdicionales(){
        return ImportesConstantes.getValorCategoria(categoria);
    }

    @Override
    public Float getRemunerativosBonificables(){
        return super.getRemunerativosBonificables() + getAdicionales();
    }

    @Override
    public Float getSueldo(){
        float descuentoRemunerativo = super.calcularDescuento(getRemunerativosBonificables());
        return getRemunerativosBonificables() + super.getSalarioFamiliar() - descuentoRemunerativo;
    }
}
