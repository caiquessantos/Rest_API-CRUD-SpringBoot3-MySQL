package github.com.caiquessantos.tarefas.control;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import github.com.caiquessantos.tarefas.model.entities.Tarefas;
import github.com.caiquessantos.tarefas.model.repositories.tarefasRepositories;
import jakarta.validation.Valid;

/**
 * Controlador REST para manipulação de tarefas.
 */
@RestController
@RequestMapping(path = "api/tarefas")
public class tarefasController {

	@Autowired
	private tarefasRepositories tr;
	
    /**
     * Cria uma nova tarefa.
     *
     * @param tarefa A tarefa a ser criada.
     * @return A tarefa criada.
     */
	@PostMapping(path = "/criar")
	public Tarefas criarTarefa(@Valid Tarefas tarefa) {
		tr.save(tarefa);
		return tarefa;
	}
	
    /**
     * Lista todas as tarefas.
     *
     * @return Uma lista de todas as tarefas.
     */
	@GetMapping
	public Iterable<Tarefas> listarTodos(){
		return tr.findAll();
	}
	
    /**
     * Lista uma tarefa por ID.
     *
     * @param id O ID da tarefa a ser encontrada.
     * @return Um ResponseEntity com a tarefa encontrada ou um status 'notFound' caso não seja encontrada.
     */
	@GetMapping(path = "/buscaporid/{id}")
	public ResponseEntity<Tarefas> listarPorID(@PathVariable int id){
		Optional<Tarefas> tarefa = tr.findById(id);
		if (tarefa.isPresent()) {
			return ResponseEntity.ok(tarefa.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
    /**
     * Lista tarefas de forma paginada.
     *
     * @param numeroDApagina O número da página desejada.
     * @return Uma lista de tarefas na página especificada.
     */
	@GetMapping(path = "/pagina/{numeroDApagina}")
	public Iterable<Tarefas> listaPaginada(@PathVariable int numeroDApagina){
		Pageable page = PageRequest.of(numeroDApagina, 1);
		return tr.findAll(page);
	}
	
    /**
     * Lista tarefas por parte do nome.
     *
     * @param parteDoNome A parte do nome a ser pesquisada nas tarefas.
     * @return Uma lista de tarefas que contêm a parte do nome especificada.
     */
	@GetMapping(path = "/buscapornome/{parteDoNome}")
	public Iterable<Tarefas> listarPorNome(@PathVariable String parteDoNome){
		return tr.findByTituloContainingIgnoreCase(parteDoNome);
	}
	
    /**
     * Atualiza uma tarefa existente por ID.
     *
     * @param id      O ID da tarefa a ser atualizada.
     * @param tarefa  A tarefa com as informações atualizadas.
     * @return Um ResponseEntity com a tarefa atualizada ou um status 'notFound' caso a tarefa não exista.
     */
    @PutMapping("/editar/{id}")
    public ResponseEntity<Tarefas> atualizarTarefa(@PathVariable int id, @Valid Tarefas tarefa){
        if (tr.existsById(id)) {
            tarefa.setId(id);
            return ResponseEntity.ok(tr.save(tarefa));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    

    /**
     * Exclui uma tarefa por ID.
     *
     * @param id O ID da tarefa a ser excluída.
     * @return Um ResponseEntity com status 'noContent' se a tarefa foi excluída com sucesso, ou um status 'notFound' caso a tarefa não exista.
     */
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Tarefas> excluir(@PathVariable int id){
    	if (tr.existsById(id)){
			tr.deleteById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
    }

}
