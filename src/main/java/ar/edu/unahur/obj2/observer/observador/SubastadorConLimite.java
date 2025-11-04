package ar.edu.unahur.obj2.observer.observador;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepcion.SuperoElUmbralException;
import ar.edu.unahur.obj2.observer.observado.ProductoSubastado;

public class SubastadorConLimite extends Subastador {
    
    private final Integer umbral;
    
    public SubastadorConLimite(String nombre, Integer umbral) {
        super(nombre);
        this.umbral = umbral;
    }
    @Override
    public Oferta doAgregarOferta(ProductoSubastado producto) {
        if (this.ultimaOferta.getValor() > umbral) {
            throw new SuperoElUmbralException("El nuevo valor supero el umbral");
        };
        return new Oferta(this, umbral);
    }

}
