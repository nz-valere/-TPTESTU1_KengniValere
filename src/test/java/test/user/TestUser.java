import org.junit.jupiter.api.Test;

@Test
public void testAddValidUser() {
        User user = new User(1, "John Doe", 25, "john.doe@example.com", "123456789", "City", 1000.0);
        User.add(user);
        assertTrue(User.users.contains(user));
        }

@Test
public void testAddInvalidEmail() {
        User user = new User(2, "Jane Doe", 30, "invalid-email", "123456789", "City", 500.0);
        assertThrows(EmailInvalidException.class, () -> User.add(user));
        }

@Test
public void testDeleteUser() {
        User user = new User(1, "John Doe", 25, "john.doe@example.com", "123456789", "City", 1000.0);
        User.add(user);
        User.delete(user.getId());
        assertFalse(User.users.contains(user));
        }

@Test
public void testDeleteNonExistentUser() {
        assertThrows(DeletionInvalidException.class, () -> User.delete(999));
        }

@Test
public void testDisplayUser() {
        User user = new User(1, "John Doe", 25, "john.doe@example.com", "123456789", "City", 1000.0);
        User.add(user);
        assertEquals(user, User.display(user.getId()));
        }
