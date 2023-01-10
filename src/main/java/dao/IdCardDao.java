package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import modelo.IdCard;
import modelo.Person;

public class IdCardDao {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction transaction;

    public IdCardDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    public IdCard busca(IdCard idCard){
        return entityManager.find(IdCard.class, idCard.getNumero() );
    }

    public void guardaIdCard (IdCard idCard){

        try {
            transaction.begin();
            entityManager.persist(idCard);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }




}
