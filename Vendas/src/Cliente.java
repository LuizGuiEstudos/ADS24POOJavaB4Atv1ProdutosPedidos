import java.util.ArrayList;

public class Cliente {
    private static ArrayList< Cliente > lista = new ArrayList<>();

    private String nome;
    private String cpf;
    private ArrayList<Pedido> pedido;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.pedido = new ArrayList<>();

        init();
    }

    public Cliente() {
    }

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

    public ArrayList<Pedido> getPedido() {
        return pedido;
    }

    private void init(){
        lista.add(this);
    }
}
