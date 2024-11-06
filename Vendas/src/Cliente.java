import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private static List< Cliente > lista = new ArrayList<  >();

    public Cliente() {
    }
    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.pedidos = new ArrayList<>();

        init();
    }

    public static void add( Cliente cl ) {
        lista.add( cl );
    }
    public static List<Cliente> get() {
        return lista;
    }


    private String nome;
    private String cpf;
    private ArrayList<Pedido> pedidos;







    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void mostraClie(){
        System.out.println(this.nome);
        System.out.println(this.cpf);
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    private void init(){
        lista.add(this);
    }
}
