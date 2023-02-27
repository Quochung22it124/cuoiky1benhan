package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.BenhNhan;
import model.DanToc;
import model.QLBNModel;
import model.Tinh;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.QLBNController;

import javax.swing.JRadioButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.awt.event.ActionEvent;


public class QLBNView extends JFrame {

	private JPanel contentPane;
	public QLBNModel model;
	public JTextField textField_maHoSoTimKiem;
	public JTable table;
	public JTextField textField_MaHoSo;
	public JTextField textField_TenBenhNhan;
	public JTextField textField_MaSoBHYT;
	public JTextField textField_NamSinh;
	public JTextField textField_LoaiBenh;
	public JComboBox comboBox_DiaChi_1;
	public JComboBox comboBox_DiaChi;
	public JComboBox comboBox_DanToc;
	public ButtonGroup btn_gioiTinh;
	public JRadioButton RadioButtonNam;
	public JRadioButton RadioButtonNu;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLBNView frame = new QLBNView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public QLBNView() {
		this.model = new QLBNModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 891, 771);
		
		Action action = new QLBNController(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(action);
		menuFile.add(menuOpen);
		
		JMenuItem menuSave = new JMenuItem("Save");
		menuSave.addActionListener(action);
		menuFile.add(menuSave);
		
		JSeparator separator = new JSeparator();
		menuFile.add(separator);
		
		JMenuItem menuExit = new JMenuItem("Exit");
		menuExit.addActionListener(action);
		menuFile.add(menuExit);
		
		JMenu menuAbout = new JMenu("About");
		menuAbout.addActionListener(action);
		menuBar.add(menuAbout);
		
		JMenuItem menuAboutMe = new JMenuItem("About Me");
		menuAboutMe.addActionListener(action);
		menuAbout.add(menuAboutMe);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_DiaChi = new JLabel("Địa chỉ (Tỉnh):");
		label_DiaChi.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_DiaChi.setBounds(10, 10, 147, 46);
		contentPane.add(label_DiaChi);
		
		JLabel label_MaHoSoTimKiem = new JLabel("Mã hồ sơ:");
		label_MaHoSoTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_MaHoSoTimKiem.setBounds(315, 10, 147, 46);
		contentPane.add(label_MaHoSoTimKiem);
		
		textField_maHoSoTimKiem = new JTextField();
		textField_maHoSoTimKiem.setBounds(391, 13, 177, 46);
		contentPane.add(textField_maHoSoTimKiem);
		textField_maHoSoTimKiem.setColumns(10);
		
		JButton Button_TimKiem = new JButton("Tìm kiếm");
		Button_TimKiem.addActionListener(action);
		Button_TimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		Button_TimKiem.setBounds(578, 10, 105, 46);
		contentPane.add(Button_TimKiem);
		
		comboBox_DiaChi = new JComboBox();
		ArrayList<Tinh> listTinh = Tinh.getDSTinh();
		comboBox_DiaChi.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_DiaChi.addItem(tinh.getTenTinh());
		}
		comboBox_DiaChi.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox_DiaChi.setBounds(128, 10, 177, 46);
		contentPane.add(comboBox_DiaChi);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 66, 857, 2);
		contentPane.add(separator_1);
		
		JLabel label_DanhSachHoSoBenhAn = new JLabel("Danh sách hồ sơ bệnh án");
		label_DanhSachHoSoBenhAn.setFont(new Font("Tahoma", Font.ITALIC, 15));
		label_DanhSachHoSoBenhAn.setBounds(10, 78, 229, 46);
		contentPane.add(label_DanhSachHoSoBenhAn);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã hồ sơ", "Tên bệnh nhân", "Mã số BHYT", "Địa chỉ","Năm Sinh", "Giới tính", "Dân tộc","Loại bệnh"
			}
		));
		table.setRowHeight(25);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 123, 857, 220);
		contentPane.add(scrollPane);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 353, 857, 2);
		contentPane.add(separator_2);
		
		JLabel label_ThongTinBenhAn = new JLabel("Thông tin bệnh án");
		label_ThongTinBenhAn.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_ThongTinBenhAn.setBounds(10, 343, 147, 46);
		contentPane.add(label_ThongTinBenhAn);
		
		JLabel label_MaHoSo = new JLabel("Mã hồ sơ:");
		label_MaHoSo.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_MaHoSo.setBounds(10, 398, 147, 46);
		contentPane.add(label_MaHoSo);
		
		textField_MaHoSo = new JTextField();
		textField_MaHoSo.setColumns(10);
		textField_MaHoSo.setBounds(136, 401, 196, 46);
		contentPane.add(textField_MaHoSo);
		
		JLabel label_TenBenhNhan = new JLabel("Tên bệnh nhân:");
		label_TenBenhNhan.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_TenBenhNhan.setBounds(10, 454, 147, 46);
		contentPane.add(label_TenBenhNhan);
		
		textField_TenBenhNhan = new JTextField();
		textField_TenBenhNhan.setColumns(10);
		textField_TenBenhNhan.setBounds(136, 457, 196, 46);
		contentPane.add(textField_TenBenhNhan);
		
		JLabel label_DiaChi_1 = new JLabel("Địa chỉ (Tỉnh):");
		label_DiaChi_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_DiaChi_1.setBounds(10, 510, 147, 46);
		contentPane.add(label_DiaChi_1);
		
		comboBox_DiaChi_1 = new JComboBox();
		comboBox_DiaChi_1.addItem("");
		for (Tinh tinh : listTinh) {
			comboBox_DiaChi_1.addItem(tinh.getTenTinh());
		}
		comboBox_DiaChi_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox_DiaChi_1.setBounds(136, 510, 196, 46);
		contentPane.add(comboBox_DiaChi_1);
		
		JLabel label_MaSoBHYT = new JLabel("Mã số BHYT:");
		label_MaSoBHYT.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_MaSoBHYT.setBounds(455, 398, 147, 46);
		contentPane.add(label_MaSoBHYT);
		
		textField_MaSoBHYT = new JTextField();
		textField_MaSoBHYT.setColumns(10);
		textField_MaSoBHYT.setBounds(573, 401, 196, 46);
		contentPane.add(textField_MaSoBHYT);
		
		JLabel lblNmSinh = new JLabel("Năm sinh:");
		lblNmSinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNmSinh.setBounds(455, 454, 147, 46);
		contentPane.add(lblNmSinh);
		
		textField_NamSinh = new JTextField();
		textField_NamSinh.setColumns(10);
		textField_NamSinh.setBounds(573, 457, 196, 46);
		contentPane.add(textField_NamSinh);
		
		JLabel label_DanToc = new JLabel("Dân Tộc:");
		label_DanToc.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_DanToc.setBounds(455, 510, 147, 46);
		contentPane.add(label_DanToc);
		
		comboBox_DanToc = new JComboBox ();
		ArrayList<DanToc> listDanToc = DanToc.getDSDanToc();
		comboBox_DanToc.addItem("");
		for (DanToc dantoc : listDanToc) {
			comboBox_DanToc.addItem(dantoc.getTenDanToc());
		}
		comboBox_DanToc.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox_DanToc.setBounds(573, 510, 196, 46);
		contentPane.add(comboBox_DanToc);
		
		JLabel label_LoaiBenh = new JLabel("Loại bệnh:");
		label_LoaiBenh.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_LoaiBenh.setBounds(10, 566, 147, 46);
		contentPane.add(label_LoaiBenh);
		
		textField_LoaiBenh = new JTextField();
		textField_LoaiBenh.setColumns(10);
		textField_LoaiBenh.setBounds(136, 566, 196, 46);
		contentPane.add(textField_LoaiBenh);
		
		JLabel label_GioiTinh = new JLabel("Giới Tính:");
		label_GioiTinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_GioiTinh.setBounds(455, 566, 147, 46);
		contentPane.add(label_GioiTinh);
		
		RadioButtonNam = new JRadioButton("Nam");
		RadioButtonNam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RadioButtonNam.setBounds(573, 564, 105, 50);
		contentPane.add(RadioButtonNam);
		
		RadioButtonNu = new JRadioButton("Nữ");
		RadioButtonNu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RadioButtonNu.setBounds(680, 564, 124, 50);
		contentPane.add(RadioButtonNu);
		
		btn_gioiTinh = new ButtonGroup();
		btn_gioiTinh.add(RadioButtonNam);
		btn_gioiTinh.add(RadioButtonNu);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 636, 857, 2);
		contentPane.add(separator_3);
		
		JButton Button_Them = new JButton("Thêm");
		Button_Them.addActionListener(action);
		Button_Them.setFont(new Font("Tahoma", Font.BOLD, 15));
		Button_Them.setBounds(10, 650, 105, 46);
		contentPane.add(Button_Them);
		
		JButton Button_Xoa = new JButton("Xóa");
		Button_Xoa.addActionListener(action);
		Button_Xoa.setFont(new Font("Tahoma", Font.BOLD, 15));
		Button_Xoa.setBounds(194, 648, 105, 46);
		contentPane.add(Button_Xoa);
		
		JButton Button_ChinhSua = new JButton("Chỉnh sửa");
		Button_ChinhSua.addActionListener(action);
		Button_ChinhSua.setFont(new Font("Tahoma", Font.BOLD, 15));
		Button_ChinhSua.setBounds(379, 648, 124, 46);
		contentPane.add(Button_ChinhSua);
		
		JButton Button_Luu = new JButton("Lưu");
		Button_Luu.addActionListener(action);
		Button_Luu.setFont(new Font("Tahoma", Font.BOLD, 15));
		Button_Luu.setBounds(573, 648, 105, 46);
		contentPane.add(Button_Luu);
		
		JButton Button_HuyBo = new JButton("Hủy bỏ");
		Button_HuyBo.addActionListener(action);
		Button_HuyBo.setFont(new Font("Tahoma", Font.BOLD, 15));
		Button_HuyBo.setBounds(762, 648, 105, 46);
		contentPane.add(Button_HuyBo);
		
		JButton Button_HuyTimKiem = new JButton("Hủy tìm kiếm");
		Button_HuyTimKiem.addActionListener(action);
		Button_HuyTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		Button_HuyTimKiem.setBounds(693, 10, 159, 46);
		contentPane.add(Button_HuyTimKiem);
		
		
		
		
		this.setVisible(true);
	}

	public void xoaForm() {
		textField_MaHoSo.setText("");
		textField_TenBenhNhan.setText("");
		textField_MaSoBHYT.setText("");
		textField_NamSinh.setText("");
		textField_LoaiBenh.setText("");
		comboBox_DiaChi_1.setSelectedIndex(-1);
		comboBox_DanToc.setSelectedIndex(-1);
		btn_gioiTinh.clearSelection();
	}

	public void themBenhNhanVaoTable(BenhNhan bn) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		model_table.addRow(new Object[] {
				bn.getMaHoSo()+"",
				bn.getTenBenhNhan(),
				bn.getMaSoBHYT(),
				bn.getDiaChi().getTenTinh(),
				bn.getNamSinh(),
				bn.isGioiTinh()?"Nam":"Nữ",
			    bn.getDanToc().getTenDanToc(),
				bn.getLoaiBenh(),
				});
		
	}
	
	public void ThemHoacCapNhapBenhNhan(BenhNhan bn) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		if(!this.model.kiemTraTonTai(bn)) {
		this.model.insert(bn);
		this.themBenhNhanVaoTable(bn);
		
		}else {
			this.model.update(bn);
			int soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0)+"";
				if(id.equals(bn.getMaHoSo()+"")) {
				model_table.setValueAt(bn.getMaHoSo()+"", i, 0);
				model_table.setValueAt(bn.getTenBenhNhan()+"", i, 1);
				model_table.setValueAt(bn.getMaSoBHYT()+"", i, 2);
				model_table.setValueAt(bn.getDiaChi().getTenTinh()+"", i, 3);
				model_table.setValueAt(bn.getNamSinh()+"", i, 4);
				model_table.setValueAt((bn.isGioiTinh()?"Nam":"Nữ"), i, 5);
				model_table.setValueAt(bn.getDanToc().getTenDanToc()+"", i, 6);
				model_table.setValueAt(bn.getLoaiBenh()+"", i, 7);
				}
			}
		}
	}

