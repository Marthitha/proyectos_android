package com.example.marthitha.trabajadores.model;

/**
 * Created by Marthitha on 14/03/2018.
 */

public class Trabajador {
    private int id;
    private String apellidoP;
    private String apellidoM;
    private String nombre;
    private String curp;
    private String puesto;
    private int sexo;
    private String departamento;

    public Trabajador() {
        this.id = id;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.nombre = nombre;
        this.curp = curp;
        this.puesto = puesto;
        this.sexo = sexo;
        this.departamento = departamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Trabajador{" +
                ", apellidoP='" + apellidoP + '\'' +
                ", apellidoM='" + apellidoM + '\'' +
                ", nombre='" + nombre + '\'' +
                ", curp='" + curp + '\'' +
                ", puesto='" + puesto + '\'' +
                ", departamento='" + departamento + '\'' +
                '}';
    }
}
