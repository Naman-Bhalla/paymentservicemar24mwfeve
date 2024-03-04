package dev.naman.paymentservicemar24mwfeve.controllers;

import com.razorpay.RazorpayException;
import com.razorpay.Webhook;
import dev.naman.paymentservicemar24mwfeve.dtos.CreatePaymentLinkRequestDto;
import dev.naman.paymentservicemar24mwfeve.services.PaymentService;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/")
    public String createPaymentLink(@RequestBody CreatePaymentLinkRequestDto request) throws RazorpayException {
        String link = paymentService.createPaymentLink(request.getOrderId());

        return link;
    }

    @PostMapping("/webhook")
    public void handleWebhookEvent(@RequestBody Map<String, String> webhookEvent) {
        System.out.println(webhookEvent);
    }

}
