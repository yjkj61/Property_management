package com.yjkj.property_management.java.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OldOrderBean {

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
        private Integer agentId;
        @SerializedName("agentName")
        private String agentName;
        @SerializedName("agentPhone")
        private String agentPhone;
        @SerializedName("workerUserId")
        private Integer workerUserId;
        @SerializedName("workerId")
        private Integer workerId;
        @SerializedName("workerName")
        private String workerName;
        @SerializedName("workerPhone")
        private String workerPhone;
        @SerializedName("sTypeId")
        private Integer sTypeId;
        @SerializedName("sTypeLogo")
        private String sTypeLogo;
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
        private Object bookSatisfaction;
        @SerializedName("bookAdvice")
        private Object bookAdvice;
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

        public Integer getAgentId() {
            return agentId;
        }

        public void setAgentId(Integer agentId) {
            this.agentId = agentId;
        }

        public String getAgentName() {
            return agentName;
        }

        public void setAgentName(String agentName) {
            this.agentName = agentName;
        }

        public String getAgentPhone() {
            return agentPhone;
        }

        public void setAgentPhone(String agentPhone) {
            this.agentPhone = agentPhone;
        }

        public Integer getWorkerUserId() {
            return workerUserId;
        }

        public void setWorkerUserId(Integer workerUserId) {
            this.workerUserId = workerUserId;
        }

        public Integer getWorkerId() {
            return workerId;
        }

        public void setWorkerId(Integer workerId) {
            this.workerId = workerId;
        }

        public String getWorkerName() {
            return workerName;
        }

        public void setWorkerName(String workerName) {
            this.workerName = workerName;
        }

        public String getWorkerPhone() {
            return workerPhone;
        }

        public void setWorkerPhone(String workerPhone) {
            this.workerPhone = workerPhone;
        }

        public Integer getSTypeId() {
            return sTypeId;
        }

        public void setSTypeId(Integer sTypeId) {
            this.sTypeId = sTypeId;
        }

        public String getSTypeLogo() {
            return sTypeLogo;
        }

        public void setSTypeLogo(String sTypeLogo) {
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

        public Object getBookSatisfaction() {
            return bookSatisfaction;
        }

        public void setBookSatisfaction(Object bookSatisfaction) {
            this.bookSatisfaction = bookSatisfaction;
        }

        public Object getBookAdvice() {
            return bookAdvice;
        }

        public void setBookAdvice(Object bookAdvice) {
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
