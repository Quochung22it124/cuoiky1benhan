package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class BenhNhan implements Serializable{
	private int maHoSo;
	private String tenBenhNhan;
	private int maSoBHYT;
	private Tinh diaChi;
	private int namSinh;
	private boolean gioiTinh;
	private DanToc danToc;
	private String loaiBenh;
	public BenhNhan() {
	}
	public BenhNhan(int maHoSo, String tenBenhNhan, int maSoBHYT, Tinh diaChi, int namSinh, boolean gioiTinh,
			DanToc danToc, String loaiBenh) {
		this.maHoSo = maHoSo;
		this.tenBenhNhan = tenBenhNhan;
		this.maSoBHYT = maSoBHYT;
		this.diaChi = diaChi;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
		this.danToc = danToc;
		this.loaiBenh = loaiBenh;
	}
	public int getMaHoSo() {
		return maHoSo;
	}
	public void setMaHoSo(int maHoSo) {
		this.maHoSo = maHoSo;
	}
	public String getTenBenhNhan() {
		return tenBenhNhan;
	}
	public void setTenBenhNhan(String tenBenhNhan) {
		this.tenBenhNhan = tenBenhNhan;
	}
	public int getMaSoBHYT() {
		return maSoBHYT;
	}
	public void setMaSoBHYT(int maSoBHYT) {
		this.maSoBHYT = maSoBHYT;
	}
	public Tinh getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(Tinh diaChi) {
		this.diaChi = diaChi;
	}
	public int getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public DanToc getDanToc() {
		return danToc;
	}
	public void setDanToc(DanToc danToc) {
		this.danToc = danToc;
	}
	public String getLoaiBenh() {
		return loaiBenh;
	}
	public void setLoaiBenh(String loaiBenh) {
		this.loaiBenh = loaiBenh;
	}
	@Override
	public String toString() {
		return "BenhNhan [maHoSo=" + maHoSo + ", tenBenhNhan=" + tenBenhNhan + ", maSoBHYT=" + maSoBHYT + ", diaChi="
				+ diaChi + ", namSinh=" + namSinh + ", gioiTinh=" + gioiTinh + ", danToc=" + danToc + ", loaiBenh="
				+ loaiBenh + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(danToc, diaChi, gioiTinh, loaiBenh, maHoSo, maSoBHYT, namSinh, tenBenhNhan);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BenhNhan other = (BenhNhan) obj;
		return Objects.equals(danToc, other.danToc) && Objects.equals(diaChi, other.diaChi)
				&& gioiTinh == other.gioiTinh && Objects.equals(loaiBenh, other.loaiBenh) && maHoSo == other.maHoSo
				&& maSoBHYT == other.maSoBHYT && Objects.equals(namSinh, other.namSinh)
				&& Objects.equals(tenBenhNhan, other.tenBenhNhan);
	}
	
}
