package br.com.fiap.baitersburger.domain.port.in.controller;

import br.com.fiap.baitersburger.application.dto.request.CustomerRequestDTO;
import br.com.fiap.baitersburger.application.dto.response.CustomerResponseDTO;

public interface CustomerController {
    CustomerResponseDTO find(String cpf);
    void insert(CustomerRequestDTO dto);
}
