package org.sid.demo.entities;

import org.sid.demo.dao.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProduitRestService {
    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping(value = "find")
    public List<Produit> produitList()
    {
      return produitRepository.findAll();
    }

    @GetMapping(value = "find/{id}")
    public Produit produitList(@PathVariable(name = "id")Long id)
    {
        return produitRepository.findById(id).get();
    }

    //pour recuper les donnes en format json RequestBody
    //ayous format de json utiliser est changer les donnes enter les mecro-service
    @PutMapping(value = "find/{id}")
    public Produit update(@PathVariable(name = "id")Long id,@RequestBody Produit p)
    {
        p.setId(id);
        return produitRepository.save(p);
    }

    @PostMapping(value = "Ajouter")
    public Produit Ajouter(@RequestBody Produit p)
    {
        return produitRepository.save(p);
    }

    @DeleteMapping(value = "find/{id}")
    public void  delete(@PathVariable(name = "id")Long id)
    {
        produitRepository.deleteById(id);
    }

}
