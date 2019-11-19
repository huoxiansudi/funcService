package com.hospital.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hospital.out.clinicPayInter.CostVo;
import com.hospital.out.clinicPayInter.GhsfVo;
import com.hospital.out.clinicPayInter.TotalCostInventoryVo;
import com.hospital.out.clinicPayInter.ZYPatientVo;
import com.hospital.out.hospital.PayDetaileList;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by fuxf on 2017/7/31.
 */
public class ResultModel {

    static Logger logger = Logger.getLogger(ResultModel.class);

    private String state; // 成功 0 失败 1
    private Object result;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String patientid;//医院用户编号
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String regState;//挂号状态
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String orderid;//预约订单编号
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Object> list;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Object> assay;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CostVo cost; //费用信息
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ZYPatientVo obj;//住院人员信息
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TotalCostInventoryVo oneMainCost;//住院一日清单
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PayDetaileList payDetaileList;//充值记录
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String visitNo;//就诊卡号
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private GhsfVo reg;//挂号收费
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String invoicenumber;//发票号

    public static ResultModel failResultModel(Object result) {
        ResultModel resultModel = new ResultModel();
        resultModel.setState("1");
        resultModel.setResult(result);
        logger.debug("返回参数:" +result !=null?result.toString():"数据为空！！!");
        return resultModel;
    }
    public static ResultModel NullPatientModel(Object result) {
        ResultModel resultModel = new ResultModel();
        resultModel.setState("-1");
        resultModel.setResult(result);
        logger.debug("返回参数:" +result !=null?result.toString():"数据为空！！!");
        return resultModel;
    }

    public static ResultModel SuccessResultModel(Object result) {
        ResultModel resultModel = new ResultModel();
        resultModel.setState("0");
        resultModel.setResult(result);
        logger.debug("返回参数:" + (result !=null?result.toString():"数据为空！！!"));
        return resultModel;
    }

    public static ResultModel SuccessGhxxModelInfo(String regState) {
        ResultModel resultModel = new ResultModel();
        resultModel.setState("0");
        resultModel.setResult("操作成功");
        resultModel.setRegState(regState);
        logger.debug("返回参数:" + regState);
        return resultModel;
    }

    public static ResultModel SuccessResultModelInfo() {
        ResultModel resultModel = new ResultModel();
        resultModel.setState("0");
        resultModel.setResult("操作成功");
        logger.debug("返回参数:" + (resultModel.toString()));
        return resultModel;
    }

    public static ResultModel SuccessRegistResultModel(String patientid) {
        ResultModel resultModel = new ResultModel();
        resultModel.setState("0");
        resultModel.setResult("操作成功");
        resultModel.setPatientid(patientid);
        logger.debug("返回参数:" + patientid);
        return resultModel;
    }

    public static ResultModel SuccessYyghResultModel(String yyxh) {
        ResultModel resultModel = new ResultModel();
        resultModel.setState("0");
        resultModel.setResult("操作成功");
        resultModel.setOrderid(String.valueOf(yyxh));
        logger.debug("返回参数:" +yyxh );
        return resultModel;
    }

    public static ResultModel SuccessListResultModel(List list) {
        ResultModel resultModel = new ResultModel();
        resultModel.setState("0");
        resultModel.setResult("操作成功");
        resultModel.setList(list);
        logger.debug("返回参数:" + (list != null?list.isEmpty()?"数据为空！！":list.toString():"数据为空"));
        return resultModel;
    }

    public static ResultModel SuccessAssayResultModel(List assay) {
        ResultModel resultModel = new ResultModel();
        resultModel.setState("0");
        resultModel.setResult("操作成功");
        resultModel.setAssay(assay);
        logger.debug("返回参数:" + (assay !=null?assay.toString():"数据为空！！"));
        return resultModel;
    }

