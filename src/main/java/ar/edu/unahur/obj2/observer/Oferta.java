package ar.edu.unahur.obj2.observer;

import ar.edu.unahur.obj2.observer.observador.IObservador;

public class Oferta {
    private IObservador subastador;
    private Integer valor;

    
    public Oferta(IObservador subastador, Integer valor) {
        this.subastador = subastador;
        this.valor = valor;
    }
    public IObservador getSubastador() {
        return subastador;
    }
    public Integer getValor() {
        return valor;
    }
    
}
