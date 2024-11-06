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
        Cliente.add(cl1);

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


        //PEDIDO ...
        Pedido ped1 = new Pedido();




        //...-SELECIONAR CLIENTE







        //RELACIONAR PRODUTO COM PEDIDO
        //caso PedidoProduto seja criado
        if( pedProd1.set(pedido1, produto1, 2,.5) ){
            PedidoProduto.add( pedProd1 );
            System.out.println("Produto Inserido No Pedido com sucesso!");
        } else {
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

    private static void printClientes() {
        List< Cliente > lClientes = Cliente.get();
        for( int i=0; i<lClientes.size(); i++ ) {
            Cliente clI = lClientes.get( i );
            System.out.println( "...ID: " + i );
            printCliente( clI );
        }
    }

    private static void printCliente( Cliente cl ) {
        System.out.println( ".Nome:" + cl.getNome() );
        System.out.println( ".CPF:" + cl.getCpf() );
    }


    private static Cliente selectClienteByID() {
        System.out.println( " ### SELECIONAR CLIENTE ###" );

        List< Cliente > cls = Cliente.get();
        printClientes();

        System.out.println( "-Selecione a ID do Cliente desejado: ");
        System.out.print("<");
        int id = scan.nextInt();

        clSelecionado = cls.get(id);
        return clSelecionado;
    }

}