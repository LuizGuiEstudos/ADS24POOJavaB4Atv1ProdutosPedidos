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








        ///PEDIDO - PRODUTOS
        //RELACIONAR PRODUTO COM PEDIDO






    }

    //ACTIONS
    private static void addCliente(){
        //CLIENTE
        System.out.println("### ADICIONAR CLIENTE ###");
        System.out.println( ">Digite a seguintes informações sobre o Cliente:" );
        System.out.println( "-Nome" );
        System.out.print( "<" );
        String clNome = scan.next();

        System.out.println( "-CPF" );
        System.out.print( "<" );
        String clCPF = scan.next();

        Cliente cl1 = new Cliente( clNome, clCPF );

        System.out.println( ">O seguinte Cliente foi criado:" );
        cl1.print();
    }
    private static void addProduto() {
        //PRODUTO
        System.out.println(" ### ADICIONAR PRODUTO ### " );

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

        System.out.println(">O seguinte Produto foi criado: ");
        prod1.print();
    }

    private static void addPedido() {
        System.out.println(" ### ADICIONAR PEDIDO ### ");
        System.out.println("-Selecionar Cliente do novo pedido:");
        Cliente slCl = selectClienteByID();
        Pedido ped = new Pedido( slCl );

        System.out.println( ">o seguinte Pedido foi criado:" );
        ped.print();
    }

    private static void addPedidoProduto() {
        SPedidoProduto pedProd1 = new PedidoProduto();



        System.out.println("-Quantidade do produto solicitada:");
        System.out.print("<");
        int quantidade = scan.nextInt();

        System.out.println( "-Variação do valor(desconto ou acrescimo):" );
        System.out.print( "<" );
        double varValor = scan.nextDouble();

        //caso PedidoProduto seja criado
        if( pedProd1.set(ped1, prod1, quantidade, varValor) ){
            System.out.println(">Item inserido no Pedido com sucesso!");
        } else {
            System.out.println(">Quantidade Insuficiente do produto!");
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
    private static void printPedidos() {
        for (Pedido lI : Pedido.get() ) {
            System.out.println();
            lI.print();
            System.out.println();
        }
    }
    private static void printProdutos() {
        for (Produto lI : Produto.get() ) {
            System.out.println();
            lI.print();
            System.out.println();
        }
    }
    private static void printPedidoProdutos() {
        for (PedidoProduto lI : PedidoProduto.get() ) {
            System.out.println();
            lI.print();
            System.out.println();
        }
    }


    ///SELECTS
    private static Cliente selectClienteByID() {
        System.out.println( ">lista de Clientes:" );
        System.out.println();

        List< Cliente > cls = Cliente.get();
        printClientes();

        System.out.println( "-Selecione a ID do Cliente desejado: ");
        System.out.print("<");
        int id = scan.nextInt();

       Cliente clSelecionado = cls.get(id);
       System.out.println(">O seguinte Cliente foi selecionado: ");
       clSelecionado.print();

       return clSelecionado;
    }

    private static Produto selectProdutoById() {
        System.out.println( ">lista de Produtos:" );
        System.out.println();

        List< Produto > prods = Produto.get();
        printProdutos();

        System.out.println( "-Selecione a ID do Produto desejado: ");
        System.out.print("<");
        int id = scan.nextInt();

        Produto prodSel = prods.get(id);

        System.out.println(">O seguinte Produto foi selecionado: ");
        prodSel.print();

        return prodSel;
    }

    private static Pedido selectPedidoByID() {


        List< Pedido > peds = Pedido.get();

        System.out.println( ">lista de Pedidos:" );
        System.out.println();

        printPedidos();

        System.out.println("-selecione Pedido pelo seu número:");
        System.out.print("<");
        int inNum = scan.nextInt();
        boolean find = false;
        Pedido pedEncontrado = null;

        for ( Pedido pedI : peds )
        {
            if (pedI.getNumPedido() == inNum) {
                find = true;
                pedEncontrado = pedI;
            }
        }

        if(find) {
            System.out.println(">O seguinte pedido foi seleciona:");
            System.out.println(">O seguinte Produto foi adicionado:" );
            pedEncontrado.print();
        } else {
            System.out.println( ">Número de Pedido inesxistente!" );
        }


        return pedEncontrado;


    }

}