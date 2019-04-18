/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.views;

import hotel.daos.StaffDAO;
import hotel.dtos.StaffDTO;
import java.sql.Date;
import java.sql.Timestamp;
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
        spnBirthDate.setEditor(new JSpinner.DateEditor(spnBirthDate, "dd-MM-yyyy")); //sua lai cach hien thi birth date
        //load toan bo staff vao bang
        tblModelStaffs = (DefaultTableModel) tblStaffs.getModel(); //lay model cua bang staffs
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

    private void resetStaff() {
        txtStaffID.setText("");
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupGender = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        tabPnl = new javax.swing.JTabbedPane();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ KHÁCH SẠN");

        lblStaffID.setText("Mã nhân viên:");

        lblName.setText("Tên nhân viên:");

        lblRole.setText("Chức vụ:");

        lblAddress.setText("Địa chỉ:");

        lblGender.setText("Giới tính:");

        btnGroupGender.add(rbtnMale);
        rbtnMale.setSelected(true);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
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

            //btnAdd.setEnabled(false);
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
    private javax.swing.JButton btnDelete;
    private javax.swing.ButtonGroup btnGroupGender;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBirthDate;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblSalary;
    private javax.swing.JLabel lblStaffID;
    private javax.swing.JPanel pnlStaff;
    private javax.swing.JRadioButton rbtnFemale;
    private javax.swing.JRadioButton rbtnMale;
    private javax.swing.JSpinner spnBirthDate;
    private javax.swing.JSpinner spnSalary;
    private javax.swing.JTabbedPane tabPnl;
    private javax.swing.JTable tblStaffs;
    private javax.swing.JToggleButton tbtnChangePW;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtRole;
    private javax.swing.JTextField txtStaffID;
    // End of variables declaration//GEN-END:variables
}
