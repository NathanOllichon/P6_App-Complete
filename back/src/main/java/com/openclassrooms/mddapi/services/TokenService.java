package com.openclassrooms.mddapi.services;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import com.openclassrooms.mddapi.models.User;
import com.openclassrooms.mddapi.repository.UserRepository;

@Service
public class TokenService {

	private final JwtEncoder encoder;
	private final JwtDecoder decoder;
	@Autowired
	private UserRepository usersRepository;

	public TokenService(JwtEncoder encoder, JwtDecoder decoder) {
		this.encoder = encoder;
		this.decoder = decoder;
	}

	public String generateToken(String mail) {
		Instant now = Instant.now();
		JwtClaimsSet claims = JwtClaimsSet.builder().issuer("self").issuedAt(now)
				.expiresAt(now.plus(1, ChronoUnit.HOURS)).subject(mail).build();
		return this.encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
	}

	public User validateJwtToken(String tokenEncoded) {
		String[] tokenSplited = tokenEncoded.split(" ");
		Jwt jwt = decoder.decode(tokenSplited[1]);
		return usersRepository.findByEmail(jwt.getSubject());
	}

}