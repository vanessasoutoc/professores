/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mobilitasistemas.professor.dao;

import br.com.mobilitasistemas.professor.model.Professor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author mobilita
 */
@Stateless
public class ProfessorDao {

    @PersistenceContext( unitName = "ProfessorPU" )
    private EntityManager entityManager;

    public Professor salva( Professor professor ) {
        return entityManager.merge( professor );
    }

    public List<Professor> get() {
        TypedQuery<Professor> createNamedQuery = entityManager.createNamedQuery(
                Professor.FIND_ALL , Professor.class );
        List<Professor> resultList = null;
        if ( createNamedQuery != null ) {
            resultList = createNamedQuery.getResultList();
        }

        return resultList;

    }

}
