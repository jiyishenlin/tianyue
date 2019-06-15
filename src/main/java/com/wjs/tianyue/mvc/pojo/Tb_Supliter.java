package com.wjs.tianyue.mvc.pojo;

public class Tb_Supliter {
    private Integer id;

    private String supname;

    private String supaddr;

    private String name;

    private String tel;
    
    private String des;
    

    public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSupname() {
        return supname;
    }

    public void setSupname(String supname) {
        this.supname = supname == null ? null : supname.trim();
    }

    public String getSupaddr() {
        return supaddr;
    }

    public void setSupaddr(String supaddr) {
        this.supaddr = supaddr == null ? null : supaddr.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }
}