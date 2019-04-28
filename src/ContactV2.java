import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactV2 extends JFrame {

    private JTabbedPane vkladki;
    private JPanel One;
    private JPanel Two;

    private JLabel TextName;
    private JTextField Name;

    private JLabel TextSurName;
    private JTextField SurName;

    private JLabel TextPatronymic;
    private JTextField Partronymic;

    private JLabel TextPulpit;
    private JTextField Pulpit;

    private JLabel TextProfession;
    private JTextField Profession;

    private JLabel TextContact;
    private JTextField Contactt;

    private JComboBox Training;

    private JLabel TextIntarn;
    private JComboBox Studant;

    private JLabel TextPrepod;
    private JTextField Prepod;

    static JLabel SaveMes;
    static JLabel ErrorMes;

    private JButton Back;

    private JButton Save;

    private JLabel NameTraining;
    private JComboBox TrainingMain;

    private JLabel ParaText;
    private JComboBox Para;

    private JComboBox Pipole;

    public ContactV2() {
        super("Name");
        this.setBounds(50, 50, 600, 420);

        vkladki = new JTabbedPane();
        getContentPane().add(vkladki);

        One = new JPanel();
        One.setLayout(null);
        Two = new JPanel();
        Two.setLayout(null);

        vkladki.add("Заняття", One);
        vkladki.add("Тренінг", Two);

        String[] NamePipol = {
                "Інтерн",
                "Слухач",
                "Відвідувач",
                "Лікарь",
                "Парамед",
                "Сер.Мед. персонал"
        };
        Pipole = new JComboBox(NamePipol);
        Pipole.setBounds(15, 20, 110, 25);
        One.add(Pipole);

        Pipole.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tst = (String) Pipole.getSelectedItem();

                if (tst == NamePipol[1]) {

                }
            }
        });

        NameTraining = new JLabel("Тренінг");
        NameTraining.setFont(new Font("serif", Font.PLAIN, 19));
        NameTraining.setBounds(150, 20, 110, 20);
        One.add(NameTraining);

        String TrainingMainText[] = {
                "Серцево-легенева реанімація",
                "Люмбальна пункція",
                "В/в, в/м ін’єкції",
                "Постановка переферичного венозного катетеру",
                "Катетеризація центральної вени",
                "Крикотиреотомія",
                "Плевральна пункція",
                "Торакоцентез"
        };


        TrainingMain = new JComboBox(TrainingMainText);
        TrainingMain.setBounds(260, 20, 325, 25);
        One.add(TrainingMain);

        TextName = new JLabel("Ім'я");
        TextName.setFont(new Font("serif", Font.PLAIN, 16));
        TextName.setBounds(15, 105, 70, 20);
        One.add(TextName);

        Name = new JTextField();
        Name.setBounds(125, 105, 150, 25);
        One.add(Name);

        TextSurName = new JLabel("Призвище");
        TextSurName.setFont(new Font("serif", Font.PLAIN, 16));
        TextSurName.setBounds(15, 70, 100, 20);
        One.add(TextSurName);

        SurName = new JTextField();
        SurName.setBounds(125, 70, 150, 25);
        One.add(SurName);

        TextPatronymic = new JLabel("По батькові");
        TextPatronymic.setFont(new Font("serif", Font.PLAIN, 16));
        TextPatronymic.setBounds(15, 140, 140, 20);
        One.add(TextPatronymic);

        Partronymic = new JTextField();
        Partronymic.setBounds(125, 140, 150, 25);
        One.add(Partronymic);

        TextPulpit = new JLabel("Кафедра");
        TextPulpit.setFont(new Font("serif", Font.PLAIN, 16));
        TextPulpit.setBounds(300, 70, 80, 20);
        One.add(TextPulpit);

        Pulpit = new JTextField();
        Pulpit.setBounds(435, 70, 150, 25);
        One.add(Pulpit);

        TextProfession = new JLabel("Спеціальність");
        TextProfession.setFont(new Font("serif", Font.PLAIN, 16));
        TextProfession.setBounds(300, 105, 140, 20);
        One.add(TextProfession);

        Profession = new JTextField();
        Profession.setBounds(435, 105, 150, 25);
        One.add(Profession);

        TextPrepod = new JLabel("Викладач");
        TextPrepod.setFont(new Font("serif", Font.PLAIN, 16));
        TextPrepod.setBounds(300, 140, 140, 25);
        One.add(TextPrepod);

        Prepod = new JTextField();
        Prepod.setBounds(435, 140, 150, 25);
        One.add(Prepod);

        TextContact = new JLabel("Номер");
        TextContact.setFont(new Font("serif", Font.PLAIN, 16));
        TextContact.setBounds(15, 175, 90, 20);
        One.add(TextContact);

        Contactt = new JTextField();
        Contactt.setBounds(125, 175, 150, 25);
        One.add(Contactt);

        ParaText = new JLabel("Пара");
        ParaText.setFont(new Font("serif", Font.PLAIN, 16));
        ParaText.setBounds(15, 240, 90, 20);
        One.add(ParaText);

        String[] NamberPara = {
                "1",
                "2",
                "3",
                "4"
        };
        Para = new JComboBox(NamberPara);
        Para.setBounds(125, 240, 90, 25);
        One.add(Para);

        String[] item = {
                "Бюджет",
                "Контрак"
        };
        Training = new JComboBox(item);
        Training.setBounds(485, 175, 100, 25);
        One.add(Training);

        TextIntarn = new JLabel("Курс/Форма");
        TextIntarn.setFont(new Font("serif", Font.PLAIN, 16));
        TextIntarn.setBounds(300, 175, 120, 20);
        One.add(TextIntarn);

        String[] ite = {
                "1",
                "2",
                "3"
        };
        Studant = new JComboBox(ite);
        Studant.setBounds(435, 175, 50, 25);
        One.add(Studant);


        Save = new JButton("Зберегти");
        Save.setFont(new Font("serif", Font.PLAIN, 16));
        Save.setBounds(300, 300, 150, 30);
        One.add(Save);


        Back = new JButton("Назад");
        Back.setFont(new Font("serif", Font.PLAIN, 16));
        Back.setBounds(150, 300, 150, 30);
        One.add(Back);

        ErrorMes = new JLabel("NO DATE");
        ErrorMes.setForeground(Color.RED);
        ErrorMes.setBounds(250, 320, 250, 25);
        ErrorMes.setFont(new Font("serif", Font.PLAIN, 16));
        One.add(ErrorMes);
        ErrorMes.setVisible(false);

        SaveMes = new JLabel("SAVE");
        SaveMes.setForeground(Color.GREEN);
        SaveMes.setBounds(250, 320, 250, 25);
        SaveMes.setFont(new Font("serif", Font.PLAIN, 16));
        One.add(SaveMes);
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

                dateBaseHandler.singUpUser(Name.getText(), SurName.getText(), Partronymic.getText(), Pulpit.getText(), Profession.getText(), Contactt.getText(), "1");
            }
        });
    }
}
