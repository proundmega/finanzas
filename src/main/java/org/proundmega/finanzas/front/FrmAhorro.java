package org.proundmega.finanzas.front;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import lombok.Data;
import org.proundmega.finanzas.core.Ahorro;
import org.proundmega.finanzas.core.Cliente;

@Named
@RequestScoped
@Data
public class FrmAhorro {
    private Cliente cliente;
    private boolean hayCalculo = false;
    private Ahorro ahorrosCalculados;
    
    public FrmAhorro() {
        cliente = new Cliente();
    }
    
    public void calcularFondosParaRetiro() {
        hayCalculo = true;
        ahorrosCalculados = cliente.calcularAhorro();
    }
}
