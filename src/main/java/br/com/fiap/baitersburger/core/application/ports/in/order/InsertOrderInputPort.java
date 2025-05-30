package br.com.fiap.baitersburger.core.application.ports.in.order;

import java.util.List;

public interface InsertOrderInputPort {
    void insert(List<String> productsIds, String customerCpf);
}
