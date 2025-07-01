package br.com.fiap.baitersburger.application.usecase.customer.impl;

import br.com.fiap.baitersburger.domain.model.Customer;
import br.com.fiap.baitersburger.domain.exception.ExceptionMessages;
import br.com.fiap.baitersburger.domain.exception.NotFoundException;
import br.com.fiap.baitersburger.application.usecase.customer.FindCustomerByCpfUseCase;
import br.com.fiap.baitersburger.domain.port.repository.CustomerRepository;

public class FindCustomerByCpfUseCaseImpl implements FindCustomerByCpfUseCase {

    private final CustomerRepository customerRepository;

    public FindCustomerByCpfUseCaseImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer find(String cpf) {
        return customerRepository.findByCpf(cpf).orElseThrow(() -> new NotFoundException(ExceptionMessages.CUSTOMER_NOT_FOUND));
    }
}
