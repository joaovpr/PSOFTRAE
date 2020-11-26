package com.ufcg.psoft.mercadofacil.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.ufcg.psoft.mercadofacil.enumTipos.TipoPagamento;
import com.ufcg.psoft.mercadofacil.model.*;
import com.ufcg.psoft.mercadofacil.repositories.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ufcg.psoft.mercadofacil.DTO.LoteDTO;
import com.ufcg.psoft.mercadofacil.repositories.LoteRepository;
import com.ufcg.psoft.mercadofacil.repositories.ProdutoRepository;
import com.ufcg.psoft.mercadofacil.util.CustomErrorType;

import exceptions.ObjetoInvalidoException;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class RestApiController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private LoteRepository loteRepository;

	@Autowired
	private Carrinho carrinho;

	@Autowired
	private CompraRepository compraRepository;
		
	@RequestMapping(value = "/produtos", method = RequestMethod.GET)
	public ResponseEntity<?> listarProdutos() {
		List<Produto> produtos = new ArrayList<>();
		produtos = produtoRepository.findAll();
		
		if (produtos.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// Outro código de erro pode ser retornado HttpStatus.NOT_FOUND
		}
		
		return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/produto/", method = RequestMethod.POST)
	public ResponseEntity<?> criarProduto(@RequestBody Produto produto, UriComponentsBuilder ucBuilder) {

		List<Produto> produtos = produtoRepository.findByCodigoBarra(produto.getCodigoBarra());
		
		// Produto não encontrado
		if (!produtos.isEmpty()) {
			return new ResponseEntity<CustomErrorType>(new CustomErrorType("O produto " + produto.getNome() + " do fabricante "
					+ produto.getFabricante() + " ja esta cadastrado!"), HttpStatus.CONFLICT);
		}

		try {
			produto.mudaSituacao(Produto.INDISPONIVEL);
		} catch (ObjetoInvalidoException e) {
			return new ResponseEntity<CustomErrorType>(new CustomErrorType("Error: Produto" + produto.getNome() + " do fabricante "
					+ produto.getFabricante() + " alguma coisa errada aconteceu!"), HttpStatus.NOT_ACCEPTABLE);
		}

		produtoRepository.save(produto);
		return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/produto/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarProduto(@PathVariable("id") long id) {

		Optional<Produto> produto = produtoRepository.findById(id);
	

		if (!produto.isPresent()) {
			return new ResponseEntity<CustomErrorType>(new CustomErrorType("Produto with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Produto>(produto.get(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/produto/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateProduto(@PathVariable("id") long id, @RequestBody Produto produto) {

		Optional<Produto> optionalProduto = produtoRepository.findById(id);
		

		if (!optionalProduto.isPresent()) {
			return new ResponseEntity<CustomErrorType>(new CustomErrorType("Produto with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		
		Produto currentProduto = optionalProduto.get();
		
		currentProduto.setNome(produto.getNome());
		currentProduto.setPreco(produto.getPreco());
		currentProduto.setCodigoBarra(produto.getCodigoBarra());
		currentProduto.mudaFabricante(produto.getFabricante());
		currentProduto.mudaCategoria(produto.getCategoria());
		currentProduto.setDescricao(produto.getDescricao());

		produtoRepository.save(currentProduto);
		
		return new ResponseEntity<Produto>(currentProduto, HttpStatus.OK);
	}

	@RequestMapping(value = "/produto/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteProduto(@PathVariable("id") long id) {

		Optional<Produto> optionalProduto = produtoRepository.findById(id);
		
		if (!optionalProduto.isPresent()) {
			return new ResponseEntity<CustomErrorType>(new CustomErrorType("Produto with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
				
		produtoRepository.delete(optionalProduto.get());

		return new ResponseEntity<Produto>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/produto/{id}/lote", method = RequestMethod.POST)
	public ResponseEntity<?> criarLote(@PathVariable("id") long id, @RequestBody LoteDTO loteDTO) {
		
		Optional<Produto> optionalProduto = produtoRepository.findById(id);
		
		if (!optionalProduto.isPresent()) {
			return new ResponseEntity<CustomErrorType>(new CustomErrorType("Produto with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		
		Produto product = optionalProduto.get();
		Lote lote = new Lote(product, loteDTO.getNumeroDeItens(), loteDTO.getValidade());
		
		loteRepository.save(lote);
		
		try {
			if (product.getSituacao() == Produto.INDISPONIVEL) {
				if (loteDTO.getNumeroDeItens() > 0) {
					Produto produtoDisponivel = product;
					produtoDisponivel.situacao = Produto.DISPONIVEL;
					produtoRepository.save(produtoDisponivel);
				}
			}
		} catch (ObjetoInvalidoException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(lote, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/lotes", method = RequestMethod.GET)
	public ResponseEntity<?> listarLotes() {
		
		List<Lote> lotes = loteRepository.findAll();

		if (lotes.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// Outro código de erro pode ser retornado HttpStatus.NOT_FOUND
		}
		
		return new ResponseEntity<List<Lote>>(lotes, HttpStatus.OK);
	}

	@RequestMapping(value = "/carrinho/{idProduto}", method = RequestMethod.PUT)
	public ResponseEntity<?> addAoCarrinho(@PathVariable Long idProduto){
		Optional<Produto> prod = produtoRepository.findById(idProduto);
		if(!prod.isPresent()){
			return new ResponseEntity<CustomErrorType>(new CustomErrorType("Produto Invalido"),HttpStatus.NOT_FOUND);
		}
		Produto produto =  prod.get();
		Produto produtoAdd = this.carrinho.addProdutoCarrinho(produto);
		return new ResponseEntity<Produto>(produtoAdd,HttpStatus.OK);
	}

	@RequestMapping(value = "/carrinho", method = RequestMethod.GET)
	public ResponseEntity<?> listaCarrinho(){
		return new ResponseEntity<List<Produto>>(this.carrinho.exibirCarrinho(),HttpStatus.OK);
	}
	@RequestMapping(value = "/carrinho", method = RequestMethod.PUT)
	public ResponseEntity<?> esvaziaCarrinho(){
		carrinho.esvaziaCarrinho();
		return new ResponseEntity<Produto>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/carrinho/compra", method = RequestMethod.POST)
	public ResponseEntity<?> confirmacaoCompra(TipoPagamento formaPagamento) throws ObjetoInvalidoException {
		List<Lote> lotes = loteRepository.findAll();
		Compra compra = new Compra(carrinho.exibirCarrinho(),formaPagamento);
		compra.povoaArray(carrinho.exibirCarrinho());
		compra.removeDoLote(compra.getProdutos(),lotes);
		compraRepository.save(compra);
		carrinho.esvaziaCarrinho();
		return new ResponseEntity<String>(compra.geraRelatorio(),HttpStatus.CREATED);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<?> listarCompras() {

		List<Compra> compras = compraRepository.findAll();

		if (compras.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// Outro código de erro pode ser retornado HttpStatus.NOT_FOUND
		}

		return new ResponseEntity<List<Compra>>(compras, HttpStatus.OK);

	}

	@RequestMapping(value = "/compra/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarCompra(@PathVariable("id") long id) {

		Optional<Compra> compra = compraRepository.findById(id);


		if (!compra.isPresent()) {
			return new ResponseEntity<CustomErrorType>(new CustomErrorType("Compra with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Compra>(compra.get(), HttpStatus.OK);
	}















}