public class Pila {

    private Nodo primero;
    private Nodo ultimo;
    private int cantidad;

    public Nodo getPrimero() {
        return primero;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void push(Nodo nodo) {
        if (this.cantidad == 0) {
            this.primero = nodo;
            this.ultimo = nodo;
            this.cantidad++;
        } else {
            nodo.setAnterior(this.ultimo);
            this.ultimo.setSiguiente(nodo);
            this.ultimo = nodo;
            this.cantidad++;
        }
    }

    public Nodo pop() {
        if (this.cantidad == 0) {
            return null;
        } else {
            if (cantidad == 1) {
                Nodo retorno = this.primero;
                this.primero = null;
                this.ultimo = null;
                this.cantidad--;
                return retorno;
            }
            else
            {
                Nodo retorno = this.ultimo;
                this.ultimo = retorno.getAnterior();
                this.ultimo.setSiguiente(null);
                retorno.setAnterior(null);
                this.cantidad--;
                return retorno;
            }
        }
    }

    public Nodo pop(int posicion) {
        if(this.cantidad == 0){
            return null;
        }
        else
        {
            return this.pop(posicion, this.primero);
        }
    }

    private Nodo pop(int posicion, Nodo nodo){
        if(posicion == 0){
            if (cantidad == 1){
                this.primero = null;
                this.ultimo = null;
            }
            else {
                if(nodo.getAnterior() == null){
                    this.primero = nodo.getSiguiente();
                } else {
                    nodo.getAnterior().setSiguiente(nodo.getSiguiente());
                }

                if(nodo.getSiguiente() == null) {
                    this.ultimo = nodo.getAnterior();
                } else {
                    nodo.getSiguiente().setAnterior(nodo.getAnterior());
                }
            }
            nodo.setAnterior(null);
            nodo.setSiguiente(null);
            this.cantidad--;
            return nodo;
        }
        else
        {
            return pop(posicion - 1, nodo.getSiguiente());
        }
    }
}
