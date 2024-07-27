package com.assignment.controllers;

import com.assignment.dtos.MakePaymentRequestDto;
import com.assignment.dtos.MakePaymentResponseDto;
import com.assignment.dtos.ResponseStatus;
import com.assignment.exceptions.InvalidBillException;
import com.assignment.models.Payment;
import com.assignment.services.PaymentService;

public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public MakePaymentResponseDto makePayment(MakePaymentRequestDto makePaymentRequestDto) {
        MakePaymentResponseDto responseDto = new MakePaymentResponseDto();
        try{
            Payment payment = paymentService.makePayment(makePaymentRequestDto.getBillId());
            responseDto.setTxnId(payment.getTxnId());
            responseDto.setPaymentStatus(payment.getPaymentStatus());
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch(InvalidBillException e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}