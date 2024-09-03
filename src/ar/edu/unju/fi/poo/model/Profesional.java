package ar.edu.unju.fi.poo.model;

import ar.edu.unju.fi.poo.constantes.ImportesConstantes;

import java.time.LocalDate;

public class Profesional extends Empleado {
    private Boolean tieneTitulo;

    public Profesional(Integer id, String legajo, String nombre, Integer cantidadHijos,
                       LocalDate fechaNacimiento, Integer antiguedad, Boolean tieneTitulo) {
        super(id, legajo, nombre, cantidadHijos, fechaNacimiento, antiguedad);
        this.tieneTitulo = tieneTitulo;
    }

    @Override
    public String toString() {
        return super.toString() + ", Profesional{" +
                "tieneTitulo=" + tieneTitulo +
                '}';
    }

    public Boolean getTieneTitulo() {
        return tieneTitulo;
    }

    public void setTieneTitulo(Boolean tieneTitulo) {
        this.tieneTitulo = tieneTitulo;
    }

    @Override
    public Float getAdicionales(){
        return tieneTitulo ? ImportesConstantes.ADICIONAL_TITULO : 0f;
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
