package ar.edu.unahur.obj2.observer.observado;

import java.util.List;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observador.IObservador;

public interface IObservado {
    public void notificar(Oferta oferta);

    public void agregarObservador(IObservador observador);

    public void quitarObservador(IObservador observador);

    public void reiniciarProducto();

    public Oferta ultimaOfertaRegistrada();

    public List<Oferta> getOfertasRecibidas();

    public List<IObservador> getSubastadores();
}
