package br.senac.tads.dsw.dadospessoais;

import java.util.List;
import java.util.Optional;

public interface ConhecimentoRepository {

    List<Conhecimento> findAll();

    Optional<Conhecimento> findById(Integer id);

    Conhecimento save(Conhecimento c);
}
