package org.sid.demo;

import org.sid.demo.dao.ProduitRepository;
import org.sid.demo.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
    private ProduitRepository p;

    @Autowired
    private RepositoryRestConfiguration restConfiguration;

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        restConfiguration.exposeIdsFor(Produit.class);
        p.save(new Produit(1L,"Ordinadteur LW 88",9500,12));
        p.save(new Produit(2L,"Imprimante HP",1200,22));
//        p.save(new Produit(3L,"IPhone",13000,12));
//        p.save(new Produit(4L,"HP 12",2900,32));
//        p.save(new Produit(5L,"cOMPAQUE  HP 34",5600,21));
//        p.save(new Produit(6L,"sorie  HP ",100,100));
//
//        p.save(new Produit(7L,"Ordinadteur LW 88",9500,12));
//        p.save(new Produit(8L,"Imprimante HP",1200,22));
//        p.save(new Produit(9L,"IPhone",13000,12));
//        p.save(new Produit(10L,"HP 12",2900,32));
//        p.save(new Produit(11L,"cOMPAQUE  HP 34",5600,21));
//        p.save(new Produit(12L,"sorie  HP ",100,100));
//
//        p.save(new Produit(13L,"Ordinadteur LW 88",9500,12));
//        p.save(new Produit(14L,"Imprimante HP",1200,22));
//        p.save(new Produit(15L,"IPhone",13000,12));
//        p.save(new Produit(16L,"HP 12",2900,32));
//        p.save(new Produit(17L,"cOMPAQUE  HP 34",5600,21));
//        p.save(new Produit(18L,"sorie  HP ",100,100));
//
//        p.save(new Produit(19L,"ZZ",100,100));

        p.findAll().forEach(System.out::println);
    }
}
