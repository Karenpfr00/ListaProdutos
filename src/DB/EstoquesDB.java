package DB;

import models.Estoque;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstoquesDB {
    private Map<String, Estoque> estoquesDBMap = new HashMap<>();

    public Map<String, Estoque> getEstoquesDBMap() {
        return estoquesDBMap;
    }

    public List<Estoque> getEstoques() {
        List<Estoque> estoques = new ArrayList<>();
        for (Map.Entry<String, Estoque> estoque : estoquesDBMap.entrySet()) {
            estoques.add(estoque.getValue());
        }
        return estoques;
    }

    public void addNovoEstoque(Estoque estoque) {
        estoquesDBMap.put(estoque.getId(), estoque);
    }
}
