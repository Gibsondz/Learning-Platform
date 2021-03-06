package FrontEnd.pages;

import FrontEnd.ProfessorGUI;
import FrontEnd.StudentGUI;
import FrontEnd.components.PageNavigator;
import SharedDataObjects.CourseEmail;
import SharedDataObjects.Email;
import SharedDataObjects.ServerMessage;
import SharedDataObjects.Course;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Evan Mcphee
 */
public class Messenger extends Page {

    /**
     * Ctor, Creates new frame Messenger
     */
    public Messenger(PageNavigator userGUI, Course course, boolean isProf) {
        super(userGUI, isProf);
        initComponents();
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
            java.util.logging.Logger.getLogger(Messenger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Messenger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Messenger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Messenger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //Setting the text fields based off the users classification
        if(isProfessor) {
            fromField.setText(((ProfessorGUI) userGUI).getProfessor().getEmail());
            toField.setText(course.getName()+ " "+ course.getId()+ " students");
        }
        else {
            fromField.setText(((StudentGUI) userGUI).getStudent().getEmail());
            toField.setText(userGUI.getClient().communicate(new ServerMessage<Course>(course, "Professor")).getMessage());
        }

        /**
         * Calls the corresponding method for sending an email depending on user classification
         */
        sendB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(isProfessor){
                    ProfessorGUI profGUI= (ProfessorGUI) userGUI;
                    sendEmail(profGUI, course);
                }
                else{
                    StudentGUI studentGUI= (StudentGUI) userGUI;
                    sendEmail(studentGUI, course);
                }

                exitMessenger(course);
            }
        });

        /**
         * calls the exitMessenger Method
         */
        cancelB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitMessenger(course);
            }
        });
    }

    /**
     * creates all elements of the frame
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        userHeader = new javax.swing.JLabel();
        messengerHeader = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        toField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fromField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        subjectText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bodyText = new javax.swing.JTextArea();
        sendB = new javax.swing.JButton();
        cancelB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel6.setBackground(java.awt.Color.pink);

        userHeader.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        userHeader.setText("User:");

        messengerHeader.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        messengerHeader.setText("Messenger");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(375, 375, 375)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(userHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(messengerHeader))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(messengerHeader)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addComponent(userHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jPanel7.setBackground(java.awt.Color.orange);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("To:");

        toField.setEditable(false);
        toField.setBackground(new java.awt.Color(204, 204, 255));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("From:");

        fromField.setEditable(false);
        fromField.setBackground(new java.awt.Color(204, 204, 255));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Subject:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Body:");

        bodyText.setColumns(20);
        bodyText.setLineWrap(true);
        bodyText.setRows(5);

        jScrollPane1.setViewportView(bodyText);

        sendB.setText("Send");

        cancelB.setText("Cancel");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addComponent(cancelB)
                                                .addGap(49, 49, 49)
                                                .addComponent(sendB))
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel7Layout.createSequentialGroup()
                                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel3)
                                                                .addComponent(jLabel2)
                                                                .addComponent(jLabel1))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(toField)
                                                                .addComponent(fromField)
                                                                .addComponent(subjectText, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)))))
                                .addContainerGap(217, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
                jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(toField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(fromField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel7Layout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel3)
                                                .addComponent(subjectText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(sendB)
                                        .addComponent(cancelB))
                                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    /**
     * Gets text from the text areas in the GUI and sends the email to all students in the course
     * @param profGUI   current prof user
     * @param course    course directory the user is currently in
     */
    private void sendEmail(ProfessorGUI profGUI, Course course){

        Email email= new Email(profGUI.getProfessor().getEmail(),
                profGUI.getProfessor().getLogininfo().getPassword(),
                null, subjectText.getText(), bodyText.getText());

        System.out.println(profGUI.getProfessor().getLogininfo().getPassword());

        CourseEmail courseEmail= new CourseEmail(course, email);

        ServerMessage<CourseEmail> emailMessage= new ServerMessage<>(courseEmail, "AllStudents");
        profGUI.getClient().communicate(emailMessage);
    }

    /**
     * Gets text from the text areas of the GUI and sends the email to the courses corresponding professor
     * @param studentGUI current student user
     * @param course    course directory the user is currently in
     */
    private void sendEmail(StudentGUI studentGUI, Course course){

        Email email= new Email(studentGUI.getStudent().getEmail(),
                studentGUI.getStudent().getLogininfo().getPassword(),
                null, subjectText.getText(), bodyText.getText());

        System.out.println(studentGUI.getStudent().getLogininfo().getPassword());

        CourseEmail courseEmail= new CourseEmail(course, email);

        ServerMessage<CourseEmail> emailMessage= new ServerMessage<>(courseEmail, "ToProfessor");
        studentGUI.getClient().communicate(emailMessage);
    }

    /**
     * Closes the frame and reopens the course home page for the user
     * @param course    Current course directory the user is in
     */
    private void exitMessenger(Course course){

        if(isProfessor){
            Messenger.super.professorGUI.addPage(new ProfCourseHome(Messenger.super.professorGUI, course));
            Messenger.super.professorGUI.showPage();
        }
        else{
            Messenger.super.studentGUI.addPage(new StudentCourseHome(Messenger.super.studentGUI, course));
            Messenger.super.studentGUI.showPage();
        }

        setVisible(false);
    }

    // Variables declaration - do not modify
    private javax.swing.JTextArea bodyText;
    private javax.swing.JButton cancelB;
    private javax.swing.JTextField fromField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel messengerHeader;
    private javax.swing.JButton sendB;
    private javax.swing.JTextField subjectText;
    private javax.swing.JTextField toField;
    private javax.swing.JLabel userHeader;
    // End of variables declaration
}

