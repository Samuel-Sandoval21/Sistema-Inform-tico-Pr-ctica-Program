/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appsistemainformatico;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class GestorEmpleados {

    private ArrayList<Empleado> empleados = new ArrayList<>();

    public void agregarEmpleado(Empleado e) {
        empleados.add(e);
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void guardarEmpleados(String archivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(empleados);
        }
    }

    public void cargarEmpleados(String archivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            empleados = (ArrayList<Empleado>) ois.readObject();
        }

    }

}
