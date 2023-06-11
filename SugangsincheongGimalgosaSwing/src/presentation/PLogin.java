package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import control.CLogin;
import valueObject.VLogin;
import valueObject.VUserInfo;

public class PLogin extends JPanel {
    private CLogin cLogin;
    private JTextField txtID;
    private JPasswordField txtPass;
    private LoginListener loginListener; // 로그인 이벤트 리스너

    public PLogin() {
        this.setSize(600, 400);

        JLabel label = new JLabel("ID : ");
        JLabel password = new JLabel("PassWord : ");

        txtID = new JTextField(10);
        txtPass = new JPasswordField(10);

        JButton logbtn = new JButton("LogIn");

        this.add(label);
        this.add(txtID);
        this.add(password);
        this.add(txtPass);
        this.add(logbtn);

        logbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 로그인 버튼 클릭 시 loginListener를 통해 로그인 결과를 전달
                if (loginListener != null) {
                    loginListener.onLogin(login());
                }
            }
        });
    }

    public VUserInfo login() {
        String userId = txtID.getText();
        String password = new String(txtPass.getPassword()); // 패스워드 필드의 입력값을 문자열로 변환

        VLogin vLogin = new VLogin();
        vLogin.setUserId(userId);
        vLogin.setPassword(password);

        cLogin = new CLogin();
        VUserInfo vUserInfo = cLogin.login(vLogin);
        if (vUserInfo == null) {
            JOptionPane.showMessageDialog(null, "잘 못 입력하셨습니다.");
        } else {
            JOptionPane.showMessageDialog(null, vUserInfo.getName() + "님 안녕하세요");
        }

        return vUserInfo;
    }

    // 로그인 이벤트 리스너 설정
    public void setLoginListener(LoginListener listener) {
        this.loginListener = listener;
    }

    // 로그인 이벤트 리스너 인터페이스
    public interface LoginListener {
        void onLogin(VUserInfo vUserInfo);
    }
}
