import java.util.ArrayList;

//serve para RELACIONAR Pedido <> Produto
public class PedidoProduto {
    public static ArrayList< PedidoProduto > lista = new ArrayList<>();

    private Pedido pedido;
    private Produto produto;
    private int quantidade;
    private double precoPagar; //sera decide por um calculo interno

    public boolean ItemPedido(Pedido pedido, Produto produto, int quantidade) {
        return ItensPedido(pedido, produto, quantidade, 0);
    }

    public boolean ItemPedido(Pedido pedido, Produto produto, int quantidade, double valorAmais  ) {
        if(produto.getQuantidadeProduto() > quantidade){
            //CASO A QUANTIDADE DE PRODUTOS SEJA MAIOR QUE A QUANTIDADE SOLICITADA
            // = prossegir com a inserção do item
            //-CALCULAR precoPagar
            this.precoPagar =  produto.getPrecoProduto() + quantidade + valorAmais;

            this.setQuantidade(quantidade);
            this.setPrecoPagar(precoPagar);
            this.produto = produto;
            this.pedido = pedido;
            produto.setQuantidadeProduto(produto.getQuantidadeProduto() - this.getQuantidade());
            //LISTA
            init();

            return true;


        }else {
            //CASO A QUANT DE PROD SEJA MENOR QUE **
            return false;
        }
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public PedidoProduto() {
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getPrecoPagar() {
        return precoPagar;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void mostrarItemPedido(){
        this.pedido.mostrarPedido();
        System.out.println("Produto:" + this.produto.getNomeProduto());
        System.out.println("Quantidade: " + this.getQuantidade());
        System.out.println("Produto:" + this.getPrecoPagar());
    }

    private void init() {
        lista.add(this);
    }
}
