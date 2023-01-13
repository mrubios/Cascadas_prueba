package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import modelo.Asociacion;

public class AsociacionDao {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction transaction;

    public AsociacionDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }

    public void guardaAsociacion (Asociacion asociacion){

        try {
            transaction.begin();
            entityManager.persist(asociacion);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    public void borrarAsociacion(Asociacion a) {
        try {
            transaction.begin();
            Asociacion asociacionTMP = entityManager.merge(a);
            entityManager.remove(asociacionTMP);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }
    public Asociacion buscarAsociacion(Asociacion a ){
        return  entityManager.merge(a);
    }
}
