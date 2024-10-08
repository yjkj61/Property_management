package com.yjkj.property_management.java.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShopOrderBean {


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
        private String createTime;
        @SerializedName("updateBy")
        private Object updateBy;
        @SerializedName("updateTime")
        private Object updateTime;
        @SerializedName("remark")
        private Object remark;
        @SerializedName("isToday")
        private Object isToday;
        @SerializedName("sOrderParentId")
        private Long sOrderParentId;
        @SerializedName("sOrderId")
        private Object sOrderId;
        @SerializedName("userId")
        private Integer userId;
        @SerializedName("sumOrderPrice")
        private Object sumOrderPrice;
        @SerializedName("sOrderPoList")
        private List<SOrderPoListDTO> sOrderPoList;

        public Object getCreateBy() {
            return createBy;
        }

        public void setCreateBy(Object createBy) {
            this.createBy = createBy;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
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

        public Object getIsToday() {
            return isToday;
        }

        public void setIsToday(Object isToday) {
            this.isToday = isToday;
        }

        public Long getSOrderParentId() {
            return sOrderParentId;
        }

        public void setSOrderParentId(Long sOrderParentId) {
            this.sOrderParentId = sOrderParentId;
        }

        public Object getSOrderId() {
            return sOrderId;
        }

        public void setSOrderId(Object sOrderId) {
            this.sOrderId = sOrderId;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Object getSumOrderPrice() {
            return sumOrderPrice;
        }

        public void setSumOrderPrice(Object sumOrderPrice) {
            this.sumOrderPrice = sumOrderPrice;
        }

        public List<SOrderPoListDTO> getSOrderPoList() {
            return sOrderPoList;
        }

        public void setSOrderPoList(List<SOrderPoListDTO> sOrderPoList) {
            this.sOrderPoList = sOrderPoList;
        }

        public static class SOrderPoListDTO {
            @SerializedName("createBy")
            private String createBy;
            @SerializedName("createTime")
            private Object createTime;
            @SerializedName("updateBy")
            private String updateBy;
            @SerializedName("updateTime")
            private String updateTime;
            @SerializedName("remark")
            private Object remark;
            @SerializedName("goodsCoverImages")
            private String goodsCoverImages;
            @SerializedName("businessName")
            private String businessName;
            @SerializedName("sOrderId")
            private Long sOrderId;
            @SerializedName("sOrderParentId")
            private Long sOrderParentId;
            @SerializedName("userId")
            private Integer userId;
            @SerializedName("sGoodsBusinessId")
            private Integer sGoodsBusinessId;
            @SerializedName("sGoodsId")
            private Long sGoodsId;
            @SerializedName("sGoodsSpecificationsId")
            private Integer sGoodsSpecificationsId;
            @SerializedName("sGoodsSpecificationsName")
            private Object sGoodsSpecificationsName;
            @SerializedName("goodsNumber")
            private Integer goodsNumber;
            @SerializedName("goodsPrice")
            private Integer goodsPrice;
            @SerializedName("expressDeliveryPrice")
            private Integer expressDeliveryPrice;
            @SerializedName("orderPrice")
            private Integer orderPrice;
            @SerializedName("address")
            private String address;
            @SerializedName("contact")
            private String contact;
            @SerializedName("phone")
            private String phone;
            @SerializedName("status")
            private String status;
            @SerializedName("payWay")
            private String payWay;
            @SerializedName("orderSource")
            private String orderSource;
            @SerializedName("buyerMessage")
            private Object buyerMessage;
            @SerializedName("sellerMessage")
            private Object sellerMessage;
            @SerializedName("sCommentsFirstId")
            private Object sCommentsFirstId;
            @SerializedName("deliveryMethod")
            private String deliveryMethod;
            @SerializedName("logistics")
            private Object logistics;
            @SerializedName("createOrderTime")
            private String createOrderTime;
            @SerializedName("finishOrderTime")
            private Object finishOrderTime;
            @SerializedName("goodsName")
            private String goodsName;
            @SerializedName("sGoodsTypeId")
            private String sGoodsTypeId;
            @SerializedName("specificationsValueOne")
            private String specificationsValueOne;
            @SerializedName("specificationsValueTwo")
            private Object specificationsValueTwo;
            @SerializedName("specificationsValueThree")
            private Object specificationsValueThree;
            @SerializedName("name")
            private String name;
            @SerializedName("goodsSendNumber")
            private Integer goodsSendNumber;
            @SerializedName("isSevenExchangePurchase")
            private Object isSevenExchangePurchase;
            @SerializedName("sOrderReturnExchangeId")
            private Object sOrderReturnExchangeId;
            @SerializedName("sOrderNewId")
            private Object sOrderNewId;
            @SerializedName("payTime")
            private Object payTime;
            @SerializedName("thisSendGoodsNumber")
            private Integer thisSendGoodsNumber;
            @SerializedName("isSettlement")
            private String isSettlement;
            @SerializedName("sOrderSendGoodsList")
            private List<?> sOrderSendGoodsList;

            public String getCreateBy() {
                return createBy;
            }

            public void setCreateBy(String createBy) {
                this.createBy = createBy;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public String getUpdateBy() {
                return updateBy;
            }

            public void setUpdateBy(String updateBy) {
                this.updateBy = updateBy;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public Object getRemark() {
                return remark;
            }

            public void setRemark(Object remark) {
                this.remark = remark;
            }

            public String getGoodsCoverImages() {
                return goodsCoverImages;
            }

            public void setGoodsCoverImages(String goodsCoverImages) {
                this.goodsCoverImages = goodsCoverImages;
            }

            public String getBusinessName() {
                return businessName;
            }

            public void setBusinessName(String businessName) {
                this.businessName = businessName;
            }

            public Long getSOrderId() {
                return sOrderId;
            }

            public void setSOrderId(Long sOrderId) {
                this.sOrderId = sOrderId;
            }

            public Long getSOrderParentId() {
                return sOrderParentId;
            }

            public void setSOrderParentId(Long sOrderParentId) {
                this.sOrderParentId = sOrderParentId;
            }

            public Integer getUserId() {
                return userId;
            }

            public void setUserId(Integer userId) {
                this.userId = userId;
            }

            public Integer getSGoodsBusinessId() {
                return sGoodsBusinessId;
            }

            public void setSGoodsBusinessId(Integer sGoodsBusinessId) {
                this.sGoodsBusinessId = sGoodsBusinessId;
            }

            public Long getSGoodsId() {
                return sGoodsId;
            }

            public void setSGoodsId(Long sGoodsId) {
                this.sGoodsId = sGoodsId;
            }

            public Integer getSGoodsSpecificationsId() {
                return sGoodsSpecificationsId;
            }

            public void setSGoodsSpecificationsId(Integer sGoodsSpecificationsId) {
                this.sGoodsSpecificationsId = sGoodsSpecificationsId;
            }

            public Object getSGoodsSpecificationsName() {
                return sGoodsSpecificationsName;
            }

            public void setSGoodsSpecificationsName(Object sGoodsSpecificationsName) {
                this.sGoodsSpecificationsName = sGoodsSpecificationsName;
            }

            public Integer getGoodsNumber() {
                return goodsNumber;
            }

            public void setGoodsNumber(Integer goodsNumber) {
                this.goodsNumber = goodsNumber;
            }

            public Integer getGoodsPrice() {
                return goodsPrice;
            }

            public void setGoodsPrice(Integer goodsPrice) {
                this.goodsPrice = goodsPrice;
            }

            public Integer getExpressDeliveryPrice() {
                return expressDeliveryPrice;
            }

            public void setExpressDeliveryPrice(Integer expressDeliveryPrice) {
                this.expressDeliveryPrice = expressDeliveryPrice;
            }

            public Integer getOrderPrice() {
                return orderPrice;
            }

            public void setOrderPrice(Integer orderPrice) {
                this.orderPrice = orderPrice;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getContact() {
                return contact;
            }

            public void setContact(String contact) {
                this.contact = contact;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getPayWay() {
                return payWay;
            }

            public void setPayWay(String payWay) {
                this.payWay = payWay;
            }

            public String getOrderSource() {
                return orderSource;
            }

            public void setOrderSource(String orderSource) {
                this.orderSource = orderSource;
            }

            public Object getBuyerMessage() {
                return buyerMessage;
            }

            public void setBuyerMessage(Object buyerMessage) {
                this.buyerMessage = buyerMessage;
            }

            public Object getSellerMessage() {
                return sellerMessage;
            }

            public void setSellerMessage(Object sellerMessage) {
                this.sellerMessage = sellerMessage;
            }

            public Object getSCommentsFirstId() {
                return sCommentsFirstId;
            }

            public void setSCommentsFirstId(Object sCommentsFirstId) {
                this.sCommentsFirstId = sCommentsFirstId;
            }

            public String getDeliveryMethod() {
                return deliveryMethod;
            }

            public void setDeliveryMethod(String deliveryMethod) {
                this.deliveryMethod = deliveryMethod;
            }

            public Object getLogistics() {
                return logistics;
            }

            public void setLogistics(Object logistics) {
                this.logistics = logistics;
            }

            public String getCreateOrderTime() {
                return createOrderTime;
            }

            public void setCreateOrderTime(String createOrderTime) {
                this.createOrderTime = createOrderTime;
            }

            public Object getFinishOrderTime() {
                return finishOrderTime;
            }

            public void setFinishOrderTime(Object finishOrderTime) {
                this.finishOrderTime = finishOrderTime;
            }

            public String getGoodsName() {
                return goodsName;
            }

            public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
            }

            public String getSGoodsTypeId() {
                return sGoodsTypeId;
            }

            public void setSGoodsTypeId(String sGoodsTypeId) {
                this.sGoodsTypeId = sGoodsTypeId;
            }

            public String getSpecificationsValueOne() {
                return specificationsValueOne;
            }

            public void setSpecificationsValueOne(String specificationsValueOne) {
                this.specificationsValueOne = specificationsValueOne;
            }

            public Object getSpecificationsValueTwo() {
                return specificationsValueTwo;
            }

            public void setSpecificationsValueTwo(Object specificationsValueTwo) {
                this.specificationsValueTwo = specificationsValueTwo;
            }

            public Object getSpecificationsValueThree() {
                return specificationsValueThree;
            }

            public void setSpecificationsValueThree(Object specificationsValueThree) {
                this.specificationsValueThree = specificationsValueThree;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Integer getGoodsSendNumber() {
                return goodsSendNumber;
            }

            public void setGoodsSendNumber(Integer goodsSendNumber) {
                this.goodsSendNumber = goodsSendNumber;
            }

            public Object getIsSevenExchangePurchase() {
                return isSevenExchangePurchase;
            }

            public void setIsSevenExchangePurchase(Object isSevenExchangePurchase) {
                this.isSevenExchangePurchase = isSevenExchangePurchase;
            }

            public Object getSOrderReturnExchangeId() {
                return sOrderReturnExchangeId;
            }

            public void setSOrderReturnExchangeId(Object sOrderReturnExchangeId) {
                this.sOrderReturnExchangeId = sOrderReturnExchangeId;
            }

            public Object getSOrderNewId() {
                return sOrderNewId;
            }

            public void setSOrderNewId(Object sOrderNewId) {
                this.sOrderNewId = sOrderNewId;
            }

            public Object getPayTime() {
                return payTime;
            }

            public void setPayTime(Object payTime) {
                this.payTime = payTime;
            }

            public Integer getThisSendGoodsNumber() {
                return thisSendGoodsNumber;
            }

            public void setThisSendGoodsNumber(Integer thisSendGoodsNumber) {
                this.thisSendGoodsNumber = thisSendGoodsNumber;
            }

            public String getIsSettlement() {
                return isSettlement;
            }

            public void setIsSettlement(String isSettlement) {
                this.isSettlement = isSettlement;
            }

            public List<?> getSOrderSendGoodsList() {
                return sOrderSendGoodsList;
            }

            public void setSOrderSendGoodsList(List<?> sOrderSendGoodsList) {
                this.sOrderSendGoodsList = sOrderSendGoodsList;
            }
        }
    }
}
