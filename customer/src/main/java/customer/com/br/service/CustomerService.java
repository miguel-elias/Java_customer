package customer.com.br.service;

import customer.com.br.dto.CustomerDto;
import customer.com.br.entity.CustomerEntity;
import customer.com.br.repository.CustomerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
@ApplicationScoped
public class CustomerService {
    @Inject
    private CustomerRepository customerRepository;
    public List<CustomerDto> findAllCustomers(){
        List<CustomerDto> customers = new ArrayList<>();
        customerRepository.findAll().stream().forEach(item->{
            customers.add(mapCustomerEntityToDTO(item));
        });
        return customers;

    }

    public CustomerDto getCustomerById(Long id) {
        return mapCustomerEntityToDTO(customerRepository.findById(id));
    }

    public void createNewCustomer(CustomerDto customerDto){
        customerRepository.persist(mapCustomerDtoToEntity(customerDto));
    }

    public void changeCustomer(Long id, CustomerDto customerDto){
        CustomerEntity customer = customerRepository.findById(id);


        customer.setName(customerDto.getName());
        customer.setPhone(customerDto.getPhone());
        customer.setEmail((customerDto.getEmail()));
        customer.setAge(customerDto.getAge());

        customerRepository.persist(customer);
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);

    }

    private CustomerDto mapCustomerEntityToDTO(CustomerEntity customer){
        CustomerDto customerDto = new CustomerDto();

        customerDto.setAge(customer.getAge());
        customerDto.setEmail(customer.getEmail());
        customerDto.setName(customer.getName());
        customerDto.setPhone(customer.getPhone());

        return customerDto;
    }

    private CustomerEntity mapCustomerDtoToEntity(CustomerDto customer){
        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setAge(customer.getAge());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setName(customer.getName());
        customerEntity.setPhone(customer.getPhone());

        return customerEntity;
    }
}
