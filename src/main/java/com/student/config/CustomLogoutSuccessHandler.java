package com.student.config;

import com.student.model.AuditLog;
import com.student.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    @Autowired
    private AuditLogRepository auditLogRepository;

    @Override
    public void onLogoutSuccess(HttpServletRequest request,
                                HttpServletResponse response,
                                Authentication authentication)
            throws IOException {

        if (authentication != null) {
            String username = authentication.getName();

            AuditLog log = new AuditLog();
            log.setUsername(username);
            log.setAction("LOGOUT");
            log.setIpAddress(request.getRemoteAddr());
            log.setTimestamp(LocalDateTime.now());

            auditLogRepository.save(log);
        }

        response.sendRedirect("/login?logout");
    }
}