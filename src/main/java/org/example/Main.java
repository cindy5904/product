package org.example;

import org.example.entity.Image;
import org.example.entity.Product;
import org.example.service.ImageService;
import org.example.service.ProduitService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ProduitService product = new ProduitService();

        product.create(new Product("Apple","i5685",1500,199,new Date("2024/05/20")));
        product.create(new Product("Samsung","s7985",800,85,new Date("2024/01/10")));
        product.create(new Product("DELL","d5685",300,75,new Date("2023/07/20")));
        product.create(new Product("Huawei","hu568",20,800,new Date("2022/12/22")));
        product.create(new Product("Nokia","3310",50,89,new Date("2024/05/10")));



//        System.out.println(product.findAll());
//        System.out.println(product.prixSperieurA100());
//        Date dateDebut = new Date("2018/ 11/ 12");
//        Date dateFin = new Date("2023/01/01");
//        System.out.println(product.dateCompriseEntre(dateDebut, dateFin));
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Entrez la date de début: ");
//        String dateDebutStr = scanner.nextLine();
//        Date dateDebutScanner = new Date(dateDebutStr);
//        System.out.print("Entrez la date de fin: ");
//        String dateFinStr = scanner.nextLine();
//        Date dateFinScanner = new Date(dateFinStr);

//        System.out.println(product.dateCompriseEntre(dateDebutScanner, dateFinScanner));
        System.out.println(product.produitStockInferieurSaisieUtilisateur());
        System.out.println(product.stockValeurMarque("Apple"));
        System.out.println(product.moyenneTousLesProduits());
        System.out.println(product.listeProduitMarque("Nokia"));
        System.out.println(product.deleteProductMarque("DELL"));
//        System.out.println(product.ajouterImageAuProduit(1,"1234545"));

        ProduitService produitService = new ProduitService();


        ImageService imageService = new ImageService();
        int idProduit = 1;
        String imgUrl = "blabla";
        System.out.println(produitService.ajouterImageAuProduit(idProduit, imgUrl, imageService));

        ;




    }





}