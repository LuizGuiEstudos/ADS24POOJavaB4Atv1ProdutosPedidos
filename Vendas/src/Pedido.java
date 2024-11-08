import java.util.ArrayList;

//Classe Para Relacionar para CLIENTE e PRODUTOS
//possiblidade de relacionar outras informações como fretagem
public class Pedido {

    public static ArrayList< Pedido > lista = new ArrayList<>();

    private int numPedido;
    private Cliente cliente;

    private int seqNum;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.numPedido = seqNum++;

        init();
    }

    private Pedido() {
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
