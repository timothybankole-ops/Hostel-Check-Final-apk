package com.hostelcheck.backend.controller;
import org.springframework.web.bind.annotation.GetMapping;import org.springframework.web.bind.annotation.RestController;import java.util.Map;
@RestController public class HomeController { @GetMapping("/") public Map<String,String> home(){return Map.of("application","HostelCheck EKSU","status","running","message","HostelCheck API is ready. See /api/health for service health.");} }
