package ar.edu.unahur.obj2.observer.observador;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observado.ProductoSubastado;

public interface IObservador {
    public void recibirOferta(Oferta oferta);

    public void agregarOferta(ProductoSubastado producto);

    public void reiniciarOferta();
}
