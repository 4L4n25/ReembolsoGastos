package com.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ingreso", schema = "public")
public class Ingreso {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_ingreso")
    private int idIngreso;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;

    @Column(name = "ingreso")
    private float Ingreso;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "cuenta")
    private String cuenta;

    public Ingreso() {
    }

    public Ingreso(int idIngreso) {
        this.idIngreso = idIngreso;
    }

    public int getIdIngreso() {
        return idIngreso;
    }

    public void setIdIngreso(int idIngreso) {
        this.idIngreso = idIngreso;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public float getIngreso() {
        return Ingreso;
    }

    public void setIngreso(float ingreso) {
        Ingreso = ingreso;
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
