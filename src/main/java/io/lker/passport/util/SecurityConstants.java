package io.lker.passport.util;

import io.jsonwebtoken.SignatureAlgorithm;

public class SecurityConstants {
    public static final String APP_NAME = "LKER_PASSPORT";

    // yeah yeah, this wouldn't be here if it as a real app.
    public static final String SECRET = "AardvarksAndJWTs";
    public static final long EXPIRATION_DATE = 1800;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    //public static final String SIGN_UP_URL = "/api/users/sign-up";
    public static final String AUDIENCE = "SOMEAPIKEY";
    public static final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;
}
