package br.senac.tads.dsw.dadospessoais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class DadosPessoaisService {

    @Autowired
    private DadosPessoaisRepository repository;

    @Autowired
    private ConhecimentoRepository conhecimentoRepository;

    private DadosPessoaisDto convertToDto(DadosPessoais ent) {
        List<Integer> conhecimentosIds = new ArrayList<>();
        for (Conhecimento c : ent.getConhecimentos()) {
            conhecimentosIds.add(c.getId());
        }
        DadosPessoaisDto dto = new DadosPessoaisDto(
                ent.getApelido(), ent.getNome(), ent.getEmail(),
                ent.getTelefone(), ent.getDataNascimento(),
                conhecimentosIds, null);
        return dto;
    }

    private DadosPessoais convertToEntity(DadosPessoaisDto dto) {
        DadosPessoais entity = new DadosPessoais();
        entity.setApelido(dto.getApelido());
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setTelefone(dto.getTelefone());
        entity.setDataNascimento(dto.getDataNascimento());

        if (dto.getConhecimentosIds() != null) {
            Set<Conhecimento> conhecimentos = new LinkedHashSet<>();
            for (Integer idConhecimento : dto.getConhecimentosIds()) {
                Optional<Conhecimento> optConhecimento =
                        conhecimentoRepository.findById(idConhecimento);
                if (optConhecimento.isPresent()) {
                    Conhecimento conhecimento = optConhecimento.get();
                    conhecimentos.add(conhecimento);
                }
            }
            entity.setConhecimentos(conhecimentos);
        }
        return entity;
    }

    public List<DadosPessoaisDto> findAll(
            int pagina, int quantidade, String textoBusca
    ) {
        List<DadosPessoais> entities = repository.findAll();
        List<DadosPessoaisDto> resultado = new ArrayList<>();
        for (DadosPessoais ent : entities) {
            DadosPessoaisDto dto = convertToDto(ent);
            resultado.add(dto);
        }
        return resultado;
    }



    public DadosPessoaisDto findByApelido(String apelido) {
        Optional<DadosPessoais> optPessoa = repository.findByApelidoIgnoreCase(apelido);
        if (optPessoa.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa " + apelido + " não encontrada");
        }
        DadosPessoaisDto dto = convertToDto(optPessoa.get());
        return dto;
    }

    public void addNew(DadosPessoaisDto dto) {
        DadosPessoais entity = convertToEntity(dto);
        repository.save(entity);
    }



    public void update(String apelido, DadosPessoaisDto dto) {
        Optional<DadosPessoais> optPessoa = repository.findByApelido(apelido);
        if (optPessoa.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa " + apelido + " não encontrado");
        }
        DadosPessoais dp = optPessoa.get();
        DadosPessoais entity = convertToEntity(dto);
        entity.setId(dp.getId());
        entity.setApelido(apelido);
        repository.save(entity);
    }
    public void delete(String apelido) {
        repository.deleteByApelido(apelido);
    }
}
