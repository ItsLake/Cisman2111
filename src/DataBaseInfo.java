import javax.swing.*;
import java.awt.*;
import java.awt.image.ColorModel;

import static java.awt.Color.RED;

public class DataBaseInfo extends JFrame {
    private JLabel TextName;
    private JLabel Name;

    private JLabel TextSurName;
    private JLabel SurName;
    //Отчество
    private JLabel TextPatronymic;
    private JLabel Partronymic;
    //Кафедра
    private JLabel TextPulpit;
    private JLabel Pulpit;
    //Фах
    private JLabel TextProfession;
    private JLabel Profession;

    private JLabel TextContact;
    private JLabel Contactt;

    

    private JLabel TextTraining;
    private JCheckBoxMenuItem TrainingB;
    private JCheckBoxMenuItem TrainingK;

    private JLabel TextIntarn;
    private JCheckBoxMenuItem OneStudant;
    private JCheckBoxMenuItem TwoStudant;
    private JCheckBoxMenuItem ThreeStudant;

    private JLabel TextKyrs;
    private JTextField Kyrs;

    public DataBaseInfo(){
        super( "Info");
        this.setBounds(50,50,600,450);
        this.setLayout(null);
        this.setDefaultCloseOperation(CommentsUser.DISPOSE_ON_CLOSE);

        TextName = new JLabel("Name:");
        TextName.setBounds(30,20,150,25);
        TextName.setFont(new Font("serif",Font.PLAIN,16));
        add(TextName);

        Name = new JLabel(Text.srt);
        Name.setBounds(75,20,150,25);
        Name.setFont(new Font("serif",Font.PLAIN,16));
        add(Name);

        TextSurName = new JLabel("UserName:");
        TextSurName.setBounds(30,50,150,25);
        TextSurName.setFont(new Font("serif",Font.PLAIN,16));
        add(TextSurName);

        SurName = new JLabel(Text.srtUser);
        SurName.setBounds(110,50,150,25);
        SurName.setFont(new Font("serif",Font.PLAIN,16));
        add(SurName);

        TextPatronymic = new JLabel("Patronymic:");
        TextPatronymic.setBounds(30,80,150,25);
        TextPatronymic.setFont(new Font("serif",Font.PLAIN,16));
        add(TextPatronymic);

        Partronymic = new JLabel(Text.srtPar);
        Partronymic.setBounds(110,80,150,25);
        Partronymic.setFont(new Font("serif",Font.PLAIN,16));
        add(Partronymic);

        TextPulpit = new JLabel("Pulpitc:");
        TextPulpit.setBounds(30,110,150,25);
        TextPulpit.setFont(new Font("serif",Font.PLAIN,16));
        add(TextPulpit);

        Pulpit = new JLabel(Text.srtPul);
        Pulpit.setBounds(110,110,150,25);
        Pulpit.setFont(new Font("serif",Font.PLAIN,16));
        add(Pulpit);

        TextContact = new JLabel("Contact:");
        TextContact.setBounds(30,140,150,25);
        TextContact.setFont(new Font("serif",Font.PLAIN,16));
        add(TextContact);

        Contactt = new JLabel(Text.srtCont);
        Contactt.setBounds(110,140,150,25);
        Contactt.setFont(new Font("serif",Font.PLAIN,16));
        add(Contactt);

        TextProfession = new JLabel("Profession:");
        TextProfession.setBounds(30,170,150,25);
        TextProfession.setFont(new Font("serif",Font.PLAIN,16));
        add(TextProfession);

        Profession = new JLabel(Text.srtProf);
        Profession.setBounds(110,170,150,25);
        Profession.setFont(new Font("serif",Font.PLAIN,16));
        add(Profession);
    }
}
