package org.chronotics.sample.pithos_ext_es;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;

/**
 * @author Thinh Ly
 * @date 12/7/2018
 */
public class ESDataModel {
    public static HashMap<String, String> FIELD_MAP = new HashMap<>();

    static {
        FIELD_MAP.put("createDate", "createDate");
        FIELD_MAP.put("equipmentId", "equipmentId");
        FIELD_MAP.put("filename", "filename");
        FIELD_MAP.put("head", "head");
        FIELD_MAP.put("func", "func");
        FIELD_MAP.put("mStatusAut", "mStatusAut");
        FIELD_MAP.put("mStatusRun", "mStatusRun");
        FIELD_MAP.put("mStatusEmg", "mStatusEmg");
        FIELD_MAP.put("blockNo", "blockNo");
        FIELD_MAP.put("rPosX", "rPosX");
        FIELD_MAP.put("rPosY", "rPosY");
        FIELD_MAP.put("rPosZ", "rPosZ");
        FIELD_MAP.put("rPosA", "rPosA");
        FIELD_MAP.put("rPosB", "rPosB");
        FIELD_MAP.put("rPosC", "rPosC");
        FIELD_MAP.put("aPosX", "aPosX");
        FIELD_MAP.put("aPosY", "aPosY");
        FIELD_MAP.put("aPosZ", "aPosZ");
        FIELD_MAP.put("aPosA", "aPosA");
        FIELD_MAP.put("aPosB", "aPosB");
        FIELD_MAP.put("aPosC", "aPosC");
        FIELD_MAP.put("spLoad", "spLoad");
        FIELD_MAP.put("actFeed", "actFeed");
        FIELD_MAP.put("actRPM", "actRPM");
        FIELD_MAP.put("cmdRPM", "cmdRPM");
        FIELD_MAP.put("cmdFeed", "cmdFeed");
        FIELD_MAP.put("mCode", "mCode");
        FIELD_MAP.put("atcNo", "atcNo");
        FIELD_MAP.put("lineNo", "lineNo");
        FIELD_MAP.put("mainNo", "mainNo");
        FIELD_MAP.put("subNo", "subNo");
        FIELD_MAP.put("chattFreq", "chattFreq");
        FIELD_MAP.put("chattMaxAmp", "chattMaxAmp");
        FIELD_MAP.put("chattRPM1", "chattRPM1");
        FIELD_MAP.put("chattRPM2", "chattRPM2");
        FIELD_MAP.put("chattRPM3", "chattRPM3");
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
        FIELD_MAP.put("pmcR", "pmcR");
        FIELD_MAP.put("hh", "hh");
        FIELD_MAP.put("mm", "mm");
        FIELD_MAP.put("ss", "ss");
        FIELD_MAP.put("ms", "ms");
        FIELD_MAP.put("reserve1", "reserve1");
        FIELD_MAP.put("reserve2", "reserve2");
        FIELD_MAP.put("reserve3", "reserve3");
        FIELD_MAP.put("tail", "tail");
    }

    @JsonProperty("createDate")
    Date createDate;

    @JsonProperty("equipmentId")
    String equipmentId;

    @JsonProperty("filename")
    String filename;

    @JsonProperty("head")
    Integer head;

    @JsonProperty("func")
    Integer func;

    @JsonProperty("mStatusAut")
    Short mStatusAut;

    @JsonProperty("mStatusRun")
    Short mStatusRun;

    @JsonProperty("mStatusEmg")
    Short mStatusEmg;

    @JsonProperty("blockNo")
    Integer blockNo;

    @JsonProperty("rPosX")
    String rPosX;

    @JsonProperty("rPosY")
    String rPosY;

    @JsonProperty("rPosZ")
    String rPosZ;

    @JsonProperty("rPosA")
    String rPosA;

    @JsonProperty("rPosB")
    String rPosB;

    @JsonProperty("rPosC")
    String rPosC;

    @JsonProperty("aPosX")
    Float aPosX;

    @JsonProperty("aPosY")
    Float aPosY;

    @JsonProperty("aPosZ")
    Float aPosZ;

