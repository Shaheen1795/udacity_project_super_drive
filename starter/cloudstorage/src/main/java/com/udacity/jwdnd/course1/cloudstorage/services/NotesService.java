package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NotesMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class NotesService {
    private NotesMapper notesMapper ;

    public NotesService(NotesMapper notesMapper) {
        this.notesMapper = notesMapper;

    }

    @ModelAttribute("notes")
   public List<Notes> getNotes(Integer userId){
        return notesMapper.getNotes(userId);
   }


    public int createNotes(Notes notes){

        return notesMapper.insertNotes(notes);
    }

   public void delete(Notes notes){
        notesMapper.deleteNotes(notes.getNoteId());
   }
}
