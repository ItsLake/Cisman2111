import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private JButton AddCont ;
    private JButton windows2;
    private JLabel MainText;

    public GUI (){
        super("Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(50,50 ,400,300);
        this.setLayout(null);

        MainText = new JLabel("CISMAN");
        MainText.setBounds(155,0,73,35);
        MainText.setFont(new Font("serif",Font.PLAIN, 16));
        add(MainText);

        AddCont = new JButton("Добавить контакт");
        AddCont.setBounds(25,100,150,75);
        add(AddCont);

        windows2 = new JButton("Текст");
        windows2.setBounds(200,100,150,75);
        add(windows2);

        AddCont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contact contact = new Contact();
                contact.setVisible(true);
            }
        });
        windows2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditUser editUser = new EditUser();
                editUser.setVisible(true);
            }
        });
    }
}