    @JsonProperty("aPosA")
    Float aPosA;

    @JsonProperty("aPosB")
    Float aPosB;

    @JsonProperty("aPosC")
    Float aPosC;

    @JsonProperty("spLoad")
    Short spLoad;

    @JsonProperty("actFeed")
    Short actFeed;

    @JsonProperty("actRPM")
    Short actRPM;

    @JsonProperty("cmdRPM")
    Short cmdRPM;

    @JsonProperty("cmdFeed")
    Short cmdFeed;

    @JsonProperty("mCode")
    Short mCode;

    @JsonProperty("atcNo")
    Short atcNo;

    @JsonProperty("lineNo")
    Integer lineNo;

    @JsonProperty("mainNo")
    Short mainNo;

    @JsonProperty("subNo")
    Short subNo;

    @JsonProperty("chattFreq")
    Float chattFreq;

    @JsonProperty("chattMaxAmp")
    Float chattMaxAmp;

    @JsonProperty("chattRPM1")
    Float chattRPM1;

    @JsonProperty("chattRPM2")
    Float chattRPM2;

    @JsonProperty("chattRPM3")
    Float chattRPM3;

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

    @JsonProperty("pmcR")
    Short pmcR;

    @JsonProperty("hh")
    Short hh;

    @JsonProperty("mm")
    Short mm;

    @JsonProperty("ss")
    Short ss;

    @JsonProperty("ms")
    Short ms;

    @JsonProperty("reserve1")
    Float reserve1;

    @JsonProperty("reserve2")
    Float reserve2;

    @JsonProperty("reserve3")
    Float reserve3;

    @JsonProperty("tail")
    Float tail;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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

    public Integer getHead() {
        return head;
    }

    public void setHead(Integer head) {
        this.head = head;
    }

    public Integer getFunc() {
        return func;
    }

    public void setFunc(Integer func) {
        this.func = func;
    }

    public Short getmStatusAut() {
        return mStatusAut;
    }

    public void setmStatusAut(Short mStatusAut) {
        this.mStatusAut = mStatusAut;
    }

    public Short getmStatusRun() {
        return mStatusRun;
    }

    public void setmStatusRun(Short mStatusRun) {
        this.mStatusRun = mStatusRun;
    }

    public Short getmStatusEmg() {
        return mStatusEmg;
    }

    public void setmStatusEmg(Short mStatusEmg) {
        this.mStatusEmg = mStatusEmg;
    }

    public Integer getBlockNo() {
        return blockNo;
    }

    public void setBlockNo(Integer blockNo) {
        this.blockNo = blockNo;
    }

    public String getrPosX() {
        return rPosX;
    }

    public void setrPosX(String rPosX) {
        this.rPosX = rPosX;
    }

    public String getrPosY() {
        return rPosY;
    }

    public void setrPosY(String rPosY) {
        this.rPosY = rPosY;
    }

    public String getrPosZ() {
        return rPosZ;
    }

    public void setrPosZ(String rPosZ) {
        this.rPosZ = rPosZ;
    }

    public String getrPosA() {
        return rPosA;
    }

    public void setrPosA(String rPosA) {
        this.rPosA = rPosA;
    }

    public String getrPosB() {
        return rPosB;
    }

    public void setrPosB(String rPosB) {
        this.rPosB = rPosB;
    }

    public String getrPosC() {
        return rPosC;
    }

    public void setrPosC(String rPosC) {
        this.rPosC = rPosC;
    }

    public Float getaPosX() {
        return aPosX;
    }

    public void setaPosX(Float aPosX) {
        this.aPosX = aPosX;
    }

    public Float getaPosY() {
        return aPosY;
    }

    public void setaPosY(Float aPosY) {
        this.aPosY = aPosY;
    }

    public Float getaPosZ() {
        return aPosZ;
    }

    public void setaPosZ(Float aPosZ) {
        this.aPosZ = aPosZ;
    }

    public Float getaPosA() {
        return aPosA;
    }

    public void setaPosA(Float aPosA) {
        this.aPosA = aPosA;
    }

    public Float getaPosB() {
        return aPosB;
    }

