package cn.chenxinjie.mx.sys.token.utils;

import cn.chenxinjie.mx.sys.token.dto.MxTokenDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.jsonwebtoken.*;
import org.springframework.util.CollectionUtils;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

public class MxTokenUtil {

    private static final String JWT_KEY = "KEY+202501/keyKEY+202501/keyKEY+202501/keyKEY+202501/keyKEY+202501/key";
    public static final String USER_NO = "userNo";
    public static final String USER_NAME = "userName";
    public static final String ROLE_NOS = "roleNos";
    private static Gson GSON = new GsonBuilder().create();

    private static long expiration = 24 * 60 * 60 * 1000;

    public static String getToken(MxTokenDTO mxTokenDTO) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey key = getSecretKey();
        return Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setSubject(mxTokenDTO.getUserNo())
                .setClaims(getClaims(mxTokenDTO))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(signatureAlgorithm, key)
                .compact();
    }

    public static boolean validateToken(String token) {
        SecretKey key = getSecretKey();
        JwtParser parser = Jwts.parser().verifyWith(key).build();
        Jws<Claims> jws = parser.parseSignedClaims(token);
        Claims claims = jws.getPayload();
        if (null != claims && null != claims.get(USER_NO) && claims.getExpiration().after(new Date())) {
            return true;
        }
        return false;
    }

    private static SecretKey getSecretKey() {
        byte[] encodeKey = Base64.getDecoder().decode(JWT_KEY);
        SecretKey key = new SecretKeySpec(encodeKey, 0, encodeKey.length, "HmacSHA256");
        return key;
    }

    private static Map<String, ?> getClaims(MxTokenDTO mxTokenDTO) {
        Map<String, Object> claims = new HashMap<>(4);
        claims.put(USER_NO, mxTokenDTO.getUserNo());
        claims.put(USER_NAME, mxTokenDTO.getUserName());
        if (!CollectionUtils.isEmpty(mxTokenDTO.getRoleNos())) {
            claims.put(ROLE_NOS, GSON.toJson(mxTokenDTO.getRoleNos()));
        }
        return claims;
    }
}
