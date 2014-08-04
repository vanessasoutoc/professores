/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mobilitasistemas.professor.service;

import br.com.mobilitasistemas.professor.dao.ProfessorDao;
import br.com.mobilitasistemas.professor.model.Escola;
import br.com.mobilitasistemas.professor.model.Professor;
import com.google.gson.Gson;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author vanessa
 */
@Stateless
@Path( "/professores" )
public class ProfessorREST {

    @Inject
    ProfessorDao dao;

    Gson gson = new Gson();

    @Path( "/salva" )
    @POST
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    public String salva( String jsonProfessor ) {

        Professor professorFromJson = gson.fromJson( jsonProfessor ,
                                                     Professor.class );
        Professor salva = dao.salva( professorFromJson );
        String toJson = gson.toJson( salva );
        return toJson;
    }

    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public String busca() {
        List<Professor> lista = dao.get();
        for ( Professor professor : lista ) {
            for ( Escola escola : professor.getEscolas() ) {
                escola.setProfessores( null );
            }
        }
        String toJson = gson.toJson( lista );
        return toJson;

    }

}
