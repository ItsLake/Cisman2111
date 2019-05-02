import javax.swing.*;
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
    private JTextField Partronymic = new JTextField();
    private JTextField Pulpit = new JTextField();
    private JTextField Profession = new JTextField();
    private JTextField Contactt = new JTextField();
    private JTextField Prepod = new JTextField();
    JTextField ALL [] = {Name,SurName,Partronymic,Pulpit,Profession,Contactt,Prepod};

    private JLabel TextName = new JLabel("Ім'я");
    private JLabel TextSurName = new JLabel("Призвище");
    private JLabel TextPatronymic = new JLabel("По батькові");
    private JLabel TextPulpit = new JLabel("Кафедра");
    private JLabel TextProfession = new JLabel("Спеціальність");
    private JLabel TextContact = new JLabel("Номер");
    private JLabel TextIntarn = new JLabel("Курс/Форма");
    private JLabel TextPrepod = new JLabel("Викладач");
    private JLabel NameTraining = new JLabel("Тренінг");
    private JLabel ParaText = new JLabel("Пара");
    static JLabel SaveMes = new JLabel("SAVE");
    static JLabel ErrorMes = new JLabel("NO DATE");

    private JComboBox Training = new JComboBox();
    private JComboBox Studant = new JComboBox();
    private JComboBox TrainingMain = new JComboBox();
    private JComboBox Para = new JComboBox();
    private JComboBox PeopleList = new JComboBox();

    private JButton Back = new JButton("Назад");
    private JButton Save = new JButton("Зберегти");

    private JList<String> ListName = new JList<>();
    private JScrollPane jScrollPane = new JScrollPane();

    private DefaultListModel defaultListModel = new DefaultListModel();
    DateBaseHandler dateBaseHandler = new DateBaseHandler();
    private static String namee;
    private static String getItem[] = new String[24];
    int coun;

    public ContactV2() {
        super("Name");
        this.setBounds(50, 50, 620, 420);
        getContentPane().add(vkladki);

        JP(One, "Заняття");
        JP(Two, "Тренінг");

        Search(search, false, 125, 92, 150, 120);
        JSro(jScrollPane, ListName);

        String[] ite = {"1", "2", "3"};
        String[] item = {"Бюджет", "Контрак"};
        String[] NamberPara = {"1", "2", "3", "4"};
        String NamePeople[] = {"Інтерн", "Слухач", "Відвідувач", "Лікарь", "Парамед", "Сер.Мед. персонал"};
        String TrainingMainText[] = {"Серцево-легенева реанімація", "Люмбальна пункція", "В/в, в/м ін’єкції", "Постановка переферичного венозного катетеру", "Катетеризація центральної вени", "Крикотиреотомія", "Плевральна пункція", "Торакоцентез"};

        JText(Name, 125, 105, 150, 25);
        JText(Pulpit, 435, 70, 150, 25);
        JText(Prepod, 435, 140, 150, 25);
        JText(SurName, 125, 70, 150, 25);
        JText(Contactt, 125, 175, 150, 25);
        JText(Profession, 435, 105, 150, 25);
        JText(Partronymic, 125, 140, 150, 25);

        BoundsFont(TextName, 16, 15, 105, 70, 20);
        BoundsFont(SaveMes, 16, 460, 300, 250, 25);
        BoundsFont(TextPulpit, 16, 300, 70, 80, 20);
        BoundsFont(TextSurName, 16, 15, 70, 100, 20);
        BoundsFont(ParaText, 16, 15, 240, 90, 20);
        BoundsFont(TextPrepod, 16, 300, 140, 140, 25);
        BoundsFont(NameTraining, 19, 150, 20, 110, 20);
        BoundsFont(ErrorMes, 16, 460, 300, 250, 25);
        BoundsFont(TextContact, 16, 15, 175, 90, 20);
        BoundsFont(TextPatronymic, 16, 15, 140, 140, 20);
        BoundsFont(TextIntarn, 16, 300, 175, 120, 20);
        BoundsFont(TextProfession, 16, 300, 105, 140, 20);

        JBut(Save, 16, 300, 300, 150, 30);
        JBut(Back, 16, 150, 300, 150, 30);

        JCom(Studant, ite, 435, 175, 50, 25);
        JCom(Training, item, 485, 175, 100, 25);
        JCom(Para, NamberPara, 125, 240, 90, 25);
        JCom(PeopleList, NamePeople, 15, 20, 110, 25);
        JCom(TrainingMain, TrainingMainText, 260, 20, 325, 25);

        Mess(SaveMes, Color.GREEN, false);
        Mess(ErrorMes, Color.RED, false);

        SurName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (coun > 0) {
                    defaultListModel.removeAllElements();
                }
                ResultSet res = dateBaseHandler.seart(SurName.getText());
                coun = 0;
                try {
                    while (res.next()) {
                        coun++;
                        SaveMes.setVisible(false);
                        namee = res.getString(Const.USERNAME);
                        defaultListModel.addElement(namee);
                        getItem[coun] = namee;
                    }
                } catch (SQLException a) {
                    a.printStackTrace();
                }
                if (SurName.getText().length() < 1 || defaultListModel.getSize() < 1) {
                    search.setVisible(false);
                    defaultListModel.removeAllElements();
                } else search.setVisible(true);
                JList(ListName, defaultListModel, 5, 0, 0, 150, 20);
                search.setBounds(125, 92, 150, AutoScl());
            }
        });
        One.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                search.setVisible(false);
            }
        });

        ListName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                super.mouseClicked(e);
                SurName.setText(ListName.getSelectedValue());
                ResultSet res = dateBaseHandler.seart(SurName.getText());
                coun = 0;
                try {
                    while (res.next()) {
                        coun++;
                        Contactt.setText(res.getString(Const.CONTACTT));
                        Partronymic.setText(res.getString(Const.PARTRONYMIC));
                        Profession.setText(res.getString(Const.PROFESSION));
                        Pulpit.setText(res.getString(Const.PULPIT));
                        Name.setText(res.getString(Const.NAME));
                    }
                } catch (SQLException a) {
                    a.printStackTrace();
                }
                search.setVisible(false);
            }
        });
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Scan(ALL);
            }
        });
    }
    public void BoundsFont(JLabel name, int font, int x, int y, int w, int h) {
        name.setBounds(x, y, w, h);
        name.setFont(new Font("serif", Font.PLAIN, font));
        One.add(name);
    }
    public void JText(JTextField name, int x, int y, int w, int h) {
        name.setBounds(x, y, w, h);
        One.add(name);
    }
    public void JBut(JButton name, int font, int x, int y, int w, int h) {
        name.setBounds(x, y, w, h);
        name.setFont(new Font("serif", Font.PLAIN, font));
        One.add(name);
    }
    public void JCom(JComboBox name, String[] tab, int x, int y, int w, int h) {
        for (int bly = 0; bly < tab.length; bly++) {
            name.addItem(tab[bly]);
        }
        name.setBounds(x, y, w, h);
        One.add(name);
    }
    public void JP(JPanel name, String title) {
        name.setLayout(null);
        vkladki.add(title, name);
    }
    public void Search(JPanel name, boolean visibility, int x, int y, int w, int h) {
        name.setLayout(new BorderLayout());
        name.setBounds(x, y, w, h);
        name.setVisible(visibility);
        One.add(name);
    }
    public void JList(JList name, DefaultListModel title, int RowCount, int x, int y, int w, int h) {
        name.setListData(title.toArray());
        name.setBounds(x, y, w, h);
        name.setVisibleRowCount(RowCount);
        name.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        name.setLayoutOrientation(JList.VERTICAL);
    }
    public void Mess(JLabel name, Color color, boolean visible) {
        name.setForeground(color);
        name.setVisible(visible);
    }
    public void JSro(JScrollPane name, JList name1) {
        name.setViewportView(name1);
        search.add(jScrollPane);
    }
    public int AutoScl() {
        int height;
        if (defaultListModel.getSize() * 25 > 75) {
            height = 75;
        } else height = defaultListModel.getSize() * 25;
        return height;
    }
    public void Scan(JTextField name []) {
        int t = 0;
        for (int s = 0; s < name.length; s++){
            if (name[s].getText().length() < 4){
                name[s].setBackground(Color.RED);
            }else {
                t++;
            }
        }
        if (t == name.length){
            //dateBaseHandler.singUpUser(Name.getText(), SurName.getText(), Partronymic.getText(), Pulpit.getText(), Profession.getText(), Contactt.getText(), "1");
            SaveMes.setVisible(true);
            for (int s = 0; s < name.length; s++){
                name[s].setText(null);
            }
        }else {
            ErrorMes.setVisible(true);
        }
        Test(ALL);
    }
    public void Test(JTextField name[]){
        for (int y = 0; y < name.length; y++){
            int finalY = y;
            name[y].addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    super.keyReleased(e);
                    ErrorMes.setVisible(false);
                    name[finalY].setBackground(Color.WHITE);
                }
            });
        }
    }
}