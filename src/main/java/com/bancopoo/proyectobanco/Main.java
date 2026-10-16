/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bancopoo.proyectobanco;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== SIMULADOR BANCARIO ===");

        // Crear una cuenta bancaria
        CuentaBancaria cuenta = new CuentaBancaria(
                "1001", "Juan Perez", 5000
        );

        System.out.println("\n--- CUENTA BANCARIA ---");
        cuenta.mostrarDatos();

        System.out.println("\nRealizando deposito de L. 1000");
        cuenta.depositar(1000);

        System.out.println("\nRealizando retiro de L. 500");
        cuenta.retirar(500);

        // Crear una cuenta de ahorro
        CuentaAhorro ahorro = new CuentaAhorro(
                "2001", "Maria Lopez", 3000
        );

        System.out.println("\n--- CUENTA DE AHORRO ---");

        ahorro.retirar(100);
        ahorro.retirar(100);
        ahorro.retirar(100);
        ahorro.retirar(100);

        System.out.println("Retiros realizados: "
                + ahorro.getRetirosRealizados());
        System.out.println("Saldo final: L. " + ahorro.getSaldo());

        // Crear una cuenta corriente con sobregiro
        CuentaCorriente corriente = new CuentaCorriente(
                "3001", "Carlos Gomez", 500, 1000
        );

        System.out.println("\n--- CUENTA CORRIENTE ---");
        corriente.mostrarDatos();

        System.out.println("\nRetiro de L. 1200");
        corriente.retirar(1200);

        System.out.println("\nSaldo final de cuenta corriente: L. "
                + corriente.getSaldo());

        System.out.println("\n=== FIN DEL SIMULADOR ===");
    }
}