import java.util.ArrayList;

//Classe Relacional para CLIENTE e LISTAGEM de itens pedidos
//possiblidade de relacionar outras informações como fretagem
public class Pedido {

    public static ArrayList< Pedido > lista = new ArrayList<>();

    private int numPedido;
    private Cliente cliente;

    public Pedido(Cliente cliente, int numPedido) {
        this.cliente = cliente;
        this.numPedido = numPedido;

        init();
    }

    public Pedido() {
        init();
    }



    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public void mostrarPedido() {
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Pedido: " + numPedido);
    }

    private void init() {
        lista.add(this);
    }
}
