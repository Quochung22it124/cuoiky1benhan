package model;

import java.util.ArrayList;

public class QLBNModel {
	private ArrayList<BenhNhan>dsBenhNhan;
	private String luaChon;
	private String tenFile;

	public QLBNModel() {
		this.dsBenhNhan = new ArrayList<BenhNhan>();
		this.luaChon = "";
		this.tenFile="";
	}

	public QLBNModel(ArrayList<BenhNhan> dsBenhNhan) {
		this.dsBenhNhan = dsBenhNhan;
	}

	public ArrayList<BenhNhan> getDsBenhNhan() {
		return dsBenhNhan;
	}

	public void setDsBenhNhan(ArrayList<BenhNhan> dsBenhNhan) {
		this.dsBenhNhan = dsBenhNhan;
	}
	
	public void insert(BenhNhan benhNhan) {
		this.dsBenhNhan.add(benhNhan);
	}
	public void delete(BenhNhan benhNhan) {
		this.dsBenhNhan.remove(benhNhan);
	}
	public void update(BenhNhan benhNhan) {
		this.dsBenhNhan.remove(benhNhan);
		this.dsBenhNhan.add(benhNhan);
	}

	public String getLuaChon() {
		return luaChon;
	}

	public void setLuaChon(String luaChon) {
		this.luaChon = luaChon;
	}

	public boolean kiemTraTonTai(BenhNhan bn) {
		for (BenhNhan benhNhan : dsBenhNhan) {
			if(benhNhan.getMaHoSo() == bn.getMaHoSo())
				return true;
		}
		return false;
	}

	public String getTenFile() {
		return tenFile;
	}

	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}
	
	
}
