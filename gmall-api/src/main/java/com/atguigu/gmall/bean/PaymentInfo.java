package com.atguigu.gmall.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @param
 * @return
 */
public class PaymentInfo {

    @Column
    @Id
    private String  id;

    @Column
    private String outTradeNo;

    @Column
    private String orderId;

    @Column
    private String alipayTradeNo;

    @Column
    private BigDecimal totalAmount;

    @Column
    private String subJect;

    @Column
    private String paymentStatus;

    @Column
    private Date createTime;

    @Column
    private Date callbackTime;

    @Column
    private String callbackContent;


    public String getId() {
        return this.id;
    }

    public String getOutTradeNo() {
        return this.outTradeNo;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public String getAlipayTradeNo() {
        return this.alipayTradeNo;
    }

    public BigDecimal getTotalAmount() {
        return this.totalAmount;
    }

    public String getSubJect() {
        return this.subJect;
    }

    public String getPaymentStatus() {
        return this.paymentStatus;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public Date getCallbackTime() {
        return this.callbackTime;
    }

    public String getCallbackContent() {
        return this.callbackContent;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setAlipayTradeNo(String alipayTradeNo) {
        this.alipayTradeNo = alipayTradeNo;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setSubJect(String subJect) {
        this.subJect = subJect;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setCallbackTime(Date callbackTime) {
        this.callbackTime = callbackTime;
    }

    public void setCallbackContent(String callbackContent) {
        this.callbackContent = callbackContent;
    }
}
