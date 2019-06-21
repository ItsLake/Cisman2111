import javax.swing.*;
import java.awt.*;

public class MainPanel extends JFrame{
    public MainPanel(){
        super("Menu");
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(50, 50, 450, 250);
        this.setLayout(null);

        JLabel MainText = new JLabel("CISCOMAN");
        MainText.setBounds(175, 0, 100, 35);
        MainText.setFont(new Font("serif", Font.PLAIN, 16));
        add(MainText);


        JButton AddUser = new JButton("Добавить контакт");
        AddLine(AddUser, 25, 65, 175, 75);

        JButton StaticUser = new JButton("Статистика");
        AddLine(StaticUser, 25, 150, 400, 50);

        JButton EditUser = new JButton("Изменить");
        AddLine(EditUser, 250, 65, 175, 75);

        StaticUser.addActionListener(e -> {
            //click button
        });
        EditUser.addActionListener(e -> {
            /*ommentsUser commentsUser = new CommentsUser();
            commentsUser.setVisible(true);
            this.dis*/
        });
        AddUser.addActionListener(e -> {
            Windows windows = new Windows();
            windows.setVisible(true);
            this.dispose();

        });
    }
    private void AddLine(JButton jButton, int x, int y, int w, int h){
        jButton.setBounds(x, y, w, h);
        add(jButton);
    }
}
