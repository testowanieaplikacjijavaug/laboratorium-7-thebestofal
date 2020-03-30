import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoteTest
{
    
    static Note note;
    private Throwable thrown;
    @Test
    void of()
    {
        note = Note.of("Marek", 5);
        note = Note.of("Marek", 4);
        assertEquals(note.getNote(), 4);
    }
    
    @Test
    void of_incorrectNoteisLower()
    {
        thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            note = Note.of("Marek", 1);
        });
        assertEquals("Niewłaściwa ocena", thrown.getMessage());
    }
    
    @Test
    void of_incorrectNoteisHigher()
    {
        thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            note = Note.of("Marek", 7);
        });
        assertEquals("Niewłaściwa ocena", thrown.getMessage());
    }
    
    @Test
    void of_NullStudentName()
    {
        thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            note = Note.of(null, 4);
        });
        assertEquals("Imię ucznia nie może być null", thrown.getMessage());
    }
    
    @Test
    void of_EmptyStudentName()
    {
        thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            note = Note.of("", 4);
        });
        assertEquals("Imię ucznia nie może być puste", thrown.getMessage());
    }
    
    @Test
    void getName()
    {
        note = Note.of("Marek", 5);
        assertEquals(note.getName(), "Marek");
    }
    
    @Test
    void getNote()
    {
        note = Note.of("Marek", 6);
        assertEquals(note.getNote(), 6);
    }
    
    @AfterAll
    static public void closeUp()
    {
        note = null;
    }
}