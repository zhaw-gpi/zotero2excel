package ch.zhaw.iwi.zotero2excel.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Charset
 */
@Entity
@Table(name="charsets")
public class Charset {

    @Id
    private Long charsetID;
    private String charset;

    public Long getCharsetID() {
        return charsetID;
    }

    public void setCharsetID(Long charsetID) {
        this.charsetID = charsetID;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    
}