package Estoque_CRUD.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB__produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {



    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //Campo de objeto não pode ser nulo
    @NotNull(message = "Nome não pode ser nula")
    @NotBlank(message = "Nome não pode ser branco")
    @Column(nullable = false)
    private String nome;

    @NotNull(message = "Preço não pode ser nula")
    @Column(nullable = false)
    private Double preco;

    @NotNull(message = "Quantidade não pode ser nula")
    @Column(nullable = false)
    private Integer quant_prod;

}
