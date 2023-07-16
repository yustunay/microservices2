package com.yustunay.notification;

import com.yustunay.clients.notification.NotificationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public record NotificationService(NotificationRepository notificationRepository) {
    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.toCustomerId())
                        .toCustomerEmail(notificationRequest.toCustomerName())
                        .sender("Yahya")
                        .message(notificationRequest.message())
                        .sentAt(LocalDateTime.now())
                        .build());
        log.info("Notification is saved to database. Notification:", notificationRequest);
    }
}
