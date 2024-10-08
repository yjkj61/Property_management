package com.yjkj.property_management.java.bean;

import java.util.List;

public class AfBean {

    /**
     * total : 3
     * rows : [{"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"id":72,"ownerId":1,"ownerName":null,"agentId":null,"agentName":null,"serialNumber":863730062167414,"type":"YG04","signal":"12","temperature":155,"battery":"100","event":"2","msg":"3","upTime":1716456999,"upTimeDate":"2024-05-23","markerId":1},{"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"id":73,"ownerId":1,"ownerName":null,"agentId":null,"agentName":null,"serialNumber":863730062167414,"type":"YG04","signal":"5","temperature":155,"battery":"100","event":"2","msg":"3","upTime":1716542802,"upTimeDate":"2024-05-24","markerId":1},{"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"remark":null,"id":74,"ownerId":1,"ownerName":null,"agentId":null,"agentName":null,"serialNumber":863730062167414,"type":"YG04","signal":"16","temperature":155,"battery":"100","event":"2","msg":"3","upTime":1716702491,"upTimeDate":"2024-05-26","markerId":1}]
     * code : 200
     * msg : 查询成功
     */

    private int total;
    private int code;
    private String msg;
    private List<RowsBean> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * createBy : null
         * createTime : null
         * updateBy : null
         * updateTime : null
         * remark : null
         * id : 72
         * ownerId : 1
         * ownerName : null
         * agentId : null
         * agentName : null
         * serialNumber : 863730062167414
         * type : YG04
         * signal : 12
         * temperature : 155
         * battery : 100
         * event : 2
         * msg : 3
         * upTime : 1716456999
         * upTimeDate : 2024-05-23
         * markerId : 1
         */

        private Object createBy;
        private Object createTime;
        private Object updateBy;
        private Object updateTime;
        private Object remark;
        private int id;
        private int ownerId;
        private Object ownerName;
        private Object agentId;
        private Object agentName;
        private long serialNumber;
        private String type;
        private String signal;
        private int temperature;
        private String battery;
        private String event;
        private String msg;
        private int upTime;
        private String upTimeDate;
        private int markerId;

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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getOwnerId() {
            return ownerId;
        }

        public void setOwnerId(int ownerId) {
            this.ownerId = ownerId;
        }

        public Object getOwnerName() {
            return ownerName;
        }

        public void setOwnerName(Object ownerName) {
            this.ownerName = ownerName;
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

        public long getSerialNumber() {
            return serialNumber;
        }

        public void setSerialNumber(long serialNumber) {
            this.serialNumber = serialNumber;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSignal() {
            return signal;
        }

        public void setSignal(String signal) {
            this.signal = signal;
        }

        public int getTemperature() {
            return temperature;
        }

        public void setTemperature(int temperature) {
            this.temperature = temperature;
        }

        public String getBattery() {
            return battery;
        }

        public void setBattery(String battery) {
            this.battery = battery;
        }

        public String getEvent() {
            return event;
        }

        public void setEvent(String event) {
            this.event = event;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public int getUpTime() {
            return upTime;
        }

        public void setUpTime(int upTime) {
            this.upTime = upTime;
        }

        public String getUpTimeDate() {
            return upTimeDate;
        }

        public void setUpTimeDate(String upTimeDate) {
            this.upTimeDate = upTimeDate;
        }

        public int getMarkerId() {
            return markerId;
        }

        public void setMarkerId(int markerId) {
            this.markerId = markerId;
        }
    }
}
