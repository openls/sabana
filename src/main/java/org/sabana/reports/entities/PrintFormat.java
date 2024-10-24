package org.sabana.reports.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "AD_PrintFormat")
public class PrintFormat {
    
    @Id
    private Long ad_printformat_id;
    private String name;

    public PrintFormat() {

    }

    public PrintFormat(Long id) {
        this.ad_printformat_id = id;
    }

	public static PrintFormat newInstance() {
		return new PrintFormat();
	}

    public Long getId() {
        return ad_printformat_id;
    }

    public void setId(Long id) {
        this.ad_printformat_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }   
}
