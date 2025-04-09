package com.github.marciokleber.todolist.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.Comments;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TAREFA")
@NoArgsConstructor
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TAREFA")
    @SequenceGenerator(name = "SEQ_TAREFA", sequenceName = "SEQ_TAREFA", allocationSize = 1)
    private Long id;

    @Column
    @Comments(@Comment("CAMPO DESCRITOR DO TITULO DA TAREFA"))
    private String titulo;

    @Column
    @Comments(@Comment("CAMPO DESCRITOR DA TAREFA"))
    private String descricao;

    @Column
    @Comments(@Comment("CAMPO DESCRITOR DO STATUS DA TAREFA"))
    private Boolean isCompleta;

    @Column
    @Comments(@Comment("CAMPO DESCRITOR DA DATA DE CRIAÇÃO DA TAREFA"))
    private LocalDateTime created_at;

    @Column
    @Comments(@Comment("CAMPO DESCRITOR DA DATA DE ULTIMA ATUALIZAÇÃO DA TAREFA"))
    private LocalDateTime updated_at;

    @ManyToOne(optional = false)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
}
