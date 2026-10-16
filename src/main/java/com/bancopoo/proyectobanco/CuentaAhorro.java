/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bancopoo.proyectobanco;

public class CuentaAhorro extends CuentaBancaria {

    private int retirosRealizados;
    private static final double COMISION = 20.0;

    // Constructor
    public CuentaAhorro(String numeroCuenta, String titular,
                        double saldoInicial) {
        super(numeroCuenta, titular, saldoInicial);
        this.retirosRealizados = 0;
    }

    // Consultar los retiros realizados
    public int getRetirosRealizados() {
        return retirosRealizados;
    }

    // Retirar dinero aplicando comision desde el cuarto retiro
    @Override
    public boolean retirar(double monto) {

        if (monto <= 0) {
            System.out.println("Error: el monto debe ser mayor que cero.");
            return false;
        }

        // Desde el cuarto retiro se cobra una comision de L. 20
        boolean cobraComision = retirosRealizados >= 3;

        double totalNecesario = monto;
        if (cobraComision) {
            totalNecesario += COMISION;
        }

        if (getSaldo() < totalNecesario) {
            System.out.println(
                "Error: saldo insuficiente para el retiro y la comision."
            );
            return false;
        }

        boolean retiroExitoso = super.retirar(monto);

        if (retiroExitoso) {
            retirosRealizados++;

            if (cobraComision) {
                aplicarCargo(COMISION);
                System.out.println(
                    "Se aplico una comision de L. " + COMISION
                );
                System.out.println("Saldo final: L. " + getSaldo());
            }
        }

        return retiroExitoso;
    }
}