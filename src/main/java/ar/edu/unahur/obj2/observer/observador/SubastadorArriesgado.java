package ar.edu.unahur.obj2.observer.observador;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observado.ProductoSubastado;

public class SubastadorArriesgado extends Subastador {

    public SubastadorArriesgado(String nombre) {
        super(nombre);
    }

    @Override
    public Oferta doAgregarOferta(ProductoSubastado producto) {
        return new Oferta(this, this.ultimaOferta.getValor() + 10);
    }


}
