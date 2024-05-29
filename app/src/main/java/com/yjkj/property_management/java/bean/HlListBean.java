package com.yjkj.property_management.java.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @description 护理列表
 * @author: Lenovo
 * @date: 2024/5/28
 */
public class HlListBean {

    @SerializedName("msg")
    private String msg;
    @SerializedName("code")
    private Integer code;
    @SerializedName("data")
    private List<DataDTO> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<DataDTO> getData() {
        return data;
    }

    public void setData(List<DataDTO> data) {
        this.data = data;
    }

    public static class DataDTO {
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
        @SerializedName("bookId")
        private Integer bookId;
        @SerializedName("bookNum")
        private String bookNum;
        @SerializedName("ownerUserId")
        private Integer ownerUserId;
        @SerializedName("ownerId")
        private Integer ownerId;
        @SerializedName("ownerName")
        private String ownerName;
        @SerializedName("ownerSex")
        private String ownerSex;
        @SerializedName("ownerAge")
        private Integer ownerAge;
        @SerializedName("ownerPhone")
        private String ownerPhone;
        @SerializedName("agentUserId")
        private Integer agentUserId;
        @SerializedName("agentId")
        private Object agentId;
        @SerializedName("agentName")
        private Object agentName;
        @SerializedName("agentPhone")
        private Object agentPhone;
        @SerializedName("workerUserId")
        private Object workerUserId;
        @SerializedName("workerId")
        private Object workerId;
        @SerializedName("workerName")
        private Object workerName;
        @SerializedName("workerPhone")
        private Object workerPhone;
        @SerializedName("sTypeId")
        private Integer sTypeId;
        @SerializedName("sTypeLogo")
        private Object sTypeLogo;
        @SerializedName("projectName")
        private String projectName;
        @SerializedName("ownerAddress")
        private String ownerAddress;
        @SerializedName("serviceBookStartTime")
        private Object serviceBookStartTime;
        @SerializedName("serviceBookEndTime")
        private Object serviceBookEndTime;
        @SerializedName("firstElsePropertyValue")
        private String firstElsePropertyValue;
        @SerializedName("secondElsePropertyValue")
        private String secondElsePropertyValue;
        @SerializedName("thirdElsePropertyValue")
        private String thirdElsePropertyValue;
        @SerializedName("bookRemark")
        private Object bookRemark;
        @SerializedName("bookStartPic")
        private Object bookStartPic;
        @SerializedName("bookEndPic")
        private Object bookEndPic;
        @SerializedName("isOrderStatus")
        private Integer isOrderStatus;
        @SerializedName("serviceStatus")
        private Integer serviceStatus;
        @SerializedName("bookTime")
        private String bookTime;
        @SerializedName("servicerMoney")
        private Object servicerMoney;
        @SerializedName("bookMoney")
        private Object bookMoney;
        @SerializedName("bookStartTime")
        private String bookStartTime;
        @SerializedName("bookFinishTime")
        private Object bookFinishTime;
        @SerializedName("bookFinishDate")
        private Object bookFinishDate;
        @SerializedName("payWay")
        private Object payWay;
        @SerializedName("payStatus")
        private Integer payStatus;
        @SerializedName("bookSatisfaction")
        private String bookSatisfaction;
        @SerializedName("bookAdvice")
        private String bookAdvice;
        @SerializedName("bookYear")
        private Object bookYear;
        @SerializedName("bookMonth")
        private Object bookMonth;
        @SerializedName("bookCount")
        private Object bookCount;

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

        public Integer getBookId() {
            return bookId;
        }

        public void setBookId(Integer bookId) {
            this.bookId = bookId;
        }

        public String getBookNum() {
            return bookNum;
        }

        public void setBookNum(String bookNum) {
            this.bookNum = bookNum;
        }

        public Integer getOwnerUserId() {
            return ownerUserId;
        }

