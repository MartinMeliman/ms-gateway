# ms-gateway — EcoTrade

API Gateway del marketplace EcoTrade. Punto único de entrada que recibe
todas las peticiones y las enruta hacia el microservicio correspondiente
usando Eureka para resolver las ubicaciones dinámicamente.

> **Nota:** Este repositorio contiene también el README completo del
> proyecto EcoTrade. Ver README.md en la raíz para la arquitectura
> general, los 12 microservicios y todas las rutas.

---

## Integrantes

- Martín Meliman
- Ignacio Lapierre

**Equipo N°:** 9

---

## Información técnica

| Dato | Valor |
|------|-------|
| Puerto local | 8080 |
| Tecnología | Spring Cloud Gateway (reactivo) |
| Service Discovery | Eureka (lb://) |
| Documentación | Swagger (sin Actuator) |

---

## Rutas configuradas

| Ruta | Microservicio destino |
|------|------------------------|
| `/api/usuarios/**` | ms-usuarios |
| `/api/auth/**` | ms-autenticacion |
| `/api/productos/**` | ms-productos |
| `/api/categorias/**` | ms-categorias |
| `/api/pedidos/**` | ms-pedidos |
| `/api/carrito/**` | ms-carrito |
| `/api/pagos/**` | ms-pagos |
| `/api/envios/**` | ms-envios |
| `/api/resenas/**` | ms-resenas |
| `/api/notificaciones/**` | ms-notificaciones |

Cada ruta usa `uri: lb://NOMBRE-SERVICIO` (Load Balanced vía Eureka) y
un filtro `AddRequestHeader` que identifica las peticiones que pasaron
por el Gateway.

---

## Documentación Swagger

| Entorno | URL |
|---------|-----|
| Local | http://localhost:8080/swagger-ui.html |
| Remoto (Render) | https://ms-gateway-ndke.onrender.com/swagger-ui.html |

---

## Ejecución local

1. Levantar **ms-eureka** primero (puerto 8761)
2. Levantar los 10 microservicios de negocio
3. Ejecutar el Gateway:
   ```bash
   mvn spring-boot:run
   ```
4. Probar una ruta: http://localhost:8080/api/pedidos

Perfil de desarrollo:
```
SPRING_PROFILES_ACTIVE=dev
```

---

## Despliegue

Desplegado en **Render**: https://ms-gateway-ndke.onrender.com

Variables de entorno (perfil prod):
```
SPRING_PROFILES_ACTIVE=prod
EUREKA_URL=https://ms-eureka-2lpc.onrender.com/eureka/
```

El Gateway no necesita base de datos.

Ejemplo de uso en producción:
```
GET https://ms-gateway-ndke.onrender.com/api/pedidos
```