public BenhNhan getBenhNhanDangChon() {
	DefaultTableModel model_table = (DefaultTableModel) table.getModel();
	int i_row = table.getSelectedRow();
	int maHoSo = Integer.valueOf(model_table.getValueAt(i_row, 0)+"");
	String tenBenhNhan = model_table.getValueAt(i_row, 1)+"";
	int maSoBHYT = Integer.valueOf(model_table.getValueAt(i_row, 2)+"");
	Tinh tinh = Tinh.getTinhByTen(model_table.getValueAt(i_row, 3)+"");
	int namSinh = Integer.valueOf(model_table.getValueAt(i_row, 4)+"");
	String textGioiTinh = model_table.getValueAt(i_row, 5)+"";
	boolean gioiTinh = textGioiTinh.equals("Nam");
	
	DanToc dantoc = DanToc.getDanTocByTen(model_table.getValueAt(i_row, 6)+"");
	String loaiBenh = model_table.getValueAt(i_row, 7)+"";
	
	this.textField_MaHoSo.setText(maHoSo+"");
	this.textField_TenBenhNhan.setText(tenBenhNhan+"");
	this.textField_MaSoBHYT.setText(maSoBHYT+"");
	this.comboBox_DiaChi_1.setSelectedItem(tinh.getTenTinh());
	this.textField_NamSinh.setText(namSinh+"");
	
	BenhNhan bn = new BenhNhan(maHoSo, tenBenhNhan, maSoBHYT, tinh, namSinh, gioiTinh, dantoc, loaiBenh);
	return bn;
}
	public void hienThiThongTinBenhNhanDaChon() {
		BenhNhan bn = getBenhNhanDangChon();

		
		this.textField_MaHoSo.setText(bn.getMaHoSo()+"");
		this.textField_TenBenhNhan.setText(bn.getTenBenhNhan()+"");
		this.textField_MaSoBHYT.setText(bn.getMaSoBHYT()+"");
		this.comboBox_DiaChi_1.setSelectedItem(bn.getDiaChi().getTenTinh());
		this.textField_NamSinh.setText(bn.getNamSinh()+"");
		if(bn.isGioiTinh()) {
			RadioButtonNam.setSelected(true);
		}else {
			RadioButtonNu.setSelected(true);
		}
		this.comboBox_DanToc.setSelectedItem(bn.getDanToc().getTenDanToc());
		this.textField_LoaiBenh.setText(bn.getLoaiBenh()+"");

	}

	public void thucHienXoa() {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int i_row = table.getSelectedRow();
		int luaChon = JOptionPane.showConfirmDialog(this,"Bạn có chắc chắn xóa dòng đã chọn");
		if(luaChon==JOptionPane.YES_OPTION) {
			BenhNhan bn = getBenhNhanDangChon();
			this.model.delete(bn);
			model_table.removeRow(i_row);
		}
		
	}

	public void thucHienThemBenhNhan() {
		//get du lieu
		int maHoSo = Integer.valueOf(this.textField_MaHoSo.getText());
		String tenBenhNhan = this.textField_TenBenhNhan.getText();
		int diaChi = this.comboBox_DiaChi_1.getSelectedIndex()-1;
		Tinh tinh = Tinh.getTinhByID(diaChi);
		boolean gioiTinh = true;
		if(this.RadioButtonNam.isSelected()) {
			gioiTinh = true;
		}else if(this.RadioButtonNu.isSelected()) {
			gioiTinh=false;
		}
		int maSoBHYT = Integer.valueOf(this.textField_MaSoBHYT.getText());
		int danToc = this.comboBox_DanToc.getSelectedIndex()-1;
		DanToc dantoc = DanToc.getDanTocByID(danToc);
		String loaiBenh = this.textField_LoaiBenh.getText();
		int namSinh = Integer.valueOf(this.textField_NamSinh.getText());
		
		BenhNhan bn = new BenhNhan(maHoSo, tenBenhNhan, maSoBHYT, tinh, namSinh, gioiTinh, dantoc, loaiBenh);
		this.ThemHoacCapNhapBenhNhan(bn);
		
		
	}

	public void thucHienTim() {
		//Goi ham huy tim kiem
		this.thucHienTaiLaiDuLieu();
		//Thuc hien tim kiem
		
		int diaChi = this.comboBox_DiaChi.getSelectedIndex()-1;
		String maBenhNhanTimKiem = this.textField_maHoSoTimKiem.getText();
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();
		
		Set <Integer> idCuaBenhNhanCanXoa = new TreeSet<Integer>();
		if(diaChi>=0) {
			Tinh tinhDaChon = Tinh.getTinhByID(diaChi);
		for (int i = 0; i < soLuongDong; i++) {
			String tenTinh = model_table.getValueAt(i, 3)+"";
			String id = model_table.getValueAt(i, 0)+"";
			if(!tenTinh.equals(tinhDaChon.getTenTinh())) {
				idCuaBenhNhanCanXoa.add(Integer.valueOf(id));
			}
		}
	}
		if(maBenhNhanTimKiem.length()>0) {
			for (int i = 0; i < soLuongDong; i++) {
				String id = model_table.getValueAt(i, 0)+"";
				if(!id.equals(maBenhNhanTimKiem)) {
					idCuaBenhNhanCanXoa.add(Integer.valueOf(id));
				}
			}
		}
		for (Integer idCanXoa : idCuaBenhNhanCanXoa) {
			System.out.println(idCanXoa);
			soLuongDong = model_table.getRowCount();
			for (int i = 0; i < soLuongDong; i++) {
				String idTrongTable = model_table.getValueAt(i, 0)+"";
				if(idTrongTable.equals(idCanXoa.toString())) {
					System.out.println("Đã xóa: " + i);
					try {
						model_table.removeRow(i);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
		} 
			}
		}
	}

	
	
	public void thucHienTaiLaiDuLieu() {
		while(true) {
		DefaultTableModel model_table = (DefaultTableModel) table.getModel();
		int soLuongDong = model_table.getRowCount();
		if(soLuongDong==0)
			break;
		else
			try {
				model_table.removeRow(0);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		for(BenhNhan bn : this.model.getDsBenhNhan()) {
			this.themBenhNhanVaoTable(bn);
		}	
	}

	public void hienThiAbout() {
		JOptionPane.showMessageDialog(this, "Phần mềm quản lý hồ sơ bệnh án bệnh viện");
		
	}

	public void thoatKhoiChuongTrinh() {
		int luaChon = JOptionPane.showConfirmDialog(this,
				"Thoát khỏi chương trình?",
				"Exit",
				JOptionPane.YES_NO_OPTION);
		if(luaChon==JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		
	}
	public void saveFile(String path) {
		try {
			this.model.setTenFile(path);
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (BenhNhan bn : this.model.getDsBenhNhan()) {
				oos.writeObject(bn);
			}
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void thucHienSaveFile() {
		if(this.model.getTenFile().length()>0) {
			saveFile(this.model.getTenFile());
		}else {
			JFileChooser fc = new JFileChooser();
			int returnVal = fc.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				saveFile(file.getAbsolutePath());
			} 
		}
		
	}
	public void openFile(File file) {
		ArrayList<BenhNhan> ds = new ArrayList<BenhNhan>();
		try {
			this.model.setTenFile(file.getAbsolutePath());
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			BenhNhan bn = null;
			while((bn = (BenhNhan) ois.readObject())!= null){
				ds.add(bn);
			}
			ois.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		this.model.setDsBenhNhan(ds);
	}
	public void thucHienOpenFile() {
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			openFile(file);
			thucHienTaiLaiDuLieu();
		
		}
	}
}
