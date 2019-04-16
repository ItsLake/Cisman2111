import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditUser extends JFrame{
    private JButton AddCont ;
    private JButton windows2;
    private JLabel MainText;

    public EditUser (){
        super("User");
        this.setBounds(50,50 ,400,300);
        this.setLayout(null);

        MainText = new JLabel("USER");
        MainText.setBounds(195,0,73,35);
        MainText.setFont(new Font("serif",Font.PLAIN, 16));
        add(MainText);

        AddCont = new JButton("Stat");
        AddCont.setBounds(25,100,150,75);
        add(AddCont);

        windows2 = new JButton("EDIT");
        windows2.setBounds(200,100,150,75);
        add(windows2);

        AddCont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Text text = new Text();
                text.setVisible(true);
            }
        });
        windows2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CommentsUser commentsUser = new CommentsUser();
                commentsUser.setVisible(true);
            }
        });
    }
}

