package com.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ingreso", schema = "public")
public class Ingreso {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_ingreso")
    private int idIngreso;//esto se jala al front

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;//esto se jala al front

    @Column(name = "ingreso")
    private float ingreso;//esto se jala al front

    @Column(name = "descripcion")
    private String descripcion;//esto se jala al front

    @Column(name = "cuenta")
    private String cuenta;//esto se jala al front

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
        return ingreso;
    }

    public void setIngreso(float ingreso) {
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
