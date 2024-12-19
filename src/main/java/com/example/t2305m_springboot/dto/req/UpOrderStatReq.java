package com.example.t2305m_springboot.dto.req;

public class UpOrderStatReq {
    private Long orderId;
    private Long status;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}
