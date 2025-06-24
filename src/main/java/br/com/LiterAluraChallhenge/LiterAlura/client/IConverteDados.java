package br.com.LiterAluraChallhenge.LiterAlura.client;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
