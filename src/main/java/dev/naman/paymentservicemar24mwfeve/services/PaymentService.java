package dev.naman.paymentservicemar24mwfeve.services;

import com.razorpay.RazorpayException;

public interface PaymentService {


    String createPaymentLink(String orderId) throws RazorpayException;

    String getPaymentStatus(String paymentId);


}
