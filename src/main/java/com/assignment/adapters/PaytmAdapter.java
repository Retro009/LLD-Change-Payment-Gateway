package com.assignment.adapters;

import com.assignment.libraries.paytm.PaytmApi;
import com.assignment.libraries.paytm.PaytmPaymentResponse;
import com.assignment.models.Payment;
import com.assignment.models.PaymentStatus;

public class PaytmAdapter implements PaymentGatewayAdapter{
    private PaytmApi api;
    public PaytmAdapter(){
        api = new PaytmApi();
    }
    @Override
    public Payment makePayment(long billId, double amount) {
        PaytmPaymentResponse paytmPaymentResponse = api.makePayment(billId, amount);
        Payment payment = new Payment();
        payment.setPaymentStatus(PaymentStatus.valueOf(paytmPaymentResponse.getPaymentStatus()));
        payment.setTxnId(paytmPaymentResponse.getTxnId());
        payment.setBillId(billId);
        return payment;
    }
}
