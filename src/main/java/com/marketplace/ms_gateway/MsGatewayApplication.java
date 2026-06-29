package com.marketplace.ms_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * API Gateway — punto único de entrada al ecosistema de microservicios.
 *
 * Usa Spring Cloud Gateway + Eureka:
 *   - Recibe todas las peticiones en el puerto 8080
 *   - Resuelve el destino consultando a Eureka (lb://NOMBRE-SERVICIO)
 *   - Aplica balanceo de carga y enrutamiento dinámico
 *
 * No necesita @EnableEurekaClient (se activa automáticamente con la dependencia).
 */
@SpringBootApplication
public class MsGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsGatewayApplication.class, args);
    }
}
