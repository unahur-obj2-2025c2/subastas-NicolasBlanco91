package ar.edu.unahur.obj2.observer.observador;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepcion.NoEstaElSubastadorException;
import ar.edu.unahur.obj2.observer.observado.ProductoSubastado;

public abstract class Subastador implements IObservador {
    private final String nombre;
    protected Oferta ultimaOferta;

    
    public Subastador(String nombre) {
        this.nombre = nombre;
        reiniciarOferta();
    }
    
    @Override
    public void recibirOferta(Oferta oferta) {
        this.ultimaOferta = oferta;
    }

    @Override
    public void agregarOferta(ProductoSubastado producto) {
        estoyEnLaSubasta(producto);
        Oferta nuevaOferta = doAgregarOferta(producto);
        producto.notificar(nuevaOferta); 
    }

    public abstract Oferta doAgregarOferta(ProductoSubastado producto);

    @Override
    public void reiniciarOferta() {
        this.ultimaOferta = new Oferta(this, 0);
    }
    
    public Oferta getUltimaOferta() {
        return ultimaOferta;
    }

    public void estoyEnLaSubasta(ProductoSubastado producto) {
        if (!producto.getSubastadores().contains(this)) {
            throw new NoEstaElSubastadorException("El subastador no esta en esta subasta");
            }
    }
}
