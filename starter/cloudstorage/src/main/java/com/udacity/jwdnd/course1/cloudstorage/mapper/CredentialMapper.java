package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.CredentialData;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * credentialid INT PRIMARY KEY auto_increment,
 *     url VARCHAR(100),
 *     username VARCHAR (30),
 *     key VARCHAR,
 *     password VARCHAR,
 *     userid INT,
 */

@Mapper
public interface CredentialMapper {

    @Select("SELECT * FROM CREDENTIALS WHERE userId =#{userId}")
    List<CredentialData> getCredentialList(Integer userId);

    @Insert("INSERT INTO CREDENTIALS(url,username,key,password,userId) VALUES(#{url},#{username},#{key},#{password},#{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "credentialId")
    int insertCredentials(CredentialData credentialData);

    @Delete("DELETE credentialId, username WHERE credentialId=#{credentialId}")
    int deleteCredentials(String credentialId);
}
