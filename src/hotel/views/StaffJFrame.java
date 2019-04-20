/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.views;

import hotel.daos.BookingDAO;
import hotel.daos.CustomerDAO;
import hotel.daos.RoomDAO;
import hotel.daos.StaffDAO;
import hotel.dtos.BookingDTO;
import hotel.dtos.CustomerDTO;
import hotel.dtos.RoomDTO;
import hotel.dtos.StaffDTO;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danze
 */
public class StaffJFrame extends javax.swing.JFrame {

    String staff;
    private DefaultTableModel tblModelStaffs, tblModelInvoices, tblModelRooms, tblModelCustomers, tblModelBookings;

    /**
     * Creates new form StaffJFrame
     */    
    
    public StaffJFrame() {
        initComponents();
    }

    public StaffJFrame(String staff) {
        initComponents();
        setLocationRelativeTo(null);
        this.staff = staff;
        spnBirthDate.setEditor(new JSpinner.DateEditor(spnBirthDate, "dd-MM-yyyy")); //sua lai cach hien thi birth date
        //load toan bo staff vao bang
        tblModelStaffs = (DefaultTableModel) tblStaffs.getModel(); //lay model cua bang staffs
        tblModelCustomers = (DefaultTableModel) tblCustomers.getModel();
        tblModelRooms = (DefaultTableModel) tblRooms.getModel();
//        tblModelInvoices = (DefaultTableModel) tblInvoices.getModel();
        tblModelBookings = (DefaultTableModel) tblBookings.getModel();
        tbtnChangePW.setVisible(false);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);

