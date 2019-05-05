import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContactV2 extends JFrame {

    DateFormat dateFormat = new SimpleDateFormat("dd.MM.YYYY HH:MM");
    Date date = new Date();

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
    private JTextField Date = new JTextField();
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
    static JLabel TextEditDate = new JLabel("Змінити дату");

    private JComboBox Training = new JComboBox();
    private JComboBox Studant = new JComboBox();
    private JComboBox TrainingMain = new JComboBox();
    private JComboBox Para = new JComboBox();
    private JComboBox PeopleList = new JComboBox();
    JComboBox AllCom [] ={Training,Studant,TrainingMain,Para};

    private JButton Back = new JButton("Назад");
    private JButton Save = new JButton("Зберегти");

    private JCheckBox ok = new JCheckBox();

    private JList<String> ListName = new JList<>();
    private JScrollPane jScrollPane = new JScrollPane();

    private DefaultListModel defaultListModel = new DefaultListModel();
    DateBaseHandler dateBaseHandler = new DateBaseHandler();
    private static String namee;
    private static String getItem[] = new String[24];
    int coun;
    private  String hi [];
    private static String getPidor[];
    private String time;
    private String xz;
    String finDate;
    String resolt [] = new  String[10];
    String ter [] = new String[10];
    String textDate;
    int keepActionCheckBox;
    private  String f [] = new String[24];
    private String oreo;

    public ContactV2() {
        super("Name");
       // this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(50, 50, 620, 420);
        getContentPane().add(vkladki);

        JP(One, "Заняття");
        JP(Two, "Тренінг");

        Search(search, false, 125, 92, 150, 120);
        JSro(jScrollPane, ListName);

        String[] ite = {"1", "2", "3"};
        String[] item = {"Бюджет", "Контракт"};
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
        JText(Date,435,240,150,25);

        BoundsFont(TextEditDate,16,330,240,110,20);
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

        JBox(ok,280,240,25,25);

        JCom(Studant, ite, 435, 175, 50, 25);
        JCom(Training, item, 485, 175, 100, 25);
        JCom(Para, NamberPara, 125, 240, 90, 25);
        JCom(PeopleList, NamePeople, 15, 20, 110, 25);
        JCom(TrainingMain, TrainingMainText, 260, 20, 325, 25);

        Mess(SaveMes, Color.GREEN, false);
        Mess(ErrorMes, Color.RED, false);

        Date.setEditable(false);
        Date.setFont(new Font("serif", Font.PLAIN, 16));

        SurName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (coun > 0) {
                    defaultListModel.removeAllElements();
                    getItem = new String[getItem.length];
                }
                ResultSet res = dateBaseHandler.seart(SurName.getText());
                ResultSet resultSet = dateBaseHandler.getUser(Const.DATE,Date.getText());
                coun = 0;
                try {
                    while (res.next()) {
                        coun++;
                        SaveMes.setVisible(false);
                        namee = res.getString(Const.USERNAME);
                        getItem[coun] = namee;
                        f[coun] = resultSet.getString(Const.DATE);
                    }
                } catch (SQLException a) {
                    a.printStackTrace();
                }
                searts();


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
                        Prepod.setText(res.getString(Const.PREPOD));
                        if (res.getString(Const.TRAINING) == String.valueOf(Training.getSelectedItem())){
                            Training.setSelectedIndex(0);
                        }else Training.setSelectedIndex(1);
                        Jcombo(res,Studant);
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
                GUI gui = new GUI();
                gui.setVisible(true);
            }
        });
        Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getPidor = Date(ALL,AllCom);
                Scan(ALL);
            }
        });
        Time();
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
            }else { t++; }
            if (name[s].getText().length() > 3){
                name[s].setBackground(Color.GREEN);
            }
        }
        if (t == name.length){
            dateBaseHandler.singUpUser(getPidor,fin());
            SaveMes.setVisible(true);
            for (int s = 0; s < name.length; s++){
                name[s].setText(null);
                name[s].setBackground(Color.WHITE);
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
            name[finalY].addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    super.keyReleased(e);
                        if (name[finalY].getText().length() > 3) {
                            name[finalY].setBackground(Color.GREEN);
                        }
                }
            });
        }
    }
    public String[] Date (JTextField name [], JComboBox name1 []){
        String hi [] = new String[name.length+name1.length];
        for (int n = 0; n < name.length; n++){
            hi[n] = name[n].getText();
        }
        int t = 0;
        for (int s = name.length; s < name1.length + name.length; s++){
            hi[s] = String.valueOf(name1[t].getSelectedItem());
            t++;
        }
        return hi;
    }
    public void Jcombo(ResultSet resultSet,JComboBox name) throws SQLException {
        for (int s = 0; s <name.getItemCount();s++){
            if (String.valueOf(name.getItemAt(s)).equals(resultSet.getString(Const.STUDANT))) {
                name.setSelectedIndex(s);
            }
        }
    }
    public void Time(){
        Date.setText(dateFormat.format(date));
        ok.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1){
                    Date.setEditable(true);
                    Date.setText("");
                    keepActionCheckBox = 1;
                    Kye();
                }else {
                         time = dateFormat.format(date);
                         Date.setText(time);
                         Date.setEditable(false);
                }
            }
        });
    }
    public void JBox(JCheckBox name, int x, int y, int w, int h) {
        name.setBounds(x, y, w, h);
        One.add(name);
    }
    public void Kye(){
        Date.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                    if (Date.getText().length() == 2){
                        xz = Date.getText() + ".";
                        Date.setText(xz);
                        xz = null;
                    }
                    if (Date.getText().length() == 5) {
                        xz = Date.getText() + ".";
                        Date.setText(xz);
                        xz = null;
                    }
                    if (Date.getText().length() == 10) {
                        xz = Date.getText() + " ";
                        Date.setText(xz);
                        xz = null;
                    }
                    if (Date.getText().length() == 13) {
                        xz = Date.getText() + ":";
                        Date.setText(xz);
                        xz = null;
                    }
                    if (Date.getText().length() == 16){
                        xz = Date.getText();
                    }
            }
        });
    }
    public String fin(){
                if (keepActionCheckBox == 1){
                    oreo = xz;
                }else {
                    oreo = dateFormat.format(date);
                }
        return oreo;
    }
    public void searts(){
        int t = 0;
        int k = 0;
        String re[] = new String [getItem.length];

        for (int s = 0; s < getItem.length; s++) {
            int nElems = 0;
            if (getItem[s] == null) {
                k++;
                for (int v = s; v < nElems - 1; v++)
                    f[v] = f[v + 1];
                nElems--;
            } else {
                re[t] = getItem[s];
                t++;
            }
        }
        System.out.println(k);
        String re1[] = new String [getItem.length - k ];
        for (int r = 0; r < re1.length ; r++){
            re1 [r] = re[r];
        }
        int f = 0;
        int y = 0;
        int s = 1;
        int i = 1;
        int l = 0;
        for (int q = 0; q < re1.length; q++) {
            for (i = i +l; i < re1.length; i++) {
                if (re1[f].equals(re1[i ])){

                }else {
                    y++;
                    System.out.println("good");
                }
            }
            System.out.println("f === " + f);
            if (y == re1.length - s){
                defaultListModel.addElement(re1[f]);
                y = 0;
            }
            f++;
            l++;
            i=1;
            s++;
        }
    }
}