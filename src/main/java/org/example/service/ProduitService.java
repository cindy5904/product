package org.example.service;

import org.example.entity.Product;
import org.example.interfaces.Repository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Date;
import java.util.List;

public class ProduitService extends BaseService implements Repository<Product> {
    public ProduitService() {
        super();
    }


    @Override
    public boolean create(Product o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Product o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Product o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Product findById(int id) {
        session = sessionFactory.openSession();
        Product product = session.get(Product.class,id);
        session.close();
        return product;
    }

    @Override
    public List<Product> findAll() {
        session = sessionFactory.openSession();
        List<Product> products = session.createQuery("from Product", Product.class).list();
        session.close();
        return products;
    }

    public List<Product> prixSperieurA100() {
        session = sessionFactory.openSession();
        List<Product> products = session.createQuery("from Product where prix > 100", Product.class).list();
        session.close();
        return products;
    }

    public List<Product> dateCompriseEntre(Date dateDebut, Date dateFin) {
        session = sessionFactory.openSession();
        List<Product> product = session.createQuery("from Product where dateAchat between :dateDebut and :dateFin", Product.class)
        .setParameter("dateDebut", dateDebut)
        .setParameter("dateFin", dateFin)
        .list();
        session.close();
        return product;
    }

    public List<Product> produitStockInferieurSaisieUtilisateur() {
        session = sessionFactory.openSession();
        List<Product> product = session.createQuery("from Product where stock < 100", Product.class).list();
        session.close();
        return product;
    }

    public double stockValeurMarque(String nomMarque ) {
        Session session = sessionFactory.openSession();
        Query<Double> productQuery = session.createQuery("Select sum(p.prix * p.stock) from Product p where p.marque = :nomMarque", Double.class);
        productQuery.setParameter("nomMarque", nomMarque);
        double stockValue = productQuery.uniqueResult();
        session.close();
        return stockValue;
    }

    public double moyenneTousLesProduits() {
        Session session = sessionFactory.openSession();
        Query<Double> productQuery = session.createQuery("select avg(prix) from Product ", Double.class);
        double moyenneValeur = productQuery.uniqueResult();
        session.close();
        return moyenneValeur;
    }

    public List<Product> listeProduitMarque(String nomMarque) {
        Session session = sessionFactory.openSession();
        Query<Product> productQuery = session.createQuery( "from Product where marque = :nomMarque", Product.class);
        productQuery.setParameter("nomMarque", nomMarque);
        List<Product> produits = productQuery.getResultList();
        session.close();
        return produits;
    }
    public boolean deleteProductMarque(String nomMarque) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query<Boolean> query = session.createQuery("delete from Product where marque = :nomMarque");
        query.setParameter("nomMarque", nomMarque);
        session.getTransaction().commit();
        session.close();
        return true;
    }


    public void close(){
        sessionFactory.close();
    }
}
