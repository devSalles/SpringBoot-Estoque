package Estoque_CRUD.dto;

import Estoque_CRUD.model.Produto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//Classe DTO usada para fazer requisições
public class ProdutoRequestDTO {

    @NotNull(message = "Nome obrigatório") @NotBlank(message = "Nome obrigatório")
    private String name;

    @Min(value = 1,message = "Valor deve ser positivo ou maior que 0")
    private Double preco;

    @NotNull(message = "Quantidade não pode ser nula") @Min(value = 1,message = "Valor deve ser positivo ou maior que 0")
    private Integer quant_prod;

    public Produto toProduto()
    {
        Produto produto = new Produto();

        produto.setNome(this.name);
        produto.setPreco(this.preco);
        produto.setQuant_prod(this.quant_prod);

        return produto;
    }

    public Produto updateProduto(Produto produto)
    {
        produto.setNome(this.getName());
        produto.setPreco(this.getPreco());
        produto.setQuant_prod(this.getQuant_prod());
        return produto;
    }
}
