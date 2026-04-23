package contactservice;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private Map<String, Contact> contacts = new HashMap<>();

    public boolean addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            return false;
        }
        contacts.put(contact.getContactId(), contact);
        return true;
    }

    public boolean deleteContact(String contactId) {
        if (contacts.containsKey(contactId)) {
            contacts.remove(contactId);
            return true;
        }
        return false;
    }

    public boolean updateFirstName(String contactId, String newFirstName) {
        Contact contact = contacts.get(contactId);
        if (contact == null) return false;
        contact.setFirstName(newFirstName);
        return true;
    }

    public boolean updateLastName(String contactId, String newLastName) {
        Contact contact = contacts.get(contactId);
        if (contact == null) return false;
        contact.setLastName(newLastName);
        return true;
    }

    public boolean updatePhone(String contactId, String newPhone) {
        Contact contact = contacts.get(contactId);
        if (contact == null) return false;
        contact.setPhone(newPhone);
        return true;
    }

    public boolean updateAddress(String contactId, String newAddress) {
        Contact contact = contacts.get(contactId);
        if (contact == null) return false;
        contact.setAddress(newAddress);
        return true;
    }
}
