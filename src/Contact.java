import javax.swing.*;
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

    private JComboBox Training;

    private JLabel TextIntarn;
    private JComboBox Studant;

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
        this.setBounds(50, 50, 600, 350);
        this.setLayout(null);


        TextName = new JLabel("Имя");
        TextName.setFont(new Font("serif",Font.PLAIN, 16));
        TextName.setBounds(25, 20, 70, 20);
        add(TextName);


        Name = new JTextField();
        Name.setBounds(125, 20, 150, 25);
        add(Name);

        TextSurName = new JLabel("Фамилия");
        TextSurName.setFont(new Font("serif",Font.PLAIN, 16));
        TextSurName.setBounds(25, 65, 80, 20);
        add(TextSurName);

        SurName = new JTextField();
        SurName.setBounds(125, 65, 150, 25);
        add(SurName);

        TextPatronymic = new JLabel("Отчество");
        TextPatronymic.setFont(new Font("serif",Font.PLAIN, 16));
        TextPatronymic.setBounds(25, 105, 80, 20);
        add(TextPatronymic);

        Partronymic = new JTextField();
        Partronymic.setBounds(125, 105, 150, 25);
        add(Partronymic);

        TextPulpit = new JLabel("Кафедра");
        TextPulpit.setFont(new Font("serif",Font.PLAIN, 16));
        TextPulpit.setBounds(300, 20, 80, 20);
        add(TextPulpit);

        Pulpit = new JTextField();
        Pulpit.setBounds(435, 20, 150, 25);
        add(Pulpit);

        TextProfession = new JLabel("Специальность");
        TextProfession.setFont(new Font("serif",Font.PLAIN, 16));
        TextProfession.setBounds(300, 65, 140, 20);
        add(TextProfession);

        Profession = new JTextField();
        Profession.setBounds(435, 65, 150, 25);
        add(Profession);

        TextPrepod = new JLabel("Преподаватель");
        TextPrepod.setFont(new Font("serif", Font.PLAIN, 16));
        TextPrepod.setBounds(300, 105, 140, 25);
        add(TextPrepod);

        Prepod = new JTextField();
        Prepod.setBounds(435, 105, 150, 25);
        add(Prepod);

        TextContact = new JLabel("Контакты");
        TextContact.setFont(new Font("serif",Font.PLAIN, 16));
        TextContact.setBounds(25, 170, 90, 20);
        add(TextContact);

        Contactt = new JTextField();
        Contactt.setBounds(125, 170, 150, 25);
        add(Contactt);

        String[] item = {
                "Бюджет",
                "Контрак"
        };
        Training = new JComboBox(item);
        Training.setBounds(435, 210, 100, 25);
        add(Training);

        TextIntarn = new JLabel("Интерны");
        TextIntarn.setFont(new Font("serif",Font.PLAIN,16));
        TextIntarn.setBounds(300, 170, 80, 20);
        add(TextIntarn);

        String[] ite = {
                "1",
                "2",
                "3"
        };
        Studant = new JComboBox(ite);
        Studant.setBounds(435, 170, 150, 25);
        add(Studant);

        Save = new JButton("Сохранить");
        Save.setFont(new Font("serif",Font.PLAIN,16));
        Save.setBounds(300, 250, 150, 30);
        add(Save);


        Back = new JButton("Назад");
        Back.setFont(new Font("serif",Font.PLAIN,16));
        Back.setBounds(150, 250, 150, 30);
        add(Back);

        ErrorMes = new JLabel("NO DATE");
        ErrorMes.setForeground(Color.RED);
        ErrorMes.setBounds(250, 270, 250, 25);
        ErrorMes.setFont(new Font("serif",Font.PLAIN,16));
        add(ErrorMes);
        ErrorMes.setVisible(false);

        SaveMes = new JLabel("SAVE");
        SaveMes.setForeground(Color.GREEN);
        SaveMes.setBounds(250, 270, 250, 25);
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
