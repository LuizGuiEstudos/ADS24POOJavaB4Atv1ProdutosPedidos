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

        int scanOpt = -1;

        while( scanOpt != 0 )
        {

            System.out.print( "-Selecione uma ação:" );
            System.out.println( "1-adicionar cliente, 2-adicionar produto, 3-adicionar pedido, 4-adicionar item ao pedido");
            System.out.println( "5-listar clientes, 6-listar produtos, 7-listar itens e pedidos" );

            scanOpt = scan.nextInt();

            switch( scanOpt ) {
                case 0:
                    System.out.println(">Saindo do programa...");
                    break;
                case 1:
                    addCliente();
                    break;
                case 2:
                    addProduto();
                    break;
                case 3:
                    Cliente clSelected = selectClienteByID();
                    addPedido( clSelected );
                    break;
                case 4:
                    Pedido pedSelected = selectPedidoByID();
                    Produto prodSelected = selectProdutoById();
                    addPedidoProduto( pedSelected, prodSelected );
                    break;
                case 5:
                    printClientes();
                    break;
                case 6:
                    printProdutos();
                    break;
                case 7:
                    printPedidoProdutos();
                    break;
            }
        }

    }

    //ACTIONS
    private static Cliente addCliente(){
        //CLIENTE
        System.out.println("### ADICIONAR CLIENTE ###");
        System.out.println( ">Digite a seguintes informações sobre o Cliente:" );
        System.out.println( "-Nome" );
        System.out.print( "<" );
        String clNome = scan.next();

        System.out.println( "-CPF" );
        System.out.print( "<" );
        String clCPF = scan.next();

        Cliente cl = new Cliente( clNome, clCPF );

        return cl;
    }
    private static Produto addProduto() {
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

        Produto prod = new Produto( prodNome, prodPreco, prodQuantidade );

        return prod;


    }

    private static Pedido addPedido( Cliente cl ) {
        System.out.println(" ### ADICIONAR PEDIDO ### ");
        System.out.println("-Selecionar Cliente do novo pedido:");

        Pedido ped = new Pedido( cl );

        return ped;
    }

    private static void addPedidoProduto( Pedido ped, Produto prod ) {
        PedidoProduto pedProd1 = new PedidoProduto();

        System.out.println("-Quantidade do produto solicitada:");
        System.out.print("<");
        int quantidade = scan.nextInt();

        System.out.println( "-Variação do valor(desconto ou acrescimo):" );
        System.out.print( "<" );
        double varValor = scan.nextDouble();

        //caso PedidoProduto seja criado
        if( pedProd1.set(ped, prod, quantidade, varValor) ){
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
        int i = 0;
        for (Produto lI : Produto.get() ) {

            System.out.println("...ID:" + i++);

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