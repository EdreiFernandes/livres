package br.com.livresbs.livres.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@PropertySource("message.properties")
@Configuration
@Data
public class MessageProperty {

    @Value("${parametro.nulo}")
    private String menssageParametroNulo;

    @Value("${header.nulo}")
    private String menssagemHeaderNulo;

    @Value("${carrinho.vazio}")
    private String menssagemCarrinhoVazio;

}
