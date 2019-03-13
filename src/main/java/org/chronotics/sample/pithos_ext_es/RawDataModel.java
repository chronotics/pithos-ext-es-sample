package org.chronotics.sample.pithos_ext_es;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.chronotics.pandora.java.converter.ConverterUtil;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * @author Thinh Ly
 * @date 12/7/2018
 */
public class RawDataModel {
    public static HashMap<Integer, String> FIELD_OFFSET_MAP = new HashMap<>();
    public static HashMap<String, String> FIELD_DATATYPE_MAP = new HashMap<>();
    public static Integer OBJECT_BYTE_LENGTH = 162;

    static {
        FIELD_DATATYPE_MAP.put("head", "int");
        FIELD_DATATYPE_MAP.put("func", "int");
        FIELD_DATATYPE_MAP.put("mStatusAut", "short");
        FIELD_DATATYPE_MAP.put("mStatusRun", "short");
        FIELD_DATATYPE_MAP.put("mStatusEmg", "short");
        FIELD_DATATYPE_MAP.put("blockNo", "int");
        FIELD_DATATYPE_MAP.put("rPosX", "string");
        FIELD_DATATYPE_MAP.put("rPosY", "string");
        FIELD_DATATYPE_MAP.put("rPosZ", "string");
        FIELD_DATATYPE_MAP.put("rPosA", "string");
        FIELD_DATATYPE_MAP.put("rPosB", "string");
        FIELD_DATATYPE_MAP.put("rPosC", "string");
        FIELD_DATATYPE_MAP.put("aPosX", "float");
        FIELD_DATATYPE_MAP.put("aPosY", "float");
        FIELD_DATATYPE_MAP.put("aPosZ", "float");
        FIELD_DATATYPE_MAP.put("aPosA", "float");
        FIELD_DATATYPE_MAP.put("aPosB", "float");
        FIELD_DATATYPE_MAP.put("aPosC", "float");
        FIELD_DATATYPE_MAP.put("spLoad", "short");
        FIELD_DATATYPE_MAP.put("actFeed", "short");
        FIELD_DATATYPE_MAP.put("actRPM", "short");
        FIELD_DATATYPE_MAP.put("cmdRPM", "short");
        FIELD_DATATYPE_MAP.put("cmdFeed", "short");
        FIELD_DATATYPE_MAP.put("mCode", "short");
        FIELD_DATATYPE_MAP.put("atcNo", "short");
        FIELD_DATATYPE_MAP.put("lineNo", "int");
        FIELD_DATATYPE_MAP.put("mainNo", "short");
        FIELD_DATATYPE_MAP.put("subNo", "short");
        FIELD_DATATYPE_MAP.put("chattFreq", "float");
        FIELD_DATATYPE_MAP.put("chattMaxAmp", "float");
        FIELD_DATATYPE_MAP.put("chattRPM1", "float");
        FIELD_DATATYPE_MAP.put("chattRPM2", "float");
        FIELD_DATATYPE_MAP.put("chattRPM3", "float");
        FIELD_DATATYPE_MAP.put("acc1TPF1", "float");
        FIELD_DATATYPE_MAP.put("acc1TPF2", "float");
        FIELD_DATATYPE_MAP.put("acc1TPF3", "float");
        FIELD_DATATYPE_MAP.put("acc1TPF4", "float");
        FIELD_DATATYPE_MAP.put("acc1TPF5", "float");
        FIELD_DATATYPE_MAP.put("acc1TPFMax", "float");
        FIELD_DATATYPE_MAP.put("acc1TPFAmp", "float");
        FIELD_DATATYPE_MAP.put("acc2TPF1", "float");
        FIELD_DATATYPE_MAP.put("acc2TPF2", "float");
        FIELD_DATATYPE_MAP.put("acc2TPF3", "float");
        FIELD_DATATYPE_MAP.put("acc2TPF4", "float");
        FIELD_DATATYPE_MAP.put("acc2TPF5", "float");
        FIELD_DATATYPE_MAP.put("acc2TPFMax", "float");
        FIELD_DATATYPE_MAP.put("acc2TPFAmp", "float");
        FIELD_DATATYPE_MAP.put("cur1RMS", "float");
        FIELD_DATATYPE_MAP.put("cur2RMS", "float");
        FIELD_DATATYPE_MAP.put("pmcR", "short");
        FIELD_DATATYPE_MAP.put("hh", "short");
        FIELD_DATATYPE_MAP.put("mm", "short");
        FIELD_DATATYPE_MAP.put("ss", "short");
        FIELD_DATATYPE_MAP.put("ms", "short");
        FIELD_DATATYPE_MAP.put("reserve1", "float");
        FIELD_DATATYPE_MAP.put("reserve2", "float");
        FIELD_DATATYPE_MAP.put("reserve3", "float");
        FIELD_DATATYPE_MAP.put("tail", "float");
    }

