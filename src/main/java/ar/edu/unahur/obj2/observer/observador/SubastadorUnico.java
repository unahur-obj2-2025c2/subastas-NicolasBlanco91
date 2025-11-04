package ar.edu.unahur.obj2.observer.observador;

import javax.swing.text.StyledEditorKit.BoldAction;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepcion.YaSubasteException;
import ar.edu.unahur.obj2.observer.observado.ProductoSubastado;

public class SubastadorUnico extends Subastador{
    private Boolean yaSubaste;

    public SubastadorUnico(String nombre) {
        super(nombre);
        this.yaSubaste = Boolean.FALSE;
    }

    @Override
    public Oferta doAgregarOferta(ProductoSubastado producto) {
        if (yaSubaste) {
            throw new YaSubasteException("El subastador unico ya subastó");
        }
        return new Oferta(this, this.ultimaOferta.getValor() + 10);
    }

}
