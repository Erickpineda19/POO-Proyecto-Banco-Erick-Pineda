/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bancopoo.proyectobanco;

public class CuentaCorriente extends CuentaBancaria {

    private double limiteSobregiro;

    // Constructor
    public CuentaCorriente(String numeroCuenta, String titular,
                           double saldoInicial, double limiteSobregiro) {
        super(numeroCuenta, titular, saldoInicial);

        if (limiteSobregiro >= 0) {
            this.limiteSobregiro = limiteSobregiro;
        } else {
            this.limiteSobregiro = 0;
        }
    }

    // Consultar el limite de sobregiro
    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }

    // Retirar dinero permitiendo sobregiro
    @Override
    public boolean retirar(double monto) {

        if (monto <= 0) {
            System.out.println("Error: el monto debe ser mayor que cero.");
            return false;
        }

        if (getSaldo() - monto >= -limiteSobregiro) {

            if (monto <= getSaldo()) {
                return super.retirar(monto);
            }

            // El retiro utiliza el saldo disponible y el sobregiro
            double saldoActual = getSaldo();
            double parteSobregiro = monto - saldoActual;

            if (saldoActual > 0) {
                super.retirar(saldoActual);
            }

            aplicarSobregiro(parteSobregiro);

            System.out.println("Retiro realizado con sobregiro.");
            System.out.println("Saldo actual: L. " + getSaldo());

            return true;

        } else {
            System.out.println("Error: limite de sobregiro excedido.");
            return false;
        }
    }

    // Registrar la parte utilizada del sobregiro
    private void aplicarSobregiro(double monto) {
        if (monto > 0) {
            super.retirar(0.01);
            ajustarSobregiro(monto);
        }
    }

    private void ajustarSobregiro(double monto) {
        // El saldo se ajusta mediante el metodo protegido de la clase padre.
        registrarSobregiro(monto);
    }
    
}