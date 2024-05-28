package com.yjkj.property_management.java.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FoodOrderBean {

    @SerializedName("total")
    private Integer total;
    @SerializedName("rows")
    private List<RowsDTO> rows;
    @SerializedName("code")
    private Integer code;
    @SerializedName("msg")
    private String msg;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<RowsDTO> getRows() {
        return rows;
    }

    public void setRows(List<RowsDTO> rows) {
        this.rows = rows;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class RowsDTO {
        @SerializedName("createBy")
        private Object createBy;
        @SerializedName("createTime")
        private Object createTime;
        @SerializedName("updateBy")
        private Object updateBy;
        @SerializedName("updateTime")
        private Object updateTime;
        @SerializedName("remark")
        private Object remark;
        @SerializedName("id")
        private Integer id;
        @SerializedName("rOrderId")
        private String rOrderId;
        @SerializedName("userId")
        private Object userId;
        @SerializedName("ownerId")
        private Integer ownerId;
        @SerializedName("ownerName")
        private String ownerName;
        @SerializedName("ownerPic")
        private String ownerPic;
        @SerializedName("ownerSex")
        private String ownerSex;
        @SerializedName("rOrderRemark")
        private Object rOrderRemark;
        @SerializedName("rFoodCanteenId")
        private Integer rFoodCanteenId;
        @SerializedName("rFoodCanteenName")
        private String rFoodCanteenName;
        @SerializedName("rFoodId")
        private Object rFoodId;
        @SerializedName("rFoodName")
        private Object rFoodName;
        @SerializedName("rOrderCount")
        private Object rOrderCount;
        @SerializedName("rFoodPackingCharge")
        private Integer rFoodPackingCharge;
        @SerializedName("rOrderPrice")
        private Integer rOrderPrice;
        @SerializedName("rOrderList")
        private String rOrderList;
        @SerializedName("orderInfoList")
        private Object orderInfoList;
        @SerializedName("rOrderRoute")
        private Object rOrderRoute;
        @SerializedName("rOrderPaymentWay")
        private Object rOrderPaymentWay;
        @SerializedName("rOrderTime")
        private String rOrderTime;
        @SerializedName("rOrderCompletionTime")
        private Object rOrderCompletionTime;
        @SerializedName("rOrderAddressId")
        private Integer rOrderAddressId;
        @SerializedName("rOrderAddress")
        private String rOrderAddress;
        @SerializedName("ownerPhone")
        private String ownerPhone;
        @SerializedName("rOrderCourierId")
        private Object rOrderCourierId;
        @SerializedName("rOrderCourier")
        private Object rOrderCourier;
        @SerializedName("rOrderStatus")
        private Integer rOrderStatus;
        @SerializedName("rOrderType")
        private Object rOrderType;
        @SerializedName("rFoodEvaluate")
        private Object rFoodEvaluate;
        @SerializedName("userType")
        private String userType;
        @SerializedName("markerId")
        private Long markerId;
        @SerializedName("markerName")
        private Object markerName;
        @SerializedName("rOrderRefundReason")
        private Object rOrderRefundReason;

        public Object getCreateBy() {
            return createBy;
        }

        public void setCreateBy(Object createBy) {
            this.createBy = createBy;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public Object getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(Object updateBy) {
            this.updateBy = updateBy;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getROrderId() {
            return rOrderId;
        }

        public void setROrderId(String rOrderId) {
            this.rOrderId = rOrderId;
        }

        public Object getUserId() {
            return userId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }

        public Integer getOwnerId() {
            return ownerId;
        }

        public void setOwnerId(Integer ownerId) {
            this.ownerId = ownerId;
        }

        public String getOwnerName() {
            return ownerName;
        }

        public void setOwnerName(String ownerName) {
            this.ownerName = ownerName;
        }

        public String getOwnerPic() {
            return ownerPic;
        }

        public void setOwnerPic(String ownerPic) {
            this.ownerPic = ownerPic;
        }

        public String getOwnerSex() {
            return ownerSex;
        }

        public void setOwnerSex(String ownerSex) {
            this.ownerSex = ownerSex;
        }

        public Object getROrderRemark() {
            return rOrderRemark;
        }

        public void setROrderRemark(Object rOrderRemark) {
            this.rOrderRemark = rOrderRemark;
        }

        public Integer getRFoodCanteenId() {
            return rFoodCanteenId;
        }

        public void setRFoodCanteenId(Integer rFoodCanteenId) {
            this.rFoodCanteenId = rFoodCanteenId;
        }

        public String getRFoodCanteenName() {
            return rFoodCanteenName;
        }

        public void setRFoodCanteenName(String rFoodCanteenName) {
            this.rFoodCanteenName = rFoodCanteenName;
        }

        public Object getRFoodId() {
            return rFoodId;
        }

        public void setRFoodId(Object rFoodId) {
            this.rFoodId = rFoodId;
        }

        public Object getRFoodName() {
            return rFoodName;
        }

        public void setRFoodName(Object rFoodName) {
            this.rFoodName = rFoodName;
        }

        public Object getROrderCount() {
            return rOrderCount;
        }

        public void setROrderCount(Object rOrderCount) {
            this.rOrderCount = rOrderCount;
        }

        public Integer getRFoodPackingCharge() {
            return rFoodPackingCharge;
        }

        public void setRFoodPackingCharge(Integer rFoodPackingCharge) {
            this.rFoodPackingCharge = rFoodPackingCharge;
        }

        public Integer getROrderPrice() {
            return rOrderPrice;
        }

        public void setROrderPrice(Integer rOrderPrice) {
            this.rOrderPrice = rOrderPrice;
        }

        public String getROrderList() {
            return rOrderList;
        }

        public void setROrderList(String rOrderList) {
            this.rOrderList = rOrderList;
        }

        public Object getOrderInfoList() {
            return orderInfoList;
        }

        public void setOrderInfoList(Object orderInfoList) {
            this.orderInfoList = orderInfoList;
        }

        public Object getROrderRoute() {
            return rOrderRoute;
        }

        public void setROrderRoute(Object rOrderRoute) {
            this.rOrderRoute = rOrderRoute;
        }

        public Object getROrderPaymentWay() {
            return rOrderPaymentWay;
        }

        public void setROrderPaymentWay(Object rOrderPaymentWay) {
            this.rOrderPaymentWay = rOrderPaymentWay;
        }

        public String getROrderTime() {
            return rOrderTime;
        }

        public void setROrderTime(String rOrderTime) {
            this.rOrderTime = rOrderTime;
        }

        public Object getROrderCompletionTime() {
            return rOrderCompletionTime;
        }

        public void setROrderCompletionTime(Object rOrderCompletionTime) {
            this.rOrderCompletionTime = rOrderCompletionTime;
        }

        public Integer getROrderAddressId() {
            return rOrderAddressId;
        }

        public void setROrderAddressId(Integer rOrderAddressId) {
            this.rOrderAddressId = rOrderAddressId;
        }

        public String getROrderAddress() {
            return rOrderAddress;
        }

        public void setROrderAddress(String rOrderAddress) {
            this.rOrderAddress = rOrderAddress;
        }

        public String getOwnerPhone() {
            return ownerPhone;
        }

        public void setOwnerPhone(String ownerPhone) {
            this.ownerPhone = ownerPhone;
        }

        public Object getROrderCourierId() {
            return rOrderCourierId;
        }

        public void setROrderCourierId(Object rOrderCourierId) {
            this.rOrderCourierId = rOrderCourierId;
        }

        public Object getROrderCourier() {
            return rOrderCourier;
        }

        public void setROrderCourier(Object rOrderCourier) {
            this.rOrderCourier = rOrderCourier;
        }

        public Integer getROrderStatus() {
            return rOrderStatus;
        }

        public void setROrderStatus(Integer rOrderStatus) {
            this.rOrderStatus = rOrderStatus;
        }

        public Object getROrderType() {
            return rOrderType;
        }

        public void setROrderType(Object rOrderType) {
            this.rOrderType = rOrderType;
        }

        public Object getRFoodEvaluate() {
            return rFoodEvaluate;
        }

        public void setRFoodEvaluate(Object rFoodEvaluate) {
            this.rFoodEvaluate = rFoodEvaluate;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public Long getMarkerId() {
            return markerId;
        }

        public void setMarkerId(Long markerId) {
            this.markerId = markerId;
        }

        public Object getMarkerName() {
            return markerName;
        }

        public void setMarkerName(Object markerName) {
            this.markerName = markerName;
        }

        public Object getROrderRefundReason() {
            return rOrderRefundReason;
        }

        public void setROrderRefundReason(Object rOrderRefundReason) {
            this.rOrderRefundReason = rOrderRefundReason;
        }
    }
}
