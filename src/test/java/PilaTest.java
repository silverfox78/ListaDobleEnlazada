import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class PilaTest {

    private Pila pila;
    private Nodo nodoUno;
    private Nodo nodoDos;
    private Nodo nodoTres;

    @Before
    public void inicio(){
        this.pila = new Pila();
        this.nodoUno = new Nodo(Esperado.Uno.getNumero());
        this.nodoDos = new Nodo(Esperado.Dos.getNumero());
        this.nodoTres = new Nodo(Esperado.Tres.getNumero());
    }

    @Test
    @Category({InstanciaPilaTest.class})
    public void validaInstancia(){
        assertNull(this.pila.getPrimero());
        assertNull(this.pila.getUltimo());
        assertEquals(this.pila.getCantidad(), Esperado.Zero.getNumero());
    }

    @Test
    @Category({InstanciaNodoTest.class})
    public void validaInstanciaNodo(){
        assertNull(this.nodoUno.getAnterior());
        assertNull(this.nodoUno.getSiguiente());
        assertEquals(this.nodoUno.getValor(), Esperado.Uno.getNumero());
    }

    @Test
    @Category({InstanciaNodoTest.class})
    public void validaNodoAsignaValor(){
        this.nodoUno.setValor(Valor.Uno.getNumero());
        assertEquals(this.nodoUno.getValor(), Esperado.Uno.getNumero());
    }

    @Test
    @Category({InstanciaNodoTest.class})
    public void validaNodoAsignaSiguiente(){
        this.nodoUno.setSiguiente(this.nodoDos);
        assertEquals(this.nodoUno.getSiguiente(), this.nodoDos);
    }

    @Test
    @Category({InstanciaNodoTest.class})
    public void validaNodoAsignaAnterior(){
        this.nodoUno.setAnterior(this.nodoTres);
        assertEquals(this.nodoUno.getAnterior(), this.nodoTres);
    }

    @Test
    @Category({InstanciaNodoTest.class})
    public void validaNodoValorAnteriorSiguiente(){
        this.nodoUno.setAnterior(this.nodoTres);
        this.nodoUno.setSiguiente(this.nodoDos);
        assertEquals(this.nodoUno.getAnterior(), this.nodoTres);
        assertEquals(this.nodoUno.getSiguiente(), this.nodoDos);
    }

    @Test
    @Category({InstanciaPilaTest.class, InstanciaPilaAgregarTest.class})
    public void pilaValidaInsertaPrimerElemento(){
        this.pila.push(this.nodoUno);
        assertEquals(this.pila.getPrimero(), this.nodoUno);
        assertEquals(this.pila.getUltimo(), this.nodoUno);
        assertEquals(this.pila.getCantidad(), Esperado.Uno.getNumero());
        assertNull(this.pila.getPrimero().getAnterior());
        assertNull(this.pila.getPrimero().getSiguiente());
        assertNull(this.pila.getUltimo().getAnterior());
        assertNull(this.pila.getUltimo().getSiguiente());
    }

    @Test
    @Category({InstanciaPilaTest.class, InstanciaPilaAgregarTest.class})
    public void pilaValidaInsertaDosElemento(){
        this.pila.push(this.nodoUno);
        this.pila.push(this.nodoDos);
        assertEquals(this.pila.getPrimero(), this.nodoUno);
        assertEquals(this.pila.getUltimo(), this.nodoDos);
        assertEquals(this.pila.getCantidad(), Esperado.Dos.getNumero());
        assertNull(this.pila.getPrimero().getAnterior());
        assertEquals(this.pila.getPrimero().getSiguiente(), this.nodoDos);
        assertEquals(this.pila.getUltimo().getAnterior(), this.nodoUno);
        assertNull(this.pila.getUltimo().getSiguiente());
    }

    @Test
    @Category({InstanciaPilaTest.class, InstanciaPilaAgregarTest.class})
    public void pilaValidaInsertaTresElemento(){
        this.pila.push(this.nodoUno);
        this.pila.push(this.nodoDos);
        this.pila.push(this.nodoTres);
        assertEquals(this.pila.getPrimero(), this.nodoUno);
        assertEquals(this.pila.getUltimo(), this.nodoTres);
        assertEquals(this.pila.getCantidad(), Esperado.Tres.getNumero());
        assertNull(this.pila.getPrimero().getAnterior());
        assertEquals(this.pila.getPrimero().getSiguiente(), this.nodoDos);
        assertEquals(this.pila.getUltimo().getAnterior(), this.nodoDos);
        assertNull(this.pila.getUltimo().getSiguiente());
    }

    @Test
    @Category({InstanciaPilaTest.class, InstanciaPilaEliminarTest.class})
    public void pilaValidaEliminaDePilaVacia(){
        Nodo retorno = this.pila.pop();
        assertNull(this.pila.getPrimero());
        assertNull(this.pila.getUltimo());
        assertEquals(this.pila.getCantidad(), Esperado.Zero.getNumero());
        assertNull(retorno);
    }

    @Test
    @Category({InstanciaPilaTest.class, InstanciaPilaEliminarTest.class})
    public void pilaValidaEliminaDePilaDeUnElemento(){
        this.pila.push(this.nodoUno);
        Nodo retorno = this.pila.pop();
        assertNull(this.pila.getPrimero());
        assertNull(this.pila.getUltimo());
        assertEquals(this.pila.getCantidad(), Esperado.Zero.getNumero());
        assertEquals(retorno, this.nodoUno);
    }

    @Test
    @Category({InstanciaPilaTest.class, InstanciaPilaEliminarTest.class})
    public void pilaValidaEliminaDePilaDeDosElementos(){
        this.pila.push(this.nodoUno);
        this.pila.push(this.nodoDos);
        Nodo retorno = this.pila.pop();
        assertEquals(this.pila.getPrimero(), this.nodoUno);
        assertEquals(this.pila.getUltimo(), this.nodoUno);
        assertEquals(this.pila.getCantidad(), Esperado.Uno.getNumero());
        assertNull(this.pila.getPrimero().getAnterior());
        assertNull(this.pila.getPrimero().getSiguiente());
        assertNull(this.pila.getUltimo().getAnterior());
        assertNull(this.pila.getUltimo().getSiguiente());
        assertEquals(retorno, this.nodoDos);
    }

    @Test
    @Category({InstanciaPilaTest.class, InstanciaPilaEliminarTest.class, InstanciaPilaEliminarPosicionTest.class})
    public void pilaValidaEliminaPosicionUnoListaVacia(){
        Nodo retorno = this.pila.pop(Valor.Uno.getNumero());
        assertNull(this.pila.getPrimero());
        assertNull(this.pila.getUltimo());
        assertEquals(this.pila.getCantidad(), Esperado.Zero.getNumero());
        assertNull(retorno);
    }

    @Test
    @Category({InstanciaPilaTest.class, InstanciaPilaEliminarTest.class, InstanciaPilaEliminarPosicionTest.class})
    public void pilaValidaEliminaPosicionUnoListaDeUnElemento(){
        this.pila.push(this.nodoUno);
        Nodo retorno = this.pila.pop(Valor.Zero.getNumero());
        assertNull(this.pila.getPrimero());
        assertNull(this.pila.getUltimo());
        assertEquals(this.pila.getCantidad(), Esperado.Zero.getNumero());
        assertEquals(retorno, this.nodoUno);
    }

    @Test
    @Category({InstanciaPilaTest.class, InstanciaPilaEliminarTest.class, InstanciaPilaEliminarPosicionTest.class})
    public void pilaValidaEliminaPosicionUnoListaDeDosElementos(){
        this.pila.push(this.nodoUno);
        this.pila.push(this.nodoDos);
        Nodo retorno = this.pila.pop(Valor.Zero.getNumero());
        assertEquals(this.pila.getPrimero(), this.nodoDos);
        assertEquals(this.pila.getUltimo(), this.nodoDos);
        assertEquals(this.pila.getCantidad(), Esperado.Uno.getNumero());
        assertNull(this.pila.getPrimero().getAnterior());
        assertNull(this.pila.getPrimero().getSiguiente());
        assertNull(this.pila.getUltimo().getAnterior());
        assertNull(this.pila.getUltimo().getSiguiente());
        assertEquals(retorno, this.nodoUno);
    }

    @Test
    @Category({InstanciaPilaTest.class, InstanciaPilaEliminarTest.class, InstanciaPilaEliminarPosicionTest.class})
    public void pilaValidaEliminaPosicionDosListaDeDosElementos(){
        this.pila.push(this.nodoUno);
        this.pila.push(this.nodoDos);
        Nodo retorno = this.pila.pop(Valor.Uno.getNumero());
        assertEquals(this.pila.getPrimero(), this.nodoUno);
        assertEquals(this.pila.getUltimo(), this.nodoUno);
        assertEquals(this.pila.getCantidad(), Esperado.Uno.getNumero());
        assertNull(this.pila.getPrimero().getAnterior());
        assertNull(this.pila.getPrimero().getSiguiente());
        assertNull(this.pila.getUltimo().getAnterior());
        assertNull(this.pila.getUltimo().getSiguiente());
        assertEquals(retorno, this.nodoDos);
    }

    @Test
    @Category({InstanciaPilaTest.class, InstanciaPilaEliminarTest.class, InstanciaPilaEliminarPosicionTest.class})
    public void pilaValidaEliminaPosicionUnoListaDeTresElementos(){
        this.pila.push(this.nodoUno);
        this.pila.push(this.nodoDos);
        this.pila.push(this.nodoTres);
        Nodo retorno = this.pila.pop(Valor.Zero.getNumero());
        assertEquals(this.pila.getPrimero(), this.nodoDos);
        assertEquals(this.pila.getUltimo(), this.nodoTres);
        assertEquals(this.pila.getCantidad(), Esperado.Dos.getNumero());
        assertNull(this.pila.getPrimero().getAnterior());
        assertEquals(this.pila.getPrimero().getSiguiente(), this.nodoTres);
        assertEquals(this.pila.getUltimo().getAnterior(), this.nodoDos);
        assertNull(this.pila.getUltimo().getSiguiente());
        assertEquals(retorno, this.nodoUno);
    }

    @Test
    @Category({InstanciaPilaTest.class, InstanciaPilaEliminarTest.class, InstanciaPilaEliminarPosicionTest.class})
    public void pilaValidaEliminaPosicionDosListaDeTresElementos(){
        this.pila.push(this.nodoUno);
        this.pila.push(this.nodoDos);
        this.pila.push(this.nodoTres);
        Nodo retorno = this.pila.pop(Valor.Uno.getNumero());
        assertEquals(this.pila.getPrimero(), this.nodoUno);
        assertEquals(this.pila.getUltimo(), this.nodoTres);
        assertEquals(this.pila.getCantidad(), Esperado.Dos.getNumero());
        assertNull(this.pila.getPrimero().getAnterior());
        assertEquals(this.pila.getPrimero().getSiguiente(), this.nodoTres);
        assertEquals(this.pila.getUltimo().getAnterior(), this.nodoUno);
        assertNull(this.pila.getUltimo().getSiguiente());
        assertEquals(retorno, this.nodoDos);
    }

    @Test
    @Category({InstanciaPilaTest.class, InstanciaPilaEliminarTest.class, InstanciaPilaEliminarPosicionTest.class})
    public void pilaValidaEliminaPosicionTresListaDeTresElementos(){
        this.pila.push(this.nodoUno);
        this.pila.push(this.nodoDos);
        this.pila.push(this.nodoTres);
        Nodo retorno = this.pila.pop(Valor.Dos.getNumero());
        assertEquals(this.pila.getPrimero(), this.nodoUno);
        assertEquals(this.pila.getUltimo(), this.nodoDos);
        assertEquals(this.pila.getCantidad(), Esperado.Dos.getNumero());
        assertNull(this.pila.getPrimero().getAnterior());
        assertEquals(this.pila.getPrimero().getSiguiente(), this.nodoDos);
        assertEquals(this.pila.getUltimo().getAnterior(), this.nodoUno);
        assertNull(this.pila.getUltimo().getSiguiente());
        assertEquals(retorno, this.nodoTres);
    }

    @Test
    @Category({InstanciaPilaTest.class, InstanciaPilaAgregarTest.class, InstanciaPilaAgregarPosicionTest.class})
    public void pilaValidaInsertaPosicionUnoListaVacia(){
        this.pila.push(Valor.Zero.getNumero(), this.nodoUno);
        assertEquals(this.pila.getPrimero(), this.nodoUno);
        assertEquals(this.pila.getUltimo(), this.nodoUno);
        assertEquals(this.pila.getCantidad(), Esperado.Uno.getNumero());
        assertNull(this.pila.getPrimero().getAnterior());
        assertNull(this.pila.getPrimero().getSiguiente());
        assertNull(this.pila.getUltimo().getAnterior());
        assertNull(this.pila.getUltimo().getSiguiente());
    }

    private enum Valor{
        Zero(0),
        Uno(1),
        Dos(2),
        Tres(3);

        private int numero;

        Valor(int numero){
            this.numero = numero;
        }

        public int getNumero() {
            return numero;
        }
    }

    private enum Esperado{
        Zero(0),
        Uno(1),
        Dos(2),
        Tres(3);

        private int numero;

        Esperado(int numero){
            this.numero = numero;
        }

        public int getNumero() {
            return numero;
        }
    }

    public interface InstanciaPilaTest {}

    public interface InstanciaPilaAgregarTest {}

    public interface InstanciaPilaAgregarPosicionTest {}

    public interface InstanciaPilaEliminarTest {}

    public interface InstanciaPilaEliminarPosicionTest {}

    public interface InstanciaNodoTest {}
}

