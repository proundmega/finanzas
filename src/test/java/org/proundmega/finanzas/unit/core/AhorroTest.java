package org.proundmega.finanzas.unit.core;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.categories.Category;
import org.proundmega.finanzas.core.Ahorro;
import org.proundmega.pruebas.UnitTest;

@Category(UnitTest.class)
public class AhorroTest {
    
    @Test
    public void calculoFinalCorrecto1() {
        Ahorro ahorro = new Ahorro(1000, 10, 0.05);
        double esperado = 32577.89;
        
        assertEquals(esperado, ahorro.getValorFinal(), 0.01);
    }
    
    @Test
    public void calculoFinalCorrecto2() {
        Ahorro ahorro = new Ahorro(12000, 30, 0.1);
        double esperado = 2093928.27;
        
        assertEquals(esperado, ahorro.getValorFinal(), 0.01);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void calculoFinalConValoresNegativos() {
        double anualidadNegativa = -1000;
        
        Ahorro ahorro = new Ahorro(anualidadNegativa, 20, 0.05);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void calculoFinalConAnualidadCero() {
        double anualidadCero = 0;
        
        Ahorro ahorro = new Ahorro(anualidadCero, 30, 0.06);
    }
    
}
