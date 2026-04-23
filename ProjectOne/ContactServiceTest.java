package contactservice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

    @Test
    void testAddContactSuccessfully() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertTrue(service.addContact(contact));
    }

    @Test
    void testAddDuplicateContactIdFails() {
        ContactService service = new ContactService();
        Contact c1 = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        Contact c2 = new Contact("12345", "Jane", "Smith", "0987654321", "456 Oak St");

        service.addContact(c1);
        assertFalse(service.addContact(c2));
    }

    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);
        assertTrue(service.deleteContact("12345"));
    }

    @Test
    void testDeleteNonexistentContactFails() {
        ContactService service = new ContactService();
        assertFalse(service.deleteContact("99999"));
    }

    @Test
    void testUpdateFirstName() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);
        assertTrue(service.updateFirstName("12345", "Jane"));
        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    void testUpdateLastName() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);
        assertTrue(service.updateLastName("12345", "Smith"));
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    void testUpdatePhone() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);
        assertTrue(service.updatePhone("12345", "0987654321"));
        assertEquals("0987654321", contact.getPhone());
    }

    @Test
    void testUpdateAddress() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);
        assertTrue(service.updateAddress("12345", "456 Oak St"));
        assertEquals("456 Oak St", contact.getAddress());
    }

    @Test
    void testUpdateFailsForMissingContact() {
        ContactService service = new ContactService();

        assertFalse(service.updateFirstName("99999", "Test"));
        assertFalse(service.updateLastName("99999", "Test"));
        assertFalse(service.updatePhone("99999", "1234567890"));
        assertFalse(service.updateAddress("99999", "123 Main St"));
    }
}
