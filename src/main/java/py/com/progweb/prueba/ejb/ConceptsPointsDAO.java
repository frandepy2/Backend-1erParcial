package py.com.progweb.prueba.ejb;

import py.com.progweb.prueba.model.ConceptsPoints;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class ConceptsPointsDAO {
    @PersistenceContext(unitName = "pruebaPU")
    private EntityManager em;

    public List<ConceptsPoints> lista(){
        Query q = this.em.createQuery("select c from ConceptsPoints c");
        return (List<ConceptsPoints>) q.getResultList();
    }

}
