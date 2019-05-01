import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactV2 extends JFrame {
    private JTabbedPane vkladki = new JTabbedPane();

    private JPanel One = new JPanel();
    private JPanel Two = new JPanel();
    private JPanel search = new JPanel();

    private JTextField Name = new JTextField();
    private JTextField SurName = new JTextField();
    private JTextField Partronymic  = new JTextField();
    private JTextField Pulpit = new JTextField();
    private JTextField Profession = new JTextField();
    private JTextField Contactt = new JTextField();
    private JTextField Prepod = new JTextField();

    private JLabel TextName = new JLabel("Ім'я");
    private JLabel TextSurName = new JLabel("Призвище");;
    private JLabel TextPatronymic = new JLabel("По батькові");
    private JLabel TextPulpit = new JLabel("Кафедра");
    private JLabel TextProfession = new JLabel("Спеціальність");
    private JLabel TextContact  = new JLabel("Номер");
    private JLabel TextIntarn;
    private JLabel TextPrepod = new JLabel("Викладач");
    private JLabel NameTraining = new JLabel("Тренінг");
    private JLabel ParaText = new JLabel("Пара");
    static JLabel SaveMes = new JLabel("SAVE");
    static JLabel ErrorMes;


    private JComboBox Training;
    private JComboBox Studant;
    private JComboBox TrainingMain;
    private JComboBox Para;
    private JComboBox PeopleList = new JComboBox();

    private JButton Back = new JButton("Назад");
    private JButton Save = new JButton("Зберегти");

    private JList<String> TEst;
    private JScrollPane jScrollPane;


    private DefaultListModel defaultListModel = new DefaultListModel();
    DateBaseHandler dateBaseHandler = new DateBaseHandler();
    private static String namee ;
    private static String getItem [] = new String[24];
    int coun = 0;


    public ContactV2() {
        super("Name");
        this.setBounds(50, 50, 620, 420);
        getContentPane().add(vkladki);

        One.setLayout(null);
        Two.setLayout(null);

        vkladki.add("Заняття", One);
        vkladki.add("Тренінг", Two);

        search.setLayout(new BorderLayout());
        search.setBounds(125,93,150,70);
        search.setVisible(false);
        One.add(search);

        TEst = new JList<>(defaultListModel);
        TEst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        TEst.setLayoutOrientation(JList.VERTICAL);
        TEst.setVisibleRowCount(5);
        TEst.setBounds(0,0,150,20);

        jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(TEst);
        search.add(jScrollPane);

        One.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                search.setVisible(false);
            }
        });

       TEst.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(java.awt.event.MouseEvent e) {
               super.mouseClicked(e);
               SurName.setText(TEst.getSelectedValue());
               ResultSet res = dateBaseHandler.seart(SurName.getText());
               try {
                   while (res.next()) {
                       coun++;

                        Contactt.setText(res.getString(Const.CONTACTT));
                        Partronymic.setText(res.getString(Const.PARTRONYMIC));
                        Profession.setText(res.getString(Const.PROFESSION));
                        Pulpit.setText(res.getString(Const.PULPIT));
                        Name.setText(res.getString(Const.NAME));
                   }
               }catch (SQLException a){
                   a.printStackTrace();
               }
               search.setVisible(false);
           }
       });

        String NamePeople [] = {"Інтерн","Слухач", "Відвідувач","Лікарь","Парамед","Сер.Мед. персонал"};
        People(NamePeople);

        String TrainingMainText[] = {"Серцево-легенева реанімація", "Люмбальна пункція","В/в, в/м ін’єкції", "Постановка переферичного венозного катетеру", "Катетеризація центральної вени", "Крикотиреотомія", "Плевральна пункція", "Торакоцентез"};

        TrainingMain = new JComboBox(TrainingMainText);
        TrainingMain.setBounds(260, 20, 325, 25);
        One.add(TrainingMain);

        JText(Name,125,105,150,25);
        JText(Pulpit,435, 70, 150, 25);
        JText(Prepod,435, 140, 150, 25);
        JText(SurName,125, 70, 150, 25);
        JText(Contactt,125, 175, 150, 25);
        JText(Profession,435, 105, 150, 25);
        JText(Partronymic,125, 140, 150, 25);

        BoundsFont(TextName,16,15,105,70,20);
        BoundsFont(TextPulpit,16,300,70,80,20);
        BoundsFont(TextSurName,16,15,70,100,20);
        BoundsFont(ParaText,16,15, 240, 90, 20);
        BoundsFont(TextPrepod,16,300,140,140,25);
        BoundsFont(NameTraining,19,150,20,110,20);
        BoundsFont(TextContact,16,15, 175, 90, 20);
        BoundsFont(TextPatronymic,16,15,140,140,20);
        BoundsFont(TextProfession,16,300,105,140,20);

        SurName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                ResultSet res = dateBaseHandler.seart(SurName.getText());
                try {
                    while (res.next()) {
                        coun++;
                        SaveMes.setVisible(false);
                        namee = res.getString(Const.USERNAME);
                        defaultListModel.addElement(namee);
                        getItem [coun] = namee;

                    }
                }catch (SQLException a){
                    a.printStackTrace();
                }
                if(SurName.getText().length()<1 || defaultListModel.getSize() < 1){
                    search.setVisible(false);
                    defaultListModel.removeAllElements();
                }else search.setVisible(true);
            }
        });

        String[] NamberPara = {"1", "2", "3", "4"};

        Para = new JComboBox(NamberPara);
        Para.setBounds(125, 240, 90, 25);
        One.add(Para);

        String[] item = {"Бюджет", "Контрак"};

        Training = new JComboBox(item);
        Training.setBounds(485, 175, 100, 25);
        One.add(Training);

        TextIntarn = new JLabel("Курс/Форма");
        TextIntarn.setFont(new Font("serif", Font.PLAIN, 16));
        TextIntarn.setBounds(300, 175, 120, 20);
        One.add(TextIntarn);

        String[] ite = {"1", "2", "3"};
        Studant = new JComboBox(ite);
        Studant.setBounds(435, 175, 50, 25);
        One.add(Studant);

        Save.setFont(new Font("serif", Font.PLAIN, 16));
        Save.setBounds(300, 300, 150, 30);
        One.add(Save);

        Back.setFont(new Font("serif", Font.PLAIN, 16));
        Back.setBounds(150, 300, 150, 30);
        One.add(Back);

        ErrorMes = new JLabel("NO DATE");
        ErrorMes.setForeground(Color.RED);
        ErrorMes.setBounds(250, 320, 250, 25);
        ErrorMes.setFont(new Font("serif", Font.PLAIN, 16));
        One.add(ErrorMes);
        ErrorMes.setVisible(false);

        SaveMes.setForeground(Color.GREEN);
        BoundsFont(SaveMes,16,460,300,250,25);
        SaveMes.setVisible(false);
        One.add(SaveMes);

        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dateBaseHandler.singUpUser(Name.getText(), SurName.getText(), Partronymic.getText(), Pulpit.getText(), Profession.getText(), Contactt.getText(), "1");
                SaveMes.setVisible(true);
            }
        });
    }
    public void People(String [] namePeople){
        for (int e = 0; e < namePeople.length; e++){
            PeopleList.addItem(namePeople[e]);
        }
        PeopleList.setBounds(15, 20, 110, 25);
        One.add(PeopleList);
    }
    public void BoundsFont(JLabel name,int font, int x ,int y, int w, int h){
        name.setBounds(x,y,w,h);
        name.setFont(new Font("serif", Font.PLAIN,font));
        One.add(name);
    }
    public void JText(JTextField name,int x ,int y, int w, int h){
        name.setBounds(x,y,w,h);
        One.add(name);
    }
}