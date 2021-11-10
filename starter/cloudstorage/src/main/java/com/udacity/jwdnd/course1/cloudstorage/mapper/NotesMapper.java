package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NotesMapper {

    @Select("SELECT * FROM NOTES WHERE userId = #{userId}")
    List<Notes> getNotes(Integer userId);

    @Delete("SELECT noteId NOTES WHERE noteId=#{noteId}" )
    int deleteNotes(Integer noteId);

    @Update("")
    boolean updateNotes(Notes notes);

    @Insert("INSERT INTO NOTES(noteTitle, noteDescription, userId) VALUES (#{noteTitle},#{noteDescription},#{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "noteId")
    int insertNotes(Notes notes);
}