        try {
            showAllStaffs();
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showAllStaffs() throws Exception {
        tblModelStaffs.setRowCount(0); //xoa toan bo row tren bang
        StaffDAO dao = new StaffDAO();
        List<StaffDTO> listStaff = dao.getAllStaffs();
        if (!listStaff.isEmpty()) { //neu co staff
            for (StaffDTO dto : listStaff) {
                tblModelStaffs.addRow(dto.toVector()); //them vao bang mot row voi mot staff trong listStaff duoc chuyen sang dang Vector
            }
        }
    }
    
    private void showAllCustomers() throws Exception {
        tblModelCustomers.setRowCount(0); //xoa toan bo row tren bang
        CustomerDAO dao = new CustomerDAO();
        List<CustomerDTO> list = dao.getAllCustomers();
        if (!list.isEmpty()) { //neu co customer
            for (CustomerDTO dto : list) {
                tblModelCustomers.addRow(dto.toVector()); //them vao bang mot row voi mot customer trong list duoc chuyen sang dang Vector
            }
        }
    }
    
    private void showAllRooms() throws Exception {
        tblModelRooms.setRowCount(0); //xoa toan bo row tren bang
        RoomDAO dao = new RoomDAO();
        List<RoomDTO> list = dao.getAllRooms();
        if (!list.isEmpty()) { //neu co phong
            for (RoomDTO dto : list) {
                tblModelRooms.addRow(dto.toVector()); //them vao bang mot row voi mot phong trong list duoc chuyen sang dang Vector
            }
        }        
    }
    
    private void showAllBookings() throws Exception {
        tblModelBookings.setRowCount(0); //xoa toan bo row tren bang
        BookingDAO dao = new BookingDAO();
        List<BookingDTO> list = dao.getAllBookings();
        if (!list.isEmpty()) { //neu co phieu
            for (BookingDTO dto : list) {
                tblModelBookings.addRow(dto.toVector()); //them vao bang mot row voi mot phieu trong list duoc chuyen sang dang Vector
            }
        }
    }

    private void resetStaff() {
        txtStaffID.setText("");
        txtStaffID.setEditable(true);
        txtName.setText("");
        txtPassword.setText("");
        txtPassword.setEnabled(true);
        txtRole.setText("");
        txtAddress.setText("");
        txtPhone.setText("");
        btnGroupGender.clearSelection();
        spnSalary.setValue((float) 0);
        spnBirthDate.setValue(new java.util.Date());
        tbtnChangePW.setVisible(false);
        tbtnChangePW.setSelected(false);
        
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }
    
    private void resetCustomer() {
        txtCMND.setText("");
        txtCMND.setEditable(true);
        txtCusName.setText("");
        txtCusAddress.setText("");
        txtCountry.setText("");
        txtCusPhone.setText("");
        btnGroupGenderCus.clearSelection();
        
        btnCusUpdate.setEnabled(false);
        btnCusDelete.setEnabled(false);
    }
    
    private void resetRoom() {
        txtRoomNum.setText("");
        txtRoomNum.setEditable(true);
        cbbRoomType.setSelectedIndex(0);
        spnRoomPrice.setValue((float) 0);
        cbbAvail.setSelectedIndex(0);
        
        btnUpdateRoom.setEnabled(false);
        btnDeleteRoom.setEnabled(false);
    }
    
    private void resetBooking() {
        txtBookingCode.setText("");
        txtBookingCode.setEditable(true);
        cbbRoom.setSelectedIndex(0);
        lblPriceRoom.setText("");
        spnDuration.setValue(0);
        cbbCustomer.setSelectedIndex(0);
        lblStaff.setText(this.staff);
        lblBookingDate.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        lblTotal.setText("");
        
        btnUpdateBooking.setEnabled(false);
        btnDeleteBooking.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupGender = new javax.swing.ButtonGroup();
        btnGroupGenderCus = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        tabPnl = new javax.swing.JTabbedPane();
        pnlCustomer = new javax.swing.JPanel();
        lblCMND = new javax.swing.JLabel();
        txtCMND = new javax.swing.JTextField();
        txtCusName = new javax.swing.JTextField();
        lblCusName = new javax.swing.JLabel();
        lblCusAddress = new javax.swing.JLabel();
        lblCusPhone = new javax.swing.JLabel();
        txtCusPhone = new javax.swing.JTextField();
        txtCusAddress = new javax.swing.JTextField();
        rbtnCusMale = new javax.swing.JRadioButton();
        rbtnCusFemale = new javax.swing.JRadioButton();
        btnCusAdd = new javax.swing.JButton();
        btnCusUpdate = new javax.swing.JButton();
        btnCusDelete = new javax.swing.JButton();
        btnCusSearch = new javax.swing.JButton();
        btnCusReset = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCustomers = new javax.swing.JTable();
        lblNationality = new javax.swing.JLabel();
        lblCusGender = new javax.swing.JLabel();
        txtCountry = new javax.swing.JTextField();
        pnlBooking = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblBookings = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lblRoomNum1 = new javax.swing.JLabel();
        lblRoomType1 = new javax.swing.JLabel();
        cbbCustomer = new javax.swing.JComboBox<>();
        lblRoomPrice1 = new javax.swing.JLabel();
        lblAvail1 = new javax.swing.JLabel();
        btnAddBooking = new javax.swing.JButton();
        btnUpdateBooking = new javax.swing.JButton();
        btnSearchBooking = new javax.swing.JButton();
        btnDeleteBooking = new javax.swing.JButton();
        btnResetBooking = new javax.swing.JButton();
        lblRoomNum2 = new javax.swing.JLabel();
        txtBookingCode = new javax.swing.JTextField();
        cbbRoom = new javax.swing.JComboBox<>();
        lblPriceRoom = new javax.swing.JLabel();
        lblStaff = new javax.swing.JLabel();
        lblAvail2 = new javax.swing.JLabel();
        lblBookingDate = new javax.swing.JLabel();
        lblRoomPrice2 = new javax.swing.JLabel();
        spnDuration = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        pnlStaff = new javax.swing.JPanel();
        lblStaffID = new javax.swing.JLabel();
        txtStaffID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtRole = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        rbtnMale = new javax.swing.JRadioButton();
        rbtnFemale = new javax.swing.JRadioButton();
        lblBirthDate = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        spnBirthDate = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStaffs = new javax.swing.JTable();
        lblSalary = new javax.swing.JLabel();
        spnSalary = new javax.swing.JSpinner();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        tbtnChangePW = new javax.swing.JToggleButton();
        pnlRoom = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRooms = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        lblRoomNum = new javax.swing.JLabel();
        txtRoomNum = new javax.swing.JTextField();
        lblRoomType = new javax.swing.JLabel();
        cbbRoomType = new javax.swing.JComboBox<>();
        lblRoomPrice = new javax.swing.JLabel();
        spnRoomPrice = new javax.swing.JSpinner();
        lblAvail = new javax.swing.JLabel();
        btnAddRoom = new javax.swing.JButton();
        btnUpdateRoom = new javax.swing.JButton();
        btnSearchRoom = new javax.swing.JButton();
        btnDeleteRoom = new javax.swing.JButton();
        btnResetRoom = new javax.swing.JButton();
        cbbAvail = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ KHÁCH SẠN");

        lblCMND.setText("CMND:");

        lblCusName.setText("Tên khách hàng:");

        lblCusAddress.setText("Địa chỉ:");

        lblCusPhone.setText("Số điện thoại:");

        btnGroupGenderCus.add(rbtnCusMale);
        rbtnCusMale.setText("Nam");

        btnGroupGenderCus.add(rbtnCusFemale);
        rbtnCusFemale.setText("Nữ");

        btnCusAdd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCusAdd.setForeground(new java.awt.Color(0, 153, 204));
        btnCusAdd.setText("Thêm");
        btnCusAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusAddActionPerformed(evt);
            }
        });

        btnCusUpdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCusUpdate.setForeground(new java.awt.Color(0, 153, 102));
        btnCusUpdate.setText("Cập nhật");
        btnCusUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusUpdateActionPerformed(evt);
            }
        });

        btnCusDelete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCusDelete.setForeground(new java.awt.Color(255, 51, 0));
        btnCusDelete.setText("Xóa");
        btnCusDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusDeleteActionPerformed(evt);
            }
        });

        btnCusSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCusSearch.setText("Tìm kiếm");
        btnCusSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusSearchActionPerformed(evt);
            }
        });

        btnCusReset.setText("Đặt lại");
        btnCusReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCusResetActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách khách hàng:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        tblCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CMND", "Tên", "Giới tính", "Quốc tịch"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCustomers.setRowHeight(30);
        tblCustomers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblCustomers.getTableHeader().setReorderingAllowed(false);
        tblCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCustomersMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCustomers);
        if (tblCustomers.getColumnModel().getColumnCount() > 0) {
            tblCustomers.getColumnModel().getColumn(0).setResizable(false);
            tblCustomers.getColumnModel().getColumn(1).setResizable(false);
            tblCustomers.getColumnModel().getColumn(2).setResizable(false);
            tblCustomers.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblNationality.setText("Quốc tịch:");

        lblCusGender.setText("Giới tính:");

        javax.swing.GroupLayout pnlCustomerLayout = new javax.swing.GroupLayout(pnlCustomer);
        pnlCustomer.setLayout(pnlCustomerLayout);
        pnlCustomerLayout.setHorizontalGroup(
            pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCustomerLayout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlCustomerLayout.createSequentialGroup()
                        .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCusGender, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCusName, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCusName, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlCustomerLayout.createSequentialGroup()
                                .addComponent(rbtnCusMale, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rbtnCusFemale))))
                    .addGroup(pnlCustomerLayout.createSequentialGroup()
                        .addComponent(lblCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCMND)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblCusAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNationality, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCusPhone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtCusAddress)
                    .addComponent(txtCusPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCountry, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(173, 173, 173))
            .addGroup(pnlCustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCustomerLayout.createSequentialGroup()
                .addContainerGap(198, Short.MAX_VALUE)
                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCustomerLayout.createSequentialGroup()
                        .addComponent(btnCusReset, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCustomerLayout.createSequentialGroup()
                        .addComponent(btnCusAdd)
                        .addGap(101, 101, 101)
                        .addComponent(btnCusUpdate)
                        .addGap(108, 108, 108)
                        .addComponent(btnCusSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(btnCusDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184))))
        );

        pnlCustomerLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblCMND, lblCusGender, lblCusName});

        pnlCustomerLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCusAdd, btnCusDelete, btnCusSearch, btnCusUpdate});

        pnlCustomerLayout.setVerticalGroup(
            pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCustomerLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnCusReset)
                .addGap(40, 40, 40)
                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlCustomerLayout.createSequentialGroup()
                        .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCMND)
                            .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCusName)
                            .addComponent(txtCusName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCusGender)
                            .addComponent(rbtnCusMale)
                            .addComponent(rbtnCusFemale)))
                    .addGroup(pnlCustomerLayout.createSequentialGroup()
                        .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCusAddress)
                            .addComponent(txtCusAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNationality)
                            .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCusPhone)
                            .addComponent(txtCusPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(43, 43, 43)
                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCusAdd)
                    .addComponent(btnCusUpdate)
                    .addComponent(btnCusDelete)
                    .addComponent(btnCusSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlCustomerLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblCMND, lblCusGender, lblCusName});

        pnlCustomerLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCusAdd, btnCusDelete, btnCusSearch, btnCusUpdate});

        tabPnl.addTab("Khách hàng", pnlCustomer);

        tblBookings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đặt phòng", "Số phòng", "CMND", "Thời gian thuê"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBookings.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblBookings.getTableHeader().setReorderingAllowed(false);
        tblBookings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBookingsMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblBookings);
        if (tblBookings.getColumnModel().getColumnCount() > 0) {
            tblBookings.getColumnModel().getColumn(0).setResizable(false);
            tblBookings.getColumnModel().getColumn(1).setResizable(false);
            tblBookings.getColumnModel().getColumn(2).setResizable(false);
            tblBookings.getColumnModel().getColumn(3).setResizable(false);
            tblBookings.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết phiếu:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        lblRoomNum1.setText("Số phòng:");

        lblRoomType1.setText("Giá phòng:");

        cbbCustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---- Chọn khách hàng ----" }));

        lblRoomPrice1.setText("Khách hàng:");

        lblAvail1.setText("Nhân viên:");

        btnAddBooking.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnAddBooking.setForeground(new java.awt.Color(0, 153, 255));
        btnAddBooking.setText("Thêm");
        btnAddBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBookingActionPerformed(evt);
            }
        });

        btnUpdateBooking.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnUpdateBooking.setForeground(new java.awt.Color(0, 153, 102));
        btnUpdateBooking.setText("Cập nhật");
        btnUpdateBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateBookingActionPerformed(evt);
            }
        });

        btnSearchBooking.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSearchBooking.setText("Tìm kiếm");
        btnSearchBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchBookingActionPerformed(evt);
            }
        });

        btnDeleteBooking.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnDeleteBooking.setForeground(new java.awt.Color(255, 51, 0));
        btnDeleteBooking.setText("Xóa");
        btnDeleteBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBookingActionPerformed(evt);
            }
        });

        btnResetBooking.setText("Đặt lại");
        btnResetBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetBookingActionPerformed(evt);
            }
        });

        lblRoomNum2.setText("Mã đặt phòng:");

        cbbRoom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---- Chọn số phòng ----" }));

        lblAvail2.setText("Ngày tạo:");

        lblRoomPrice2.setText("Thời gian thuê (ngày):");

        spnDuration.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 153, 0));
        jButton1.setText("THANH TOÁN");

        jLabel2.setText("Tổng:");

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btnResetBooking)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAddBooking)
                        .addGap(40, 40, 40)
                        .addComponent(btnUpdateBooking)
                        .addGap(47, 47, 47)
                        .addComponent(btnSearchBooking)
                        .addGap(51, 51, 51)
                        .addComponent(btnDeleteBooking)
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblRoomNum1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblRoomNum2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblRoomType1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblRoomPrice1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAvail1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAvail2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblRoomPrice2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtBookingCode)
                            .addComponent(cbbRoom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbCustomer, 0, 269, Short.MAX_VALUE)
                            .addComponent(lblPriceRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblStaff, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBookingDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spnDuration)
                            .addComponent(lblTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(68, 68, 68))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnResetBooking)
                .addGap(56, 56, 56)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRoomNum2)
                    .addComponent(txtBookingCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRoomNum1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPriceRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRoomType1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRoomPrice2)
                    .addComponent(spnDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRoomPrice1)
                    .addComponent(cbbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAvail1)
                    .addComponent(lblStaff))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblBookingDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAvail2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotal))
                .addGap(60, 60, 60)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddBooking)
                    .addComponent(btnUpdateBooking)
                    .addComponent(btnSearchBooking)
                    .addComponent(btnDeleteBooking))
                .addGap(48, 48, 48)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblBookingDate, lblPriceRoom, lblStaff, lblTotal, txtBookingCode});

        javax.swing.GroupLayout pnlBookingLayout = new javax.swing.GroupLayout(pnlBooking);
        pnlBooking.setLayout(pnlBookingLayout);
        pnlBookingLayout.setHorizontalGroup(
            pnlBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBookingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlBookingLayout.setVerticalGroup(
            pnlBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBookingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );

        tabPnl.addTab("Phiếu đăng ký", pnlBooking);

        lblStaffID.setText("Mã nhân viên:");

        lblName.setText("Tên nhân viên:");

        lblRole.setText("Chức vụ:");

        lblAddress.setText("Địa chỉ:");

        lblGender.setText("Giới tính:");

        btnGroupGender.add(rbtnMale);
        rbtnMale.setText("Nam");

        btnGroupGender.add(rbtnFemale);
        rbtnFemale.setText("Nữ");

        lblBirthDate.setText("Ngày sinh:");

        lblPhone.setText("Số điện thoại:");

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(0, 153, 204));
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(0, 153, 102));
        btnUpdate.setText("Cập nhật");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 51, 0));
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSearch.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSearch.setText("Tìm kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnReset.setText("Đặt lại");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        spnBirthDate.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, new java.util.Date(), java.util.Calendar.DAY_OF_MONTH));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách nhân viên:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        tblStaffs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Tên", "Chức vụ", "Giới tính"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStaffs.setRowHeight(30);
        tblStaffs.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblStaffs.getTableHeader().setReorderingAllowed(false);
        tblStaffs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStaffsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStaffs);
        if (tblStaffs.getColumnModel().getColumnCount() > 0) {
            tblStaffs.getColumnModel().getColumn(0).setResizable(false);
            tblStaffs.getColumnModel().getColumn(1).setResizable(false);
            tblStaffs.getColumnModel().getColumn(2).setResizable(false);
            tblStaffs.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblSalary.setText("Lương:");

        spnSalary.setModel(new javax.swing.SpinnerNumberModel(0.0f, 0.0f, null, 1.0f));

        lblPassword.setText("Mật khẩu:");

        tbtnChangePW.setText("Đổi");
        tbtnChangePW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnChangePWActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlStaffLayout = new javax.swing.GroupLayout(pnlStaff);
        pnlStaff.setLayout(pnlStaffLayout);
        pnlStaffLayout.setHorizontalGroup(
            pnlStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlStaffLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
            .addGroup(pnlStaffLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(pnlStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlStaffLayout.createSequentialGroup()
                        .addGroup(pnlStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlStaffLayout.createSequentialGroup()
                                .addComponent(lblStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlStaffLayout.createSequentialGroup()
                                .addGroup(pnlStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tbtnChangePW)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addGroup(pnlStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSalary, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtRole, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(spnSalary))
                        .addGap(80, 80, 80)
                        .addGroup(pnlStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBirthDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblGender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlStaffLayout.createSequentialGroup()
                                .addComponent(rbtnMale, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(93, 93, 93)
                                .addComponent(rbtnFemale))
                            .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(spnBirthDate))
                        .addGap(40, 40, 40))
                    .addGroup(pnlStaffLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(btnAdd)
                        .addGap(131, 131, 131)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108))))
            .addGroup(pnlStaffLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlStaffLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {spnBirthDate, spnSalary, txtAddress, txtName, txtPassword, txtPhone, txtRole, txtStaffID});

        pnlStaffLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, btnDelete, btnUpdate});

        pnlStaffLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblName, lblPassword, lblStaffID});

        pnlStaffLayout.setVerticalGroup(
            pnlStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStaffLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnReset)
                .addGap(35, 35, 35)
                .addGroup(pnlStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlStaffLayout.createSequentialGroup()
                        .addGroup(pnlStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStaffID)
                            .addComponent(txtStaffID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRole)
                            .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSalary)
                            .addComponent(spnSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlStaffLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(pnlStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBirthDate))
                        .addGap(18, 18, 18)
                        .addGroup(pnlStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPhone))
                        .addGap(18, 18, Short.MAX_VALUE)))
                .addGroup(pnlStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGender)
                    .addComponent(rbtnMale)
                    .addComponent(rbtnFemale)
                    .addComponent(tbtnChangePW))
                .addGap(41, 41, 41)
                .addGroup(pnlStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlStaffLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblName, lblPassword, lblStaffID});

        pnlStaffLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {spnBirthDate, spnSalary, txtAddress, txtName, txtPassword, txtPhone, txtRole, txtStaffID});

        pnlStaffLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAdd, btnDelete, btnSearch, btnUpdate});

        tabPnl.addTab("Nhân viên", pnlStaff);

        tblRooms.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Số phòng", "Loại phòng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRooms.getTableHeader().setReorderingAllowed(false);
        tblRooms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRoomsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblRooms);
        if (tblRooms.getColumnModel().getColumnCount() > 0) {
            tblRooms.getColumnModel().getColumn(0).setResizable(false);
            tblRooms.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết phòng:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        lblRoomNum.setText("Số phòng:");

        lblRoomType.setText("Loại phòng:");

        cbbRoomType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---- Chọn loại phòng ----", "Thường", "VIP" }));

        lblRoomPrice.setText("Giá phòng:");

        spnRoomPrice.setModel(new javax.swing.SpinnerNumberModel(0.0f, 0.0f, null, 1.0f));

        lblAvail.setText("Tình trạng:");

        btnAddRoom.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnAddRoom.setForeground(new java.awt.Color(0, 153, 255));
        btnAddRoom.setText("Thêm");
        btnAddRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRoomActionPerformed(evt);
            }
        });

        btnUpdateRoom.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnUpdateRoom.setForeground(new java.awt.Color(0, 153, 102));
        btnUpdateRoom.setText("Cập nhật");
        btnUpdateRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateRoomActionPerformed(evt);
            }
        });

        btnSearchRoom.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSearchRoom.setText("Tìm kiếm");
        btnSearchRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchRoomActionPerformed(evt);
            }
        });

        btnDeleteRoom.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnDeleteRoom.setForeground(new java.awt.Color(255, 51, 0));
        btnDeleteRoom.setText("Xóa");
        btnDeleteRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteRoomActionPerformed(evt);
            }
        });

        btnResetRoom.setText("Đặt lại");
        btnResetRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetRoomActionPerformed(evt);
            }
        });

        cbbAvail.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn trống", "VIP" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnAddRoom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(btnUpdateRoom)
                .addGap(47, 47, 47)
                .addComponent(btnSearchRoom)
                .addGap(51, 51, 51)
                .addComponent(btnDeleteRoom)
                .addGap(39, 39, 39))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblAvail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblRoomType, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblRoomNum, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblRoomPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtRoomNum)
                            .addComponent(cbbRoomType, 0, 215, Short.MAX_VALUE)
                            .addComponent(spnRoomPrice, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbAvail, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(125, 125, 125))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnResetRoom)
                        .addGap(25, 25, 25))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnResetRoom)
                .addGap(96, 96, 96)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRoomNum)
                    .addComponent(txtRoomNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRoomType)
                    .addComponent(cbbRoomType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRoomPrice)
                    .addComponent(spnRoomPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAvail)
                    .addComponent(cbbAvail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddRoom)
                    .addComponent(btnUpdateRoom)
                    .addComponent(btnSearchRoom)
                    .addComponent(btnDeleteRoom))
                .addGap(98, 98, 98))
        );

        javax.swing.GroupLayout pnlRoomLayout = new javax.swing.GroupLayout(pnlRoom);
        pnlRoom.setLayout(pnlRoomLayout);
        pnlRoomLayout.setHorizontalGroup(
            pnlRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRoomLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlRoomLayout.setVerticalGroup(
            pnlRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRoomLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRoomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        tabPnl.addTab("Phòng", pnlRoom);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tabPnl)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(tabPnl)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            String id = txtStaffID.getText();
            String password = new String(txtPassword.getPassword());
            String name = txtName.getText().trim();
            String role = txtRole.getText();
            String address = txtAddress.getText();
            String phone = txtPhone.getText();
            String gender = "";
            if (rbtnMale.isSelected()) {
                gender = "Nam";
            } else if (rbtnFemale.isSelected()) {
                gender = "Nữ";
            }
            float salary = (float) spnSalary.getValue();
            java.util.Date date = (java.util.Date) spnBirthDate.getValue();
            Date birthDate = new Date(date.getTime());

            StaffDAO dao = new StaffDAO();
            String valid = "";
            if (id.isEmpty()) {
                valid += "Mã nhân viên không được bỏ trống! \n";
            } else if (dao.isExistedID(id)) {
                valid += "Mã nhân viên đã tồn tại! \n";
            }
            if (name.isEmpty()) {
                valid += "Tên không được bỏ trống! \n";
            }
            if (password.isEmpty()) {
                valid += "Mật khẩu không được bỏ trống! \n";
            }
            if (role.isEmpty()) {
                valid += "Chức vụ không được bỏ trống! \n";
            }
            if (gender.isEmpty()) {
                valid += "Vui lòng chọn giới tính! \n";
            }

            if (valid.isEmpty()) {
                StaffDTO dto = new StaffDTO(name, role, gender, address, phone, birthDate, salary);
                dto.setId(id);
                dto.setPassword(password);
                if (dao.insert(dto)) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi! Thử lại sau!");
                }
                showAllStaffs();
                resetStaff();
            } else {
                JOptionPane.showMessageDialog(null, valid);
            }
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetStaff();
    }//GEN-LAST:event_btnResetActionPerformed

    private void tblStaffsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStaffsMouseClicked
        try {
            int row = tblStaffs.getSelectedRow();
            String id = (String) tblModelStaffs.getValueAt(row, 0);
            StaffDAO dao = new StaffDAO();
            StaffDTO dto = dao.findByID(id);

            txtStaffID.setText(id.toUpperCase());
            txtStaffID.setEditable(false);
            txtPassword.setText("");
            txtPassword.setEnabled(false);
            tbtnChangePW.setVisible(true);
            tbtnChangePW.setSelected(false);
            txtName.setText(dto.getName());
            txtRole.setText(dto.getRole());
            txtAddress.setText(dto.getAddress());
            txtPhone.setText(dto.getPhone());
            if (dto.getGender().equalsIgnoreCase("Nam")) {
                rbtnMale.setSelected(true);
            } else if (dto.getGender().equalsIgnoreCase("Nữ")) {
                rbtnFemale.setSelected(true);
            }
            spnSalary.setValue(dto.getSalary());
            spnBirthDate.setValue(new Timestamp(dto.getBirthDate().getTime()));

//            btnAdd.setEnabled(false);
//            btnSearch.setEnabled(false);
            btnUpdate.setEnabled(true);
            btnDelete.setEnabled(true);
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblStaffsMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            String id = txtStaffID.getText();
            String password = new String(txtPassword.getPassword());
            String name = txtName.getText().trim();
            String role = txtRole.getText();
            String address = txtAddress.getText();
            String phone = txtPhone.getText();
            String gender = "";
            if (rbtnMale.isSelected()) {
                gender = "Nam";
            } else if (rbtnFemale.isSelected()) {
                gender = "Nữ";
            }
            float salary = (float) spnSalary.getValue();
            java.util.Date date = (java.util.Date) spnBirthDate.getValue();
            Date birthDate = new Date(date.getTime());

            StaffDAO dao = new StaffDAO();
            String valid = "";
            if (name.isEmpty()) {
                valid += "Tên không được bỏ trống! \n";
            }

            if (txtPassword.isEnabled() && password.isEmpty()) {
                valid += "Mật khẩu không được bỏ trống! \n";
            }
            if (role.isEmpty()) {
                valid += "Chức vụ không được bỏ trống! \n";
            }
            if (gender.isEmpty()) {
                valid += "Vui lòng chọn giới tính! \n";
            }

            if (valid.isEmpty()) {
                StaffDTO dto = new StaffDTO(name, role, gender, address, phone, birthDate, salary);
                dto.setId(id);
                dto.setPassword(password);
                if (dao.update(dto)) {
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi! Thử lại sau!");
                }
                showAllStaffs();
                resetStaff();
            } else {
                JOptionPane.showMessageDialog(null, valid);
            }
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tbtnChangePWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnChangePWActionPerformed
        if (txtPassword.isEnabled()) {
            txtPassword.setText("");
            txtPassword.setEnabled(false);
        } else {
            txtPassword.setEnabled(true);
        }
    }//GEN-LAST:event_tbtnChangePWActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            String id = txtStaffID.getText();
            String name = txtName.getText().trim();
            String role = txtRole.getText();
            String address = txtAddress.getText();
            String phone = txtPhone.getText();
            String gender = "";
            if (rbtnMale.isSelected()) {
                gender = "Nam";
            } else if (rbtnFemale.isSelected()) {
                gender = "Nữ";
            }

            boolean valid = !(id.isEmpty() && name.isEmpty() && gender.isEmpty() && role.isEmpty() && address.isEmpty() && phone.isEmpty());
            if (valid) {
                StaffDTO dto = new StaffDTO(name, role, gender, address, phone, null, 0);
                dto.setId(id);
                StaffDAO dao = new StaffDAO();
                List<StaffDTO> result = dao.search(dto);
                tblModelStaffs.setRowCount(0); //xoa toan bo row tren bang
                if (!result.isEmpty()) { //neu co staff
                    for (StaffDTO x : result) {
                        tblModelStaffs.addRow(x.toVector()); //them vao bang mot row voi mot staff trong listStaff duoc chuyen sang dang Vector
                    }
                }
                if (result.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên nào!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập vào một trong những trường sau để tìm kiếm:\n*Mã nhân viên\n*Tên nhân viên\n*Chức vụ\n*Địa chỉ\n*Số điện thoại\n*Giới tính");
            }
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            String id = txtStaffID.getText();

            StaffDAO dao = new StaffDAO();
            int choice = JOptionPane.showConfirmDialog(this, "Xóa nhân viên này sẽ đồng thời xóa toàn bộ hóa đơn và phiếu đăng ký liên quan.\nBạn có chắc muốn tiếp tục?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                if (dao.delete(id)) {
                    JOptionPane.showMessageDialog(null, "Xóa thành công!");
                } else {
                    JOptionPane.showMessageDialog(null, "Lỗi! Thử lại sau!");
                }
                showAllStaffs();
                resetStaff();
            }
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCusAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusAddActionPerformed
        try {
            String id = txtCMND.getText();
            String name = txtCusName.getText().trim();
            String address = txtCusAddress.getText();
            String phone = txtCusPhone.getText();
            String gender = "";
            if (rbtnCusMale.isSelected()) {
                gender = "Nam";
            } else if (rbtnCusFemale.isSelected()) {
                gender = "Nữ";
            }
            String country = txtCountry.getText();

            CustomerDAO dao = new CustomerDAO();
            String valid = "";
            if (id.isEmpty()) {
                valid += "CMND không được bỏ trống! \n";
            } else if (dao.isExistedID(id)) {
                valid += "CMND đã tồn tại! \n";
            }
            if (name.isEmpty()) {
                valid += "Tên không được bỏ trống! \n";
            }
            if (gender.isEmpty()) {
                valid += "Vui lòng chọn giới tính! \n";
            }
            if (country.isEmpty()) {
                valid += "Quốc tịch không được bỏ trống! \n";
            }

            if (valid.isEmpty()) {
                CustomerDTO dto = new CustomerDTO(name, gender, address, phone, country);
                dto.setId(id);
                if (dao.insert(dto)) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi! Thử lại sau!");
                }
                showAllCustomers();
                resetCustomer();
            } else {
                JOptionPane.showMessageDialog(null, valid);
            }
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCusAddActionPerformed

    private void btnCusUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusUpdateActionPerformed
        try {
            String id = txtCMND.getText();
            String name = txtCusName.getText().trim();
            String address = txtCusAddress.getText();
            String phone = txtCusPhone.getText();
            String gender = "";
            if (rbtnCusMale.isSelected()) {
                gender = "Nam";
            } else if (rbtnCusFemale.isSelected()) {
                gender = "Nữ";
            }
            String country = txtCountry.getText();

            CustomerDAO dao = new CustomerDAO();
            String valid = "";
            
            if (name.isEmpty()) {
                valid += "Tên không được bỏ trống! \n";
            }
            if (gender.isEmpty()) {
                valid += "Vui lòng chọn giới tính! \n";
            }
            if (country.isEmpty()) {
                valid += "Quốc tịch không được bỏ trống! \n";
            }

            if (valid.isEmpty()) {
                CustomerDTO dto = new CustomerDTO(name, gender, address, phone, country);
                dto.setId(id);
                if (dao.update(dto)) {
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi! Thử lại sau!");
                }
                showAllCustomers();
                resetCustomer();
            } else {
                JOptionPane.showMessageDialog(null, valid);
            }
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCusUpdateActionPerformed

    private void btnCusDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusDeleteActionPerformed
        try {
            String id = txtCMND.getText();

            CustomerDAO dao = new CustomerDAO();
            int choice = JOptionPane.showConfirmDialog(this, "Xóa khách hàng này sẽ đồng thời xóa toàn bộ hóa đơn và phiếu đăng ký liên quan.\nBạn có chắc muốn tiếp tục?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                if (dao.delete(id)) {
                    JOptionPane.showMessageDialog(null, "Xóa thành công!");
                } else {
                    JOptionPane.showMessageDialog(null, "Lỗi! Thử lại sau!");
                }
                showAllCustomers();
                resetCustomer();
            }
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCusDeleteActionPerformed

    private void btnCusSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusSearchActionPerformed
        try {
            String id = txtCMND.getText();
            String name = txtCusName.getText().trim();
            String address = txtCusAddress.getText();
            String phone = txtCusPhone.getText();
            String gender = "";
            if (rbtnCusMale.isSelected()) {
                gender = "Nam";
            } else if (rbtnCusFemale.isSelected()) {
                gender = "Nữ";
            }
            String country = txtCountry.getText();

            boolean valid = !(id.isEmpty() && name.isEmpty() && gender.isEmpty() && address.isEmpty() && phone.isEmpty() && country.isEmpty());
            if (valid) {
                CustomerDTO dto = new CustomerDTO(name, gender, address, phone, country);
                dto.setId(id);
                CustomerDAO dao = new CustomerDAO();
                List<CustomerDTO> result = dao.search(dto);
                tblModelCustomers.setRowCount(0); //xoa toan bo row tren bang
                if (!result.isEmpty()) { //neu co customer
                    for (CustomerDTO x : result) {
                        tblModelCustomers.addRow(x.toVector()); //them vao bang mot row voi mot customer trong list duoc chuyen sang dang Vector
                    }
                }
                if (result.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng nào!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập vào một trong những trường sau để tìm kiếm:\n*CMND\n*Tên khách hàng\n*Giới tính\n*Địa chỉ\n*Số điện thoại\n*Quốc tịch");
            }
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCusSearchActionPerformed

    private void btnCusResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCusResetActionPerformed
        resetCustomer();
    }//GEN-LAST:event_btnCusResetActionPerformed

    private void tblCustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomersMouseClicked
        try {
            int row = tblCustomers.getSelectedRow();
            String id = (String) tblModelCustomers.getValueAt(row, 0);
            CustomerDAO dao = new CustomerDAO();
            CustomerDTO dto = dao.findByID(id);

            txtCMND.setText(id.toUpperCase());
            txtCMND.setEditable(false);
            txtCusName.setText(dto.getName());
            txtCusAddress.setText(dto.getAddress());
            txtCusPhone.setText(dto.getPhone());
            if (dto.getGender().equalsIgnoreCase("Nam")) {
                rbtnCusMale.setSelected(true);
            } else if (dto.getGender().equalsIgnoreCase("Nữ")) {
                rbtnCusFemale.setSelected(true);
            }
            txtCountry.setText(dto.getCountry());
            
            btnCusUpdate.setEnabled(true);
            btnCusDelete.setEnabled(true);
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblCustomersMouseClicked

    private void btnResetRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetRoomActionPerformed
        resetRoom();
    }//GEN-LAST:event_btnResetRoomActionPerformed

    private void btnAddRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRoomActionPerformed
        try {
            String id = txtRoomNum.getText();
            String type = cbbRoomType.getSelectedItem() + "";
            float price = (float) spnRoomPrice.getValue();

            RoomDAO dao = new RoomDAO();
            String valid = "";
            if (id.isEmpty()) {
                valid += "Số phòng không được bỏ trống! \n";
            } else if (dao.isExistedID(id)) {
                valid += "SỐ phòng đã tồn tại! \n";
            }
            if (cbbRoomType.getSelectedIndex() == 0) {
                valid += "Vui lòng chọn loại phòng! \n";
            }
            if (price <= 0) {
                valid += "Giá phòng phải lớn hơn 0! \n";
            }

            if (valid.isEmpty()) {
                RoomDTO dto = new RoomDTO(type, price);
                dto.setId(id);
                if (dao.insert(dto)) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi! Thử lại sau!");
                }
                showAllRooms();
                resetRoom();
            } else {
                JOptionPane.showMessageDialog(null, valid);
            }
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddRoomActionPerformed

    private void btnUpdateRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateRoomActionPerformed
        try {
            String id = txtRoomNum.getText();
            String type = cbbRoomType.getSelectedItem() + "";
            float price = (float) spnRoomPrice.getValue();

            RoomDAO dao = new RoomDAO();
            String valid = "";
            if (cbbRoomType.getSelectedIndex() == 0) {
                valid += "Vui lòng chọn loại phòng! \n";
            }
            if (price <= 0) {
                valid += "Giá phòng phải lớn hơn 0! \n";
            }

            if (valid.isEmpty()) {
                RoomDTO dto = new RoomDTO(type, price);
                dto.setId(id);
                if (dao.update(dto)) {
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi! Thử lại sau!");
                }
                showAllRooms();
                resetRoom();
            } else {
                JOptionPane.showMessageDialog(null, valid);
            }
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateRoomActionPerformed

    private void btnSearchRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchRoomActionPerformed
        try {
            String id = txtRoomNum.getText();
            String type = "";
            if (cbbRoomType.getSelectedIndex() != 0)
                type = cbbRoomType.getSelectedItem() + "";
            boolean isAvail = cbbAvail.getSelectedItem().equals("Còn trống");
            
            RoomDAO dao = new RoomDAO();
            RoomDTO dto = new RoomDTO();
            dto.setId(id);
            dto.setType(type);
            dto.setAvail(isAvail);
            List<RoomDTO> result = dao.search(dto);
            tblModelRooms.setRowCount(0); //xoa toan bo row tren bang
            if (!result.isEmpty()) { //neu co phong
                for (RoomDTO x : result) {
                    tblModelRooms.addRow(x.toVector()); //them vao bang mot row voi mot phong trong list duoc chuyen sang dang Vector
                }
            }
            if (result.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Không tìm thấy phòng nào!");
            }
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchRoomActionPerformed

    private void btnDeleteRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRoomActionPerformed
        try {
            String id = txtRoomNum.getText();

            RoomDAO dao = new RoomDAO();
            int choice = JOptionPane.showConfirmDialog(this, "Xóa phòng này sẽ đồng thời xóa toàn bộ hóa đơn và phiếu đăng ký liên quan.\nBạn có chắc muốn tiếp tục?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                if (dao.delete(id)) {
                    JOptionPane.showMessageDialog(null, "Xóa thành công!");
                } else {
                    JOptionPane.showMessageDialog(null, "Lỗi! Thử lại sau!");
                }
                showAllRooms();
                resetRoom();
            }
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteRoomActionPerformed

    private void tblRoomsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRoomsMouseClicked
        try {
            int row = tblRooms.getSelectedRow();
            String id = (String) tblModelRooms.getValueAt(row, 0);
            RoomDAO dao = new RoomDAO();
            RoomDTO dto = dao.findByID(id);

            txtRoomNum.setText(id.toUpperCase());
            txtRoomNum.setEditable(false);
            cbbRoomType.setSelectedItem(dto.getType());
            spnRoomPrice.setValue(dto.getPrice());
            if (dao.isAvailable(id)) {
                cbbAvail.setSelectedIndex(0);
            } else {
                cbbAvail.setSelectedIndex(1);
            }
            
            btnUpdateRoom.setEnabled(true);
            btnDeleteRoom.setEnabled(true);
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblRoomsMouseClicked

    private void tblBookingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBookingsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblBookingsMouseClicked

    private void btnAddBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBookingActionPerformed
        try {
            String code = txtBookingCode.getText();
            String room = cbbRoom.getSelectedItem().toString().split(" - ")[0]; //lay so phong tu chuoi gom so phong - loai phong
            int duration = (int) spnDuration.getValue();
            String customer = cbbCustomer.getSelectedItem() + "";
            Timestamp date = Timestamp.valueOf(LocalDateTime.now());

            BookingDAO dao =  new BookingDAO();
            String valid = "";
            if (code.isEmpty()) {
                valid += "Mã đặt phòng không được bỏ trống! \n";
            } else if (dao.isExistedID(code)) {
                valid += "Mã đặt phòng đã tồn tại! \n";
            }
            if (cbbRoom.getSelectedIndex() == 0) {
                valid += "Vui lòng chọn phòng! \n";
            }
            if (cbbCustomer.getSelectedIndex() == 0) {
                valid += "Vui lòng chọn khách hàng! \n";
            }

            if (valid.isEmpty()) {
                BookingDTO dto = new BookingDTO(customer, this.staff, room, duration, date);
                dto.setCode(code);
                if (dao.insert(dto)) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi! Thử lại sau!");
                }
                showAllRooms();
                resetRoom();
            } else {
                JOptionPane.showMessageDialog(null, valid);
            }
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddBookingActionPerformed

    private void btnUpdateBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateBookingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateBookingActionPerformed

    private void btnSearchBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchBookingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchBookingActionPerformed

    private void btnDeleteBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBookingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteBookingActionPerformed

    private void btnResetBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetBookingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResetBookingActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StaffJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StaffJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StaffJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StaffJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddBooking;
    private javax.swing.JButton btnAddRoom;
    private javax.swing.JButton btnCusAdd;
    private javax.swing.JButton btnCusDelete;
    private javax.swing.JButton btnCusReset;
    private javax.swing.JButton btnCusSearch;
    private javax.swing.JButton btnCusUpdate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDeleteBooking;
    private javax.swing.JButton btnDeleteRoom;
    private javax.swing.ButtonGroup btnGroupGender;
    private javax.swing.ButtonGroup btnGroupGenderCus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnResetBooking;
    private javax.swing.JButton btnResetRoom;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearchBooking;
    private javax.swing.JButton btnSearchRoom;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdateBooking;
    private javax.swing.JButton btnUpdateRoom;
    private javax.swing.JComboBox<String> cbbAvail;
    private javax.swing.JComboBox<String> cbbCustomer;
    private javax.swing.JComboBox<String> cbbRoom;
    private javax.swing.JComboBox<String> cbbRoomType;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAvail;
    private javax.swing.JLabel lblAvail1;
    private javax.swing.JLabel lblAvail2;
    private javax.swing.JLabel lblBirthDate;
    private javax.swing.JLabel lblBookingDate;
    private javax.swing.JLabel lblCMND;
    private javax.swing.JLabel lblCusAddress;
    private javax.swing.JLabel lblCusGender;
    private javax.swing.JLabel lblCusName;
    private javax.swing.JLabel lblCusPhone;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNationality;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPriceRoom;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblRoomNum;
    private javax.swing.JLabel lblRoomNum1;
    private javax.swing.JLabel lblRoomNum2;
    private javax.swing.JLabel lblRoomPrice;
    private javax.swing.JLabel lblRoomPrice1;
    private javax.swing.JLabel lblRoomPrice2;
    private javax.swing.JLabel lblRoomType;
    private javax.swing.JLabel lblRoomType1;
    private javax.swing.JLabel lblSalary;
    private javax.swing.JLabel lblStaff;
    private javax.swing.JLabel lblStaffID;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnlBooking;
    private javax.swing.JPanel pnlCustomer;
    private javax.swing.JPanel pnlRoom;
    private javax.swing.JPanel pnlStaff;
    private javax.swing.JRadioButton rbtnCusFemale;
    private javax.swing.JRadioButton rbtnCusMale;
    private javax.swing.JRadioButton rbtnFemale;
    private javax.swing.JRadioButton rbtnMale;
    private javax.swing.JSpinner spnBirthDate;
    private javax.swing.JSpinner spnDuration;
    private javax.swing.JSpinner spnRoomPrice;
    private javax.swing.JSpinner spnSalary;
    private javax.swing.JTabbedPane tabPnl;
    private javax.swing.JTable tblBookings;
    private javax.swing.JTable tblCustomers;
    private javax.swing.JTable tblRooms;
    private javax.swing.JTable tblStaffs;
    private javax.swing.JToggleButton tbtnChangePW;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtBookingCode;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtCountry;
    private javax.swing.JTextField txtCusAddress;
    private javax.swing.JTextField txtCusName;
    private javax.swing.JTextField txtCusPhone;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtRole;
    private javax.swing.JTextField txtRoomNum;
    private javax.swing.JTextField txtStaffID;
    // End of variables declaration//GEN-END:variables
}
