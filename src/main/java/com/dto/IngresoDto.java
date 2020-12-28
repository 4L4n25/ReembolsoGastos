package com.dto;

public class IngresoDto {

    private Integer idIngreso;
    private String fechaIngreso;
    private Float ingreso;
    private String descripcion;
    private String cuenta;

    public Integer getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(Integer idIngreso) {
        this.idIngreso = idIngreso;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Float getIngreso() {
        return ingreso;
    }

    public void setIngreso(Float ingreso) {
        this.ingreso = ingreso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }
}
