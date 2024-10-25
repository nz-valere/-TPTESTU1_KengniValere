package com.test.user;

import com.user.operation.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TstUser {

    @org.junit.jupiter.api.Test
    public void testAddValidUser() {
        User user = new User(1, "John Doe", 25, "john.doe@example.com", "123456789", "City", 1000.0);
        User.add(user);
        assertTrue(User.users.contains(user));
    }

    @org.junit.jupiter.api.Test
    public void testAddInvalidEmail() {
        User user = new User(2, "Jane Doe", 30, "invalid-email", "123456789", "City", 500.0);
        assertThrows(User.EmailInvalidException.class, () -> User.add(user));
    }

    @org.junit.jupiter.api.Test
    public void testDeleteUser() {
        User user = new User(1, "John Doe", 25, "john.doe@example.com", "123456789", "City", 1000.0);
        User.add(user);
        User.delete(user.getId());
        assertFalse(User.users.contains(user));
    }

    @org.junit.jupiter.api.Test
    public void testDeleteNonExistentUser() {
        assertThrows(DeletionInvalidException.class, () -> User.delete(999));
    }

    @Test
    public void testDisplayUser() {
        User user = new User(1, "John Doe", 25, "john.doe@example.com", "123456789", "City", 1000.0);
        User.add(user);
        assertEquals(user, User.display(user.getId()));
    }

    import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

    public class TestUser {

        @Test
        public void testAnalyseSoldeGeneralPositive() {
            User.users.clear();
            User.add(new User(1, "Alice", 25, "alice@example.com", "123456789", "City", 1000.0));
            User.add(new User(2, "Bob", 30, "bob@example.com", "987654321", "City", 2000.0));

            assertEquals(3000.0, User.analyseSoldeGeneral(), 0.001);
        }

        @Test
        public void testAnalyseSoldeGeneralNegativeException() {
            User.users.clear();
            User.add(new User(1, "Alice", 25, "alice@example.com", "123456789", "City", -500.0));
            User.add(new User(2, "Bob", 30, "bob@example.com", "987654321", "City", -600.0));

            assertThrows(NegativeGeneralBalanceException.class, User::analyseSoldeGeneral);
        }

        @Test
        public void testGetRichestUser() {
            User.users.clear();
            User.add(new User(1, "Alice", 25, "alice@example.com", "123456789", "City", 1000.0));
            User.add(new User(2, "Bob", 30, "bob@example.com", "987654321", "City", 3000.0));

            User richestUser = User.getRichestUser();
            assertEquals("Bob", richestUser.getName());
            assertEquals(3000.0, richestUser.getBalancePersonnel(), 0.001);
        }
    }

}
