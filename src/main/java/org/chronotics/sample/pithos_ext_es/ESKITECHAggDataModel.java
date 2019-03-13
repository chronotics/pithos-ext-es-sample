package org.chronotics.sample.pithos_ext_es;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;

/**
 * @author Phan Huu Hung
 * @date 12/8/2018
 */
public class ESKITECHAggDataModel {
    public static HashMap<String, String> FIELD_MAP = new HashMap<>();
    public static HashMap<String, String> FIELD_AGG_MAP = new HashMap<>();

    static {
        FIELD_MAP.put("startedDate", "startedDate");
        FIELD_MAP.put("endedDate", "endedDate");
        FIELD_MAP.put("equipmentId", "equipmentId");
        FIELD_MAP.put("filename", "filename");
        FIELD_MAP.put("blockNo", "blockNo");
        FIELD_MAP.put("mainNo","mainNo");
        FIELD_MAP.put("subNo","subNo");
        FIELD_MAP.put("blockId", "blockId");
        FIELD_MAP.put("blockIdx", "blockIdx");
        FIELD_MAP.put("summaryType", "summaryType");
        FIELD_MAP.put("acc1TPF1", "acc1TPF1");
        FIELD_MAP.put("acc1TPF2", "acc1TPF2");
        FIELD_MAP.put("acc1TPF3", "acc1TPF3");
        FIELD_MAP.put("acc1TPF4", "acc1TPF4");
        FIELD_MAP.put("acc1TPF5", "acc1TPF5");
        FIELD_MAP.put("acc1TPFMax", "acc1TPFMax");
        FIELD_MAP.put("acc1TPFAmp", "acc1TPFAmp");
        FIELD_MAP.put("acc2TPF1", "acc2TPF1");
        FIELD_MAP.put("acc2TPF2", "acc2TPF2");
        FIELD_MAP.put("acc2TPF3", "acc2TPF3");
        FIELD_MAP.put("acc2TPF4", "acc2TPF4");
        FIELD_MAP.put("acc2TPF5", "acc2TPF5");
        FIELD_MAP.put("acc2TPFMax", "acc2TPFMax");
        FIELD_MAP.put("acc2TPFAmp", "acc2TPFAmp");
        FIELD_MAP.put("cur1RMS", "cur1RMS");
        FIELD_MAP.put("cur2RMS", "cur2RMS");

        FIELD_AGG_MAP.put("acc1TPF1", "acc1TPF1");
        FIELD_AGG_MAP.put("acc1TPF2", "acc1TPF2");
        FIELD_AGG_MAP.put("acc1TPF3", "acc1TPF3");
        FIELD_AGG_MAP.put("acc1TPF4", "acc1TPF4");
        FIELD_AGG_MAP.put("acc1TPF5", "acc1TPF5");
        FIELD_AGG_MAP.put("acc1TPFMax", "acc1TPFMax");
        FIELD_AGG_MAP.put("acc1TPFAmp", "acc1TPFAmp");
        FIELD_AGG_MAP.put("acc2TPF1", "acc2TPF1");
        FIELD_AGG_MAP.put("acc2TPF2", "acc2TPF2");
        FIELD_AGG_MAP.put("acc2TPF3", "acc2TPF3");
        FIELD_AGG_MAP.put("acc2TPF4", "acc2TPF4");
        FIELD_AGG_MAP.put("acc2TPF5", "acc2TPF5");
        FIELD_AGG_MAP.put("acc2TPFMax", "acc2TPFMax");
        FIELD_AGG_MAP.put("acc2TPFAmp", "acc2TPFAmp");
        FIELD_AGG_MAP.put("cur1RMS", "cur1RMS");
        FIELD_AGG_MAP.put("cur2RMS", "cur2RMS");
    }

    @JsonProperty("startedDate")
    Date startedDate;

    @JsonProperty("endedDate")
    Date endedDate;

    @JsonProperty("equipmentId")
    String equipmentId;

    @JsonProperty("filename")
    String filename;

    @JsonProperty("blockNo")
    Integer blockNo;

    @JsonProperty("mainNo")
    Short mainNo;

    @JsonProperty("subNo")
    Short subNo;

    @JsonProperty("blockId")
    String blockId;

    @JsonProperty("blockIdx")
    Integer blockIdx;

    @JsonProperty("summaryType")
    String summaryType;

    @JsonProperty("acc1TPF1")
    Float acc1TPF1;

    @JsonProperty("acc1TPF2")
    Float acc1TPF2;

    @JsonProperty("acc1TPF3")
    Float acc1TPF3;

    @JsonProperty("acc1TPF4")
    Float acc1TPF4;

    @JsonProperty("acc1TPF5")
    Float acc1TPF5;

    @JsonProperty("acc1Max")
    Float acc1Max;

    @JsonProperty("acc1Amp")
    Float acc1Amp;

    @JsonProperty("acc2TPF1")
    Float acc2TPF1;

    @JsonProperty("acc2TPF2")
    Float acc2TPF2;

    @JsonProperty("acc2TPF3")
    Float acc2TPF3;

