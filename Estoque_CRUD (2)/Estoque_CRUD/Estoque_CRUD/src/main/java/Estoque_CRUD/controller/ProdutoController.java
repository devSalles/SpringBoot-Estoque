package Estoque_CRUD.controller;

import Estoque_CRUD.dto.ProdutoRequestDTO;
import Estoque_CRUD.dto.ProdutoResponseDTO;
import Estoque_CRUD.service.ProdutoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
@Tag(name = "Produto")
public class ProdutoController {


    private final ProdutoService produtoService;

    @PostMapping("/add")
    public ResponseEntity<Object> addnew(@RequestBody @Valid ProdutoRequestDTO produtoDTO)
    {
        this.produtoService.addNew(produtoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto criado");
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Object> editById(@PathVariable Long id, @RequestBody @Valid ProdutoRequestDTO produtoRequestDTO)
    {
        return ResponseEntity.status(HttpStatus.OK).body(this.produtoService.editById(id,produtoRequestDTO));
    }

    @GetMapping("/showAll")
    public ResponseEntity<Object> showAll()
    {
        List<ProdutoResponseDTO>produtoResponse=this.produtoService.showAll();
        return ResponseEntity.status(HttpStatus.OK).body(produtoResponse);
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<Object> showById(@PathVariable Long id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(this.produtoService.showById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object>deleteById(@PathVariable Long id)
    {
        Boolean prodDel=this.produtoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(prodDel);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<Object>delete()
    {
        this.produtoService.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/input-quantity/{id}")
    public ResponseEntity<Object> inputQuantProd(@PathVariable Long id , @RequestParam Integer quant)
    {
        this.produtoService.inputProd(id,quant);
        return ResponseEntity.status(HttpStatus.OK).body("Entrada de produto com quantidade: "+quant);
    }

    @PostMapping("/output-quantity{id}")
    public ResponseEntity<Object> outPut(@PathVariable Long id, @RequestParam Integer quant)
    {
        this.produtoService.outputProd(id,quant);
        return ResponseEntity.status(HttpStatus.OK).body("Saida de produto com quantidade: "+quant);
    }
}