        public void setOwnerUserId(Integer ownerUserId) {
            this.ownerUserId = ownerUserId;
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

        public String getOwnerSex() {
            return ownerSex;
        }

        public void setOwnerSex(String ownerSex) {
            this.ownerSex = ownerSex;
        }

        public Integer getOwnerAge() {
            return ownerAge;
        }

        public void setOwnerAge(Integer ownerAge) {
            this.ownerAge = ownerAge;
        }

        public String getOwnerPhone() {
            return ownerPhone;
        }

        public void setOwnerPhone(String ownerPhone) {
            this.ownerPhone = ownerPhone;
        }

        public Integer getAgentUserId() {
            return agentUserId;
        }

        public void setAgentUserId(Integer agentUserId) {
            this.agentUserId = agentUserId;
        }

        public Object getAgentId() {
            return agentId;
        }

        public void setAgentId(Object agentId) {
            this.agentId = agentId;
        }

        public Object getAgentName() {
            return agentName;
        }

        public void setAgentName(Object agentName) {
            this.agentName = agentName;
        }

        public Object getAgentPhone() {
            return agentPhone;
        }

        public void setAgentPhone(Object agentPhone) {
            this.agentPhone = agentPhone;
        }

        public Object getWorkerUserId() {
            return workerUserId;
        }

        public void setWorkerUserId(Object workerUserId) {
            this.workerUserId = workerUserId;
        }

        public Object getWorkerId() {
            return workerId;
        }

        public void setWorkerId(Object workerId) {
            this.workerId = workerId;
        }

        public Object getWorkerName() {
            return workerName;
        }

        public void setWorkerName(Object workerName) {
            this.workerName = workerName;
        }

        public Object getWorkerPhone() {
            return workerPhone;
        }

        public void setWorkerPhone(Object workerPhone) {
            this.workerPhone = workerPhone;
        }

        public Integer getSTypeId() {
            return sTypeId;
        }

        public void setSTypeId(Integer sTypeId) {
            this.sTypeId = sTypeId;
        }

        public Object getSTypeLogo() {
            return sTypeLogo;
        }

        public void setSTypeLogo(Object sTypeLogo) {
            this.sTypeLogo = sTypeLogo;
        }

        public String getProjectName() {
            return projectName;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        public String getOwnerAddress() {
            return ownerAddress;
        }

        public void setOwnerAddress(String ownerAddress) {
            this.ownerAddress = ownerAddress;
        }

        public Object getServiceBookStartTime() {
            return serviceBookStartTime;
        }

        public void setServiceBookStartTime(Object serviceBookStartTime) {
            this.serviceBookStartTime = serviceBookStartTime;
        }

        public Object getServiceBookEndTime() {
            return serviceBookEndTime;
        }

        public void setServiceBookEndTime(Object serviceBookEndTime) {
            this.serviceBookEndTime = serviceBookEndTime;
        }

        public String getFirstElsePropertyValue() {
            return firstElsePropertyValue;
        }

        public void setFirstElsePropertyValue(String firstElsePropertyValue) {
            this.firstElsePropertyValue = firstElsePropertyValue;
        }

        public String getSecondElsePropertyValue() {
            return secondElsePropertyValue;
        }

        public void setSecondElsePropertyValue(String secondElsePropertyValue) {
            this.secondElsePropertyValue = secondElsePropertyValue;
        }

        public String getThirdElsePropertyValue() {
            return thirdElsePropertyValue;
        }

        public void setThirdElsePropertyValue(String thirdElsePropertyValue) {
            this.thirdElsePropertyValue = thirdElsePropertyValue;
        }

        public Object getBookRemark() {
            return bookRemark;
        }

        public void setBookRemark(Object bookRemark) {
            this.bookRemark = bookRemark;
        }

        public Object getBookStartPic() {
            return bookStartPic;
        }

        public void setBookStartPic(Object bookStartPic) {
            this.bookStartPic = bookStartPic;
        }

        public Object getBookEndPic() {
            return bookEndPic;
        }

        public void setBookEndPic(Object bookEndPic) {
            this.bookEndPic = bookEndPic;
        }

        public Integer getIsOrderStatus() {
            return isOrderStatus;
        }

        public void setIsOrderStatus(Integer isOrderStatus) {
            this.isOrderStatus = isOrderStatus;
        }

        public Integer getServiceStatus() {
            return serviceStatus;
        }

        public void setServiceStatus(Integer serviceStatus) {
            this.serviceStatus = serviceStatus;
        }

        public String getBookTime() {
            return bookTime;
        }

        public void setBookTime(String bookTime) {
            this.bookTime = bookTime;
        }

        public Object getServicerMoney() {
            return servicerMoney;
        }

        public void setServicerMoney(Object servicerMoney) {
            this.servicerMoney = servicerMoney;
        }

        public Object getBookMoney() {
            return bookMoney;
        }

        public void setBookMoney(Object bookMoney) {
            this.bookMoney = bookMoney;
        }

        public String getBookStartTime() {
            return bookStartTime;
        }

        public void setBookStartTime(String bookStartTime) {
            this.bookStartTime = bookStartTime;
        }

        public Object getBookFinishTime() {
            return bookFinishTime;
        }

        public void setBookFinishTime(Object bookFinishTime) {
            this.bookFinishTime = bookFinishTime;
        }

        public Object getBookFinishDate() {
            return bookFinishDate;
        }

        public void setBookFinishDate(Object bookFinishDate) {
            this.bookFinishDate = bookFinishDate;
        }

        public Object getPayWay() {
            return payWay;
        }

        public void setPayWay(Object payWay) {
            this.payWay = payWay;
        }

        public Integer getPayStatus() {
            return payStatus;
        }

        public void setPayStatus(Integer payStatus) {
            this.payStatus = payStatus;
        }

        public String getBookSatisfaction() {
            return bookSatisfaction;
        }

        public void setBookSatisfaction(String bookSatisfaction) {
            this.bookSatisfaction = bookSatisfaction;
        }

        public String getBookAdvice() {
            return bookAdvice;
        }

        public void setBookAdvice(String bookAdvice) {
            this.bookAdvice = bookAdvice;
        }

        public Object getBookYear() {
            return bookYear;
        }

        public void setBookYear(Object bookYear) {
            this.bookYear = bookYear;
        }

        public Object getBookMonth() {
            return bookMonth;
        }

        public void setBookMonth(Object bookMonth) {
            this.bookMonth = bookMonth;
        }

        public Object getBookCount() {
            return bookCount;
        }

        public void setBookCount(Object bookCount) {
            this.bookCount = bookCount;
        }
    }
}
