package tn.esprit.spring.services;




import org.primefaces.model.file.UploadedFiles;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.VerificationToken;

public interface IUserService {
 
    User getUser(String verificationToken);
 
    void saveRegisteredUser(User user);
    
    public void addUserImage(User U, UploadedFiles files);
 
    void createVerificationToken(User user, String token);
 
    VerificationToken getVerificationToken(String VerificationToken);
}
