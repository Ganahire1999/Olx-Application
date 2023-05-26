package com.zensar.service;
import java.util.HashMap;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import com.zensar.model.Users;
import com.zensar.repo.UsersRepository;

@Service
@Primary
public class AuthTokenServiceImplJWT implements AuthTokenService
{
	private static final Logger log = LoggerFactory.getLogger(AuthTokenServiceImplJWT.class);
	
	@Autowired
	JwtUtilService jwtUtilService;
	
	@Autowired
	UsersRepository userRepo; 
	
	@Override
	public String generateToken(OlxUserDetail userDetail)
	{
		log.debug("generating token for " + userDetail.getUserName());
		//generate a token with no data but only the username and password
		String username = userDetail.getUserName();
		String password = userDetail.getPassword();
		//String enCodedPass = passwordencoder.encode(password);
		List<Users> list = userRepo.findByUsername(username);
		if(list.size() == 0)
			return null;
		boolean pwdMatch = list.get(0).getPassword().equals(password);
		log.debug("got user and password matched " + pwdMatch);
		String token = jwtUtilService.generateToken(new HashMap<>(), username);
		return token;
		
	}

	@Override
	public String getUserName(String authToken)
	{
		String userName = jwtUtilService.getUserName(authToken);
		return userName;
	}

}
