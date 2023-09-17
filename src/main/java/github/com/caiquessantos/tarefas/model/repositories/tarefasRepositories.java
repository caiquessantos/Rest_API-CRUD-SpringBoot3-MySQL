package github.com.caiquessantos.tarefas.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import github.com.caiquessantos.tarefas.model.entities.Tarefas;

/**
 * A interface `tarefasRepositories` define operações de acesso a dados para a entidade Tarefas.
 * Ela estende as interfaces `CrudRepository` e `PagingAndSortingRepository` do Spring Data, que fornecem
 * métodos básicos de CRUD e suporte à paginação e ordenação.
 */
public interface tarefasRepositories extends CrudRepository<Tarefas, Integer>, PagingAndSortingRepository<Tarefas, Integer> {
	
    /**
     * Encontra tarefas cujo título contenha a parte especificada do nome, ignorando diferenças de maiúsculas e minúsculas.
     *
     * @param parteDoNome A parte do nome a ser pesquisada nas tarefas.
     * @return Uma lista de tarefas que contêm a parte do nome especificada.
     */
	public Iterable<Tarefas> findByTituloContainingIgnoreCase(String parteDoNome);

}
