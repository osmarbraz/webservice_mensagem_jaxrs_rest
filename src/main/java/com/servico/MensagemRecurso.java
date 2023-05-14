package com.servico;

import com.entidade.Mensagem;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 *
 * @author osmar
 */

@Path("/mensagem")
public class MensagemRecurso {
    
    private final Mensagem mensagem = Mensagem.getInstancia();
    
    /**
     * Gera saída em JSON da mensagem.
     * 
     * Teste com o comando no console:
     * curl http://localhost:8080/webservice_mensagem_jaxrs_rest/rest/mensagem
     * 
     * @return 
     */
    @GET    
    @Produces(MediaType.APPLICATION_JSON)    
    public Response getRecursoMensagemJSON() {        
        System.out.println("Executando serviço getRecursoMensagem JSON.");
        //Mensagem de retorno
        return Response.ok(mensagem).build();
    }
    
    /**
     * Gera saída em XML da mensagem.
     * 
     * Teste com o comando no console:
     * curl http://localhost:8080/webservice_mensagem_jaxrs_rest/rest/mensagem/xml
     * 
     * @return 
     */
    @GET
    @Path("xml")    
    @Produces(MediaType.APPLICATION_XML)    
    public Response getRecursoMensagemXML() {        
        System.out.println("Executando serviço getRecursoMensagem XML.");
        //Mensagem de retorno
        return Response.ok(mensagem).build();
    }

    /**
     * Modifica a mensagem através de JSON.
     * 
     * Teste com o comando no console:
     * curl -v -X POST -H "Content-Type: application/json" -d "{\"mensagem\":\"Nova Mensagem\"}" http://localhost:8080/webservice_mensagem_jaxrs_rest/rest/mensagem
     *  
     * @param mensagem 
     * @return  
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)    
    public Response setRecursoMensagem(Mensagem mensagem) {
        System.out.println("Executando serviço setRecursoMensagem(string).");
        this.mensagem.setMensagem(mensagem.getMensagem());
        //Mensagem de retorno
        return Response.ok("Mensagem enviada!", MediaType.TEXT_PLAIN).build();
    }
    
    /**     
     * Modifica a mensagem através de formulário HTML.
     * 
     * @param formParams     
     * @return      
     */
    @POST    
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)    
    public Response setRecursoMensagem(MultivaluedMap<String, String> formParams) {
        //Recupera os parâmetros do formulário
        String mensagemParam = formParams.getFirst("mensagem");
        //Modifica a mensagem
        this.mensagem.setMensagem(mensagemParam);  
        //Mensagem de retorno
        return Response.ok("Mensagem enviada!", MediaType.TEXT_PLAIN).build();
    }
}