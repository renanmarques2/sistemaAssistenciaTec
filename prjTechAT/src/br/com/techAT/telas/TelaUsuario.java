package br.com.techAT.telas;

import java.sql.*;
import br.com.techAT.dal.ModuloConexao;
import br.com.techAT.modelDAO.UsuarioDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author Renan Marques
 */
public class TelaUsuario extends javax.swing.JInternalFrame {

    //variavel conexao DAL
    Connection conexao = null;
    //Pst e RS são frameworks do pacote java.sql
    //utilizados na preparação e execução das instruções SQL
    PreparedStatement pst = null;
    ResultSet rs = null;

    public TelaUsuario() {
        initComponents();
        conexao = ModuloConexao.conector();
        UsuarioDAO usuario = new UsuarioDAO();
    }

    private void consultar() {
        //método para consultar
        String sql = "SELECT * FROM tbusuarios WHERE idusuario=?";
        try {
            //setar a busca "?" no campo de texto
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUserId.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtUserNome.setText(rs.getString(2));
                txtUserCel.setText(rs.getString(3));
                txtUserLogin.setText(rs.getString(4));
                txtUserSenha.setText(rs.getString(5));
                //a linha abaixo seta o perfil do usuario ao comboBox
                comboUserPerfil.setSelectedItem(rs.getString(6));
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado", "Erro na consulta", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/br/com/techat/icones/iconErro.png")));
                //limpar os campos de texto
                txtUserNome.setText(null);
                txtUserCel.setText(null);
                txtUserLogin.setText(null);
                txtUserSenha.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void adicionar() {
        //método para adicionar
        String sql = "INSERT INTO tbusuarios(idusuario, usuario, celusuario, loginusuario, senhausuario, perfil) values (?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUserId.getText());
            pst.setString(2, txtUserNome.getText());
            pst.setString(3, txtUserCel.getText());
            pst.setString(4, txtUserLogin.getText());
            pst.setString(5, txtUserSenha.getText());
            pst.setString(6, comboUserPerfil.getSelectedItem().toString());
            //validação dos campos obrigatórios
            if ((txtUserId.getText().isEmpty()) || (txtUserNome.getText().isEmpty()) || (txtUserLogin.getText().isEmpty()) || (txtUserSenha.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos para prosseguir");
            } else {

                int confirma = JOptionPane.showConfirmDialog(null, "Confirmar cadastro?", "ATENÇÃO", JOptionPane.YES_NO_OPTION);
                if (confirma == JOptionPane.YES_OPTION) {
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Cadastro realizado", "Sucesso", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/br/com/techat/icones/iconOk.png")));
                    txtUserNome.setText(null);
                    txtUserCel.setText(null);
                    txtUserLogin.setText(null);
                    txtUserSenha.setText(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void alterar() {
        //método alteração
        String sql = "UPDATE tbusuarios set usuario=?, celusuario=?, loginusuario=?, senhausuario=?, perfil=? WHERE idusuario=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtUserNome.getText());
            pst.setString(2, txtUserCel.getText());
            pst.setString(3, txtUserLogin.getText());
            pst.setString(4, txtUserSenha.getText());
            pst.setString(5, comboUserPerfil.getSelectedItem().toString());
            pst.setString(6, txtUserId.getText());

            if ((txtUserId.getText().isEmpty()) || (txtUserNome.getText().isEmpty()) || (txtUserLogin.getText().isEmpty()) || (txtUserSenha.getText().isEmpty())) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos para prosseguir");
            } else {

                int confirma = JOptionPane.showConfirmDialog(null, "Confirmar alteração?", "ATENÇÃO", JOptionPane.YES_NO_OPTION);
                if (confirma == JOptionPane.YES_OPTION) {
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Alteração realizada", "Sucesso", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/br/com/techat/icones/iconOk.png")));
                    txtUserNome.setText(null);
                    txtUserCel.setText(null);
                    txtUserLogin.setText(null);
                    txtUserSenha.setText(null);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void remover() {
        //método remoção
        int confirma = JOptionPane.showConfirmDialog(null, "Confirmar remoção?", "ATENÇÃO", JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM tbusuarios WHERE idusuario=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtUserId.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Remoção realizada", "Sucesso", JOptionPane.ERROR_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/br/com/techat/icones/iconOk.png")));
                txtUserNome.setText(null);
                txtUserCel.setText(null);
                txtUserLogin.setText(null);
                txtUserSenha.setText(null);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUserId = new javax.swing.JTextField();
        txtUserNome = new javax.swing.JTextField();
        txtUserLogin = new javax.swing.JTextField();
        comboUserPerfil = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnUserAdd = new javax.swing.JButton();
        btnUserConsultar = new javax.swing.JButton();
        btnUserAlterar = new javax.swing.JButton();
        btnUserRemover = new javax.swing.JButton();
        txtUserSenha = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtUserCel = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Usuários");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/techAT/icones/iconeSobre.png"))); // NOI18N
        setOpaque(true);
        setPreferredSize(new java.awt.Dimension(638, 487));
        setVisible(true);

        jLabel1.setText("ID");

        jLabel2.setText("* Nome");

        jLabel3.setText("* Login");

        jLabel4.setText("* Senha");

        jLabel5.setText("* Perfil");

        comboUserPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuário", "Administrador" }));

        jLabel6.setText("Celular");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/techAT/icones/iconeSobre.png"))); // NOI18N
        jLabel7.setText("Usuários");

        btnUserAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/techAT/icones/iconAdd.png"))); // NOI18N
        btnUserAdd.setToolTipText("Adicionar");
        btnUserAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUserAdd.setPreferredSize(new java.awt.Dimension(85, 85));
        btnUserAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserAddActionPerformed(evt);
            }
        });

        btnUserConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/techAT/icones/iconConsultar.png"))); // NOI18N
        btnUserConsultar.setToolTipText("Consultar");
        btnUserConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUserConsultar.setPreferredSize(new java.awt.Dimension(85, 85));
        btnUserConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserConsultarActionPerformed(evt);
            }
        });

        btnUserAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/techAT/icones/iconAlterar.png"))); // NOI18N
        btnUserAlterar.setToolTipText("Alterar");
        btnUserAlterar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUserAlterar.setPreferredSize(new java.awt.Dimension(85, 85));
        btnUserAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserAlterarActionPerformed(evt);
            }
        });

        btnUserRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/techAT/icones/iconRemover.png"))); // NOI18N
        btnUserRemover.setToolTipText("Remover");
        btnUserRemover.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUserRemover.setPreferredSize(new java.awt.Dimension(85, 85));
        btnUserRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserRemoverActionPerformed(evt);
            }
        });

        jLabel8.setText("* Campos obrigatórios");

        try {
            txtUserCel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUserAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboUserPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(137, 389, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtUserLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(98, 98, 98))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(btnUserConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(43, 43, 43)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnUserAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(44, 44, 44)
                                                .addComponent(btnUserRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtUserSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(txtUserCel, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtUserNome))
                                .addGap(0, 0, Short.MAX_VALUE))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel8)
                .addGap(99, 99, 99)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtUserId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUserNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtUserCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUserLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(txtUserSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboUserPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUserConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUserAlterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnUserAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUserRemover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );

        getAccessibleContext().setAccessibleName("");

        setBounds(0, 0, 638, 505);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUserConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserConsultarActionPerformed
        // chamando metodo consultar
        consultar();
    }//GEN-LAST:event_btnUserConsultarActionPerformed

    private void btnUserAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserAddActionPerformed
        adicionar();
    }//GEN-LAST:event_btnUserAddActionPerformed

    private void btnUserAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserAlterarActionPerformed
        alterar();
    }//GEN-LAST:event_btnUserAlterarActionPerformed

    private void btnUserRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserRemoverActionPerformed
        remover();
    }//GEN-LAST:event_btnUserRemoverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUserAdd;
    private javax.swing.JButton btnUserAlterar;
    private javax.swing.JButton btnUserConsultar;
    private javax.swing.JButton btnUserRemover;
    private javax.swing.JComboBox<String> comboUserPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JFormattedTextField txtUserCel;
    private javax.swing.JTextField txtUserId;
    private javax.swing.JTextField txtUserLogin;
    private javax.swing.JTextField txtUserNome;
    private javax.swing.JTextField txtUserSenha;
    // End of variables declaration//GEN-END:variables
}
