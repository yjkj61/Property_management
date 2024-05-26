package com.yjkj.property_management.java.bean;

import java.util.List;

public class DealWithTwoBean {
    /**
     * total : 1
     * rows : [{"createBy":null,"createTime":"2024-05-25 11:36:29","updateBy":null,"updateTime":null,"remark":"新增商家","sGoodsBusinessId":184,"userId":null,"businessName":"商家ZSM11323","shopName":"店铺ZSM11323","contact":"15370337637","contactPhone":"15370337637","contactEmail":"1132347000@qq.com","area":"北京市/北京市/东城区/东华门街道","address":"XXXXXXXXXXXXXXXX","societyUnifyCreditCode":"91110106348363902B","enterpriseName":"XXXX企业名称","legalPerson":"ZSM","tradeBeginTime":"2024-05-01","tradeEndTime":"2025-07-31","registeredCapital":"100000000","businessScope":"无","businessLicenseElectronicVersion":"http://47.116.36.196:9300/statics/2024/05/25/油炸虾_20240525113448A003.jpg","legalPersonIdentityCard":"32132119980509701X","goodsTypeName":null,"goodsTypeParentName":null,"goodsTypeDiscount":null,"brandName":null,"brandLogo":null,"bankName":"XXXX","bankAccountName":"xxxx","bankAccountNumber":"6214832533628173","subbranch":"xxxx","processStatus":"1","processNopassRemark":null,"businessStatus":"1","disableRemark":null,"sGoodsTypeList":null,"sGoodsTypeAuthorityList":null}]
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
        private String agentName;

        private String ownerMarkerName;

        private String agentAddress;

        private String agentManager;

        public String getAgentName() {
            return agentName;
        }

        public void setAgentName(String agentName) {
            this.agentName = agentName;
        }

        public String getOwnerMarkerName() {
            return ownerMarkerName;
        }

        public void setOwnerMarkerName(String ownerMarkerName) {
            this.ownerMarkerName = ownerMarkerName;
        }

        public String getAgentAddress() {
            return agentAddress;
        }

        public void setAgentAddress(String agentAddress) {
            this.agentAddress = agentAddress;
        }

        public String getAgentManager() {
            return agentManager;
        }

        public void setAgentManager(String agentManager) {
            this.agentManager = agentManager;
        }
    }
}
