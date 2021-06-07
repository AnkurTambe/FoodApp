package com.example.foodapp

class BillDet {
    var srno: String
    var billid: String
    var billcredate: String


    constructor(
        srno: String,
        billid: String,
        billcredate: String,
    ) {
        this.srno = srno
        this.billid = billid
        this.billcredate = billcredate
    }
}