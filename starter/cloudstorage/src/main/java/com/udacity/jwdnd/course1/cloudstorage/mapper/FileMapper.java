package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Files;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *  fileId INT PRIMARY KEY auto_increment,
 *     filename VARCHAR,
 *     contenttype VARCHAR,
 *     filesize VARCHAR,
 *     userid INT,
 *     filedata BLOB,
 */
@Mapper
public interface FileMapper {

    @Insert("INSERT INTO FILES(filename,contentType, fileSize, userId, fileData) VALUES(#filename,#contentType,#fileSize,#userId" +
            ", #fileData)")
    @Options(useGeneratedKeys = true,keyProperty = "fileId")
    int createFile(Files file);

    @Select("SELECT * FROM FILES WHERE fileId = #{fileId}")
    Files getFile(Integer fileId);

    @Select("SELECT * FROM FILES WHERE userId = #{userId}")
    List<Files> getListOfFiles(Integer userId);

    @Delete("DELETE FROM FILES WHERE fileId = #{fileId}")
    int deleteFile(Integer fileId);

    @Update("UPDATE FILES SET fileName=#{fileName}, contentType = #{contentType}, fileSize = #{fileSize},fileData = #{fileData}")
    boolean updateFile(Integer fileId,Files files);


}
