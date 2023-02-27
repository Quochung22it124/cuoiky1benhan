package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class DanToc implements Serializable{
	private int maDanToc;
	private String tenDanToc;
	public DanToc(int maDanToc, String tenDanToc) {
		this.maDanToc = maDanToc;
		this.tenDanToc = tenDanToc;
	}
	public int getMaDanToc() {
		return maDanToc;
	}
	public void setMaDanToc(int maDanToc) {
		this.maDanToc = maDanToc;
	}
	public String getTenDanToc() {
		return tenDanToc;
	}
	public void setTenDanToc(String tenDanToc) {
		this.tenDanToc = tenDanToc;
	}
	@Override
	public String toString() {
		return "DanToc [maDanToc=" + maDanToc + ", tenDanToc=" + tenDanToc + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(maDanToc, tenDanToc);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DanToc other = (DanToc) obj;
		return maDanToc == other.maDanToc && Objects.equals(tenDanToc, other.tenDanToc);
	}
	public static ArrayList getDSDanToc(){
		String[] arr_dantoc = {"Kinh",
				"Chứt",
				"Mường",
				"Thổ",
				"Bố Y",
				"Giáy",
				"Lào",
				"Lự",
				"Nùng",
				"Sán Chay",
				"Tày",
				"Thái",
				"Cờ Lao",
				"La Chí",
				"La Ha",
				"Pu Péo",
				"Ba Na",
				"Brâu",
				"Bru - Vân Kiều",
				"Chơ Ro",
				"Co",
				"Cơ Ho",
				"Cơ Tu",
				"Giẻ Triêng",
				"Hrê",
				"Kháng",
				"Khmer",
				"Khơ Mú",
				"Mạ",
				"Mảng",
				"M’Nông",
				"Ơ Đu",
				"Rơ Măm",
				"Tà Ôi",
				"Xinh Mun",
				"Xơ Đăng",
				"X’Tiêng",
				"Dao",
				"H’Mông",
				"Pà Thẻn",
				"Chăm",
				"Chu Ru",
				"Ê Đê",
				"Gia Rai",
				"Ra Glai",
				"Hoa",
				"Ngái",
				"Sán Dìu",
				"Cống",
				"Hà Nhì",
				"La Hủ",
				"Lô Lô",
				"Phù Lá",
				"Si La"};
	ArrayList listDanToc = new ArrayList();
	int i =0;
	for (String tenDanToc : arr_dantoc) {
		DanToc d = new DanToc(i, tenDanToc);
		listDanToc.add(d);
	}
	return listDanToc;	
	}
	public static DanToc getDanTocByID(int danToc) {
		return (DanToc) DanToc.getDSDanToc().get(danToc);
	}
	public static DanToc getDanTocByTen(String tenTinh) {
		ArrayList<DanToc> listDanToc = DanToc.getDSDanToc();
		for (DanToc danToc : listDanToc) {
			if(danToc.tenDanToc.equals(tenTinh))
		return danToc;
		}
		return null;
	}
	
	

}
