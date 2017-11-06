package org.proundmega.finanzas.core;

import java.text.NumberFormat;
import java.util.Locale;
import lombok.Value;

@Value
public class Ahorro {
    private double anualidad;
    private int tiempo;
    private double tasaInteres;

    public Ahorro(double anualidad, int tiempo, double tasaInteres) {
        this.anualidad = anualidad;
        this.tiempo = tiempo;
        this.tasaInteres = tasaInteres;
        
        validarCampos();
    }
    
    private void validarCampos() {
        if(anualidad <= 0) {
            throw new IllegalArgumentException("La anualidad debe ser mayor que cero");
        }
        if(tiempo <= 0) {
            throw new IllegalArgumentException("El tiempo debe ser mayor que cero");
        }
        if(tasaInteres <= 0) {
            throw new IllegalArgumentException("La tasa de interes debe ser mayor que cero");
        }
    }
    
    public double getValorFinal() {
        return anualidad * (Math.pow(1 + tasaInteres, tiempo)/tasaInteres);
    }
    
    public String getValorFinalAsString() {
        double valor = getValorFinal();
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        
        return format.format(valor);
    }
}
