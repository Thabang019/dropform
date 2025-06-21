package org.capaciti.api;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class Interceptor implements HandlerInterceptor {

    private final Map<String, Instant> requestTimestamps = new ConcurrentHashMap<>();
    private static final int SECONDS = 30;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String ip = request.getRemoteAddr();
        Instant now = Instant.now();
        Instant last = requestTimestamps.get(ip);

        if (last != null && Duration.between(last, now).getSeconds() < SECONDS) {
            response.setStatus(429);
            response.getWriter().write("Too many requests. Try again later.");
            return false;
        }
        requestTimestamps.put(ip, now);
        return true;
    }
}

