/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import controllers.Authors;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import utils.Log;

/**
 *
 * @author willyaguirre
 */
public class UserReport {
    
    public UserReport(){}
    
    Log log = new Log();
       
    /*public static void report() throws Exception {
        Logger.getLogger(UserReport.class.getName()).log(Level.INFO, "START REPORT ...");
        String sourceFileName = "/Users/willyaguirre/NetBeansProjects/webapp/src/main/resources/reports/test.jasper";
        String printFileName;
        Map<String, Object> parameters = new HashMap();
        try {
            Authors authors = new Authors();
            JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(authors.listAuthors());
            printFileName = JasperFillManager.fillReportToFile(sourceFileName, parameters, data);
            Logger.getLogger(UserReport.class.getName()).log(Level.INFO, "REPORT: " + printFileName);
            if(printFileName != null){
                JasperExportManager.exportReportToPdfFile(printFileName, "/Users/willyaguirre/Desktop/pdf/test.pdf");
            } else {
                Logger.getLogger(UserReport.class.getName()).log(Level.SEVERE, "ERROR DOES NOT GENERATE A REPORT");
            }
        } catch (Exception e) {
            Logger.getLogger(UserReport.class.getName()).log(Level.SEVERE, e.getMessage());
        }
    }*/
    
    public byte[] reportPDF() throws Exception {
        byte[] file = null;
        log.status("DEBUG", UserReport.class, "START REPORT ...");
        String sourceFileName = "/Users/willyaguirre/NetBeansProjects/webapp/src/main/resources/reports/test.jasper";
        Map<String, Object> parameters = new HashMap();
        try {
            Authors authors = new Authors();
            JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(authors.listAuthors());
            JasperPrint print = JasperFillManager.fillReport(sourceFileName, parameters, data);
            log.status("DEBUG", UserReport.class, "REPORT: " + print.getName());
            file = JasperExportManager.exportReportToPdf(print);
        } catch (Exception e) {
            log.status("ERROR", UserReport.class, e.getMessage());
        }
        return file;
    }
    
}
