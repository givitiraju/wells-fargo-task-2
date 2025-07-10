package com.wellsfargo.counselor.service;

import com.wellsfargo.counselor.entity.Client;
import com.wellsfargo.counselor.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    // Save a new client
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    // Get all clients
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Get client by ID
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    // Update client
    public Client updateClient(Long id, Client updatedClient) {
        Optional<Client> existing = clientRepository.findById(id);
        if (existing.isPresent()) {
            Client client = existing.get();
            client.setName(updatedClient.getName());
            client.setEmail(updatedClient.getEmail());
            client.setPhoneNumber(updatedClient.getPhoneNumber());
            client.setAddress(updatedClient.getAddress());
            client.setAdvisor(updatedClient.getAdvisor());
            return clientRepository.save(client);
        } else {
            throw new RuntimeException("Client not found with ID: " + id);
        }
    }

    // Delete client
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}


