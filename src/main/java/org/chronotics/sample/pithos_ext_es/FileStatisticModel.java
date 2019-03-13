package org.chronotics.sample.pithos_ext_es;

public class FileStatisticModel {
    String statDate;
    Integer numCollectedFile;
    Long timeCollectedFile;
    Long sizeCollectedFile;
    Integer numErrorCollectedFile;
    Integer numExportedRequest;
    Long sizeExportedCSVFile;
    Integer numExportedUser;

    public String getStatDate() {
        return statDate;
    }

    public void setStatDate(String statDate) {
        this.statDate = statDate;
    }

    public Integer getNumCollectedFile() {
        return numCollectedFile;
    }

    public void setNumCollectedFile(Integer numCollectedFile) {
        this.numCollectedFile = numCollectedFile;
    }

    public Long getTimeCollectedFile() {
        return timeCollectedFile;
    }

    public void setTimeCollectedFile(Long timeCollectedFile) {
        this.timeCollectedFile = timeCollectedFile;
    }

    public Long getSizeCollectedFile() {
        return sizeCollectedFile;
    }

    public void setSizeCollectedFile(Long sizeCollectedFile) {
        this.sizeCollectedFile = sizeCollectedFile;
    }

    public Integer getNumErrorCollectedFile() {
        return numErrorCollectedFile;
    }

    public void setNumErrorCollectedFile(Integer numErrorCollectedFile) {
        this.numErrorCollectedFile = numErrorCollectedFile;
    }

    public Integer getNumExportedRequest() {
        return numExportedRequest;
    }

    public void setNumExportedRequest(Integer numExportedRequest) {
        this.numExportedRequest = numExportedRequest;
    }

    public Long getSizeExportedCSVFile() {
        return sizeExportedCSVFile;
    }

    public void setSizeExportedCSVFile(Long sizeExportedCSVFile) {
        this.sizeExportedCSVFile = sizeExportedCSVFile;
    }

    public Integer getNumExportedUser() {
        return numExportedUser;
    }

    public void setNumExportedUser(Integer numExportedUser) {
        this.numExportedUser = numExportedUser;
    }
}
