package ar.edu.unahur.obj2.observer.observado;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepcion.NoEstaElSubastadorException;
import ar.edu.unahur.obj2.observer.observador.IObservador;

public class ProductoSubastado implements IObservado {
    private List<Oferta> ofertasRecibidas = new ArrayList<>();
    
    private List<IObservador> subastadores = new ArrayList<>();
    
    
    public ProductoSubastado() {}
    
    @Override
    public void notificar(Oferta oferta) {
        this.ofertasRecibidas.add(oferta);
        this.subastadores.forEach(o -> o.recibirOferta(oferta));
    }
    @Override
    public void agregarObservador(IObservador observador) {
        this.subastadores.add(observador);
    }
    @Override
    public void quitarObservador(IObservador observador) {
        this.subastadores.remove(observador);
    }
    

    @Override
    public void reiniciarProducto() {
        this.ofertasRecibidas.clear();
        this.subastadores.clear();
    }
    
    @Override
    public Oferta ultimaOfertaRegistrada() {
        return this.ofertasRecibidas.getLast();
    }
    
    @Override
    public List<Oferta> getOfertasRecibidas() {
        return ofertasRecibidas;
    }

    @Override
    public List<IObservador> getSubastadores() {
        return subastadores;
    }
}
