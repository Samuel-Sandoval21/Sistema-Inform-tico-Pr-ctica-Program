/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appsistemainformatico;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author HP
 */
public class Empleado implements Serializable {

    private static final long serialVersion = 1L;

    private String nombre;
    private String cedula;
    private String puesto;
    private String departamento;
    private double salario;
    private LocalDate fechaIngreso;

    public Empleado(String nombre, String cedula, String puesto, String departamento, double salario, LocalDate fechaIngreso) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.puesto = puesto;
        this.departamento = departamento;
        this.salario = salario;
        this.fechaIngreso = fechaIngreso;

    }

    public double calcularAguinaldo() {
        return salario; // Se simplifica a 1 mes de salario
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getPuesto() {
        return puesto;
    }

    public String getDepartamento() {
        return departamento;
    }

    public double getSalario() {
        return salario;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

}
