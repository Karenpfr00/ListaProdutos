package DB;

import java.util.ArrayList;
import models.Produto;
import java.util.List;

public class ProdutosDB {
    private List<Produto> produtosList = new ArrayList<>();

    public List<Produto> getProdutosList() {
        return produtosList;
    }

    public void addNovoProduto(Produto produto) {
        produtosList.add(produto);
    }
}
