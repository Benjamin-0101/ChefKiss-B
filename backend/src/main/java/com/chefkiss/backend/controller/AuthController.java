package com.chefkiss.backend.controller;

import com.chefkiss.backend.model.User;
import com.chefkiss.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        // ESTO ES LO IMPORTANTE: Imprimirá en la consola si llega algo
        System.out.println("🔔🔔🔔 ¡ALERTA! EL CELULAR ESTÁ TOCANDO LA PUERTA 🔔🔔🔔");
        System.out.println("Datos recibidos del celular: " + user.toString());

        try {
            User newUser = userService.registerUser(user);
            System.out.println("✅ GUARDADO EN RAILWAY CON ID: " + newUser.getId());
            return ResponseEntity.ok(newUser);
        } catch (Exception e) {
            System.out.println("❌ ERROR EXPLOSIVO: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginData) {
        System.out.println("🔔 INTENTO DE LOGIN: " + loginData.getEmail());
        User user = userService.loginUser(loginData.getEmail(), loginData.getPassword());
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }
    }
}