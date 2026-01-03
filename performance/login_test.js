import http from "k6/http";
import { check, sleep } from "k6";

export const options = {
  vus: 10,                // Usuarios virtuales concurrentes
  duration: "30s",        // Duración total de la prueba
  thresholds: {
    http_req_failed: ["rate<0.01"],     // < 1% de errores
    http_req_duration: ["p(95)<500"],   // p95 menor a 500 ms
  },
};

export default function () {
  const payload = JSON.stringify({
    email: "user@test.com",
    password: "1234",
  });

  const params = {
    headers: {
      "Content-Type": "application/json",
    },
    tags: {
      name: "POST /login",
    },
  };

  const res = http.post(
    "https://httpbin.test.k6.io/post",
    payload,
    params
  );

  check(res, {
    "status es 200": (r) => r.status === 200,
  });

  sleep(1);
}
