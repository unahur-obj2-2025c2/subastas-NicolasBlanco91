package ar.edu.unahur.obj2.observer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.observer.excepcion.NoEstaElSubastadorException;
import ar.edu.unahur.obj2.observer.observado.ProductoSubastado;
import ar.edu.unahur.obj2.observer.observador.Subastador;
import ar.edu.unahur.obj2.observer.observador.SubastadorArriesgado;
import ar.edu.unahur.obj2.observer.observador.SubastadorConLimite;
import ar.edu.unahur.obj2.observer.observador.SubastadorUnico;
public class MainTest {
    
    Subastador nico = new SubastadorArriesgado("Nicolas");
    Subastador lucas = new SubastadorArriesgado("Lucas");
    Subastador marcos = new SubastadorConLimite("Marcos", 100); 
    Subastador cris = new SubastadorUnico("Cristian");
    ProductoSubastado cuadroDeDali = new ProductoSubastado();


    @BeforeEach
    void initialize(){
        cuadroDeDali.reiniciarProducto();
        nico.reiniciarOferta();
        lucas.reiniciarOferta();
        marcos.reiniciarOferta();
        cris.reiniciarOferta();
        cuadroDeDali.agregarObservador(nico);  
        cuadroDeDali.agregarObservador(lucas); 
        lucas.agregarOferta(cuadroDeDali); 
        nico.agregarOferta(cuadroDeDali);  
        lucas.agregarOferta(cuadroDeDali); 
    }

    void testMain() {
        assertEquals(lucas.getUltimaOferta(), nico.getUltimaOferta());
        assertEquals(cuadroDeDali.ultimaOfertaRegistrada(), lucas.getUltimaOferta());
    }

    @Test
    void testMain2() {
        assertEquals(lucas, cuadroDeDali.ultimaOfertaRegistrada().getSubastador());
    }

    @Test
    void testMain3() {
        assertEquals(30, lucas.getUltimaOferta().getValor());
    }

    @Test
    void testMain4() { 
        assertEquals(3, cuadroDeDali.getOfertasRecibidas().size());
    }

    @Test
    void testMain5() {
        Exception exception = assertThrows(NoEstaElSubastadorException.class, () -> {
            marcos.agregarOferta(cuadroDeDali);
        });
        assertEquals("El subastador no esta en esta subasta", exception.getMessage());
    }
}