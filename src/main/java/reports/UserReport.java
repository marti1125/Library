/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import controllers.Authors;
import utils.Report;

/**
 *
 * @author willyaguirre
 */
public class UserReport {
    
    public UserReport(){}
    
    Report report = new Report();
    
    public byte[] reportPDF() throws Exception {
        Authors authors = new Authors();
        String jasperFile = "/Users/willyaguirre/NetBeansProjects/webapp/src/main/resources/reports/test.jasper";
        return report.generate(jasperFile, authors.listAuthors());
    }
    
}
