/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package displays;

import controllers.Task;
import controllers.TaskController;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Loc Nguyen
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public static MainFrame it;
    
    public MainFrame() {
        it = this;
        initComponents();
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Home", jpnHome));
        tasks.add(new Task("Function1", jpnFunction1));
        tasks.add(new Task("Function2", jpnFunction2));
        tasks.add(new Task("Function3", jpnFunction3));
        tasks.add(new Task("Function4", jpnFunction4));
        tasks.add(new Task("Function5", jpnFunction5));
        tasks.add(new Task("Function6", jpnFunction6));
        tasks.add(new Task("Function7", jpnFunction7));

        TaskController controller = new TaskController(jpnWorkplace, tasks);
        controller.setDisplay("Home", jpnHome);
        controller.setEvent();
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Bạn có muốn đóng?", "Warning!", JOptionPane.YES_NO_OPTION) == 0) {
                    dispose();
                }
            }            
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jpnHome = new javax.swing.JPanel();
        jlbHome = new javax.swing.JLabel();
        jpnFunction3 = new javax.swing.JPanel();
        jlbFunction3 = new javax.swing.JLabel();
        jpnFunction2 = new javax.swing.JPanel();
        jlbFunction2 = new javax.swing.JLabel();
        jpnFunction1 = new javax.swing.JPanel();
        jlbFunction1 = new javax.swing.JLabel();
        jpnFunction4 = new javax.swing.JPanel();
        jlbFunction4 = new javax.swing.JLabel();
        jpnFunction5 = new javax.swing.JPanel();
        jlbFunction5 = new javax.swing.JLabel();
        jpnFunction7 = new javax.swing.JPanel();
        jlbFunction7 = new javax.swing.JLabel();
        jpnFunction6 = new javax.swing.JPanel();
        jlbFunction6 = new javax.swing.JLabel();
        jpnWorkplace = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Quản lý thông tin dân cư");
        setLocationByPlatform(true);
        setResizable(false);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(236, 236, 236));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jpnHome.setBackground(new java.awt.Color(236, 236, 236));

        jlbHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/home.png"))); // NOI18N

        javax.swing.GroupLayout jpnHomeLayout = new javax.swing.GroupLayout(jpnHome);
        jpnHome.setLayout(jpnHomeLayout);
        jpnHomeLayout.setHorizontalGroup(
            jpnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbHome, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );
        jpnHomeLayout.setVerticalGroup(
            jpnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbHome, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jpnFunction3.setBackground(new java.awt.Color(236, 236, 236));

        jlbFunction3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbFunction3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbFunction3.setText("Sử dụng nhà văn hóa");

        javax.swing.GroupLayout jpnFunction3Layout = new javax.swing.GroupLayout(jpnFunction3);
        jpnFunction3.setLayout(jpnFunction3Layout);
        jpnFunction3Layout.setHorizontalGroup(
            jpnFunction3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbFunction3, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
        );
        jpnFunction3Layout.setVerticalGroup(
            jpnFunction3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbFunction3, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jpnFunction2.setBackground(new java.awt.Color(236, 236, 236));

        jlbFunction2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbFunction2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbFunction2.setText("Thu phí");

        javax.swing.GroupLayout jpnFunction2Layout = new javax.swing.GroupLayout(jpnFunction2);
        jpnFunction2.setLayout(jpnFunction2Layout);
        jpnFunction2Layout.setHorizontalGroup(
            jpnFunction2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbFunction2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jpnFunction2Layout.setVerticalGroup(
            jpnFunction2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbFunction2, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jpnFunction1.setBackground(new java.awt.Color(236, 236, 236));

        jlbFunction1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbFunction1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbFunction1.setText("Hộ khẩu/Nhân khẩu");

        javax.swing.GroupLayout jpnFunction1Layout = new javax.swing.GroupLayout(jpnFunction1);
        jpnFunction1.setLayout(jpnFunction1Layout);
        jpnFunction1Layout.setHorizontalGroup(
            jpnFunction1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbFunction1, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
        );
        jpnFunction1Layout.setVerticalGroup(
            jpnFunction1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbFunction1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jpnFunction4.setBackground(new java.awt.Color(236, 236, 236));

        jlbFunction4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbFunction4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbFunction4.setText("Lịch sinh hoạt");

        javax.swing.GroupLayout jpnFunction4Layout = new javax.swing.GroupLayout(jpnFunction4);
        jpnFunction4.setLayout(jpnFunction4Layout);
        jpnFunction4Layout.setHorizontalGroup(
            jpnFunction4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbFunction4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jpnFunction4Layout.setVerticalGroup(
            jpnFunction4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbFunction4, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jpnFunction5.setBackground(new java.awt.Color(236, 236, 236));

        jlbFunction5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbFunction5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbFunction5.setText("Cấp phần thưởng");

        javax.swing.GroupLayout jpnFunction5Layout = new javax.swing.GroupLayout(jpnFunction5);
        jpnFunction5.setLayout(jpnFunction5Layout);
        jpnFunction5Layout.setHorizontalGroup(
            jpnFunction5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFunction5Layout.createSequentialGroup()
                .addComponent(jlbFunction5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpnFunction5Layout.setVerticalGroup(
            jpnFunction5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbFunction5, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jpnFunction7.setBackground(new java.awt.Color(236, 236, 236));

        jlbFunction7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbFunction7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbFunction7.setText("Phòng tránh Covid 19");

        javax.swing.GroupLayout jpnFunction7Layout = new javax.swing.GroupLayout(jpnFunction7);
        jpnFunction7.setLayout(jpnFunction7Layout);
        jpnFunction7Layout.setHorizontalGroup(
            jpnFunction7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnFunction7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbFunction7, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnFunction7Layout.setVerticalGroup(
            jpnFunction7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbFunction7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jpnFunction6.setBackground(new java.awt.Color(236, 236, 236));

        jlbFunction6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbFunction6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbFunction6.setText("Phản ánh/Kiến nghị");

        javax.swing.GroupLayout jpnFunction6Layout = new javax.swing.GroupLayout(jpnFunction6);
        jpnFunction6.setLayout(jpnFunction6Layout);
        jpnFunction6Layout.setHorizontalGroup(
            jpnFunction6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbFunction6, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
        );
        jpnFunction6Layout.setVerticalGroup(
            jpnFunction6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbFunction6, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jpnHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnFunction1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnFunction2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnFunction3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnFunction4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnFunction5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnFunction6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnFunction7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jpnFunction3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jpnFunction2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jpnFunction1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jpnFunction4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jpnFunction5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jpnFunction7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jpnFunction6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jpnWorkplace.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpnWorkplaceLayout = new javax.swing.GroupLayout(jpnWorkplace);
        jpnWorkplace.setLayout(jpnWorkplaceLayout);
        jpnWorkplaceLayout.setHorizontalGroup(
            jpnWorkplaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 972, Short.MAX_VALUE)
        );
        jpnWorkplaceLayout.setVerticalGroup(
            jpnWorkplaceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 493, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpnWorkplace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 972, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnWorkplace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(526, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel jlbFunction1;
    private javax.swing.JLabel jlbFunction2;
    private javax.swing.JLabel jlbFunction3;
    private javax.swing.JLabel jlbFunction4;
    private javax.swing.JLabel jlbFunction5;
    private javax.swing.JLabel jlbFunction6;
    private javax.swing.JLabel jlbFunction7;
    private javax.swing.JLabel jlbHome;
    private javax.swing.JPanel jpnFunction1;
    private javax.swing.JPanel jpnFunction2;
    private javax.swing.JPanel jpnFunction3;
    private javax.swing.JPanel jpnFunction4;
    private javax.swing.JPanel jpnFunction5;
    private javax.swing.JPanel jpnFunction6;
    private javax.swing.JPanel jpnFunction7;
    private javax.swing.JPanel jpnHome;
    private javax.swing.JPanel jpnWorkplace;
    // End of variables declaration//GEN-END:variables
}
