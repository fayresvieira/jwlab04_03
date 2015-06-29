/*

Classe catalogoProdutosView - Gera um arquivo HTML com informações obtidas através do servlet e repassa a classe
AdicionarProdutoCarrinho o Id para tratamento.

fabricio.ayres@gmail.com  - Fabrício Ayres Vieira

*/

package br.javaweb.ecommerce;

import br.javaweb.beans.Produto;
import br.javaweb.dao.ProdutoDAO;
import br.javaweb.dao.ProdutoDAOImpl;
import br.javaweb.util.JavaWebException;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

public class CatalogoProdutosView extends HttpServlet 
{


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
    {
        response.setContentType("text/html");
        // Obtencao do canal de envio de dados para o cliente
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Catalogo Produtos - Academia do Java</title>");
        out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
        out.println("<link href= 'jw.css' rel='stylesheet' type='text/css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<H3>Catalogo de produtos </H3>");
        // Inicio da tabela de produtos
        out.println("<TABLE width = '700' border='0'>");

        //Linha de titulo
        out.println("<TR width = '%100' class='tituloCampo'>");
        out.println("<TD width = '%20'>Imagem</TD>");
        out.println("<TD width = '%10' >Nome</TD>");
        out.println("<TD width = '%10' >Codigo</TD>");
        out.println("<TD width = '%10'  >Descri&ccedil;&atilde;o</TD>");
        out.println("<TD width = '%10' >Pre&ccedil;o</TD>");
        out.println("<TD width = '%20' colspan = '2'>Comprar</TD>");
        out.println("</TR>");
        
        //Obtendo parametros do request
     
        
        Produto prod = null;
        ProdutoDAO dao = new ProdutoDAOImpl();
        
         try {    
             
         dao.getCatalogoProdutos();
         
         
        } catch (Exception e) {
            throw new ServletException(e);
        }
        
        // Produtos
         
              
        out.println("<TR width = '%100'>");
        out.println("<TD width = '%20'>" + prod.getImage() +"</TD>");
        out.println("<TD width = '%10'  class='gridCampo'>" + prod.getNome() +"</TD>");
        out.println("<TD width = '%10' class='gridCampo'>" + prod.getCodigo() + "</TD>");
        out.println("<TD width = '%10'  class='gridCampo'>" + prod.getDescricao() +"</TD>");
        out.println("<TD width = '%10' class='gridCampo'>" + prod.getPreco() + "</TD>");
        out.println("<TD width = '%20' colspan = '2'><A HREF= 'adicionarProdutoCarrinho?idProduto=" + prod.getId() + ")' ><IMG SRC = 'imagem/carrinho.gif'/></A></TD>");
        out.println("</TR>");
        
        
        // final da tabela de produtos
        out.println("</TABLE>");
        out.println("</body>");
        out.println("</html>");
    }
}
