package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NotesMapper {

    @Select("SELECT * FROM NOTES WHERE userId = #{userId}")
    List<Notes> getListOfNotes(Integer userId);

    @Delete("SELECT noteId NOTES WHERE noteId=#{noteId}" )
    int deleteNotes(Integer noteId);

    @Update("UPDATE NOTES SET noteTile=#{noteTitle}, noteDescription=#{noteDescription} WHERE noteId=#{noteId}")
    boolean updateNotes(Notes notes,Integer noteId);

    @Insert("INSERT INTO NOTES(noteTitle, noteDescription, userId) VALUES (#{noteTitle},#{noteDescription},#{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "noteId")
    int insertNotes(Notes notes);

    @Select("SELECT * FROM NOTES WHERE noteId = #{noteId}")
    Notes getNotes(Integer noteId);
}
