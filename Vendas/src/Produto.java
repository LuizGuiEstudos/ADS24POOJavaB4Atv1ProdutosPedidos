//classe primaria para registrar PRODUTOS existentes através de seus objetos
public class Produto {
    public static ArrayList< Produto > lista = new ArrayList<>();

    private String nomeProduto;
    private double precoProduto;
    private int quantidadeProduto;

    public Produto() {
        init();
    }

    public Produto(String nomeProduto, double precoProduto, int quantidadeProduto) {
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.quantidadeProduto = quantidadeProduto;

        init();
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }



    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void mostrarProduto() {
        System.out.println("Nome: " + getNomeProduto());
        System.out.println("Preço Produto: " + getPrecoProduto());
        System.out.println("Quantidade: " + getQuantidadeProduto());
    }

    private void init() {
        lista.add(this);
    }
}
