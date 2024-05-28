package org.example;

import org.example.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();


        Session session = sessionFactory.openSession();

        session.getTransaction().begin();
        LocalDate dateAchat = LocalDate.of(2022, 5, 6);
        LocalDate dateAchat2 = LocalDate.of(2023, 12, 28);
        LocalDate dateAchat3 = LocalDate.of(2024, 2, 15);
        Product product = new Product().builder()
                .marque("Marque1")
                .reference("ref1")
                .dateAchat(dateAchat)
                .prix(150.00)
                .stock(28)
                .build();

        Product product1 = new Product().builder()
                .marque("Marque2")
                .reference("ref2")
                .dateAchat(dateAchat2)
                .prix(180.00)
                .stock(22)
                .build();

        Product product3 = new Product().builder()
                .marque("Marque3")
                .reference("ref3")
                .dateAchat(dateAchat2)
                .prix(10.00)
                .stock(122)
                .build();

        Product product4 = new Product().builder()
                .marque("Marque4")
                .reference("ref4")
                .dateAchat(dateAchat3)
                .prix(50.00)
                .stock(472)
                .build();
        Product product5 = new Product().builder()
                .marque("Marque5")
                .reference("ref5")
                .dateAchat(dateAchat3)
                .prix(80.00)
                .stock(42)
                .build();

        session.save(product);
        session.save(product1);
        session.save(product3);
        session.save(product4);
        session.save(product5);
        System.out.println("Id du produit : " + product.getId() );
        System.out.println("Id du produit : " + product1.getId());
        System.out.println("Id du produit : " + product3.getId());
        System.out.println("Id du produit : " + product4.getId());
        System.out.println("Id du produit : " + product5.getId());
        session.getTransaction().commit();

        session.getTransaction().begin();
        Product productId2 = session.load(Product.class, 2L);
        System.out.println(productId2);
        session.getTransaction().commit();

        session.getTransaction().begin();
        Product productDeleteId3 = session.load(Product.class, 3L);
        session.delete(productDeleteId3);
        session.getTransaction().commit();

        session.getTransaction().begin();
        Product productUpdateId1 = session.load(Product.class, 1L);
        productUpdateId1.setMarque("MarqueModifier");
        System.out.println(productUpdateId1);
        session.getTransaction().commit();

        session.close();
        sessionFactory.close();

    }





}