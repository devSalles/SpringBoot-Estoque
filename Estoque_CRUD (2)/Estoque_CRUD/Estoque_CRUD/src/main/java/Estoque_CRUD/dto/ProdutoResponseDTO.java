package Estoque_CRUD.dto;


import Estoque_CRUD.model.Produto;

//Classe DTO para exibição de dados
public record ProdutoResponseDTO(
        Long id,
        String name,
        Double preco,
        Integer Quant_Prod
)
{
    public static ProdutoResponseDTO fromProduto(Produto produto)
    {
        return new ProdutoResponseDTO(produto.getId(), produto.getNome(), produto.getPreco(),produto.getQuant_prod());
    }
}