    public void setaPosB(Float aPosB) {
        this.aPosB = aPosB;
    }

    public Float getaPosC() {
        return aPosC;
    }

    public void setaPosC(Float aPosC) {
        this.aPosC = aPosC;
    }

    public Short getSpLoad() {
        return spLoad;
    }

    public void setSpLoad(Short spLoad) {
        this.spLoad = spLoad;
    }

    public Short getActFeed() {
        return actFeed;
    }

    public void setActFeed(Short actFeed) {
        this.actFeed = actFeed;
    }

    public Short getActRPM() {
        return actRPM;
    }

    public void setActRPM(Short actRPM) {
        this.actRPM = actRPM;
    }

    public Short getCmdRPM() {
        return cmdRPM;
    }

    public void setCmdRPM(Short cmdRPM) {
        this.cmdRPM = cmdRPM;
    }

    public Short getCmdFeed() {
        return cmdFeed;
    }

    public void setCmdFeed(Short cmdFeed) {
        this.cmdFeed = cmdFeed;
    }

    public Short getmCode() {
        return mCode;
    }

    public void setmCode(Short mCode) {
        this.mCode = mCode;
    }

    public Short getAtcNo() {
        return atcNo;
    }

    public void setAtcNo(Short atcNo) {
        this.atcNo = atcNo;
    }

    public Integer getLineNo() {
        return lineNo;
    }

    public void setLineNo(Integer lineNo) {
        this.lineNo = lineNo;
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

    public Float getChattFreq() {
        return chattFreq;
    }

    public void setChattFreq(Float chattFreq) {
        this.chattFreq = chattFreq;
    }

    public Float getChattMaxAmp() {
        return chattMaxAmp;
    }

    public void setChattMaxAmp(Float chattMaxAmp) {
        this.chattMaxAmp = chattMaxAmp;
    }

    public Float getChattRPM1() {
        return chattRPM1;
    }

    public void setChattRPM1(Float chattRPM1) {
        this.chattRPM1 = chattRPM1;
    }

    public Float getChattRPM2() {
        return chattRPM2;
    }

    public void setChattRPM2(Float chattRPM2) {
        this.chattRPM2 = chattRPM2;
    }

    public Float getChattRPM3() {
        return chattRPM3;
    }

    public void setChattRPM3(Float chattRPM3) {
        this.chattRPM3 = chattRPM3;
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

    public Short getPmcR() {
        return pmcR;
    }

    public void setPmcR(Short pmcR) {
        this.pmcR = pmcR;
    }

    public Short getHh() {
        return hh;
    }

    public void setHh(Short hh) {
        this.hh = hh;
    }

    public Short getMm() {
        return mm;
    }

    public void setMm(Short mm) {
        this.mm = mm;
    }

    public Short getSs() {
        return ss;
    }

    public void setSs(Short ss) {
        this.ss = ss;
    }

    public Short getMs() {
        return ms;
    }

    public void setMs(Short ms) {
        this.ms = ms;
    }

    public Float getReserve1() {
        return reserve1;
    }

    public void setReserve1(Float reserve1) {
        this.reserve1 = reserve1;
    }

    public Float getReserve2() {
        return reserve2;
    }

    public void setReserve2(Float reserve2) {
        this.reserve2 = reserve2;
    }

    public Float getReserve3() {
        return reserve3;
    }

    public void setReserve3(Float reserve3) {
        this.reserve3 = reserve3;
    }

    public Float getTail() {
        return tail;
    }

    public void setTail(Float tail) {
        this.tail = tail;
    }

    public void setField(String strField, Object objData) {
        try {
            ESDataModel objModel = new ESDataModel();
            Field objField = objModel.getClass().getDeclaredField(strField);
            objField.setAccessible(true);

            objField.set(this, objData);
        } catch (Exception objEx) {
        }
    }

    public Object getField(String strField) {
        try {
            ESDataModel objModel = new ESDataModel();

            Field objField = objModel.getClass().getDeclaredField(strField);
            objField.setAccessible(true);

            return objField.get(this);
        } catch (Exception objEx) {
            return null;
        }
    }
}
