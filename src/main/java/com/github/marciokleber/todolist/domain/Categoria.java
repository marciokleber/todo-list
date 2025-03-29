package com.github.marciokleber.todolist.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.Comments;

@Data
@Entity
@Table(name = "CATEGORIA")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CATEGORIA")
    @SequenceGenerator(name = "SEQ_CATEGORIA", sequenceName = "SEQ_CATEGORIA", allocationSize = 1)
    private Long id;

    @Column
    @Comments(@Comment("CAMPO DESCRITOR DO NOME DA CATEGORIA"))
    private String nome;

    @Column
    @Comments(@Comment("CAMPO DESCRITOR DA CATEGORIA"))
    private String descricao;

}
