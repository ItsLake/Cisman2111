import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JButton AddCont ;
    private JLabel MainText;
    private JButton AddCont1;
    private JButton windows3;

    public GUI (){
        super("Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(50, 50, 450, 250);
        this.setLayout(null);

        MainText = new JLabel("CISCOMAN");
        MainText.setBounds(175, 0, 100, 35);
        MainText.setFont(new Font("serif",Font.PLAIN, 16));
        add(MainText);

        AddCont = new JButton("Добавить контакт");
        AddCont.setBounds(25, 65, 175, 75);
        add(AddCont);


        AddCont1 = new JButton("Статистика");
        AddCont1.setBounds(25, 150, 400, 50);
        add(AddCont1);

        windows3 = new JButton("Изменить");
        windows3.setBounds(250, 65, 175, 75);
        add(windows3);

        AddCont1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Text text = new Text();
                text.setVisible(true);
                dispose();
            }
        });
        windows3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CommentsUser commentsUser = new CommentsUser();
                commentsUser.setVisible(true);
                dispose();
            }
        });

        AddCont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContactV2 contact = new ContactV2();
                contact.setVisible(true);
                dispose();
            }
        });

    }
}
