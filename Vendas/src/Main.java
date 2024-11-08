import java.util.List;
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


        PedidoProduto pedProd = new PedidoProduto();

        ///ENTRADA INFORMAÇÕES
        //CLIENTE
        System.out.println( ">Digite a seguintes informações sobre o Cliente:" );
        System.out.println( "-Nome" );
        System.out.println( "<" );
        String clNome = scan.next();

        System.out.println( "-CPF" );
        System.out.println( "<" );
        String clCPF = scan.next();

        Cliente cl1 = new Cliente( clNome, clCPF );

        //PRODUTO
        System.out.println( ">Digite a seguintes informações sobre o Produto:" );
        System.out.println( "-Nome:" );
        System.out.print( "<" );
        String prodNome = scan.next();

        System.out.println( "-Preço:" );
        System.out.print( "<" );
        Double prodPreco = scan.nextDouble();

        System.out.println( "-Quantidade:" );
        System.out.print( "<" );
        int prodQuantidade = scan.nextInt();

        Produto prod1 = new Produto( prodNome, prodPreco, prodQuantidade );
        Produto.add( prod1 );


        ///PEDIDO ...
         //select cliente
        Cliente slCl = selectClienteByID();
        Pedido ped1 = new Pedido( slCl );


        ///PEDIDO - PRODUTOS
        //RELACIONAR PRODUTO COM PEDIDO
        PedidoProduto pedProd1 = new PedidoProduto();

        System.out.println("-Quantidade do produto:");
        System.out.print("<");
        int quantidade = scan.nextInt();

        System.out.println( "-Variação do valor(desconto ou acrescimo):" );
        System.out.print( "<" );
        double varValor = scan.nextDouble();

        //caso PedidoProduto seja criado
        if( pedProd1.set(ped1, prod1, quantidade, varValor) ){
            System.out.println("Produto inserido no Pedido com sucesso!");
        } else {
            System.out.println("Quantidade Insuficiente do produto!");
        }



    }

    ////PRINTS
    private static void printClientes() {
        List< Cliente > lClientes = Cliente.get();
        for( int i=0; i<lClientes.size(); i++ ) {
            Cliente clI = lClientes.get( i );
            System.out.println( "...ID: " + i );
            clI.print();
        }
    }
    private static void printProdutos() {
        for (PedidoProduto lI : Produto.get() ) {
            System.out.println("--------------");
            lI.print();
            System.out.println("--------------");
        }
    }
    private static void printPedidoProdutos() {
        for (PedidoProduto pedProdI : PedidoProduto.get() ) {
            System.out.println("--------------");
            pedProdI.mostrarPedidoProduto();
            System.out.println("--------------");
        }
    }



    private static Cliente selectClienteByID() {
        System.out.println( " ### SELECIONAR CLIENTE ###" );

        List< Cliente > cls = Cliente.get();
        printClientes();

        System.out.println( "-Selecione a ID do Cliente desejado: ");
        System.out.print("<");
        int id = scan.nextInt();

       Cliente clSelecionado = cls.get(id);
        return clSelecionado;
    }

}