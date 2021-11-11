package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NotesMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public class NotesService {
    private NotesMapper notesMapper ;
    private SignUpService signUpService ;

    public NotesService(NotesMapper notesMapper, SignUpService signUpService) {
        this.notesMapper = notesMapper;
        this.signUpService = signUpService ;
    }
    @ModelAttribute("notes")
   public List<Notes> getNotes(Integer userId){
        return notesMapper.getListOfNotes(userId);
   }
   public Notes getNote(Integer noteId){
        return notesMapper.getNotes(noteId);
   }
   public Boolean editNotes(Integer noteId, Notes notes){
        return  notesMapper.updateNotes(notes,noteId);
   }
    public int createNotes(Notes notes){
        notes.setUserId(signUpService.getId());
        return notesMapper.insertNotes(notes);
    }

   public void deleteNote(Integer noteId){
        notesMapper.deleteNotes(noteId);
   }
}
