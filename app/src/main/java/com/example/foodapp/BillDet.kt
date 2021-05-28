package com.example.foodapp

class BillDet {
    var srno: String
    var billid: String
    var billcredate: String
    var payment: String
    var paymenttime: String
    var delivery: String

    constructor(
        srno: String,
        billid: String,
        billcredate: String,
        payment: String,
        paymenttime: String,
        delivery: String
    ) {
        this.srno = srno
        this.billid = billid
        this.billcredate = billcredate
        this.payment = payment
        this.paymenttime = paymenttime
        this.delivery = delivery
    }
}