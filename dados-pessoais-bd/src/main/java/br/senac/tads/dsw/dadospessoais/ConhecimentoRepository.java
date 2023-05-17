package br.senac.tads.dsw.dadospessoais;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConhecimentoRepository extends JpaRepository<Conhecimento, Integer> {

}