    @JsonProperty("acc2TPF4")
    Float acc2TPF4;

    @JsonProperty("acc2TPF5")
    Float acc2TPF5;

    @JsonProperty("acc2Max")
    Float acc2Max;

    @JsonProperty("acc2Amp")
    Float acc2Amp;

    @JsonProperty("cur1RMS")
    Float cur1RMS;

    @JsonProperty("cur2RMS")
    Float cur2RMS;

    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }

    public Date getEndedDate() {
        return endedDate;
    }

    public void setEndedDate(Date endedDate) {
        this.endedDate = endedDate;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Integer getBlockNo() {
        return blockNo;
    }

    public void setBlockNo(Integer blockNo) {
        this.blockNo = blockNo;
    }

    public Short getMainNo() {
        return mainNo;
    }

    public void setMainNo(Short mainNo) {
        this.mainNo = mainNo;
    }

    public Short getSubNo() {
        return subNo;
    }

    public void setSubNo(Short subNo) {
        this.subNo = subNo;
    }

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
    }

    public Integer getBlockIdx() {
        return blockIdx;
    }

    public void setBlockIdx(Integer blockIdx) {
        this.blockIdx = blockIdx;
    }

    public String getSummaryType() {
        return summaryType;
    }

    public void setSummaryType(String summaryType) {
        this.summaryType = summaryType;
    }

    public Float getAcc1TPF1() {
        return acc1TPF1;
    }

    public void setAcc1TPF1(Float acc1TPF1) {
        this.acc1TPF1 = acc1TPF1;
    }

    public Float getAcc1TPF2() {
        return acc1TPF2;
    }

    public void setAcc1TPF2(Float acc1TPF2) {
        this.acc1TPF2 = acc1TPF2;
    }

    public Float getAcc1TPF3() {
        return acc1TPF3;
    }

    public void setAcc1TPF3(Float acc1TPF3) {
        this.acc1TPF3 = acc1TPF3;
    }

    public Float getAcc1TPF4() {
        return acc1TPF4;
    }

    public void setAcc1TPF4(Float acc1TPF4) {
        this.acc1TPF4 = acc1TPF4;
    }

    public Float getAcc1TPF5() {
        return acc1TPF5;
    }

    public void setAcc1TPF5(Float acc1TPF5) {
        this.acc1TPF5 = acc1TPF5;
    }

    public Float getAcc1Max() {
        return acc1Max;
    }

    public void setAcc1Max(Float acc1Max) {
        this.acc1Max = acc1Max;
    }

    public Float getAcc1Amp() {
        return acc1Amp;
    }

    public void setAcc1Amp(Float acc1Amp) {
        this.acc1Amp = acc1Amp;
    }

    public Float getAcc2TPF1() {
        return acc2TPF1;
    }

    public void setAcc2TPF1(Float acc2TPF1) {
        this.acc2TPF1 = acc2TPF1;
    }

    public Float getAcc2TPF2() {
        return acc2TPF2;
    }

    public void setAcc2TPF2(Float acc2TPF2) {
        this.acc2TPF2 = acc2TPF2;
    }

    public Float getAcc2TPF3() {
        return acc2TPF3;
    }

    public void setAcc2TPF3(Float acc2TPF3) {
        this.acc2TPF3 = acc2TPF3;
    }

    public Float getAcc2TPF4() {
        return acc2TPF4;
    }

    public void setAcc2TPF4(Float acc2TPF4) {
        this.acc2TPF4 = acc2TPF4;
    }

    public Float getAcc2TPF5() {
        return acc2TPF5;
    }

    public void setAcc2TPF5(Float acc2TPF5) {
        this.acc2TPF5 = acc2TPF5;
    }

    public Float getAcc2Max() {
        return acc2Max;
    }

    public void setAcc2Max(Float acc2Max) {
        this.acc2Max = acc2Max;
    }

    public Float getAcc2Amp() {
        return acc2Amp;
    }

    public void setAcc2Amp(Float acc2Amp) {
        this.acc2Amp = acc2Amp;
    }

    public Float getCur1RMS() {
        return cur1RMS;
    }

    public void setCur1RMS(Float cur1RMS) {
        this.cur1RMS = cur1RMS;
    }

    public Float getCur2RMS() {
        return cur2RMS;
    }

    public void setCur2RMS(Float cur2RMS) {
        this.cur2RMS = cur2RMS;
    }

    public void setField(String strField, Object objData) {
        try {
            ESKITECHAggDataModel objModel = new ESKITECHAggDataModel();
            Field objField = objModel.getClass().getDeclaredField(strField);
            objField.setAccessible(true);

            objField.set(this, objData);
        } catch (Exception objEx) {
        }
    }

    public Object getField(String strField) {
        try {
            ESKITECHAggDataModel objModel = new ESKITECHAggDataModel();

            Field objField = objModel.getClass().getDeclaredField(strField);
            objField.setAccessible(true);

            return objField.get(this);
        } catch (Exception objEx) {
            return null;
        }
    }
}
