package com.volkmann.persistence.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.volkmann.persistence.entitys.Pessoa;

//@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, UUID>{

}
