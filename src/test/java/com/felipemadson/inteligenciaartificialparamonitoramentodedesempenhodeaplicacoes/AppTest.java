package com.felipemadson.inteligenciaartificialparamonitoramentodedesempenhodeaplicacoes;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    private App app;

    @BeforeEach
    void setUp() {
        app = new App();
    }

    @Test
    void testInit() {
        assertNotNull(app);
        assertEquals("State: INITIALIZED", app.getMetadata());
    }

    @Test
    void testProcessValid() {
        String hash = app.process("test data");
        assertNotNull(hash);
        assertFalse(hash.isEmpty());
        assertEquals("State: PROCESSED", app.getMetadata());
    }

    @Test
    void testProcessInvalidNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            app.process(null);
        });
    }

    @Test
    void testProcessInvalidEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            app.process("   ");
        });
    }

    @Test
    void testValidate() {
        assertDoesNotThrow(() -> {
            app.validate("valid");
        });
    }

    @Test
    void testGetMetadata() {
        app.clear();
        assertTrue(app.getMetadata().contains("CLEARED"));
    }

    @Test
    void testClear() {
        app.process("data");
        app.clear();
        assertEquals("State: CLEARED", app.getMetadata());
    }
}
