import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class CommentsUser extends JFrame {
    private JLabel Name;
    private JLabel Date;
    private JLabel Comments;
    private JLabel Error;

    private JTextField UserName;
    private JTextField NowDate;
    private JTextField Comment;

    private JButton Done;

    static String textError = "Не коректно указано Фамилия";
    static String srt = null;
    static String srtte = null;
    static String Com = null;
    static String Dat = null;
    static String fin = null;
    static String methFin;

    public CommentsUser(){
        super ("CommentsUser");
        this.setBounds(50,50,400,300);
        this.setLayout(null);
        this.setDefaultCloseOperation(CommentsUser.DISPOSE_ON_CLOSE);

        Name = new JLabel("UserName");
        Name.setBounds(20,20,100,25);
        add(Name);

        UserName = new JTextField();
        UserName.setBounds(95,20,100,25);
        add(UserName);

        Comments = new JLabel("Comments");
        Comments.setBounds(20,50,100,25);
        add(Comments);

        Comment = new JTextField();
        Comment.setBounds(20,70,350,90);
        add(Comment);

        Done = new JButton("Save");
        Done.setBounds(20,175,350,40);
        add(Done);

        Error = new JLabel(textError);
        Error.setForeground(Color.RED);
        Error.setBounds(100,215,250,25);
        Error.setFont(new Font("serif",Font.PLAIN,16));
        add(Error);
        Error.setVisible(false);

        DateBaseHandler dateBaseHandler = new DateBaseHandler();

        Done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ResultSet res = dateBaseHandler.getUser(UserName.getText());

                int coun = 0;
                String mer = "";


                try {
                    while (res.next()) {
                        coun++;
                        srt = res.getString(Const.COMMENT);
                        Com = Comment.getText();
                        java.util.Date date = new Date();
                        Dat = date.toString();
                        String meth = res.getString(Const.GOPARI);
                        methFin = meth + " " + Dat;
                        fin = srt + " " + Dat + " "+ Com;
                        System.out.println(Com);

                    }
                }catch (SQLException a){
                    a.printStackTrace();
                }
                if(coun >=1){
                    if(Com.length() > mer.length()) {
                        ResultSet der = dateBaseHandler.updateUser(fin, UserName.getText());
                        System.out.println("work");
                    }
                    ResultSet test = dateBaseHandler.updateDate(methFin, UserName.getText());
                    setVisible(false);
                }else {
                    Error.setVisible(true);
                }
            }
        });

    }
}
