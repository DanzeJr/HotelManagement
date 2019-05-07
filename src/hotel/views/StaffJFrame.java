/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.views;

import hotel.daos.BookingDAO;
import hotel.daos.CustomerDAO;
import hotel.daos.InvoiceDAO;
import hotel.daos.RoomDAO;
import hotel.daos.StaffDAO;
import hotel.dtos.BookingDTO;
import hotel.dtos.CustomerDTO;
import hotel.dtos.InvoiceDTO;
import hotel.dtos.RoomDTO;
import hotel.dtos.StaffDTO;
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

    private String staff;
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
        lblWelcome.setText("Welcome: " + staff.toUpperCase());
        //load toan bo staff vao bang
        tblModelCustomers = (DefaultTableModel) tblCustomers.getModel();
        tblModelInvoices = (DefaultTableModel) tblInvoices.getModel();
        tblModelBookings = (DefaultTableModel) tblBookings.getModel();
        btnCusUpdate.setEnabled(false);
        btnCusDelete.setEnabled(false);
        btnUpdateBooking.setEnabled(false);
        btnDeleteBooking.setEnabled(false);
        btnCheckOut.setEnabled(false);
        btnSave.setVisible(false);
        btnDeleteInvoice.setVisible(false);

        try {
            showAllCustomers();
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
    
    private void showAllInvoices() throws Exception {
        tblModelInvoices.setRowCount(0); //xoa toan bo row tren bang
        InvoiceDAO dao = new InvoiceDAO();
        List<InvoiceDTO> list = dao.getAllInvoices();
        if (!list.isEmpty()) { //neu co hoa don
            for (InvoiceDTO dto : list) {
                tblModelInvoices.addRow(dto.toVector()); //them vao bang mot row voi mot hoa don trong list duoc chuyen sang dang Vector
            }
        }
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
    
    private void resetBooking() {
        txtBookingCode.setText("");
        txtBookingCode.setEditable(true);
        
        BookingDAO dao = new BookingDAO();
        //load combo box room
        List<RoomDTO> listRoom;
        try {
            listRoom = dao.getAvailableRooms();
            cbbRoom.removeAllItems();
            cbbRoom.addItem("---- Chọn số phòng ----");
            for (RoomDTO room : listRoom) {
                cbbRoom.addItem(room.getId() + " - " + room.getType());
            }
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        cbbRoom.setEnabled(true);
        cbbCustomer.setEnabled(true);
        spnDuration.setEnabled(true);
        lblPriceRoom.setText("");
        spnDuration.setValue(1);
        cbbCustomer.setSelectedIndex(0);
        lblBookingDate.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        lblTotal.setText("");
        
        btnCheckOut.setText("THANH TOÁN");
        btnCheckOut.setEnabled(false);
        btnUpdateBooking.setEnabled(false);
        btnDeleteBooking.setEnabled(false);
    }
    
    private void resetInvoice() {
        txtInvoiceCode.setText("");
        txtInvoiceCode.setEditable(true);
        lblBookingCode.setText("");
        cbbCustomerInvoice.setSelectedIndex(0);
        cbbCustomerInvoice.setEnabled(true);
        lblDateCheckOut.setText("");
        lblTotalInvoice.setText("");
        
        btnSave.setVisible(false);
        btnDeleteInvoice.setVisible(false);
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
        btnRefreshCus = new javax.swing.JButton();
        pnlBooking = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblBookings = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lblRoomNum1 = new javax.swing.JLabel();
        lblRoomType1 = new javax.swing.JLabel();
        cbbCustomer = new javax.swing.JComboBox<>();
        lblRoomPrice1 = new javax.swing.JLabel();
        btnAddBooking = new javax.swing.JButton();
        btnUpdateBooking = new javax.swing.JButton();
        btnSearchBooking = new javax.swing.JButton();
        btnDeleteBooking = new javax.swing.JButton();
        btnResetBooking = new javax.swing.JButton();
        lblRoomNum2 = new javax.swing.JLabel();
        txtBookingCode = new javax.swing.JTextField();
        cbbRoom = new javax.swing.JComboBox<>();
        lblPriceRoom = new javax.swing.JLabel();
        lblAvail2 = new javax.swing.JLabel();
        lblBookingDate = new javax.swing.JLabel();
        lblRoomPrice2 = new javax.swing.JLabel();
        spnDuration = new javax.swing.JSpinner();
        btnCheckOut = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnRefreshCus1 = new javax.swing.JButton();
        pnlInvoice = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblInvoices = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        lblRoomType2 = new javax.swing.JLabel();
        cbbCustomerInvoice = new javax.swing.JComboBox<>();
        lblRoomPrice3 = new javax.swing.JLabel();
        lblAvail3 = new javax.swing.JLabel();
        btnSearchInvoice = new javax.swing.JButton();
        btnDeleteInvoice = new javax.swing.JButton();
        btnResetInvoice = new javax.swing.JButton();
        lblBookingCode = new javax.swing.JLabel();
        lblStaffInvoice = new javax.swing.JLabel();
        lblAvail4 = new javax.swing.JLabel();
        lblTotalInvoice = new javax.swing.JLabel();
        lblCheckOutDate = new javax.swing.JLabel();
        lblDateCheckOut = new javax.swing.JLabel();
        lblInvoiceCode = new javax.swing.JLabel();
        txtInvoiceCode = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnRefreshInvoice = new javax.swing.JButton();
        lblWelcome = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ KHÁCH SẠN");

        tabPnl.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabPnlStateChanged(evt);
            }
        });

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
                .addContainerGap(14, Short.MAX_VALUE))
        );

        lblNationality.setText("Quốc tịch:");

        lblCusGender.setText("Giới tính:");

        btnRefreshCus.setText("Refresh");
        btnRefreshCus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshCusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCustomerLayout = new javax.swing.GroupLayout(pnlCustomer);
        pnlCustomer.setLayout(pnlCustomerLayout);
        pnlCustomerLayout.setHorizontalGroup(
            pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCustomerLayout.createSequentialGroup()
                        .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCustomerLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
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
                                .addGap(177, 177, 177)
                                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblCusAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblNationality, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblCusPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtCusAddress)
                                    .addComponent(txtCusPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCountry, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 174, Short.MAX_VALUE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCustomerLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCustomerLayout.createSequentialGroup()
                                .addComponent(btnCusReset, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCustomerLayout.createSequentialGroup()
                                .addComponent(btnRefreshCus)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCustomerLayout.createSequentialGroup()
                                .addComponent(btnCusAdd)
                                .addGap(112, 112, 112)
                                .addComponent(btnCusUpdate)
                                .addGap(99, 99, 99)
                                .addComponent(btnCusSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(92, 92, 92)
                                .addComponent(btnCusDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );

        pnlCustomerLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblCMND, lblCusGender, lblCusName});

        pnlCustomerLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCusAdd, btnCusDelete, btnCusSearch, btnCusUpdate});

        pnlCustomerLayout.setVerticalGroup(
            pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCustomerLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnCusReset)
                .addGap(40, 40, 40)
                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCMND)
                    .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCusAddress)
                    .addComponent(txtCusAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCusName)
                    .addComponent(txtCusName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNationality)
                    .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCusGender)
                    .addComponent(rbtnCusMale)
                    .addComponent(rbtnCusFemale)
                    .addComponent(lblCusPhone)
                    .addComponent(txtCusPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCusAdd)
                    .addComponent(btnCusUpdate)
                    .addComponent(btnCusDelete)
                    .addComponent(btnCusSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(btnRefreshCus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        tblBookings.setRowHeight(30);
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
            tblBookings.getColumnModel().getColumn(3).setPreferredWidth(150);
        }

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết phiếu:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        lblRoomNum1.setText("Số phòng:");

        lblRoomType1.setText("Giá phòng:");

        cbbCustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---- Chọn khách hàng ----" }));

        lblRoomPrice1.setText("Khách hàng:");

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
        cbbRoom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbRoomItemStateChanged(evt);
            }
        });

        lblAvail2.setText("Ngày đặt:");

        lblRoomPrice2.setText("Thời gian thuê (ngày):");

        spnDuration.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spnDuration.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnDurationStateChanged(evt);
            }
        });

        btnCheckOut.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnCheckOut.setForeground(new java.awt.Color(255, 153, 0));
        btnCheckOut.setText("THANH TOÁN");
        btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOutActionPerformed(evt);
            }
        });

        jLabel2.setText("Tổng:");

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblRoomNum1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblRoomNum2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblRoomType1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblRoomPrice1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAvail2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblRoomPrice2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtBookingCode)
                            .addComponent(cbbRoom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbCustomer, 0, 269, Short.MAX_VALUE)
                            .addComponent(lblPriceRoom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBookingDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spnDuration)
                            .addComponent(lblTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 19, Short.MAX_VALUE)
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
                                .addGap(39, 39, 39))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
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
                .addGap(26, 26, 26)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(btnCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblBookingDate, lblPriceRoom, lblTotal, txtBookingCode});

        btnRefreshCus1.setText("Refresh");
        btnRefreshCus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshCus1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBookingLayout = new javax.swing.GroupLayout(pnlBooking);
        pnlBooking.setLayout(pnlBookingLayout);
        pnlBookingLayout.setHorizontalGroup(
            pnlBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBookingLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefreshCus1))
                .addGap(51, 51, 51)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBookingLayout.setVerticalGroup(
            pnlBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBookingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBookingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlBookingLayout.createSequentialGroup()
                        .addComponent(btnRefreshCus1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4)))
                .addContainerGap())
        );

        tabPnl.addTab("Phiếu đăng ký", pnlBooking);

        tblInvoices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Khách hàng", "Ngày thanh toán"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblInvoices.setRowHeight(30);
        tblInvoices.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblInvoices.getTableHeader().setReorderingAllowed(false);
        tblInvoices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInvoicesMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblInvoices);
        if (tblInvoices.getColumnModel().getColumnCount() > 0) {
            tblInvoices.getColumnModel().getColumn(0).setResizable(false);
            tblInvoices.getColumnModel().getColumn(1).setResizable(false);
            tblInvoices.getColumnModel().getColumn(2).setResizable(false);
            tblInvoices.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết hóa đơn:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        lblRoomType2.setText("Mã đặt phòng:");

        cbbCustomerInvoice.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---- Chọn khách hàng ----" }));

        lblRoomPrice3.setText("Khách hàng:");

        lblAvail3.setText("Nhân viên thanh toán:");

        btnSearchInvoice.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSearchInvoice.setText("Tìm kiếm");
        btnSearchInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchInvoiceActionPerformed(evt);
            }
        });

        btnDeleteInvoice.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnDeleteInvoice.setForeground(new java.awt.Color(255, 51, 0));
        btnDeleteInvoice.setText("Xóa");
        btnDeleteInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteInvoiceActionPerformed(evt);
            }
        });

        btnResetInvoice.setText("Đặt lại");
        btnResetInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetInvoiceActionPerformed(evt);
            }
        });

        lblAvail4.setText("Tổng tiền:");

        lblCheckOutDate.setText("Ngày thanh toán:");

        lblDateCheckOut.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N

        lblInvoiceCode.setText("Mã hóa đơn:");

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSave.setForeground(new java.awt.Color(0, 153, 0));
        btnSave.setText("LƯU");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnResetInvoice)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblCheckOutDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblRoomType2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblRoomPrice3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAvail3, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(lblAvail4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblInvoiceCode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbbCustomerInvoice, 0, 269, Short.MAX_VALUE)
                            .addComponent(lblBookingCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblStaffInvoice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTotalInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDateCheckOut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtInvoiceCode, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(54, 54, 54))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(btnSave)
                .addGap(94, 94, 94)
                .addComponent(btnSearchInvoice)
                .addGap(86, 86, 86)
                .addComponent(btnDeleteInvoice)
                .addGap(58, 58, 58))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDeleteInvoice, btnSave, btnSearchInvoice});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(btnResetInvoice)
                .addGap(49, 49, 49)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInvoiceCode)
                    .addComponent(txtInvoiceCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblBookingCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRoomType2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRoomPrice3)
                    .addComponent(cbbCustomerInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAvail3)
                    .addComponent(lblStaffInvoice))
                .addGap(46, 46, 46)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTotalInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAvail4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCheckOutDate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDateCheckOut))
                .addGap(60, 60, 60)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearchInvoice)
                    .addComponent(btnDeleteInvoice)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDeleteInvoice, btnSave, btnSearchInvoice});

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblBookingCode, lblDateCheckOut, lblStaffInvoice, lblTotalInvoice, txtInvoiceCode});

        btnRefreshInvoice.setText("Refresh");
        btnRefreshInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshInvoiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInvoiceLayout = new javax.swing.GroupLayout(pnlInvoice);
        pnlInvoice.setLayout(pnlInvoiceLayout);
        pnlInvoiceLayout.setHorizontalGroup(
            pnlInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInvoiceLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefreshInvoice))
                .addGap(39, 39, 39)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlInvoiceLayout.setVerticalGroup(
            pnlInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlInvoiceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInvoiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlInvoiceLayout.createSequentialGroup()
                        .addComponent(btnRefreshInvoice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5)))
                .addContainerGap())
        );

        tabPnl.addTab("Hóa đơn", pnlInvoice);

        lblWelcome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(102, 204, 0));
        lblWelcome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblWelcome.setText("Welcome:");

        btnLogOut.setText("Đăng xuất");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabPnl)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 826, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblWelcome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLogOut)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogOut))
                .addGap(18, 18, 18)
                .addComponent(tabPnl)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnLogOut, lblWelcome});

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                    JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng nào!");
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

    private void tblBookingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBookingsMouseClicked
        try {               
            int row = tblBookings.getSelectedRow();
            String code = (String) tblModelBookings.getValueAt(row, 0);
            BookingDAO dao = new BookingDAO();
            BookingDTO dto = dao.findByID(code);
            
            
            txtBookingCode.setText(code.toUpperCase());
            txtBookingCode.setEditable(false);
            cbbRoom.removeAllItems();
            cbbRoom.addItem("---- Chọn số phòng ----");
            cbbRoom.addItem(dto.getRoom()); //vi combo box chi load cac phong con trong, phong nay da dat nen phai them thu cong
            if (dao.isDone(code)) {
                cbbRoom.setEnabled(false);
                cbbCustomer.setEnabled(false);
                spnDuration.setEnabled(false);
                btnUpdateBooking.setEnabled(false);
            } else {
                for (RoomDTO room : dao.getAvailableRooms()) {
                    cbbRoom.addItem(room.getId() + " - " + room.getType());
                }
                cbbRoom.setEnabled(true);
                cbbCustomer.setEnabled(true);
                spnDuration.setEnabled(true);
                btnUpdateBooking.setEnabled(true);
            }
            cbbRoom.setSelectedItem(dto.getRoom());
            lblPriceRoom.setText(dto.getRoomPrice() + "$");
            spnDuration.setValue(dto.getDuration());
            cbbCustomer.setSelectedItem(dto.getCustomer());
            lblBookingDate.setText(dto.getDate().toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            lblTotal.setText(dto.getRoomPrice() * dto.getDuration() + "$");
            
            if (dao.hasPayed(code)) {
                btnCheckOut.setText("ĐÃ THANH TOÁN");
                btnCheckOut.setEnabled(false);
            } else {
                btnCheckOut.setText("THANH TOÁN");
                btnCheckOut.setEnabled(true);
            }
            btnDeleteBooking.setEnabled(true);
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblBookingsMouseClicked

    private void btnAddBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBookingActionPerformed
        try {
            String code = txtBookingCode.getText();
            String room = cbbRoom.getSelectedItem().toString().split(" - ")[0]; //lay so phong tu chuoi gom so phong - loai phong
            int duration = (int) spnDuration.getValue();
            String customer = cbbCustomer.getSelectedItem().toString().split(" - ")[0]; //lay cmnd
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
                BookingDTO dto = new BookingDTO(customer, room, duration, date);
                dto.setCode(code);
                if (dao.insert(dto)) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi! Thử lại sau!");
                }
                //load lai combobox cua phong
                List<RoomDTO> listRoom = dao.getAvailableRooms();
                cbbRoom.removeAllItems();
                cbbRoom.addItem("---- Chọn số phòng ----");
                for (RoomDTO r : listRoom) {
                    cbbRoom.addItem(r.getId() + " - " + r.getType());
                }
                
                showAllBookings();
                resetBooking();
            } else {
                JOptionPane.showMessageDialog(null, valid);
            }
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddBookingActionPerformed

    private void btnUpdateBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateBookingActionPerformed
        try {
            String code = txtBookingCode.getText();
            String room = cbbRoom.getSelectedItem().toString().split(" - ")[0]; //lay so phong tu chuoi gom so phong - loai phong
            int duration = (int) spnDuration.getValue();
            String customer = cbbCustomer.getSelectedItem().toString().split(" - ")[0]; //lay cmnd

            BookingDAO dao =  new BookingDAO();
            String valid = "";
            
            if (cbbRoom.getSelectedIndex() == 0) {
                valid += "Vui lòng chọn phòng! \n";
            }
            if (cbbCustomer.getSelectedIndex() == 0) {
                valid += "Vui lòng chọn khách hàng! \n";
            }

            if (valid.isEmpty()) {
                BookingDTO dto = new BookingDTO(code, customer, room, duration);
                if (dao.update(dto)) {
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Lỗi! Thử lại sau!");
                }
                showAllBookings();
                resetBooking();
            } else {
                JOptionPane.showMessageDialog(null, valid);
            }
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateBookingActionPerformed

    private void btnSearchBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchBookingActionPerformed
        try {
            String code = txtBookingCode.getText();
            String customer = "";
            if (cbbCustomer.getSelectedIndex() != 0)
                customer = cbbCustomer.getSelectedItem().toString().split(" - ")[0];
            
            boolean valid = !(code.isEmpty() && customer.isEmpty());
            if (valid) {
                BookingDAO dao = new BookingDAO();
                BookingDTO dto = new BookingDTO();
                dto.setCode(code);
                dto.setCustomer(customer);
                List<BookingDTO> result = dao.search(dto);
                tblModelBookings.setRowCount(0); //xoa toan bo row tren bang
                if (!result.isEmpty()) { //neu co phieu
                    for (BookingDTO x : result) {
                        tblModelBookings.addRow(x.toVector()); //them vao bang mot row voi mot phieu trong list duoc chuyen sang dang Vector
                    }
                }
                if (result.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy phiếu đăng ký nào!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn vào một trong những trường sau để tìm kiếm:\n*Mã đặt phòng\n*Khách hàng");
            }
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchBookingActionPerformed

    private void btnDeleteBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBookingActionPerformed
        try {
            String code = txtBookingCode.getText();

            BookingDAO dao = new BookingDAO();
            int choice = JOptionPane.showConfirmDialog(this, "Xóa phiếu đăng ký này sẽ đồng thời xóa toàn bộ hóa đơn liên quan.\nBạn có chắc muốn tiếp tục?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                if (dao.delete(code)) {
                    JOptionPane.showMessageDialog(null, "Xóa thành công!");
                } else {
                    JOptionPane.showMessageDialog(null, "Lỗi! Thử lại sau!");
                }
                showAllBookings();
                resetBooking();
            }
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteBookingActionPerformed

    private void btnResetBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetBookingActionPerformed
        resetBooking();
    }//GEN-LAST:event_btnResetBookingActionPerformed

    private void tabPnlStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabPnlStateChanged
        try {
            List<RoomDTO> listRoom;
            List<String> listCMND;
            BookingDAO dao = new BookingDAO();
            switch (tabPnl.getSelectedIndex()) {
                case 1:
                    resetBooking();
                    showAllBookings();
                                        
                    //load ngay dat
                    lblBookingDate.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
                    
                    //load combo box room
                    listRoom = dao.getAvailableRooms();
                    cbbRoom.removeAllItems();
                    cbbRoom.addItem("---- Chọn số phòng ----");
                    for (RoomDTO room : listRoom) {
                        cbbRoom.addItem(room.getId() + " - " + room.getType());
                    }
                    
                    //load combo box customer
                    listCMND = dao.getAllCustomers();
                    cbbCustomer.removeAllItems();
                    cbbCustomer.addItem("---- Chọn khách hàng ----");
                    for (String cmnd : listCMND) {
                        cbbCustomer.addItem(cmnd);
                    }                   
                    break;
                case 2:
                    showAllInvoices();
                    //load combo box room
                    listRoom = dao.getAvailableRooms();
                    cbbRoom.removeAllItems();
                    cbbRoom.addItem("---- Chọn số phòng ----");
                    for (RoomDTO room : listRoom) {
                        cbbRoom.addItem(room.getId() + " - " + room.getType());
                    }
                    
                    //load combo box customer
                    listCMND = dao.getAllCustomers();
                    cbbCustomerInvoice.removeAllItems();
                    cbbCustomerInvoice.addItem("---- Chọn khách hàng ----");
                    for (String cmnd : listCMND) {
                        cbbCustomerInvoice.addItem(cmnd);
                    }     
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_tabPnlStateChanged

    private void tblInvoicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInvoicesMouseClicked
        try {
            int row = tblInvoices.getSelectedRow();
            String code = (String) tblModelInvoices.getValueAt(row, 0);
            InvoiceDAO dao = new InvoiceDAO();
            InvoiceDTO dto = dao.findByID(code);

            txtInvoiceCode.setText(code.toUpperCase());
            txtInvoiceCode.setEditable(false);
            lblBookingCode.setText(dto.getBookingCode());
            cbbCustomerInvoice.setSelectedItem(dto.getCustomer());
            cbbCustomerInvoice.setEnabled(false);
            lblStaffInvoice.setText(dto.getStaff());
            lblTotalInvoice.setText(dto.getTotal() + "$");
            lblDateCheckOut.setText(dto.getDate().toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            
            btnDeleteInvoice.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tblInvoicesMouseClicked

    private void btnSearchInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchInvoiceActionPerformed
        try {
            String code = txtInvoiceCode.getText();
            String customer = "";
            if (cbbCustomerInvoice.getSelectedIndex() != 0)
                customer = cbbCustomerInvoice.getSelectedItem().toString().split(" - ")[0];
            
            boolean valid = !(code.isEmpty() && customer.isEmpty());
            if (valid) {
                InvoiceDAO dao = new InvoiceDAO();
                InvoiceDTO dto = new InvoiceDTO();
                dto.setCode(code);                
                dto.setCustomer(customer);
                List<InvoiceDTO> result = dao.search(dto);
                tblModelInvoices.setRowCount(0); //xoa toan bo row tren bang
                if (!result.isEmpty()) { //neu co hoa don
                    for (InvoiceDTO x : result) {
                        tblModelInvoices.addRow(x.toVector()); //them vao bang mot row voi mot hoa don trong list duoc chuyen sang dang Vector
                    }
                }
                if (result.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn nào!");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn vào một trong những trường sau để tìm kiếm:\n*Mã hóa đơn\n*Khách hàng");
            }
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchInvoiceActionPerformed

    private void btnDeleteInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteInvoiceActionPerformed
        try {
            String code = txtInvoiceCode.getText();

            InvoiceDAO dao = new InvoiceDAO();
            int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa hóa đơn này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                if (dao.delete(code)) {
                    JOptionPane.showMessageDialog(null, "Xóa thành công!");
                } else {
                    JOptionPane.showMessageDialog(null, "Lỗi! Thử lại sau!");
                }
                showAllInvoices();
                resetInvoice();
            }
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteInvoiceActionPerformed

    private void btnResetInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetInvoiceActionPerformed
        resetInvoice();
    }//GEN-LAST:event_btnResetInvoiceActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            String code = txtInvoiceCode.getText();
            String bookingCode = lblBookingCode.getText();
            String staff = lblStaffInvoice.getText();
            Timestamp date = Timestamp.valueOf(LocalDateTime.now());

            InvoiceDAO dao =  new InvoiceDAO();
            
            InvoiceDTO dto = new InvoiceDTO(code, bookingCode, staff, date);
            if (dao.insert(dto)) {
                JOptionPane.showMessageDialog(this, "Lưu thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Lỗi! Thử lại sau!");
            }
            showAllInvoices();
            resetInvoice();
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cbbRoomItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbRoomItemStateChanged
        if (cbbRoom.getSelectedIndex() > 0) {
            try {
                RoomDAO dao = new RoomDAO();
                String id = cbbRoom.getSelectedItem().toString().split(" - ")[0];
                int duration = (int) spnDuration.getValue();
                float price = dao.getPrice(id);
                lblPriceRoom.setText(price + "$");
                lblTotal.setText(price * duration + "$");
            } catch (Exception ex) {
                Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            lblPriceRoom.setText("");
            lblTotal.setText("");
        }
    }//GEN-LAST:event_cbbRoomItemStateChanged

    private void spnDurationStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnDurationStateChanged
        if (cbbRoom.getSelectedIndex() > 0) {
            try {
                RoomDAO dao = new RoomDAO();
                String id = cbbRoom.getSelectedItem().toString().split(" - ")[0];
                int duration = (int) spnDuration.getValue();
                float price = dao.getPrice(id);
                lblPriceRoom.setText(price + "$");
                lblTotal.setText(price * duration + "$");
            } catch (Exception ex) {
                Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            lblPriceRoom.setText("");
            lblTotal.setText("");
        }
    }//GEN-LAST:event_spnDurationStateChanged

    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed
        LocalDateTime date = LocalDateTime.now();
        txtInvoiceCode.setText(cbbRoom.getSelectedItem().toString().split(" - ")[0] + date.getYear() + date.getMonth() + date.getDayOfMonth() + date.getHour() + date.getMinute() + date.getSecond());
        txtInvoiceCode.setEditable(false);
        lblBookingCode.setText(txtBookingCode.getText());
        cbbCustomerInvoice.setEnabled(false);
        lblStaffInvoice.setText(this.staff);
        lblTotalInvoice.setText(lblTotal.getText());
        lblDateCheckOut.setText(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
                
        btnSave.setVisible(true);
        tabPnl.setSelectedIndex(2);        
        cbbCustomerInvoice.setSelectedItem(cbbCustomer.getSelectedItem() + "");
    }//GEN-LAST:event_btnCheckOutActionPerformed

    private void btnRefreshCusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshCusActionPerformed
        try {
            showAllCustomers();
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefreshCusActionPerformed

    private void btnRefreshCus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshCus1ActionPerformed
        try {
            showAllBookings();
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefreshCus1ActionPerformed

    private void btnRefreshInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshInvoiceActionPerformed
        try {
            showAllInvoices();
        } catch (Exception ex) {
            Logger.getLogger(StaffJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefreshInvoiceActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        this.dispose();
        new LoginJFrame().setVisible(true);
    }//GEN-LAST:event_btnLogOutActionPerformed

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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaffJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddBooking;
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JButton btnCusAdd;
    private javax.swing.JButton btnCusDelete;
    private javax.swing.JButton btnCusReset;
    private javax.swing.JButton btnCusSearch;
    private javax.swing.JButton btnCusUpdate;
    private javax.swing.JButton btnDeleteBooking;
    private javax.swing.JButton btnDeleteInvoice;
    private javax.swing.ButtonGroup btnGroupGender;
    private javax.swing.ButtonGroup btnGroupGenderCus;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnRefreshCus;
    private javax.swing.JButton btnRefreshCus1;
    private javax.swing.JButton btnRefreshInvoice;
    private javax.swing.JButton btnResetBooking;
    private javax.swing.JButton btnResetInvoice;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearchBooking;
    private javax.swing.JButton btnSearchInvoice;
    private javax.swing.JButton btnUpdateBooking;
    private javax.swing.JComboBox<String> cbbCustomer;
    private javax.swing.JComboBox<String> cbbCustomerInvoice;
    private javax.swing.JComboBox<String> cbbRoom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblAvail2;
    private javax.swing.JLabel lblAvail3;
    private javax.swing.JLabel lblAvail4;
    private javax.swing.JLabel lblBookingCode;
    private javax.swing.JLabel lblBookingDate;
    private javax.swing.JLabel lblCMND;
    private javax.swing.JLabel lblCheckOutDate;
    private javax.swing.JLabel lblCusAddress;
    private javax.swing.JLabel lblCusGender;
    private javax.swing.JLabel lblCusName;
    private javax.swing.JLabel lblCusPhone;
    private javax.swing.JLabel lblDateCheckOut;
    private javax.swing.JLabel lblInvoiceCode;
    private javax.swing.JLabel lblNationality;
    private javax.swing.JLabel lblPriceRoom;
    private javax.swing.JLabel lblRoomNum1;
    private javax.swing.JLabel lblRoomNum2;
    private javax.swing.JLabel lblRoomPrice1;
    private javax.swing.JLabel lblRoomPrice2;
    private javax.swing.JLabel lblRoomPrice3;
    private javax.swing.JLabel lblRoomType1;
    private javax.swing.JLabel lblRoomType2;
    private javax.swing.JLabel lblStaffInvoice;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalInvoice;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel pnlBooking;
    private javax.swing.JPanel pnlCustomer;
    private javax.swing.JPanel pnlInvoice;
    private javax.swing.JRadioButton rbtnCusFemale;
    private javax.swing.JRadioButton rbtnCusMale;
    private javax.swing.JSpinner spnDuration;
    private javax.swing.JTabbedPane tabPnl;
    private javax.swing.JTable tblBookings;
    private javax.swing.JTable tblCustomers;
    private javax.swing.JTable tblInvoices;
    private javax.swing.JTextField txtBookingCode;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtCountry;
    private javax.swing.JTextField txtCusAddress;
    private javax.swing.JTextField txtCusName;
    private javax.swing.JTextField txtCusPhone;
    private javax.swing.JTextField txtInvoiceCode;
    // End of variables declaration//GEN-END:variables
}
