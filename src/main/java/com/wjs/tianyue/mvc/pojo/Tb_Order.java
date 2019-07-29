package com.wjs.tianyue.mvc.pojo;

public class Tb_Order {
    private String id;

    private String orderName;

    private String orderTime;
    private String orderTime_s;
    private String orderTime_e;

    private String deliveryTime;

    private String supname;

    private String supaddr;

    private String remarks;

    private String status;

    
    
    public String getOrderTime_s() {
		return orderTime_s;
	}

	public void setOrderTime_s(String orderTime_s) {
		this.orderTime_s = orderTime_s;
	}

	public String getOrderTime_e() {
		return orderTime_e;
	}

	public void setOrderTime_e(String orderTime_e) {
		this.orderTime_e = orderTime_e;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName == null ? null : orderName.trim();
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime == null ? null : orderTime.trim();
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime == null ? null : deliveryTime.trim();
    }

    public String getSupname() {
        return supname;
    }

    public void setSupname(String supname) {
        this.supname = supname == null ? null : supname.trim();
    }

    public String getSupaddr() {
        return supaddr;
    }

    public void setSupaddr(String supaddr) {
        this.supaddr = supaddr == null ? null : supaddr.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

	@Override
	public String toString() {
		return "Tb_Order [id=" + id + ", orderName=" + orderName + ", orderTime=" + orderTime + ", orderTime_s="
				+ orderTime_s + ", orderTime_e=" + orderTime_e + ", deliveryTime=" + deliveryTime + ", supname="
				+ supname + ", supaddr=" + supaddr + ", remarks=" + remarks + ", status=" + status + "]";
	}
    
}