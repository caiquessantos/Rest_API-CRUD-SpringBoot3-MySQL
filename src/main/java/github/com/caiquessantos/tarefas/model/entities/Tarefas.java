package github.com.caiquessantos.tarefas.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

/**
 * Classe que representa uma tarefa em um sistema.
 */
@Entity
public class Tarefas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	private String titulo;

	@NotBlank
	private String descricao;
	
    /**
     * Construtor padrão da classe Tarefas.
     */
	public Tarefas() {}

    /**
     * Construtor que cria uma nova instância de Tarefas com título e descrição.
     *
     * @param titulo    O título da tarefa.
     * @param descricao A descrição da tarefa.
     */
	public Tarefas(@NotBlank String titulo, @NotBlank String descricao) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
	}

    /**
     * Obtém o ID da tarefa.
     *
     * @return O ID da tarefa.
     */
	public int getId() {
		return id;
	}

    /**
     * Define o ID da tarefa.
     *
     * @param id O ID da tarefa.
     */
	public void setId(int id) {
		this.id = id;
	}

    /**
     * Obtém o título da tarefa.
     *
     * @return O título da tarefa.
     */
	public String getTitulo() {
		return titulo;
	}

    /**
     * Define o título da tarefa.
     *
     * @param titulo O título da tarefa.
     */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


    /**
     * Obtém a descrição da tarefa.
     *
     * @return A descrição da tarefa.
     */
	public String getDescricao() {
		return descricao;
	}

    /**
     * Define a descrição da tarefa.
     *
     * @param descricao A descrição da tarefa.
     */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
