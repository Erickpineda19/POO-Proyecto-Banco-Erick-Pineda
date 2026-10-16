/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bancopoo.proyectobanco;

public class CuentaBancaria {

    // Atributos publicos
    public String numeroCuenta;
    public String titular;

    // Atributos privados
    private double saldo;
    private int totalTransacciones;

    // Constructor
    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;

        if (saldoInicial >= 0) {
            this.saldo = saldoInicial;
        } else {
            this.saldo = 0.0;
        }

        this.totalTransacciones = 0;
    }

    // Obtener el saldo
    public double getSaldo() {
        return saldo;
    }

    // Obtener el total de transacciones
    public int getTotalTransacciones() {
        return totalTransacciones;
    }

    // Depositar dinero
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            totalTransacciones++;

            System.out.println("Deposito exitoso.");
            System.out.println("Saldo actual: L. " + saldo);
        } else {
            System.out.println("Error: el monto debe ser mayor que cero.");
        }
    }

    // Retirar dinero
    public boolean retirar(double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
            totalTransacciones++;

            System.out.println("Retiro exitoso.");
            System.out.println("Saldo actual: L. " + saldo);

            return true;
        } else {
            System.out.println("Error: monto invalido o saldo insuficiente.");
            return false;
        }
    }

    // Mostrar informacion de la cuenta
    public void mostrarDatos() {
        System.out.println("Numero de cuenta: " + numeroCuenta);
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: L. " + saldo);
        System.out.println("Total de transacciones: " + totalTransacciones);
    }
        // Aplicar un cargo adicional, como una comision
    protected void aplicarCargo(double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
            totalTransacciones++;
        }
    }
    protected void registrarSobregiro(double monto) {
    if (monto > 0) {
        saldo -= monto;
        totalTransacciones++;
    }
}
}