import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private static List< Cliente > lista = new ArrayList<  >();
    private static void add( Cliente cl ) {
        lista.add( cl );
    }
    public static List<Cliente> get() {
        return lista;
    }

    private Cliente() {
    }
    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;

        add( this );
    }



    private String nome;
    private String cpf;

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

    public void print(){
        System.out.println( ".Nome: " this.nome);
        System.out.println( ".CPF: " this.cpf);
    }


}