    static {
        FIELD_OFFSET_MAP.put(0, "head");
        FIELD_OFFSET_MAP.put(4, "func");
        FIELD_OFFSET_MAP.put(8, "mStatusAut");
        FIELD_OFFSET_MAP.put(10, "mStatusRun");
        FIELD_OFFSET_MAP.put(12, "mStatusEmg");
        FIELD_OFFSET_MAP.put(14, "blockNo");
        FIELD_OFFSET_MAP.put(18, "rPosX");
        FIELD_OFFSET_MAP.put(22, "rPosY");
        FIELD_OFFSET_MAP.put(26, "rPosZ");
        FIELD_OFFSET_MAP.put(30, "rPosA");
        FIELD_OFFSET_MAP.put(34, "rPosB");
        FIELD_OFFSET_MAP.put(38, "rPosC");
        FIELD_OFFSET_MAP.put(42, "aPosX");
        FIELD_OFFSET_MAP.put(46, "aPosY");
        FIELD_OFFSET_MAP.put(50, "aPosZ");
        FIELD_OFFSET_MAP.put(54, "aPosA");
        FIELD_OFFSET_MAP.put(58, "aPosB");
        FIELD_OFFSET_MAP.put(62, "aPosC");
        FIELD_OFFSET_MAP.put(66, "spLoad");
        FIELD_OFFSET_MAP.put(68, "actFeed");
        FIELD_OFFSET_MAP.put(70, "actRPM");
        FIELD_OFFSET_MAP.put(72, "cmdRPM");
        FIELD_OFFSET_MAP.put(74, "cmdFeed");
        FIELD_OFFSET_MAP.put(76, "mCode");
        FIELD_OFFSET_MAP.put(78, "atcNo");
        FIELD_OFFSET_MAP.put(80, "lineNo");
        FIELD_OFFSET_MAP.put(84, "mainNo");
        FIELD_OFFSET_MAP.put(86, "subNo");
        FIELD_OFFSET_MAP.put(88, "chattFreq");
        FIELD_OFFSET_MAP.put(90, "chattMaxAmp");
        FIELD_OFFSET_MAP.put(94, "chattRPM1");
        FIELD_OFFSET_MAP.put(96, "chattRPM2");
        FIELD_OFFSET_MAP.put(98, "chattRPM3");
        FIELD_OFFSET_MAP.put(100, "acc1TPF1");
        FIELD_OFFSET_MAP.put(102, "acc1TPF2");
        FIELD_OFFSET_MAP.put(104, "acc1TPF3");
        FIELD_OFFSET_MAP.put(106, "acc1TPF4");
        FIELD_OFFSET_MAP.put(108, "acc1TPF5");
        FIELD_OFFSET_MAP.put(110, "acc1TPFMax");
        FIELD_OFFSET_MAP.put(112, "acc1TPFAmp");
        FIELD_OFFSET_MAP.put(116, "acc2TPF1");
        FIELD_OFFSET_MAP.put(118, "acc2TPF2");
        FIELD_OFFSET_MAP.put(120, "acc2TPF3");
        FIELD_OFFSET_MAP.put(122, "acc2TPF4");
        FIELD_OFFSET_MAP.put(124, "acc2TPF5");
        FIELD_OFFSET_MAP.put(126, "acc2TPFMax");
        FIELD_OFFSET_MAP.put(128, "acc2TPFAmp");
        FIELD_OFFSET_MAP.put(132, "cur1RMS");
        FIELD_OFFSET_MAP.put(136, "cur2RMS");
        FIELD_OFFSET_MAP.put(140, "pmcR");
        FIELD_OFFSET_MAP.put(141, "hh");
        FIELD_OFFSET_MAP.put(142, "mm");
        FIELD_OFFSET_MAP.put(143, "ss");
        FIELD_OFFSET_MAP.put(144, "ms");
        FIELD_OFFSET_MAP.put(146, "reserve1");
        FIELD_OFFSET_MAP.put(150, "reserve2");
        FIELD_OFFSET_MAP.put(154, "reserve3");
        FIELD_OFFSET_MAP.put(158, "tail");
    }

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

    public void setField(String strField, byte[] arrByte) {
        try {
            RawDataModel objModel = new RawDataModel();
            Class<?> classZ = objModel.getClass();
            String strDataType = classZ.getDeclaredField(strField).getType().getTypeName().toLowerCase();

            Field objField = objModel.getClass().getDeclaredField(strField);
            objField.setAccessible(true);

            if (strField.equals("rPosX")) {
                String str = "";
            }

            Object objValue = ConverterUtil.convertByteArrayToObject(arrByte, strDataType);

            objField.set(this, objValue);
        } catch (Exception objEx) {
        }
    }

    public Object getField(String strField) {
        try {
            RawDataModel objModel = new RawDataModel();

            Field objField = objModel.getClass().getDeclaredField(strField);
            objField.setAccessible(true);

            return objField.get(this);
        } catch (Exception objEx) {
            return null;
        }
    }

}
