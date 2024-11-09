import java.util.ArrayList;
import java.util.List;

//serve para RELACIONAR Pedido <> Produto
public class PedidoProduto {
    private static List< PedidoProduto > lista = new ArrayList<>();
    public static List< PedidoProduto > get() {
        return lista;
    }
    private static void add( PedidoProduto pedProd ) {
        lista.add( pedProd );
    }


    private Pedido pedido;
    private Produto produto;
    private int quantidade;
    private double precoPagar; //sera decide por um calculo interno

    public boolean set(Pedido pedido, Produto produto, int quantidade) {
        return set(pedido, produto, quantidade, 0);
    }

    public boolean set(Pedido pedido, Produto produto, int quantidade, double variacaoDeValor  ) {
        if(produto.getQuantidadeProduto() > quantidade){
            //CASO A QUANTIDADE DE PRODUTOS SEJA MAIOR QUE A QUANTIDADE SOLICITADA
            // = prossegir com a inserção do item
            //-CALCULAR precoPagar
            this.precoPagar =  (produto.getPrecoProduto() * quantidade) + variacaoDeValor;

            this.setQuantidade(quantidade);
            this.produto = produto;
            this.pedido = pedido;
            produto.setQuantidadeProduto(produto.getQuantidadeProduto() - this.getQuantidade());


            //LISTA
            add( this );

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

    public Pedido getPedido(){
        return pedido;
    }

    public void print(){
        this.pedido.mostrarPedido();
        System.out.println("Produto:" + this.produto.getNomeProduto());
        System.out.println("Quantidade: " + this.getQuantidade());
        System.out.println("Preço a pagar:" + this.getPrecoPagar());
    }



}
