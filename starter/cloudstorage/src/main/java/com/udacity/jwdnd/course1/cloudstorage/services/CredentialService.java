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
        String encodedKey =encryptData(key,credentialData.getPassword());
        credentialData.setPassword(encodedKey);
        credentialData.setKey(key);
        return credentialMapper.insertCredentials(credentialData);
    }

    public String encryptData(String key, String password){
        return  encryptionService.encryptValue(key, password);
    }

     public CredentialData getCredential(Integer credentialId){
        CredentialData credentialData = credentialMapper.getCredential(credentialId);
        return  new CredentialData(credentialData.getCredentialId(),credentialData.getUrl(),
                credentialData.getUsername(),credentialData.getKey(), decryptData(credentialData.getPassword(),credentialData.getKey()),credentialData.getUserId());
     }

     public boolean updateCredential(Integer credentialId, CredentialData credentialData) {
         credentialData.setPassword(encryptData(credentialData.getPassword(), credentialData.getKey()));
         return credentialMapper.updateCredentials(credentialId, credentialData);
     }

     public int deleteCredential(Integer credentialId){
        return credentialMapper.deleteCredentials(credentialId);
     }

   public List<CredentialData> getCredentialList(Integer userId){
        return credentialMapper.getCredentialList(userId);
   }
    public String decryptData(String data,String key){
        return encryptionService.decryptValue(data,key);
    }
}
