package br.senac.tads.dsw.dadospessoais;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ConhecimentoRepositoryJpaImpl implements ConhecimentoRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Conhecimento> findAll() {
        TypedQuery<Conhecimento> jpqlQuery = em.createQuery(
                "SELECT c FROM Conhecimento c", Conhecimento.class);
        List<Conhecimento> resultado = jpqlQuery.getResultList();
        return resultado;
    }

    @Override
    public Optional<Conhecimento> findById(Integer id) {
        TypedQuery<Conhecimento> jpqlQuery = em.createQuery(
                "SELECT c FROM Conhecimento c WHERE c.id = :idParam",
                Conhecimento.class);
        jpqlQuery.setParameter("idParam", id);
        try {
            Conhecimento c = jpqlQuery.getSingleResult();
            return Optional.of(c);
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }

    @Override
    @Transactional
    public Conhecimento save(Conhecimento c) {

        if (c.getId() == null) {
            // Se ID for nulo, salva novo conhecimento
            em.persist(c);
        } else {
            // Se ID existir, atualiza conhecimento existente
            c = em.merge(c);
        }
        return c;
    }
}
