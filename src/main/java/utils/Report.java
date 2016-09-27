/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import reports.UserReport;
/**
 *
 * @author willyaguirre
 */
public class Report {
    
    public Report(){}
    
    Log log = new Log();
    
    public byte[] generate(String jasperFile, Collection<?> source) throws Exception {
        byte[] file = null;
        log.status("DEBUG", UserReport.class, "START REPORT ...");
        String sourceFileName = jasperFile;
        Map<String, Object> parameters = new HashMap();
        try {
            JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(source);
            JasperPrint print = JasperFillManager.fillReport(sourceFileName, parameters, data);
            log.status("DEBUG", UserReport.class, "REPORT: " + print.getName());
            file = JasperExportManager.exportReportToPdf(print);
        } catch (Exception e) {
            log.status("ERROR", UserReport.class, e.getMessage());
        }
        return file;
    }
    
}
