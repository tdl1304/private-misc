package no.ntnu.idata2001.contacts.model;

import java.util.Collection;
import java.util.Iterator;

public interface AddressBook {
    public void addContact(ContactDetails contact);
    public void removeContact(String phone);
    public Collection<ContactDetails> getAllContacts();
    public Iterator<ContactDetails> iterator();
    public void close();
}
