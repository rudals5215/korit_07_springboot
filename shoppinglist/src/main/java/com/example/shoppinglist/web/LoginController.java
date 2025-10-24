package com.example.shoppinglist.web;

import com.example.shoppinglist.dto.AccountCredentialsDto;
import com.example.shoppinglist.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/api")
public class LoginController {
   private final JwtService jwtService;
   private final AuthenticationManager authenticationManager;


   @PostMapping("/login")
   public ResponseEntity<?>getToken (@RequestBody AccountCredentialsDto accountCredentialsDto){
       UsernamePasswordAuthenticationToken creds =
               new UsernamePasswordAuthenticationToken(accountCredentialsDto.getUsername(), accountCredentialsDto.getPassword());
       // credentials.username() 이거 저희가 Record로 만들었기 때문에 getUsername()이 아닌 것에 주목하셔야 합니다.

       Authentication auth = authenticationManager.authenticate(creds);

       // 토큰 생성 - jwts를 지역변수로 보셔도 무방하죠.
       String jwts = jwtService.getToken(auth.getName());

       // 생성된 토큰으로 응답을 빌드
       return ResponseEntity
               .ok()
               .header(HttpHeaders.AUTHORIZATION, "Bearer " + jwts)
               .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Authorization")
               .build();
   }
}
