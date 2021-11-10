package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.CredentialData;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Random;

@Service
public class CredentialService {
    private EncryptionService encryptionService;
    private CredentialMapper credentialMapper ;

    public CredentialService(EncryptionService encryptionService, CredentialMapper credentialMapper) {
        this.encryptionService = encryptionService;
        this.credentialMapper = credentialMapper;
    }



    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

   public int createCredential(@ModelAttribute("credentialData") CredentialData credentialData){
        String key = getSaltString();
        String encodedKey = encryptionService.encryptValue(key, credentialData.getPassword());
        credentialData.setPassword(encodedKey);
        credentialData.setKey(key);
        return credentialMapper.insertCredentials(credentialData);
     }

   public List<CredentialData> getCredentialList(Integer userId){
        return credentialMapper.getCredentialList(userId);

   }
    public String decryptData(String data,String key){
        return encryptionService.decryptValue(data,key);
    }
}
