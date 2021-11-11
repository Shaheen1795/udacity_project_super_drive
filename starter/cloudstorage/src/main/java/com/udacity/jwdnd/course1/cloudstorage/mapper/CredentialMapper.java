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

    @Select("SELECT * FROM CREDENTIALS WHERE credentialId = #{credentialId}")
    CredentialData getCredential(Integer credentialId);

    @Insert("INSERT INTO CREDENTIALS(url,username,key,password,userId) VALUES(#{url},#{username},#{key},#{password},#{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "credentialId")
    int insertCredentials(CredentialData credentialData);

    @Delete("DELETE FROM CREDENTIALS WHERE credentialId=#{credentialId}")
    int deleteCredentials(Integer credentialId);

    @Update("UPDATE CREDENTIALS SET url=#{url}, username=#{username}, password=#{password} WHERE credentialId = #{credentialId}")
    boolean updateCredentials(Integer credentialId, CredentialData credentials);
}
