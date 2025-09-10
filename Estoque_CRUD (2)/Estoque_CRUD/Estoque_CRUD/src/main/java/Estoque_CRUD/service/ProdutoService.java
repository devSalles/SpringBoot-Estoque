package Estoque_CRUD.service;

import Estoque_CRUD.core.exception.EmptyListException;
import Estoque_CRUD.core.exception.IdNotFoundException;
import Estoque_CRUD.core.exception.InsufficientStockException;
import Estoque_CRUD.core.exception.StockOverFlowException;
import Estoque_CRUD.dto.ProdutoRequestDTO;
import Estoque_CRUD.dto.ProdutoResponseDTO;
import Estoque_CRUD.model.Produto;
import Estoque_CRUD.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;


    public Produto addNew(ProdutoRequestDTO produtoRequestDTO)
    {
        Produto produto = produtoRequestDTO.toProduto();
        return this.produtoRepository.save(produto);
    }

    public Produto editById(Long id, ProdutoRequestDTO produtoRequestDTO)
    {
        Produto produtoID = this.produtoRepository.findById(id).orElseThrow(IdNotFoundException::new);

        produtoRequestDTO.updateProduto(produtoID);
        return this.produtoRepository.save(produtoID);
    }

    public List<ProdutoResponseDTO> showAll()
    {
        List<Produto>produtos = this.produtoRepository.findAll();
        if(produtos.isEmpty())
        {
            throw new EmptyListException();
        }
        return produtos.stream().map(ProdutoResponseDTO::fromProduto).toList();
    }

    public ProdutoResponseDTO showById(Long id)
    {
        Produto produto = this.produtoRepository.findById(id).orElseThrow(IdNotFoundException::new);
        return ProdutoResponseDTO.fromProduto(produto);
    }

    public Boolean deleteById(Long id)
    {
        Produto produtoDEL = this.produtoRepository.findById(id).orElseThrow(IdNotFoundException::new);
        this.produtoRepository.delete(produtoDEL);
        return true;
    }

    public void deleteAll()
    {
        if(this.produtoRepository.findAll().isEmpty())
        {
            throw new EmptyListException();
        }
        this.produtoRepository.deleteAll();
    }

    //Metodo para aumentar de quantidade de produto no estoque
    public Produto inputProd(Long id, Integer quant)
    {
        if(quant==null || quant<=0)
        {
            throw new IllegalArgumentException("Valor deve ser positivo ou maior que 0");
        }

        Produto produto=this.produtoRepository.findById(id).orElseThrow(IdNotFoundException::new);

        if(produto.getQuant_prod()+quant>produto.getQuantMax())
        {
            throw new StockOverFlowException();
        }

        produto.setQuant_prod(produto.getQuant_prod()+quant);
        return this.produtoRepository.save(produto);
    }

    //Metodo para diminuir quantidade de produto no estoque
    public Produto outputProd(Long id , Integer quant)
    {
        if(quant==null || quant<=0)
        {
            throw new IllegalArgumentException("Valor deve ser positivo ou maior que 0");
        }

        Produto produto=this.produtoRepository.findById(id).orElseThrow(IdNotFoundException::new);
        if(produto.getQuant_prod()<quant)
        {
            throw new InsufficientStockException();
        }
        produto.setQuant_prod(produto.getQuant_prod()-quant);
        return this.produtoRepository.save(produto);
    }
}