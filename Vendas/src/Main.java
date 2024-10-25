import java.util.ArrayList;
import java.util.Scanner;
/*
- Encontre o erro e faça a correção
- Construa um menu para melhorar a aplicação
- Seria ideal que cada cliente, produdo e pedido tivessem um codigo único
- Possibilitar o cancelamento do item do Produto, voltando o produto para o estoque
- Possibilitar o cancelamento da venda, voltando o produto para o estoque


ERROS ENCONTRADOS:
 A QUANTIDADE NÃO TEM PESO
*/

//TODO
/*
criar arrays para listar cada entidade, possibilitando listagem e seleção, e add -ok criado uma lista para cada classe em cada classe
testar listagem e add de produto e cliente
*/


public class Main {
    public static Scanner scan = new Scanner( System.in );

    public static void main(String[] args) {


        PedidoProduto item = new PedidoProduto();

        ///ENTRADA INFORMAÇÕES
        //CLIENTE
        System.out.println( ">Digite a seguintes informações sobre o Cliente:" );
        System.out.println( "-Nome" );
        System.out.println( "<" );
        String clNome = scan.next();

        System.out.println( "-CPF" );
        System.out.println( "<" );
        String clCPF = scan.next();
        //PRODUTO
        System.out.println( ">Digite a seguintes informações sobre o Produto:" );
        System.out.println( "-Nome:" );
        System.out.println( "<" );
        String prodNome = scan.next();

        System.out.println( "-Preço:" );
        System.out.println( "<" );
        Double prodPreco = scan.nextDouble();

        System.out.println( "-Quantidade:" );
        System.out.println( "<" );
        int prodQuantidade = scan.nextInt();


        //PEDIDO ...
        //-SELECIONAR CLIENTE

        ///LISTAGENS
        //CLIENTE


        //INSERIR PedidoProduto NA LISTA DE PedidoProdutos
        //caso PedidoProduto seja criado
        if( item.ItemPedido(pedido1, produto1, 2,.5) ){
            itens.add(item);
            System.out.println("Produto Inserido No Pedido com sucesso!");
        }else {
            System.out.println("Quantidade Insuficiente do produto!");
        }


        //DISPLAY CONSOLE ITENS
        for (PedidoProduto iten : itens) {
            iten.mostrarItemPedido();
            System.out.println("--------------");
        }

    }

    private void listarClientes() {

    }

    private void printCliente( Cliente cl ) {
        System.out.println( ".Nome:" + cl.getNome() );
        System.out.println( ".CPF:" + cl.getCpf() );
    }

}