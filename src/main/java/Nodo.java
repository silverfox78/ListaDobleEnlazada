public class Nodo {
    public Nodo(int numero) {
        this.setValor(numero);
        this.setAnterior(null);
        this.setSiguiente(null);
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    private Nodo siguiente;
    private Nodo anterior;
    private int valor;
}
