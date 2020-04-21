package no.ntnu.idata2001.contacts.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Optional;

/**
 * DatabaseHandler class for Contacts
 */
public class AddressBookDBHandler implements AddressBook, Serializable {
    private EntityManagerFactory efact;
    private EntityManager em;
    private static AddressBookDBHandler instance;

    private AddressBookDBHandler() {
        efact = Persistence.createEntityManagerFactory("contacts-pu-local-db");
        em = efact.createEntityManager();
    }

    public static AddressBookDBHandler getInstance() {
        if(instance == null) {
            instance = new AddressBookDBHandler();
            return instance;
        } else {
            return instance;
        }
    }

    @Override
    public void addContact(ContactDetails contact) {
        if (contact != null) {
            em.getTransaction().begin();
            em.merge(contact);
            em.getTransaction().commit();
        }
    }

    @Override
    public void removeContact(String phone) {
        em.getTransaction().begin();
        em.remove(em.find(ContactDetails.class,phone));
        em.getTransaction().commit();
    }

    @Override
    public Collection<ContactDetails> getAllContacts() {
        Query q = em.createQuery("select a from ContactDetails a");
        Collection<ContactDetails> contacts = q.getResultList();
        return contacts;
    }

    @Override
    public Iterator<ContactDetails> iterator() {
        Iterator<ContactDetails> iterator = getAllContacts().iterator();
        return iterator;
    }

    @Override
    public void close() {
        em.close();
        efact.close();
    }
}
