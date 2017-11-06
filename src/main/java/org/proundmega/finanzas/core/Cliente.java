package org.proundmega.finanzas.core;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Cliente {
    private double sueldo;
    private int porcentajeAGuardar;
    private int edadActual;
    private int edadRetiro;
    
    public static final double TASA_INTERES = 0.08;
    
    public Ahorro calcularAhorro(){
        int años = edadRetiro - edadActual;
        double anualidad = sueldo*porcentajeAGuardar*12/100;
        
        return new Ahorro(anualidad, años, TASA_INTERES);
    }
}
