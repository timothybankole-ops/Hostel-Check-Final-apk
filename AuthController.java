package com.hostelcheck.backend.controller;
import com.hostelcheck.backend.entity.UserAccount; import com.hostelcheck.backend.service.AuthService; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/auth") public class AuthController {private final AuthService auth; private final com.hostelcheck.backend.repository.UserAccountRepository users; public AuthController(AuthService a, com.hostelcheck.backend.repository.UserAccountRepository r){auth=a;users=r;}
 @PostMapping("/register") public Map<String,Object> register(@RequestBody Map<String,Object>d){return response(auth.register(d));}
 @PostMapping("/login") public Map<String,Object> login(@RequestBody Map<String,Object>d){return response(auth.login(d));}
 @GetMapping("/me") public Map<String,Object> me(@RequestHeader(value="X-Auth-Token",required=false)String token){return auth.payload(auth.require(token));}
 @PostMapping("/logout") public Map<String,String> logout(@RequestHeader(value="X-Auth-Token",required=false)String token){UserAccount u=auth.require(token);u.setToken(UUID.randomUUID().toString()+UUID.randomUUID().toString());users.save(u);return Map.of("status","signed_out");}
 private Map<String,Object>response(UserAccount u){Map<String,Object>m=new LinkedHashMap<>();m.put("token",u.getToken());m.put("user",auth.payload(u));return m;} }