    public static ResultModel SuccessRegResultModel(GhsfVo reg) {
        ResultModel resultModel = new ResultModel();
        resultModel.setState("0");
        resultModel.setResult("操作成功");
        resultModel.setReg(reg);
        logger.debug("返回参数:" + (reg !=null?reg.toString():"数据为空！！"));
        return resultModel;
    }

    public static ResultModel SuccessCostResultModel(CostVo cost) {
        ResultModel resultModel = new ResultModel();
        resultModel.setState("0");
        resultModel.setResult("操作成功");
        resultModel.setCost(cost);
        logger.debug("返回参数:" + (cost != null?cost.toString():"数据为空！！"));
        return resultModel;
    }

    public static ResultModel SuccessObjResultModel(ZYPatientVo obj) {
        ResultModel resultModel = new ResultModel();
        resultModel.setState("0");
        resultModel.setResult("操作成功");
        resultModel.setObj(obj);
        logger.debug("返回参数:" + (obj !=null?obj.toString():"数据为空！！!"));
        return resultModel;
    }
    public static ResultModel SuccessOneResultModel(TotalCostInventoryVo obj) {
        ResultModel resultModel = new ResultModel();
        resultModel.setState("0");
        resultModel.setResult("操作成功");
        resultModel.setOneMainCost(obj);
        logger.debug("返回参数:" + (obj !=null?obj.toString():"数据为空！！!"));
        return resultModel;
    }
    public static ResultModel SuccessPayDetaileList(PayDetaileList obj) {
        ResultModel resultModel = new ResultModel();
        resultModel.setState("0");
        resultModel.setResult("操作成功");
        resultModel.setPayDetaileList(obj);
        logger.debug("返回参数:" + (obj !=null?obj.toString():"数据为空！！!"));
        return resultModel;
    }
    public static ResultModel SuccessVisitNo(String visitNo) {
        ResultModel resultModel = new ResultModel();
        resultModel.setState("0");
        resultModel.setResult("操作成功");
        resultModel.setVisitNo(visitNo);
        logger.debug("返回参数:" + (visitNo !=null?visitNo:"数据为空！！!"));
        return resultModel;
    }
    public static ResultModel SuccessInvoicenumber(String invoicenumber) {
        ResultModel resultModel = new ResultModel();
        resultModel.setState("0");
        resultModel.setResult("操作成功");
        resultModel.setInvoicenumber(invoicenumber);
        logger.debug("返回参数:" + (invoicenumber !=null?invoicenumber:"数据为空！！!"));
        return resultModel;
    }

    public String getInvoicenumber() {
        return invoicenumber;
    }

    public void setInvoicenumber(String invoicenumber) {
        this.invoicenumber = invoicenumber;
    }

    public ZYPatientVo getObj() {
        return obj;
    }

    public void setObj(ZYPatientVo obj) {
        this.obj = obj;
    }

    public CostVo getCost() {
        return cost;
    }

    public void setCost(CostVo cost) {
        this.cost = cost;
    }

    public List<Object> getAssay() {
        return assay;
    }

    public void setAssay(List<Object> assay) {
        this.assay = assay;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getOrderid() {
        return orderid;
    }

    public String getRegState() {
        return regState;
    }

    public void setRegState(String regState) {
        this.regState = regState;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getPatientid() {
        return patientid;
    }

    public void setPatientid(String patientid) {
        this.patientid = patientid;
    }

    public TotalCostInventoryVo getOneMainCost() {
        return oneMainCost;
    }

    public void setOneMainCost(TotalCostInventoryVo oneMainCost) {
        this.oneMainCost = oneMainCost;
    }

    public PayDetaileList getPayDetaileList() {
        return payDetaileList;
    }

    public void setPayDetaileList(PayDetaileList payDetaileList) {
        this.payDetaileList = payDetaileList;
    }

    public GhsfVo getReg() {
        return reg;
    }

    public void setReg(GhsfVo reg) {
        this.reg = reg;
    }

    public String getVisitNo() {
        return visitNo;
    }

    public void setVisitNo(String visitNo) {
        this.visitNo = visitNo;
    }
}
