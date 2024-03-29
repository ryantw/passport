package io.lker.passport.security;

import io.lker.passport.service.UserAuthService;
import io.lker.passport.util.SecurityConstants;
import io.lker.passport.util.TokenHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private TokenHelper tokenHelper;
    private UserAuthService userAuthService;

    public TokenAuthenticationFilter(TokenHelper tokenHelper, UserAuthService userAuthService) {
        this.tokenHelper = tokenHelper;
        this.userAuthService = userAuthService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        String username;
        String authToken = httpServletRequest.getHeader(SecurityConstants.HEADER_STRING);

        if(authToken != null){
            authToken = authToken.replace(SecurityConstants.TOKEN_PREFIX, "");
            username = tokenHelper.getUsernameFromToken(authToken);
            if(username != null){
                UserDetails userDetails = userAuthService.loadUserByUsername(username);
                // If token is close to expiring, set a new one.
                if(tokenHelper.validateToken(authToken, userDetails)){
                    TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails);
                    authentication.setToken(authToken);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            } else {
                httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Please Login");
                return;
            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
