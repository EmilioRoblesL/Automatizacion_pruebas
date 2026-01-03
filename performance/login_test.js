import http from "k6/http";
import { check, sleep } from "k6";

export const options = {
  vus: 10,              // usuarios virtuales concurrentes
  duration: "30s",      // duración total
  thresholds: {
    http_req_failed: ["rate<0.01"],      // < 1% errores
    http_req_duration: ["p(95)<500"],    // p95 < 500ms
  },
};

const BASE_URL = __ENV.BASE_URL || "https://httpbin.test.k6.io"; 
// Puedes cambiar BASE_URL a tu API real cuando exista

export default function () {
  // Simulación de "login" vía POST (ejemplo con endpoint de prueba)
  const url = `${BASE_URL}/post`;

  const payload = JSON.stringify({
    email: "user@test.com",
    password: "1234",
  });

  const params = {
    headers: { "Content-Type": "application/json" },
    tags: { name: "POST /login" }, // etiqueta para agrupar en resultados
  };

  const res = http.post(url, payload, params);

  check(res, {
    "status es 200": (r) => r.status === 200,
    "respuesta no vacía": (r) => r.body && r.body.length > 0,
  });

  sleep(1);
}
