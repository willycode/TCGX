package com.kangdainfo.common.schedule.model.bo;

import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;


/** @author Hibernate CodeGenerator */
public class Schedulelog implements Serializable {

    /** identifier field */
    private Long id;

    /** nullable persistent field */
    private String schedulename;

    /** nullable persistent field */
    private String errorlog;

    /** nullable persistent field */
    private String editdate;

    /** nullable persistent field */
    private String edittime;

    /** full constructor */
    public Schedulelog(String schedulename, String errorlog, String editdate, String edittime) {
        this.schedulename = schedulename;
        this.errorlog = errorlog;
        this.editdate = editdate;
        this.edittime = edittime;
    }

    /** default constructor */
    public Schedulelog() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSchedulename() {
        return this.schedulename;
    }

    public void setSchedulename(String schedulename) {
        this.schedulename = schedulename;
    }

    public String getErrorlog() {
        return this.errorlog;
    }

    public void setErrorlog(String errorlog) {
        this.errorlog = errorlog;
    }

    public String getEditdate() {
        return this.editdate;
    }

    public void setEditdate(String editdate) {
        this.editdate = editdate;
    }

    public String getEdittime() {
        return this.edittime;
    }

    public void setEdittime(String edittime) {
        this.edittime = edittime;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("id", getId())
            .toString();
    }

}
