package br.senac.tads.dsw.dadospessoais;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;
import java.util.Optional;

public interface DadosPessoaisRepository extends JpaRepository<DadosPessoais, Integer> {
    Optional<DadosPessoais> findByApelido(String apelido);

    Optional<DadosPessoais> findByApelidoIgnoreCase(String apelido);

    @Modifying
    void deleteByApelido(String apelido);
}
