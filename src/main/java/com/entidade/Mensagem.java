package com.entidade;

/**
 *
 * @author osmar
 */
public class Mensagem {

    private String mensagem;
    private static Mensagem instancia;

    /**
     * Construtor privado para garantir a construção através do método getInstacia().
     * 
     */
    private Mensagem() {
        setMensagem("inicial");
    }

    /**
     * Retorna uma instância do objeto.
     * 
     * Garante que somente um objeto vai existir em memória.
     * 
     * @return Um objeto mensagem.
     */
    public static Mensagem getInstancia() {
        if (instancia == null) {
            instancia = new Mensagem();
        }
        return instancia;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
