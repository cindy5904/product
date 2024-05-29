package org.example.service;

import org.example.entity.Image;
import org.example.entity.Product;
import org.example.interfaces.Repository;

import java.util.List;

public class ImageService extends BaseService implements Repository<Image> {
    private ProduitService produitService;
    @Override
    public boolean create(Image o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Image o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Image o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }


    @Override
    public Image findById(int id) {
        session = sessionFactory.openSession();
        Image image = session.get(Image.class,id);
        session.close();
        return image;
    }

    @Override
    public List<Image> findAll() {
        session = sessionFactory.openSession();
        List<Image> images = session.createQuery("from Image", Image.class).list();
        session.close();
        return images;
    }

    public void ajouterImgProduit(String url, int productId) {
        Product product = produitService.findById(productId);
        Image image = Image.builder().url(url).
    }
}
