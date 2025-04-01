package com.bichri.Client_Mgr.repos;

import com.bichri.Client_Mgr.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client, Long> {


    Client findByEmail(String email);
}
