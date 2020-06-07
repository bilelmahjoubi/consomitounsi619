package tn.esprit.spring.services;

import javax.transaction.Transactional;

import org.primefaces.model.file.UploadedFile;
import org.primefaces.model.file.UploadedFiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tn.esprit.spring.entity.ImageUser;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.entity.VerificationToken;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.repository.VerificationTokenRepository;
import tn.esprit.spring.utils.AppConstants;

@Service
@Transactional
public class UserService implements IUserService {
	
	@Autowired
	FileStorageServiceImpl fileStorageServiceImpl;
    @Autowired
    private UserRepository userRepository;
 
    @Autowired
    private VerificationTokenRepository tokenRepository;
    @Autowired
	ImageService imageser;
     
    @Override
    public User getUser(String verificationToken) {
        User user = tokenRepository.findByToken(verificationToken).getUser();
        return user;
    }
     
    @Override
    public VerificationToken getVerificationToken(String VerificationToken) {
        return tokenRepository.findByToken(VerificationToken);
    }
     
    @Override
    public void saveRegisteredUser(User user) {
        userRepository.save(user);
    }
    
    
     
    @Override
    public void createVerificationToken(User user, String token) {
        VerificationToken myToken = new VerificationToken(token, user);
        tokenRepository.save(myToken);
    }

	@Override
	public void addUserImage(User U, UploadedFiles files) {
		
		userRepository.save(U);	
		for (UploadedFile f : files.getFiles() ) {
         	String newFileName = fileStorageServiceImpl.UploadImages(f);
         	String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path(AppConstants.DOWNLOAD_PATH).path(newFileName).toUriString();
         	ImageUser image = new ImageUser();
			U.setImg(fileDownloadUri);
			image.setIduser(U);
			image.setImage(fileDownloadUri);
			imageser.save(image);
			
			
		}
		
	}
    
}