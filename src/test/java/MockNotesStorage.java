import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MockNotesStorage implements NotesStorage
{
    private Multimap<String, Note> notes = ArrayListMultimap.create();
    private boolean empty = true;
    @Override
    public void add(Note note)
    {
        notes.put(note.getName(), note);
        
        empty = false;
    }
    
    @Override
    public List<Note> getAllNotesOf(String name)
    {
        return (List<Note>) notes.get(name);
    }
    
    public boolean isClear()
    {
        return empty;
    }
    
    @Override
    public void clear()
    {
        notes.clear();
        empty = true;
    }
}