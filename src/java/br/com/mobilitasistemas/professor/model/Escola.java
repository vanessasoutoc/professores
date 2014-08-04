package br.com.mobilitasistemas.professor.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author mobilita
 */
@Entity
public class Escola implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    private String nome;

    private String bairro;

    @ManyToMany( mappedBy = "escolas" )
    private Set<Professor> professores;

    public Set<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores( Set<Professor> professores ) {
        this.professores = professores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome( String nome ) {
        this.nome = nome;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro( String bairro ) {
        this.bairro = bairro;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += ( id != null
                  ? id.hashCode()
                  : 0 );
        return hash;
    }

    @Override
    public boolean equals( Object object ) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if ( !( object instanceof Escola ) ) {
            return false;
        }
        Escola other = ( Escola ) object;
        if ( ( this.id == null && other.id != null ) || ( this.id != null && !this.id.equals(
                other.id ) ) ) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNome();
    }

}
