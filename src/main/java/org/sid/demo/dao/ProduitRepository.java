package org.sid.demo.dao;


import org.sid.demo.entities.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

//vous etre en train de dire a voter application notamment a tomcat quand il recoit une requete
// de type OPTION pour demander s'il ya une application qui a que vous avez recupere a partir
// d'un auter domaine a partir maintenant j'ai l'autorisation d'acceder a cette api Rest
// si je veux fixer les nom de  domaine a acceder a cette api REST on donnnes les donmaine dnas* en hour
@CrossOrigin("*")
@RepositoryRestResource
public interface ProduitRepository extends JpaRepository<Produit,Long> {
    @RestResource(path = "/alo")
    public List<Produit> findByDesignationContains(@Param("mc") String des);

    @RestResource(path = "/aloByPage")
        public Page<Produit> findByDesignationContains(@Param("mc") String des, Pageable pp);
}
