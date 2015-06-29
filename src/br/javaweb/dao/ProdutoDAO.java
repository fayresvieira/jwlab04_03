/*

Classe para acesso intermediário a DAO(interface);

fabricio.ayres@gmail.com  - Fabrício Ayres Vieira

*/

package br.javaweb.dao;

import java.util.List;
import br.javaweb.beans.Produto;
import br.javaweb.util.JavaWebException;

public interface ProdutoDAO {

    public void save(Produto p) throws JavaWebException;

    public List<Produto> getCatalogoProdutos() throws JavaWebException;

    public Produto getProdutoById(int id) throws JavaWebException;

    public void createTable() throws JavaWebException;
}