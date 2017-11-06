package org.proundmega.finanzas.it.core;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.categories.Category;
import org.proundmega.finanzas.core.Ahorro;
import org.proundmega.finanzas.core.Cliente;
import org.proundmega.pruebas.IntegrationTest;

@Category(IntegrationTest.class)
public class ClienteTest {
    
    @Test
    public void calculoDiferenciaDeEdadesCorrecto() {
        Cliente cliente = new Cliente();
        cliente.setEdadActual(10);
        cliente.setEdadRetiro(20);
        
        // Datos no importantes para la prueba
        cliente.setSueldo(10);
        cliente.setPorcentajeAGuardar(1);
        
        Ahorro ahorro = cliente.calcularAhorro();
        
        int esperado = 10;
        assertEquals(esperado, ahorro.getTiempo());
    }
    
    @Test
    public void calculoAnualidadDeInversionCorrecto() {
        Cliente cliente = new Cliente();
        
        cliente.setSueldo(1200);
        cliente.setPorcentajeAGuardar(25);

        // Datos no importantes
        cliente.setEdadActual(10);
        cliente.setEdadRetiro(20);
        
        Ahorro ahorro = cliente.calcularAhorro();
        
        double anualidadEsperada = 3600;
        assertEquals(anualidadEsperada, ahorro.getAnualidad(), 0.01);
    }
}
