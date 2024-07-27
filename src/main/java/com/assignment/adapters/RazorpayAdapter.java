package com.assignment.adapters;

import com.assignment.libraries.razorpay.RazorpayApi;
import com.assignment.libraries.razorpay.RazorpayPaymentResponse;
import com.assignment.models.Payment;
import com.assignment.models.PaymentStatus;

public class RazorpayAdapter implements PaymentGatewayAdapter{
    private RazorpayApi api;
    public RazorpayAdapter(){
        api = new RazorpayApi();
    }
    @Override
    public Payment makePayment(long billId, double amount) {
        RazorpayPaymentResponse razorpayPaymentResponse = api.processPayment(billId, amount);
        Payment payment = new Payment();
        payment.setBillId(billId);
        payment.setPaymentStatus(PaymentStatus.valueOf(razorpayPaymentResponse.getPaymentStatus()));
        payment.setTxnId(razorpayPaymentResponse.getTransactionId());
        return payment;
    }
}
