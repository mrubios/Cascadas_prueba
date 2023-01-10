package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import modelo.IdCard;
import modelo.Person;

public class PersonDao {

    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction transaction;

    public PersonDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("default");
        entityManager = entityManagerFactory.createEntityManager();
        transaction = entityManager.getTransaction();
    }
    public void modificarPersona(Person p) {
        try {
            p.setName("Luisa");
            IdCard tarjeta = p.getTarjeta();
            tarjeta.setTitulo("Psicologia");
            transaction.begin();
            entityManager.merge(tarjeta);
            transaction.commit();
            transaction.begin();
            entityManager.merge(p);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    public void borrarPersona(Person p) {
        try {
            transaction.begin();
            Person personTMP = entityManager.merge(p);
            entityManager.remove(personTMP);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    public Person busca(Person person){
        return entityManager.find(Person.class, person.getDni() );
    }


    public void guarda (Person person){

        try {
            transaction.begin();
            entityManager.persist(person);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

}
