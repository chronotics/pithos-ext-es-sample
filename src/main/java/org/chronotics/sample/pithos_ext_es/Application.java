package org.chronotics.sample.pithos_ext_es;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.util.Strings;
import org.chronotics.pandora.java.converter.ConverterUtil;
import org.chronotics.pandora.java.exception.ExceptionUtil;
import org.chronotics.pandora.java.file.CSVUtil;
import org.chronotics.pandora.java.file.FileUtil;
import org.chronotics.pandora.java.log.Logger;
import org.chronotics.pandora.java.log.LoggerFactory;
import org.chronotics.pithos.ext.es.adaptor.ElasticService;
import org.chronotics.pithos.ext.es.model.*;
import org.chronotics.pithos.ext.es.util.ESFilterOperationConstant;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.BucketOrder;
import org.elasticsearch.search.aggregations.bucket.filter.InternalFilter;
import org.elasticsearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;
import org.elasticsearch.search.aggregations.bucket.histogram.DateHistogramInterval;
import org.elasticsearch.search.aggregations.bucket.histogram.InternalDateHistogram;
import org.elasticsearch.search.aggregations.bucket.terms.LongTerms;
import org.elasticsearch.search.aggregations.bucket.terms.StringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.sum.InternalSum;
import org.elasticsearch.search.aggregations.metrics.sum.SumAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.valuecount.ValueCountAggregationBuilder;
import org.joda.time.DateTime;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteOrder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Application {
    private static Logger log = LoggerFactory.getLogger(Application.class);

    static String strIndex = "thela-data_20181129";
    static String strType = "thela";

    public static void main(String[] args) {
        String strESHost = "192.168.0.56";
        Integer intESPort = 9319;
        String strESClusterName = "docker-cluster";
//        String strTransportUsername = "java_client_transport";
//        String strTransportPassword = "brique0901#$";

        String strTransportUsername = "";
        String strTransportPassword = "";

        ElasticService objESConnection = ElasticService.getInstance(strESClusterName, strESHost, intESPort, strTransportUsername, strTransportPassword);

        //prepBulkFieldAction(objESConnection);
        //prepBulkFormatAction(objESConnection);
        //statsMatrix(objESConnection);
        //exportCSV(objESConnection);



        //statIndex(objESConnection);
        //changeDataType(objESConnection);
        //filterIndex(objESConnection);
        //prepBulkStatsAction(objESConnection);
        //prepBulkSamplingAction(objESConnection);
        //prepBulkArithmeticAction(objESConnection);
        //exportCSVWithIndexPattern(objESConnection);

        /*
         Create index and insert data to index
         */
        createIndexAndBulkInsert(objESConnection);

        /*
         Create index and insert array data to index
         */
        //insertArrayDataToES(objESConnection);

        /*
        Aggregation with custom filter
         */
        //statCustomAgg(objESConnection);
    }

    public static void insertArrayDataToES(ElasticService objESConnection) {
        String strCurIndex = "test_array_index";
        String strCurType = "_doc";

        List<ArrayModel> lstArrayModel = new ArrayList<>();
        Random objRandom = new Random();

        for (int intCountItem = 0; intCountItem < 100; intCountItem++) {
            String strSeed = "TEST_" + String.valueOf(intCountItem);
            ArrayModel objModel = new ArrayModel();
            objModel.setArr_double(new HashSet<>());
            objModel.setArr_int(new int[100000]);
            objModel.setArr_str(new ArrayList<>());

            for (int intCount = 0; intCount < 100000; intCount++) {
                String strStr = strSeed + "_" + String.valueOf(intCount);
                Integer intInt = objRandom.nextInt(1000000);
                Double dbDb = objRandom.nextDouble();

                objModel.getArr_double().add(dbDb);
                objModel.getArr_int()[intCount] = intInt;
                objModel.getArr_str().add(strStr);
            }

            lstArrayModel.add(objModel);
        }

        objESConnection.insertBulkData(strCurIndex, strCurType, lstArrayModel, "", null, true, "");
    }

    public static void exportCSVWithRFText(ElasticService objESConnection) {
        String strThelaHeaderIndex = "thela-header-rftest_*";
        String strThelaDataIndex = "thela-rftest_*";
        String strType = "thela";

        ESFilterAllRequestModel objFilterAllRequestModel = new ESFilterAllRequestModel();
        objFilterAllRequestModel.setIs_reversed(false);

        ESFilterRequestModel objFilterModel = new ESFilterRequestModel();
        objFilterModel.setFiltered_operation(ESFilterOperationConstant.IS);
        objFilterModel.setFiltered_on_field("site");

        List<Object> lstCondition = new ArrayList<>();
        lstCondition.add("THNW001");

        objFilterModel.setFiltered_conditions(lstCondition);

        List<ESFilterRequestModel> lstFilterModel = Arrays.asList(objFilterModel);
        objFilterAllRequestModel.setFilters(lstFilterModel);

        List<ESFileModel> lstExportFile = objESConnection.exportESTransposeDataToCSV(strThelaHeaderIndex, strType, strThelaDataIndex, strType,
                "header_id", "header_id", Arrays.asList("param_id", "special_id"), "_", Arrays.asList("value", "value_str"),
                500000, null, objFilterAllRequestModel, "/home/brique/Documents/export_es/data_rf.csv");

        log.info("Total: " + lstExportFile.get(0).getProcessed_time());
    }

    public static void exportCSVWithIndexPattern(ElasticService objESConnection) {
        //String strCurIndex = "index_na_*";

        //List<ESFileModel> lstExportFile = objESConnection.exportESDataToCSV(strCurIndex, strType, "/home/brique/Documents/export_es/data.csv", 100, null, false, 10);
        String strThelaHeaderIndex = "thela-header-data_*";
        String strThelaDataIndex = "thela-data_*";
        String strThelaParam = "thela-param";
        String strType = "thela";

        ESFilterAllRequestModel objFilterAllRequestModel = new ESFilterAllRequestModel();
        objFilterAllRequestModel.setIs_reversed(false);

        ESFilterRequestModel objFilterModel = new ESFilterRequestModel();
        objFilterModel.setFiltered_operation(ESFilterOperationConstant.IS);
        objFilterModel.setFiltered_on_field("pcb_no");

        List<Object> lstPCB = new ArrayList<>();

//        Integer intCountPCB = -1;
//        Integer intCountCur = 0;
//        String strPCBPattern = "";
//
//        for (int intCount = 0; intCount < 100; intCount++) {
//            if (intCount % 56 == 0) {
//                intCountPCB += 1;
//
//                if (intCountPCB == 0) {
//                    strPCBPattern = "SWE430J1M00BKT51-7";
//                } else if (intCountPCB == 1) {
//                    strPCBPattern = "SWE430J1M00BKT51-8";
//                } else {
//                    strPCBPattern = "SWE430J1M00BKT51-9";
//                }
//
//                intCountCur = 1;
//            }
//
//            lstPCB.add(strPCBPattern + "-" + intCountCur);
//            intCountCur += 1;
//        }
        lstPCB.add("SWE430J1I008YB02");
        objFilterModel.setFiltered_conditions(lstPCB);

        List<ESFilterRequestModel> lstFilterModel = Arrays.asList(objFilterModel);
        objFilterAllRequestModel.setFilters(lstFilterModel);

        String strField = "header_id,smd_type,pcb_no,eqp_id,site,image_path,product_id,ftp_file_name,created_date,segment_id,offset angle_deg_,board edge offset left side_um_,offset width_%_,offset length_%_,offset width_um_,offset y_um_,offset x_um_,offset length_um_";
        String[] arrField = strField.split(",");
        List<String> lstPredefineHeader = Arrays.asList(arrField);

        List<ESFileModel> lstExportFile = objESConnection.exportESMasterDetailDataToCSV(strThelaHeaderIndex, strType, strThelaDataIndex, strType, "header_id", "header_id", 10000,
                lstPredefineHeader, null, objFilterAllRequestModel, "/home/brique/Documents/export_es/data.csv", false, 10000);

        log.info("Total: " + lstExportFile.get(0).getProcessed_time());
    }

    public static void statCustomAgg(ElasticService objElasticService) {
        String strFileStatusIndex = "spi-user-history";
        String strDataGeneratorType = "management";
        String strFieldDateCSV = "requestDateUTC";

        Calendar dtFrom = Calendar.getInstance();
        Calendar dtTo = Calendar.getInstance();

        dtFrom.add(Calendar.DAY_OF_MONTH, -2);

        HashMap<Long, FileStatisticModel> mapStat = new HashMap<>();

        if (mapStat == null) {
            mapStat = new HashMap<>();
        }

        String strDateFormat = "yyyy-MM-dd";
        SimpleDateFormat objDateFormat = new SimpleDateFormat(strDateFormat);
        String strFieldSizeExport = "fileSize";
        String strFieldUserExport = "userId";
        Integer intTermSize = 100000000;

        DateHistogramAggregationBuilder objDateHistogram = AggregationBuilders.dateHistogram("date_histogram").dateHistogramInterval(DateHistogramInterval.DAY)
                .field(strFieldDateCSV)
                .format(strDateFormat)
                .minDocCount(1)
                .order(BucketOrder.key(false));
        TermsAggregationBuilder objTermBuilder = AggregationBuilders.terms("filter_by_request").field(strFieldDateCSV).size(intTermSize);
        TermsAggregationBuilder objUserTermBuilder = AggregationBuilders.terms("filter_by_user").field(strFieldUserExport).size(intTermSize);
        ValueCountAggregationBuilder objCountRequestBuilder = AggregationBuilders.count("count_request").field(strFieldDateCSV);
        SumAggregationBuilder objSizeExportedBuilder = AggregationBuilders.sum("sum_size_by_request").field(strFieldSizeExport);

        objTermBuilder.subAggregation(objCountRequestBuilder);
        objTermBuilder.subAggregation(objSizeExportedBuilder);
        objDateHistogram.subAggregation(objTermBuilder);
        objDateHistogram.subAggregation(objUserTermBuilder);

        RangeQueryBuilder objRangeQueryBuilder = QueryBuilders.rangeQuery(strFieldDateCSV)
                .from(objDateFormat.format(dtFrom.getTime()), true)
                .to(objDateFormat.format(dtTo.getTime()), true)
                .format(strDateFormat);

        SearchResponse objAggResponse = objElasticService.getCustomAggregationValue(strFileStatusIndex, strDataGeneratorType, objRangeQueryBuilder, objDateHistogram);

        if (objAggResponse != null && objAggResponse.getAggregations() != null && objAggResponse.getAggregations().asList() != null) {
            List<Aggregation> lstAggs = objAggResponse.getAggregations().asList();

            for (int intCount = 0; intCount < lstAggs.size(); intCount++) {
                if (lstAggs.get(intCount).getName().equals("date_histogram")) {
                    InternalDateHistogram objReturnDateHistogram = (InternalDateHistogram) lstAggs.get(intCount);

                    if (objReturnDateHistogram.getBuckets() != null && objReturnDateHistogram.getBuckets().size() > 0) {
                        for (int intCountBucket = 0; intCountBucket < objReturnDateHistogram.getBuckets().size(); intCountBucket++) {
                            InternalDateHistogram.Bucket objCurDateBucket = objReturnDateHistogram.getBuckets().get(intCountBucket);

                            String strCurDate = objCurDateBucket.getKeyAsString();
                            Long lCurDate = ((DateTime) objCurDateBucket.getKey()).getMillis();
                            Integer intTotalRequest = 0;
                            Long lTotalFileSize = 0L;
                            Integer intTotalUser = 0;

                            if (objCurDateBucket.getAggregations() != null && objCurDateBucket.getAggregations().asList() != null) {
                                List<Aggregation> lstDateAggs = objCurDateBucket.getAggregations().asList();

                                for (int intCountDate = 0; intCountDate < lstDateAggs.size(); intCountDate++) {
                                    if (lstDateAggs.get(intCountDate).getName().equals("filter_by_request")) {
                                        LongTerms objReturnRequestFilter = (LongTerms) lstDateAggs.get(intCountDate);

                                        if (objReturnRequestFilter != null && objReturnRequestFilter.getBuckets().size() > 0) {
                                            intTotalRequest += objReturnRequestFilter.getBuckets().size();

                                            for (int intCountDateBucket = 0; intCountDateBucket < objReturnRequestFilter.getBuckets().size(); intCountDateBucket++) {
                                                LongTerms.Bucket objCurFilterBucket = objReturnRequestFilter.getBuckets().get(intCountDateBucket);

                                                List<Aggregation> lstStatusAggs = objCurFilterBucket.getAggregations().asList();

                                                for (int intCountStatus = 0; intCountStatus < lstStatusAggs.size(); intCountStatus++) {
                                                    if (lstStatusAggs.get(intCountStatus).getName().equals("sum_size_by_request")) {
                                                        InternalSum objSum = (InternalSum) lstStatusAggs.get(intCountStatus);
                                                        lTotalFileSize += (long) objSum.getValue();
                                                    }

                                                    if (lstStatusAggs.get(intCountStatus).getName().equals("sum_size_by_status")) {
                                                        InternalSum objSum = (InternalSum) lstStatusAggs.get(intCountStatus);
                                                        lTotalFileSize += (long) objSum.getValue();
                                                    }
                                                }
                                            }
                                        }
                                    } else if (lstDateAggs.get(intCountDate).getName().equals("filter_by_user")) {
                                        StringTerms objReturnRequestFilter = (StringTerms) lstDateAggs.get(intCountDate);

                                        if (objReturnRequestFilter != null && objReturnRequestFilter.getBuckets().size() > 0) {
                                            intTotalUser += objReturnRequestFilter.getBuckets().size();
                                        }
                                    }
                                }

                                FileStatisticModel objModel = new FileStatisticModel();

                                if (mapStat.containsKey(lCurDate)) {
                                    objModel = mapStat.get(lCurDate);
                                }

                                objModel.setStatDate(strCurDate);
                                objModel.setNumExportedRequest(intTotalRequest);
                                objModel.setSizeExportedCSVFile(lTotalFileSize);
                                objModel.setNumExportedUser(intTotalUser);

                                mapStat.put(lCurDate, objModel);
                            }
                        }

                        break;
                    }
                }
            }
        }

        Integer intSize = mapStat.size();
    }

    public static void changeDataType(ElasticService objESConnection) {
        String strCurIndex = "index_na_1";

        //Change to double
        Calendar objCurrentTime = Calendar.getInstance();
        String strNewFieldName = String.valueOf(objCurrentTime.getTimeInMillis());

        log.info("strNewFieldName: " + strNewFieldName);

        List<ESPrepAbstractModel> lstPrepAction = new ArrayList<ESPrepAbstractModel>();

        ESPrepDataTypeChangeModel objPrepModel = new ESPrepDataTypeChangeModel();
        objPrepModel.setIndex(strCurIndex);
        objPrepModel.setType(strType);
        objPrepModel.setNew_field_name("Ozone_" + strNewFieldName);
        objPrepModel.setIs_forced(true);
        objPrepModel.setField("Ozone");
        objPrepModel.setConverted_data_type(ESFilterOperationConstant.DATA_TYPE_DOUBLE);
        objPrepModel.setFailed_default_value("0.0");

        lstPrepAction.add(objPrepModel);

        objESConnection.prepESData(lstPrepAction);

        //Change to string
        objCurrentTime = Calendar.getInstance();
        String strStrNewFieldName = String.valueOf(objCurrentTime.getTimeInMillis());

        log.info("strNewFieldName: " + strStrNewFieldName);

        lstPrepAction = new ArrayList<ESPrepAbstractModel>();

        objPrepModel = new ESPrepDataTypeChangeModel();
        objPrepModel.setIndex(strCurIndex);
        objPrepModel.setType(strType);
        objPrepModel.setNew_field_name("Ozone_" + strStrNewFieldName);
        objPrepModel.setIs_forced(true);
        objPrepModel.setField("Ozone" + strNewFieldName);
        objPrepModel.setConverted_data_type(ESFilterOperationConstant.DATA_TYPE_TEXT);
        objPrepModel.setFailed_default_value("NA");

        lstPrepAction.add(objPrepModel);

        objESConnection.prepESData(lstPrepAction);
    }

    public static void filterIndex(ElasticService objESConnection) {
//        String strNewNAIndex = "index_na_1";
//        ESFilterAllRequestModel objFilterAllRequestModel = new ESFilterAllRequestModel();
//        objFilterAllRequestModel.setIs_reversed(true);
//
//        ESFilterRequestModel objFilterModel = new ESFilterRequestModel();
//        objFilterModel.setFiltered_operation(ESFilterOperationConstant.IS_BETWEEN);
//        objFilterModel.setFiltered_on_field("Ozone_1541381171820");
//        objFilterModel.setFiltered_conditions(Arrays.asList(ESFilterOperationConstant.FILTER_LCL_UCL));
//
//        List<ESFilterRequestModel> lstFilterModel = Arrays.asList(objFilterModel);
//        objFilterAllRequestModel.setFilters(lstFilterModel);

        HashMap<String, Object> mapSearch = objESConnection.searchDataWithFieldIdxAndRowIdx(strIndex, strType, "", null, 0, 10, 0, 0, 0, null);

        ObjectMapper objMapper = new ObjectMapper();

        try {
            String strSearch = objMapper.writeValueAsString(mapSearch);

            log.info("Result: " + strSearch);
        } catch (Exception objEx) {
        }
    }

    public static void statIndex(ElasticService objESConnection) {
        String strNewNAIndex = "index_null";
        HashMap<String, Object> mapSearch = objESConnection.searchDataWithFieldIdxAndRowIdx(strNewNAIndex, strType, "", null, 0, 10, 0, 0, 1, null);

        ObjectMapper objMapper = new ObjectMapper();

        try {
            String strSearch = objMapper.writeValueAsString(mapSearch);

            log.info("Result: " + strSearch);
        } catch (Exception objEx) {
        }
    }

    public static void exportCSV(ElasticService objESConnection) {
        strIndex = "task_index_16147_1070_3";
        strType = "data";
        objESConnection.exportESDataToCSV(strIndex, strType, "/home/brique/Downloads/a.csv", 20000);
    }

    public static void prepBulkFieldAction(ElasticService objESConnection) {
        Calendar objCurrentTime = Calendar.getInstance();
        String strNewFieldName = String.valueOf(objCurrentTime.getTimeInMillis());

        log.info("strNewFieldName: " + strNewFieldName);

        List<ESPrepAbstractModel> lstPrepAction = new ArrayList<ESPrepAbstractModel>();

        ESPrepFieldModel objPrepModel = new ESPrepFieldModel();
        List<String> lstRemove = new ArrayList<>();
        lstRemove.add("lot_cd_1540711150272");
        lstRemove.add("cos_x_pos");
        objPrepModel.setRemove_fields(lstRemove);
        objPrepModel.setIndex(strIndex);
        objPrepModel.setType(strType);

        lstPrepAction.add(objPrepModel);

        objESConnection.prepESData(lstPrepAction);
    }

    public static void prepBulkFieldMultipleAction(ElasticService objESConnection) {
        Calendar objCurrentTime = Calendar.getInstance();
        String strNewFieldName = String.valueOf(objCurrentTime.getTimeInMillis());

        log.info("strNewFieldName: " + strNewFieldName);

        List<ESPrepAbstractModel> lstPrepAction = new ArrayList<ESPrepAbstractModel>();

        ESPrepFieldModel objPrepModel = new ESPrepFieldModel();
        List<String> lstRemove = new ArrayList<>();
        lstRemove.add("lot_cd_1540711150272");
        lstRemove.add("cos_x_pos");
        objPrepModel.setRemove_fields(lstRemove);
        objPrepModel.setIndex(strIndex);
        objPrepModel.setType(strType);

        lstPrepAction.add(objPrepModel);

        objESConnection.prepESData(lstPrepAction);
    }

    public static void prepBulkArithmeticAction(ElasticService objESConnection) {
        Calendar objCurrentTime = Calendar.getInstance();
        String strNewFieldName = String.valueOf(objCurrentTime.getTimeInMillis());

        String strCurIndex = "index_na_1";

        log.info("strNewFieldName: " + strNewFieldName);

        List<ESPrepAbstractModel> lstPrepAction = new ArrayList<ESPrepAbstractModel>();

        ESPrepFunctionArithmeticModel objPrepModel = new ESPrepFunctionArithmeticModel();
        objPrepModel.setArithmetic_op(ESFilterOperationConstant.FUNCTION_ARITHMETIC_FORMULA);
        objPrepModel.setArithmetic_param_1("#sin($Month$) * ($Wind$ + $Temp$)");
        objPrepModel.setNew_field_name("formula_" + strNewFieldName);
        objPrepModel.setIndex(strCurIndex);
        objPrepModel.setType(strType);

        lstPrepAction.add(objPrepModel);

        objESConnection.prepESData(lstPrepAction);
    }

    public static void prepBulkFormatAction(ElasticService objESConnection) {
        Calendar objCurrentTime = Calendar.getInstance();
        String strNewFieldName = String.valueOf(objCurrentTime.getTimeInMillis());

        log.info("strNewFieldName: " + strNewFieldName);

        List<ESPrepAbstractModel> lstPrepAction = new ArrayList<ESPrepAbstractModel>();

        ESPrepFormatModel objPrepModel = new ESPrepFormatModel();
        objPrepModel.setField("lot_cd");
        objPrepModel.setFormat_op(ESFilterOperationConstant.DATA_FORMAT_LOWERCASE);
        objPrepModel.setNew_field_name(objPrepModel.getField() + "_" + strNewFieldName);
        objPrepModel.setIndex(strIndex);
        objPrepModel.setType(strType);

        lstPrepAction.add(objPrepModel);

        objESConnection.prepESData(lstPrepAction);
    }

    public static void statsMatrix(ElasticService objESConnection) {
        List<String> lstSelectedField = new ArrayList<>();
        lstSelectedField.add("x_pos");

        List<Object> lstCondition = new ArrayList<>();
        lstCondition.add("0.0");

        ESFilterRequestModel objFilter = new ESFilterRequestModel();
        objFilter.setFiltered_conditions(lstCondition);
        objFilter.setFiltered_operation(ESFilterOperationConstant.CORRELATION);

        List<ESFilterRequestModel> lstRequestFilter = new ArrayList<>();
        lstRequestFilter.add(objFilter);

        ESFilterAllRequestModel objAllRequest = new ESFilterAllRequestModel();

        objAllRequest.setSelected_fields(lstSelectedField);
        objAllRequest.setFilters(lstRequestFilter);
        objAllRequest.setIs_reversed(false);

        ESMatrixStatModel objMatrixStat = objESConnection.statsMatrix(strIndex, strType, objAllRequest);

        log.info("INFO: " + objMatrixStat.toString());
    }

    public static void createIndexAndBulkInsert(ElasticService objESConnection) {
        String strNAFilePath = "/home/brique/Downloads/airquality_NA.csv";
        String strNullFilePath = "/home/brique/Downloads/test_NULL.csv";
        String strNewNAIndex = "index_na";

        //Data can be HashMap or Java Object
        //List<HashMap<String, Object>> lstNAData = CSVUtil.readCSV(strNAFilePath);

        HashMap<String, Object> curItem = new HashMap<>();
        List<HashMap<String, Object>> lstSubItem = new ArrayList<>();
        HashMap<String, Object> curSubItem = new HashMap<>();

        curSubItem.put("sub_field_1", "value_1");
        curSubItem.put("sub_field_2", "value_2");

        lstSubItem.add(curSubItem);

        curSubItem.put("sub_field_1", "value_1_2");
        curSubItem.put("sub_field_2", "value_2_2");

        lstSubItem.add(curSubItem);

        curItem.put("field_1", "value X");
        curItem.put("field_2", lstSubItem);

        List<HashMap<String, Object>> lstNAData = new ArrayList<>();
        lstNAData.add(curItem);
        lstNAData.add(curItem);


        //Create index and insert data to index
        objESConnection.insertBulkData(strNewNAIndex, strType, lstNAData, "", null, true, "");

        //Only create index
        //objESConnection.createIndex(strNewNAIndex, strType, lstNAData, "", null, false);

        //Get all fields of created index
        //List<ESFieldModel> lstFieldModel = objESConnection.getFieldsMetaData(strNewNAIndex, strType, null, false);
    }

    public static void prepBulkStatsAction(ElasticService objESConnection) {
        Calendar objCurrentTime = Calendar.getInstance();
        String strNewFieldName = String.valueOf(objCurrentTime.getTimeInMillis());

        log.info("strNewFieldName: " + strNewFieldName);

        List<ESPrepAbstractModel> lstPrepAction = new ArrayList<ESPrepAbstractModel>();

        String strCurIndex = "index_na_1";

        ESPrepFunctionStatisticModel objPrepModel = new ESPrepFunctionStatisticModel();
        objPrepModel.setNew_field_name("wind_norm_" + strNewFieldName);
        objPrepModel.setSelected_field(Arrays.asList("Wind"));
        objPrepModel.setStatistic_op(ESFilterOperationConstant.FUNCTION_STATISTICS_NORM);
        objPrepModel.setIndex(strCurIndex);
        objPrepModel.setType(strType);

        lstPrepAction.add(objPrepModel);

        objESConnection.prepESData(lstPrepAction);
    }

    public static void prepBulkSamplingAction(ElasticService objESConnection) {
        Calendar objCurrentTime = Calendar.getInstance();
        String strNewFieldName = String.valueOf(objCurrentTime.getTimeInMillis());

        log.info("strNewFieldName: " + strNewFieldName);

        List<ESPrepAbstractModel> lstPrepAction = new ArrayList<ESPrepAbstractModel>();

        String strCurIndex = "index_na_1";

        ESPrepFunctionSamplingModel objPrepModel = new ESPrepFunctionSamplingModel();
        objPrepModel.setNum_of_rows(-1L);
        objPrepModel.setSampling_op(ESFilterOperationConstant.FUNCTION_SAMPLING_DIST_CONTINUOUS);
        objPrepModel.setSelected_fields(new ArrayList<>());
        objPrepModel.setNew_fields(Arrays.asList("Auto_samp_continuous_" + strNewFieldName));
        objPrepModel.setDefined_values(Arrays.asList(0.0, 1.0));
        objPrepModel.setIndex(strCurIndex);
        objPrepModel.setType(strType);

        lstPrepAction.add(objPrepModel);

        objESConnection.prepESData(lstPrepAction);
    }

    public static void readKITECHFile(ElasticService objESConnection, String strFilePath) {
        List<ESKITECHDataModel> lstKITECHData = new ArrayList<>();
        Integer intCurBlock = 0;
        Short shortCurMainNC = 0;
        Short shortCurSubNC = 0;
        Integer intCurBlockIdx = 0;

        List<ESKITECHDataModel> lstCurBlockData = new ArrayList<>();
        List<ESKITECHAggDataModel> lstAggKITECHData = new ArrayList<>();

        String strIndex = "kitech-data-temp";
        String strAggIndex = "kitech-agg-temp";
        String strType = "kitech";
        String strEquipmentId = strFilePath.contains("2018_09_28_12_55_54.dat") ?
                "12" : (strFilePath.contains("2018_11_15_11_53_12") ?
                "02" : (strFilePath.contains("2018_12_01_09_42_52") ?
                "08" : (strFilePath.contains("2018_12_09_14_26_05") ? "15" : (strFilePath.contains("2018_12_07_05_43_06") ? "01" : "03"))));

        String strDate = "20181201";
        String strDateFormat = "yyyyMMdd";
        String strESDateFormat = "yyyyMMdd HH:mm:ss:SSS";
        SimpleDateFormat objDateFormat = new SimpleDateFormat(strESDateFormat);

        try (BufferedInputStream objBufferedInputStream = new BufferedInputStream(new FileInputStream(strFilePath))) {
            Long lCurOffset = 0L;
            Boolean bIsContinue = true;

            while (bIsContinue) {
                HashMap<String, byte[]> mapCurByte = FileUtil.readStreamFileWithBuffer(objBufferedInputStream, lCurOffset, KITECHModel.OBJECT_BYTE_LENGTH, KITECHModel.FIELD_OFFSET_MAP);

                if (mapCurByte != null && mapCurByte.size() == KITECHModel.FIELD_OFFSET_MAP.size()) {
                    bIsContinue = true;
                    lCurOffset += KITECHModel.OBJECT_BYTE_LENGTH;

                    KITECHModel objModel = new KITECHModel();
                    ESKITECHDataModel objESModel = new ESKITECHDataModel();

                    for (Map.Entry<String, byte[]> curFieldBytes : mapCurByte.entrySet()) {
                        objModel.setField(curFieldBytes.getKey(), curFieldBytes.getValue());
                    }

                    for (Map.Entry<String, byte[]> curFieldBytes : mapCurByte.entrySet()) {
                        objESModel.setField(curFieldBytes.getKey(), objModel.getField(curFieldBytes.getKey()));
                    }

                    String strCurDate = strDate + " " + String.format("%02d", objModel.getHh()) + String.format(":%02d", objESModel.getMm()) + String.format(":%02d", objESModel.getSs()) + String.format(":%03d", objESModel.getMs());
                    Date objCurDate = objDateFormat.parse(strCurDate);
                    objESModel.setCreateDate(objCurDate);
                    objESModel.setEquipmentId(strEquipmentId);
                    objESModel.setFilename(new File(strFilePath).getName());

                    lstKITECHData.add(objESModel);

                    if (!intCurBlock.equals(objModel.blockNo) || !shortCurSubNC.equals(objModel.subNo) || !shortCurMainNC.equals(objModel.mainNo)) {
                        if (lstCurBlockData != null && lstCurBlockData.size() > 0) {
                            intCurBlockIdx += 1;
                            List<ESKITECHAggDataModel> lstReturn = aggKITECHBlockData(objESConnection, strAggIndex, strType, lstCurBlockData, intCurBlockIdx);

                            if (lstReturn != null) {
                                lstAggKITECHData.addAll(lstReturn);
                            }
                        }

                        intCurBlock = objModel.blockNo;
                        shortCurSubNC = objModel.subNo;
                        shortCurMainNC = objModel.mainNo;
                        lstCurBlockData = new ArrayList<>();
                        lstCurBlockData.add(objESModel);
                    } else {
                        lstCurBlockData.add(objESModel);
                    }
                } else {
                    bIsContinue = false;

                    if (lstCurBlockData != null && lstCurBlockData.size() > 0) {
                        intCurBlockIdx += 1;
                        List<ESKITECHAggDataModel> lstReturn = aggKITECHBlockData(objESConnection, strAggIndex, strType, lstCurBlockData, intCurBlockIdx);

                        if (lstReturn != null) {
                            lstAggKITECHData.addAll(lstReturn);
                        }
                    }
                }
            }

            objESConnection.insertBulkData(strIndex, strType, lstKITECHData, "createDate", null, true, "");
            objESConnection.insertBulkData(strAggIndex, strType, lstAggKITECHData, "startedDate", null, true, "");
        } catch (Exception objEx) {
            log.error("ERR: " + ExceptionUtil.getStrackTrace(objEx));
        }
    }

    public static void readKITECHFile2(String strFilePath) {
        List<ESDataModel> lstData = new ArrayList<>();

        try {
            ObjectMapper mapper = new ObjectMapper();

            Integer intCurBlock = 0;
            Short shortCurMainNC = 0;
            Short shortCurSubNC = 0;
            Integer intCurBlockIdx = 0;

            List<ESDataModel> lstCurBlockData = new ArrayList<>();
            List<ESAggDataModel> lstAggData = new ArrayList<>();

            log.info("Parsing... ");

            //filename: 012018_12_07_05_43_06.dat
            SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
            //Date date = format.parse(strFilePath.split("\\.")[0]);
            try (BufferedInputStream objBufferedInputStream = new BufferedInputStream(
                    new FileInputStream(strFilePath))) {
                Long lCurOffset = 0L;
                Boolean bIsContinue = true;

                while (bIsContinue) {
                    HashMap<String, byte[]> mapCurByte = FileUtil
                            .readStreamFileWithBuffer(objBufferedInputStream, lCurOffset,
                                    RawDataModel.OBJECT_BYTE_LENGTH, RawDataModel.FIELD_OFFSET_MAP);

                    if (mapCurByte != null && mapCurByte.size() == RawDataModel.FIELD_OFFSET_MAP.size()) {
                        bIsContinue = true;
                        lCurOffset += RawDataModel.OBJECT_BYTE_LENGTH;

                        RawDataModel objModel = new RawDataModel();
                        ESDataModel convertModel = new ESDataModel();

                        for (Map.Entry<String, byte[]> curFieldBytes : mapCurByte.entrySet()) {
                            objModel.setField(curFieldBytes.getKey(), curFieldBytes.getValue());
                        }

                        for (Map.Entry<String, byte[]> curFieldBytes : mapCurByte.entrySet()) {
                            convertModel.setField(curFieldBytes.getKey(), objModel.getField(curFieldBytes.getKey()));
                        }

                        lstData.add(convertModel);

                    } else {
                        bIsContinue = false;
                    }
                }
            } catch (Exception objEx) {
                log.error("ERR: " + ExceptionUtil.getStrackTrace(objEx));
            }
        } catch (Exception objEx) {
            log.error("ERR: " + ExceptionUtil.getStrackTrace(objEx));
        }

        String str = "";
    }

    private static List<ESKITECHAggDataModel> aggKITECHBlockData(ElasticService objESConnection, String strIndex, String strType, List<ESKITECHDataModel> lstCurData, Integer intCurBlockIdx) {
        HashMap<String, ESKITECHAggDataModel> mapAggData = new HashMap<>();
        List<String> lstAggType = Arrays.asList("avg", "med", "min", "max", "var", "range");

        for (int intCount = 0; intCount < lstAggType.size(); intCount++) {
            ESKITECHAggDataModel objMinResult = mapAggData.containsKey("min") ? mapAggData.get("min") : null;
            ESKITECHAggDataModel objMaxResult = mapAggData.containsKey("max") ? mapAggData.get("max") : null;
            ESKITECHAggDataModel objAvgResult = mapAggData.containsKey("avg") ? mapAggData.get("avg") : null;

            ESKITECHAggDataModel objAggResult = aggKITECHDATAWithField(lstAggType.get(intCount), lstCurData, objMinResult, objMaxResult, objAvgResult);
            objAggResult.setSummaryType(lstAggType.get(intCount));
            objAggResult.setStartedDate(lstCurData.get(0).createDate);
            objAggResult.setEndedDate(lstCurData.get(lstCurData.size() - 1).createDate);

            for (Map.Entry<String, String> curItem : ESKITECHDataModel.FIELD_MAP.entrySet()) {
                if (ESKITECHAggDataModel.FIELD_MAP.containsKey(curItem.getValue())
                        && !ESKITECHAggDataModel.FIELD_AGG_MAP.containsKey(curItem.getValue())) {
                    objAggResult.setField(curItem.getValue(), lstCurData.get(0).getField(curItem.getValue()));
                }
            }

            String strBlockId = new StringBuilder().append(objAggResult.getEquipmentId()).append("/")
                    .append(objAggResult.getMainNo()).append("/").append(objAggResult.getSubNo()).append("/")
                    .append(objAggResult.getBlockNo()).toString();

            objAggResult.setBlockId(strBlockId);
            objAggResult.setBlockIdx(intCurBlockIdx);

            mapAggData.put(lstAggType.get(intCount), objAggResult);
        }

        if (mapAggData != null) {
            List<ESKITECHAggDataModel> lstAggData = mapAggData.values().stream().collect(Collectors.toList());

            return lstAggData;
        } else {
            return null;
        }
    }

    private static ESKITECHAggDataModel aggKITECHDATAWithField(String strAggType, List<ESKITECHDataModel> lstData,
                                                               ESKITECHAggDataModel objMin,
                                                               ESKITECHAggDataModel objMax,
                                                               ESKITECHAggDataModel objAvg) {
        ESKITECHAggDataModel objAggResult = new ESKITECHAggDataModel();

        for (Map.Entry<String, String> curStatField : ESKITECHAggDataModel.FIELD_AGG_MAP.entrySet()) {
            Float fAggValue = null;

            try {
                List<Float> lstFieldData = lstData.stream()
                        .filter(curData -> curData.getField(curStatField.getKey()) != null)
                        .map(curData -> (float) curData.getField(curStatField.getKey()))
                        .collect(Collectors.toList());

                if (lstFieldData != null && lstFieldData.size() > 1) {
                    switch (strAggType) {
                        case "avg":
                            fAggValue = (float) lstFieldData.stream().mapToDouble(item -> item).average().getAsDouble();
                            break;
                        case "med":
                            DoubleStream streamDouble = lstFieldData.stream().mapToDouble(item -> item).sorted();
                            fAggValue = (float) (lstFieldData.size() % 2 == 0 ?
                                    streamDouble.skip(lstFieldData.size() / 2 - 1).limit(2).average().getAsDouble() :
                                    streamDouble.skip(lstFieldData.size() / 2).findFirst().getAsDouble());
                            break;
                        case "min":
                            fAggValue = (float) lstFieldData.stream().mapToDouble(item -> item).min().getAsDouble();
                            break;
                        case "max":
                            fAggValue = (float) lstFieldData.stream().mapToDouble(item -> item).max().getAsDouble();
                            break;
                        case "var":
                            Float fAvg = (float) objAvg.getField(curStatField.getKey());

                            if (fAvg != null) {
                                fAggValue = (float) lstFieldData.stream().mapToDouble(curItem -> Math.pow(curItem.doubleValue() - fAvg.doubleValue(), 2)).sum() / (lstFieldData.size() - 1);
                            } else {
                                fAggValue = null;
                            }
                            break;
                        case "range":
                            Float fMin = (float) objMin.getField(curStatField.getKey());
                            Float fMax = (float) objMax.getField(curStatField.getKey());

                            if (fMax != null && fMin != null) {
                                fAggValue = fMax - fMin;
                            } else {
                                fAggValue = null;
                            }
                            break;
                        default:
                            break;
                    }
                } else {
                    fAggValue = lstFieldData.get(0);
                }
            } catch (Exception objEx) {
                fAggValue = null;
            }

            if (fAggValue != null && (fAggValue.equals(Float.NaN) || fAggValue.equals(Float.NEGATIVE_INFINITY) || fAggValue.equals(Float.POSITIVE_INFINITY))) {
                fAggValue = null;
            }

            objAggResult.setField(curStatField.getKey(), fAggValue);
        }

        return objAggResult;
    }
}
