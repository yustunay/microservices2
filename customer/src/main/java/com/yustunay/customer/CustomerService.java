package com.yustunay.customer;

import com.yustunay.amqp.RabbitMQMessageProducer;
import com.yustunay.clients.fraud.FraudCheckResponse;
import com.yustunay.clients.fraud.FraudClient;
import com.yustunay.clients.notification.NotificationClient;
import com.yustunay.clients.notification.NotificationRequest;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository,
                              FraudClient fraudClient,
                              //NotificationClient notificationClient,
                              RabbitMQMessageProducer rabbitMQMessageProducer
) {

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        //todo: check if the email valid
        //todo: check if email is not taken
        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());
        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("Customer is fraudster!");
        }

        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome to Yahya...", customer.getFirstName()));

        //notificationClient.sendNotification(notificationRequest);

        rabbitMQMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key"
        );

    }
}
