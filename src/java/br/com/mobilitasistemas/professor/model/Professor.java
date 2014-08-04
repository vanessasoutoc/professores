package br.com.mobilitasistemas.professor.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mobilita
 */
@Entity
@Table( name = "Professor" )
@NamedQueries( {
    @NamedQuery( name = Professor.FIND_ALL ,
                 query = "SELECT p FROM Professor p" ) } )
@XmlRootElement
public class Professor implements Serializable {

    public static final String FIND_ALL = "Professor.findAll";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    private String nome;

    private String especialidade;

    @ManyToMany( fetch = FetchType.EAGER )
    private Set<Escola> escolas;

    @XmlTransient
    public Set<Escola> getEscolas() {
        return escolas;
    }

    public void setEscolas( Set<Escola> escolas ) {
        this.escolas = escolas;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome( String nome ) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade( String especialidade ) {
        this.especialidade = especialidade;
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
        if ( !( object instanceof Professor ) ) {
            return false;
        }
        Professor other = ( Professor ) object;
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
