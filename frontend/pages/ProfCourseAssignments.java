package FrontEnd.pages;

import SharedDataObjects.Assignment;
import SharedDataObjects.Course;
import SharedDataObjects.ServerMessage;
import SharedDataObjects.Student;
import FrontEnd.ProfessorGUI;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Evan Mcphee
 */
public class ProfCourseAssignments extends Page {

    /**
     * Creates new frame ProfCourseAssignments
     */
    public ProfCourseAssignments(ProfessorGUI prof, Course course) {
        super(prof, true);
        initComponents();
        header.setText(course.getName() + " " + course.getId() + " - Assignments");
        userLabel.setText("User: " + prof.getProfessor().getFirstname() + "   " + prof.getProfessor().getLastname());
        this.course = course;
        refreshAssignmentList();
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
            java.util.logging.Logger.getLogger(ProfCourseAssignments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfCourseAssignments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfCourseAssignments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfCourseAssignments.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /**
         * Logout button event handler, just terminates the program when pressed
         */
        logoutB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        /**
         * Closes this frame and reopens the ProfCourseHome page
         */
        returnB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                professorGUI.addPage(new ProfCourseHome(prof,course));
                professorGUI.showPage();
                setVisible(false);
            }
        });

        /**
         * Sets the Assignment to Active and updates list of Assignments
         */
        activateAssignmentB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ServerMessage<Assignment> message = new ServerMessage<Assignment>(assignmentList.getSelectedValue(), "Activate");
            	professorGUI.getClient().communicate(message);
            	refreshAssignmentList();
            }
        });

        /**
         * Sets the Assignment to Not Active and updates list of Assignments
         */
        deActivateAssignmentB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ServerMessage<Assignment> message = new ServerMessage<Assignment>(assignmentList.getSelectedValue(), "Deactivate");
            	professorGUI.getClient().communicate(message);
            	refreshAssignmentList();
            }
        });

        /**
         * Fill the corresponding textfield with info from the object selected in the list
         */
        assignmentList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try
                {
	            	Assignment assign = assignmentList.getSelectedValue();
	            	assignName.setText(assign.getTitle());
	                assignCloseDate.setText(assign.getDue_date());
	                if(assign.isActive())
	                	assignStatus.setText("Active");
	                else
	                	assignStatus.setText("Inactive");
                }
                catch(NullPointerException z)
                {
                	assignmentList.clearSelection();
                }
            }
        });

        /**
         * Remove Assignment from DB and refresh assignmentList
         */
        removeAssignB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ServerMessage<Assignment> message = new ServerMessage<Assignment>(assignmentList.getSelectedValue(), "Delete");
            	professorGUI.getClient().communicate(message);
            	refreshAssignmentList();
            }
        });

        /**
         *
         */
        uploadAssignB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                professorGUI.addPage(new UploadAssignment(prof,course));
                professorGUI.showPage();
                setVisible(false);
            }
        });


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        userLabel = new javax.swing.JLabel();
        header = new javax.swing.JLabel();
        returnB = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        logoutB = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        activateAssignmentB = new javax.swing.JButton();
        deActivateAssignmentB = new javax.swing.JButton();
        removeAssignB = new javax.swing.JButton();
        dropboxB = new javax.swing.JButton();
        assignName = new javax.swing.JTextField();
  //      assignUpDate = new javax.swing.JTextField();
        assignCloseDate = new javax.swing.JTextField();
        assignStatus = new javax.swing.JTextField();
        uploadAssignB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.pink);

        userLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        userLabel.setText("User:");

        header.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        header.setText("CourseName Assignments");

        returnB.setText("Return to Course Home Page");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(returnB)
                                .addGap(220, 220, 220)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(header))
                                .addContainerGap(394, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(36, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(returnB)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(header)
                                                .addGap(18, 18, 18)
                                                .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(25, 25, 25))
        );

        jPanel2.setBackground(java.awt.Color.orange);

      
        jScrollPane1.setViewportView(assignmentList);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Assignments");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        logoutB.setText("Logout");

        jLabel7.setText("Select an assignment from the list for more information");

        jLabel5.setText("Assignment:");

        //jLabel6.setText("Date Uploaded:");

        jLabel8.setText("Drop Box Closed:");

        jLabel9.setText("Active:");

        activateAssignmentB.setText("Activate Assignment");

        deActivateAssignmentB.setText("DeActivate Assignment");

        removeAssignB.setText("Remove Assignment");

        dropboxB.setText("Assignment DropBox");

        assignName.setEditable(false);

       // assignUpDate.setEditable(false);

        assignCloseDate.setEditable(false);

        assignStatus.setEditable(false);

        uploadAssignB.setText("Upload New Assignment");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(96, 96, 96)
                                                .addComponent(jLabel7))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(activateAssignmentB, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel5)
                                                                .addComponent(jLabel6)
                                                                .addComponent(jLabel8)
                                                                .addComponent(jLabel9))
                                                        .addComponent(deActivateAssignmentB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(95, 95, 95)
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          //                                                      .addComponent(assignUpDate, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(assignName, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(assignCloseDate, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(assignStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(75, 75, 75)
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(removeAssignB, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(dropboxB, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(115, 115, 115)
                                                .addComponent(jLabel4)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(logoutB)
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(uploadAssignB))
                                                .addGap(48, 48, 48))))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(uploadAssignB)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(logoutB)
                                                .addContainerGap())
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel7)
                                                                .addGap(78, 78, 78))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(assignName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel5))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                                .addComponent(jLabel4)
                                                .addGap(28, 28, 28)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
           //                                             .addComponent(assignUpDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel6))
                                                .addGap(28, 28, 28)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(assignCloseDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel8))
                                                .addGap(31, 31, 31)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(assignStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel9))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(activateAssignmentB)
                                                        .addComponent(dropboxB))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(deActivateAssignmentB)
                                                        .addComponent(removeAssignB))
                                                .addGap(213, 213, 213))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>

    private void refreshAssignmentList()
    {
    	try
    	{
    		listmodel.clear();
    		ServerMessage<Course> message = new ServerMessage<Course>(course, "GetCourseAssignments");
    		ServerMessage<?> recieved = professorGUI.getClient().communicate(message);
    		ArrayList<?> list = (ArrayList<?>) recieved.getObject();
    		for(int i = 0; i < list.size(); i++)
	    	  {
	    		  listmodel.addElement((Assignment) list.get(i));
	    	  }
    	}
    	catch(NullPointerException k)
    	{
    		assignmentList.clearSelection();
    	}
    }

    // Variables declaration - do not modify
    private javax.swing.JButton activateAssignmentB;
    private javax.swing.JTextField assignCloseDate;
    private javax.swing.JTextField assignName;
    private javax.swing.JTextField assignStatus;
    //private javax.swing.JTextField assignUpDate;
    private DefaultListModel<Assignment>listmodel = new DefaultListModel<Assignment>();
    private JList<Assignment> assignmentList = new JList<>(listmodel);
    private javax.swing.JButton deActivateAssignmentB;
    private javax.swing.JButton dropboxB;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel header;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutB;
    private javax.swing.JButton removeAssignB;
    private javax.swing.JButton returnB;
    private javax.swing.JButton uploadAssignB;
    private javax.swing.JLabel userLabel;
    private Course course;
    // End of variables declaration
}
