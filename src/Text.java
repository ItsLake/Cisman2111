import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Text extends JFrame {
    private JTextField Name;
    private JLabel TextName;
    private JComboBox Surname;
    private JLabel TextComment;
    private JTextField Comment;
    private JLabel TextType;
    private JTextField Type;
    private JLabel TextLess;
    private JTextField Less;
    private JButton GO;
    private JLabel Error;

    static String srt = null;
    static String srtUser = null;
    static String srtPar = null;
    static String srtPul = null;
    static String srtProf = null;
    static String srtCont = null;
    static String textError = "Не коректно указано Фамилия";


    public Text (){
        super("Edit Contact");
        this.setBounds(50,50,400,300);
        this.setLayout(null);
        this.setDefaultCloseOperation(CommentsUser.DISPOSE_ON_CLOSE);

      Name = new JTextField();
      Name.setBounds(100,70,150,25);
      add(Name);

      TextName = new JLabel("UserName");
      TextName.setBounds(20,70,150,25);
      add(TextName);

      GO = new JButton("GO");
      GO.setBounds(20,175,350,40);
      add(GO);

      Error = new JLabel(textError);
      Error.setForeground(Color.RED);
      Error.setBounds(100,100,250,25);
      Error.setFont(new Font("serif",Font.PLAIN,16));
      add(Error);
      Error.setVisible(false);


        DateBaseHandler dateBaseHandler = new DateBaseHandler();

        GO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ResultSet res = dateBaseHandler.getUser(Name.getText());

                int coun = 0;

                try {
                    while (res.next()) {
                        coun++;
                        srt = res.getString(Const.NAME);
                        srtUser = res.getString(Const.USERNAME);
                        srtCont = res.getString(Const.CONTACTT);
                        srtPar = res.getString(Const.PARTRONYMIC);
                        srtProf = res.getString(Const.PROFESSION);
                        srtPul = res.getString(Const.PULPIT);
                        srtProf = res.getString(Const.PROFESSION);

                    }
                }catch (SQLException a){
                    a.printStackTrace();
                }
                if(coun >=1){
                    setVisible(false);
                    DataBaseInfo dataBaseInfo = new DataBaseInfo();
                    dataBaseInfo.setVisible(true);

                }else {
                    Error.setVisible(true);
                }
            }
        });
    }}

