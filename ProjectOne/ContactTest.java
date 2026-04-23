package contactservice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactTest {

    @Test
    void testValidContactCreation() {
        Contact c = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("12345", c.getContactId());
        assertEquals("John", c.getFirstName());
        assertEquals("Doe", c.getLastName());
        assertEquals("1234567890", c.getPhone());
        assertEquals("123 Main St", c.getAddress());
    }

    // Consolidated invalid constructor tests (Jacoco-friendly)
    @Test
    void testInvalidConstructorArguments() {
        // contactId
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));

        // firstName
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", null, "Doe", "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "JohnathanTooLong", "Doe", "1234567890", "123 Main St"));

        // lastName
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "John", null, "1234567890", "123 Main St"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "John", "DoeIsTooLonggg", "1234567890", "123 Main St"));

        // phone
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "John", "Doe", null, "123 Main St"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "John", "Doe", "12345", "123 Main St"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "John", "Doe", "abcde12345", "123 Main St"));

        // address
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "John", "Doe", "1234567890", null));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345", "John", "Doe", "1234567890",
                        "This address is definitely more than thirty characters long"));
    }

    // Consolidated setter exception tests (Jacoco-friendly)
    @Test
    void testInvalidSetters() {
        Contact c = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        // firstName
        assertThrows(IllegalArgumentException.class, () -> c.setFirstName(null));
        assertThrows(IllegalArgumentException.class, () -> c.setFirstName("ThisNameIsTooLong"));

        // lastName
        assertThrows(IllegalArgumentException.class, () -> c.setLastName(null));
        assertThrows(IllegalArgumentException.class, () -> c.setLastName("ThisLastNameIsTooLong"));

        // phone
        assertThrows(IllegalArgumentException.class, () -> c.setPhone(null));
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("12345"));
        assertThrows(IllegalArgumentException.class, () -> c.setPhone("abcde12345"));

        // address
        assertThrows(IllegalArgumentException.class, () -> c.setAddress(null));
        assertThrows(IllegalArgumentException.class,
                () -> c.setAddress("This address is definitely more than thirty characters long"));
    }

    @Test
    void testValidSetters() {
        Contact c = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        c.setFirstName("Jane");
        c.setLastName("Smith");
        c.setPhone("0987654321");
        c.setAddress("456 Oak St");

        assertEquals("Jane", c.getFirstName());
        assertEquals("Smith", c.getLastName());
        assertEquals("0987654321", c.getPhone());
        assertEquals("456 Oak St", c.getAddress());
    }
}
