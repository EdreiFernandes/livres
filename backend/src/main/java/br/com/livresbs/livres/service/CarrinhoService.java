package br.com.livresbs.livres.service;

import br.com.livresbs.livres.dto.CarrinhoDTO;

public interface CarrinhoService {
    void sincronizarProduto(String cpf, Integer estoqueProdutorId, Integer quantidade);
    CarrinhoDTO listarCarrinhos(String cpf);
}
