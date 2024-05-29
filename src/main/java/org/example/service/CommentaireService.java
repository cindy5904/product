package org.example.service;

import org.example.entity.Commentaire;
import org.example.entity.Image;
import org.example.entity.Product;
import org.example.interfaces.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class CommentaireService extends BaseService implements Repository<Commentaire> {

    private ProduitService produitService;

    public CommentaireService(ProduitService produitService) {
        this.produitService = produitService;
    }

    @Override
    public boolean create(Commentaire o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Commentaire o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Commentaire o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Commentaire findById(int id) {
        session = sessionFactory.openSession();
        Commentaire commentaire = session.get(Commentaire.class,id);
        session.close();
        return commentaire;
    }

    @Override
    public List<Commentaire> findAll() {
        session = sessionFactory.openSession();
        List<Commentaire> commentaires = session.createQuery("from Commentaire", Commentaire.class).list();
        session.close();
        return commentaires;
    }

    public boolean ajouterCommentaireProduit(String contenu, int note, int productId) {

        Product product = produitService.findById(productId);
        if(product !=null) {
            Commentaire commentaire = Commentaire.builder()
                    .contenu(contenu)
                    .date(LocalDate.now())
                    .note(note)
                    .product(product)
                    .build();
            create(commentaire);
        } else {
            System.out.println("produit non trouvé");
        }
        return false;
    }
}
