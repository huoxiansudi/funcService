package com.hospital.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: xiaofu
 * Date: 2018-1-23
 * Time: 9:21
 * Function:
 */
@XmlRootElement
public class XmlList {
    private String docName;
    private String docTitle;

    public XmlList() {
    }

    public XmlList(String docName, String docTitle) {
        this.docName = docName;
        this.docTitle = docTitle;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocTitle() {
        return docTitle;
    }

    public void setDocTitle(String docTitle) {
        this.docTitle = docTitle;
    }
}
