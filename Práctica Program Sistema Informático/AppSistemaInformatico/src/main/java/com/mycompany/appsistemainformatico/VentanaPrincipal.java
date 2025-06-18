/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appsistemainformatico;

import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class VentanaPrincipal extends JFrame {

    private GestorEmpleados gestor = new GestorEmpleados();
    private DefaultTableModel modeloTabla;
    private JTextField txtNombre, txtCedula, txtPuesto, txtDepartamento, txtSalario;
    private JTable tabla;

    public VentanaPrincipal() {
        setTitle("Gestion de Empleados - Recursos Humanos Global");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel del formulario
        JPanel panelFormulario = new JPanel(new GridLayout(6, 2, 10, 5));
        txtNombre = new JTextField();
        txtCedula = new JTextField();
        txtPuesto = new JTextField();
        txtDepartamento = new JTextField();
        txtSalario = new JTextField();

        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(txtNombre);
        panelFormulario.add(new JLabel("Cedula:"));
        panelFormulario.add(txtCedula);
        panelFormulario.add(new JLabel("Puesto:"));
        panelFormulario.add(txtPuesto);
        panelFormulario.add(new JLabel("Departamento:"));
        panelFormulario.add(txtDepartamento);
        panelFormulario.add(new JLabel("Salario mensual:"));
        panelFormulario.add(txtSalario);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(e -> agregarEmpleado());
        panelFormulario.add(btnAgregar);

        JButton btnCargar = new JButton("Cargar archivo");
        btnCargar.addActionListener(e -> cargarArchivo());

        add(panelFormulario, BorderLayout.NORTH);

        // Tabla
        String[] columnas = {"Nombre", "Cedula", "Puesto", "Departamento", "Salario", "Fecha Ingreso", "Aguinaldo"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modeloTabla);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // Boton guardar
        JButton btnGuardar = new JButton("Guardar archivo");
        btnGuardar.addActionListener(e -> guardarArchivo());
        add(btnGuardar, BorderLayout.SOUTH);
    }

    public void agregarEmpleado() {
        try {
            String nombre = txtNombre.getText();
            String Cedula = txtCedula.getText();
            String Puesto = txtPuesto.getText();
            String Departamento = txtDepartamento.getText();
            double salario = Double.parseDouble(txtSalario.getText());
            LocalDate fechaIngreso = LocalDate.now();

            Empleado emp = new Empleado(nombre, Cedula, Puesto, Departamento, salario, fechaIngreso);
            gestor.agregarEmpleado(emp);
            actualizarTabla();
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Empleado agregado. ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    public void actualizarTabla() {
        modeloTabla.setRowCount(0);
        for (Empleado emp : gestor.getEmpleados()) {
            modeloTabla.addRow(new Object[]{
                emp.getNombre(),
                emp.getCedula(),
                emp.getPuesto(),
                emp.getDepartamento(),
                emp.getSalario(),
                emp.getFechaIngreso(),
                emp.calcularAguinaldo()
            });
        }
    }

    public void guardarArchivo() {
        try {
            gestor.guardarEmpleados("Empleados.dat");
            JOptionPane.showMessageDialog(this, "Archivo guardado.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage());
        }
    }

    public void cargarArchivo() {
        try {
            gestor.cargarEmpleados("Empleado.dat");
            actualizarTabla();
            JOptionPane.showMessageDialog(this, "Archivo guardado.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage());
        }
    }

    public void limpiarCampos() {
        txtNombre.setText("");
        txtCedula.setText("");
        txtPuesto.setText("");
        txtDepartamento.setText("");
        txtSalario.setText("");

    }

}
