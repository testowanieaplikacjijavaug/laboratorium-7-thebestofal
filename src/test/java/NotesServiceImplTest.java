import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotesServiceImplTest
{
    static MockNotesStorage storage;
    static NotesService service;
    Throwable thrown;
    @BeforeEach
    public void setup()
    {
       storage = new MockNotesStorage();
       service = NotesServiceImpl.createWith(storage);
    }
    
    @Test
    public void addOne()
    {
        service.add(Note.of("Marek", 5));
        assertEquals(storage.getAllNotesOf("Marek").size(), 1);
    }
    
    @Test
    public void addMultuple()
    {
        service.add(Note.of("Marek", 5));
        service.add(Note.of("Marek", 4));
        service.add(Note.of("Marek", 3));
    
        assertEquals(storage.getAllNotesOf("Marek").size(), 3);
    }
    
    @Test
    public void addMultipleToDiffStudents()
    {
        service.add(Note.of("Marek", 5));
        service.add(Note.of("Marek", 4));
        service.add(Note.of("Marek", 3));
        service.add(Note.of("Wojtek", 4));
        service.add(Note.of("Wojtek", 2));
    
        assertEquals(storage.getAllNotesOf("Marek").size(), 3);
        assertEquals(storage.getAllNotesOf("Wojtek").size(), 2);
    }
    
    
    @Test
    void averageOf()
    {
        service.add(Note.of("Marek", 5));
        service.add(Note.of("Marek", 4));
        service.add(Note.of("Marek", 3));
        
        assertEquals(service.averageOf("Marek"), 4);
    }
    
    @Test
    void averageOfFloatingNumber()
    {
        service.add(Note.of("Marek", 5));
        service.add(Note.of("Marek", 4));
        service.add(Note.of("Marek", 4));
        
        assertEquals(service.averageOf("Marek"), 4.3, 0.1);
    }
    
    @Test
    void testClear()
    {
        service.clear();
        assertTrue(storage.isClear());
    }
    
    @AfterAll
    static void clear()
    {
        service.clear();
        storage.clear();
    }
}