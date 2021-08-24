package com.futbol.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;


public class JWTUtil {
	

    private static final String profiles="hxhxhxhxh";
	
	
    private static SecretKey generalKey(){
		String stringKey = profiles;		
		byte[] encodedKey = Base64.decodeBase64(stringKey);		
	    SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
	    return key;
	}

	
	public static String createJWT(String id, String subject, long ttlMillis) throws Exception {
		//SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
                SignatureAlgorithm signatureAlgorithm2 = SignatureAlgorithm.HS512;
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		SecretKey key = generalKey();
		JwtBuilder builder = Jwts.builder()
			.setId(id)
			.setIssuedAt(now)
			.setSubject(subject)
		    .signWith(signatureAlgorithm2, key);
		if (ttlMillis >= 0) {
		    long expMillis = nowMillis + ttlMillis;
		    Date exp = new Date(expMillis);
		    builder.setExpiration(exp);
		}
		return builder.compact();
                
                
                
                
	}
	
	
	public static Claims parseJWT(String jwt) throws Exception{
		SecretKey key = generalKey();
		Claims claims = Jwts.parser()         
		   .setSigningKey(key)
		   .parseClaimsJws(jwt).getBody();

		return claims;
	}

	// test
	public static void main(String[] args){
		
		try {
			String token = JWTUtil.createJWT("233", "payload", 1000*60);
			System.out.println(token);
			Claims c = JWTUtil.parseJWT(token);
			System.out.println(c.getSubject());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("this token is invalid");
		}
	}
}
