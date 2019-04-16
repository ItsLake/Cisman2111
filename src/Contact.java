import sun.awt.windows.ThemeReader;

import javax.swing.*;
import javax.swing.plaf.PanelUI;
import javax.xml.soap.Text;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Contact extends JFrame {

    private JLabel TextName;
    private JTextField Name;
    //Фамилия
    private JLabel TextSurName;
    private JTextField SurName;
    //Отчество
    private JLabel TextPatronymic;
    private JTextField Partronymic;
    //Кафедра
    private JLabel TextPulpit;
    private JTextField Pulpit;
    //Фах
    private JLabel TextProfession;
    private JTextField Profession;

    private JLabel TextContact;
    private JTextField Contactt;

    private JLabel TextTraining;
    private JCheckBoxMenuItem TrainingB;
    private JCheckBoxMenuItem TrainingK;

    private JLabel TextIntarn;
    private JCheckBoxMenuItem OneStudant;
    private JCheckBoxMenuItem TwoStudant;
    private JCheckBoxMenuItem ThreeStudant;

    private JLabel TextPrepod;
    private JTextField Prepod;

    private JLabel TextKyrs;
    private JTextField Kyrs;

    static JLabel SaveMes;
    static JLabel ErrorMes;

    private JButton Back;

    private JButton Save;

    public Contact(){
        super("Add Contact");
        this.setBounds(50,50,600,450);
        this.setLayout(null);


        TextName = new JLabel("Имя");
        TextName.setFont(new Font("serif",Font.PLAIN, 16));
        TextName.setBounds(25, 20, 50, 20);
        add(TextName);


        Name = new JTextField("");
        Name.setBounds(100,20,150,25);
        add(Name);

        TextSurName = new JLabel("Фамилия");
        TextSurName.setFont(new Font("serif",Font.PLAIN, 16));
        TextSurName.setBounds(25,65,70,20);
        add(TextSurName);

        SurName = new JTextField("");
        SurName.setBounds(100,65,150,25);
        add(SurName);

        TextPatronymic = new JLabel("Отчество");
        TextPatronymic.setFont(new Font("serif",Font.PLAIN, 16));
        TextPatronymic.setBounds(25,105,70,20);
        add(TextPatronymic);

        Partronymic = new JTextField("");
        Partronymic.setBounds(100,105,150,25);
        add(Partronymic);

        TextPulpit = new JLabel("Кафедра");
        TextPulpit.setFont(new Font("serif",Font.PLAIN, 16));
        TextPulpit.setBounds(300, 20, 70, 20);
        add(TextPulpit);

        Pulpit = new JTextField("");
        Pulpit.setBounds(415, 20, 150, 25);
        add(Pulpit);

        TextProfession = new JLabel("Специальность");
        TextProfession.setFont(new Font("serif",Font.PLAIN, 16));
        TextProfession.setBounds(300, 65, 110, 20);
        add(TextProfession);

        Profession = new JTextField("");
        Profession.setBounds(415, 65, 150, 25);
        add(Profession);

        TextPrepod = new JLabel("Prepod");
        TextPrepod.setFont(new Font("serif", Font.PLAIN, 16));
        TextPrepod.setBounds(300, 105, 50, 45);
        add(TextPrepod);

        Prepod = new JTextField();
        Prepod.setBounds(415, 105, 150, 25);
        add(Prepod);

        TextContact = new JLabel("Контакты");
        TextContact.setFont(new Font("serif",Font.PLAIN, 16));
        TextContact.setBounds(25,170,70,20);
        add(TextContact);

        Contactt = new JTextField("");
        Contactt.setBounds(140,170,150,25);
        add(Contactt);

        TextTraining = new JLabel("Форма");
        TextTraining.setFont(new Font("serif",Font.PLAIN, 16));
        TextTraining.setBounds(150,220,70,20);
        add(TextTraining);

        TrainingB = new JCheckBoxMenuItem("Б");
        TrainingB.setFont(new Font("serif",Font.PLAIN,16));
        TrainingB.setBounds(100,250,45,45);
        add(TrainingB);

        TrainingK = new JCheckBoxMenuItem("K");
        TrainingK.setFont(new Font("serif",Font.PLAIN,16));
        TrainingK.setBounds(180,250,45,45);
        add(TrainingK);

        TextIntarn = new JLabel("Интерны");
        TextIntarn.setFont(new Font("serif",Font.PLAIN,16));
        TextIntarn.setBounds(410,220,70,20);
        add(TextIntarn);

        OneStudant = new JCheckBoxMenuItem("1");
        OneStudant.setFont(new Font("serif",Font.PLAIN,16));
        OneStudant.setBounds(345,250,45,45);
        add(OneStudant);

        TwoStudant = new JCheckBoxMenuItem("2");
        TwoStudant.setFont(new Font("serif",Font.PLAIN,16));
        TwoStudant.setBounds(410,250,45,45);
        add(TwoStudant);

        ThreeStudant = new JCheckBoxMenuItem("3");
        ThreeStudant.setFont(new Font("serif",Font.PLAIN,16));
        ThreeStudant.setBounds(475,250,45,45);
        add(ThreeStudant);

        Save = new JButton("Сохранить");
        Save.setFont(new Font("serif",Font.PLAIN,16));
        Save.setBounds(300,350,150,30);
        add(Save);


        Back = new JButton("Назад");
        Back.setFont(new Font("serif",Font.PLAIN,16));
        Back.setBounds(150,350,150,30);
        add(Back);

        ErrorMes = new JLabel("NO DATE");
        ErrorMes.setForeground(Color.RED);
        ErrorMes.setBounds(250,380,250,25);
        ErrorMes.setFont(new Font("serif",Font.PLAIN,16));
        add(ErrorMes);
        ErrorMes.setVisible(false);

        SaveMes = new JLabel("SAVE");
        SaveMes.setForeground(Color.GREEN);
        SaveMes.setBounds(250,380,250,25);
        SaveMes.setFont(new Font("serif",Font.PLAIN,16));
        add(SaveMes);
        SaveMes.setVisible(false);

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        DateBaseHandler dateBaseHandler = new DateBaseHandler();
        Save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                dateBaseHandler.singUpUser(Name.getText(), SurName.getText(),Partronymic.getText(),Pulpit.getText(),Profession.getText(),Contactt.getText(),"1");
            }
        });

    }
}
