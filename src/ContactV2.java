import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContactV2 extends JFrame {
    private java.util.Date date = new Date();
    private DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");

    private JTabbedPane Tab = new JTabbedPane();

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
    private JTextField JT_Training = new JTextField();
    private JTextField[] ALL = {Name,SurName,Partronymic,Pulpit,Profession,Contactt,Prepod};

    private JLabel TextName = new JLabel("Ім'я");
    private JLabel TextSurName = new JLabel("Призвище");
    private JLabel TextPatronymic = new JLabel("По батькові");
    private JLabel TextPulpit = new JLabel("Кафедра");
    private JLabel TextProfession = new JLabel("Спеціальність");
    private JLabel TextContact = new JLabel("Номер");
    private JLabel TextIntarn = new JLabel("Курс/Форма");
    private JLabel TextPrepod = new JLabel("Викладач");
    private JLabel NameTraining = new JLabel("Назва тренінгу");
    private JLabel NameLesion = new JLabel("Заняття");
    private JLabel ParaText = new JLabel("Пара");
    private JLabel SaveMes = new JLabel("SAVE");
    private JLabel ErrorMes = new JLabel("NO DATE");
    private JLabel TextEditDate = new JLabel("Змінити дату");
    private JLabel EmployeeText = new JLabel("Співробітник НМАПО");

    private JComboBox Training = new JComboBox();
    private JComboBox Student = new JComboBox();
    private JComboBox TrainingMain = new JComboBox();
    private JComboBox Para = new JComboBox();
    //private JComboBox PeopleList = new JComboBox();
    private JComboBox[] AllCom = {Training, Student, TrainingMain, Para};

    private JButton Back = new JButton("Назад");
    private JButton Save = new JButton("Зберегти");

    private JCheckBox ok = new JCheckBox("Так");
    private JCheckBox Yes = new JCheckBox("Так");
    private JCheckBox No = new JCheckBox("Ні");

    private JList<String> ListName = new JList<>();
    private JScrollPane jScrollPane = new JScrollPane();

    private DefaultListModel defaultListModel = new DefaultListModel();
    private DateBaseHandler dateBaseHandler = new DateBaseHandler();
    private String[] getItemUserNameTabLesson = new String[24];
    private int coun;
    private static String[] getPidor;
    private String InputTimeWithJTF;
    private int keepActionCheckBox;
    private  String[] getDateFromBD  = new String[24];
    private int FirstStartWindows = 0;

    ContactV2() {
        super("Name");
       // this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(50, 50, 620, 420);
        getContentPane().add(Tab);

        AddJPanelInTab(One, "Заняття");
        AddJPanelInTab(Two, "Тренінг");

        ActionTab();

        SurName.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                SearchUserNameTabLesson(defaultListModel,getItemUserNameTabLesson,getDateFromBD,getDateFromBD.length);
                search.setBounds(125, 92, 150, AutoHeightSearch(defaultListModel.getSize()));
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
            public void mouseClicked(MouseEvent e) {
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
                        if (res.getString(Const.TRAINING).equals(String.valueOf(Training.getSelectedItem()))){
                            Training.setSelectedIndex(0);
                        }else {
                            Training.setSelectedIndex(1);
                        }
                        Jcombo(res,Student);
                    }
                } catch (SQLException a) {
                    a.printStackTrace();
                }
                search.setVisible(false);
            }
        });
        Back.addActionListener(e -> {
            dispose();
            GUI gui = new GUI();
            gui.setVisible(true);
        });
        Save.addActionListener(e -> {
            getPidor = Date(ALL,AllCom);
            MessageSave();
            Scan(ALL);
        });
    }
    private void AddJPanelInTab(JPanel name, String title) {
        name.setLayout(null);
        Tab.add(title, name);
    }
    private void ActionTab(){
        if (FirstStartWindows == 0){
            AddElementForTab(0);
            Array();
            FirstStartWindows++;
        }
        Tab.addChangeListener(e -> {
            if (Tab.getSelectedIndex() == 0){
                AddElementForTab(0);
            }
            if (Tab.getSelectedIndex() == 1) {
                CheckEmployee();
            }
        });
    }
    private void AddElementForTab(int IndexTabUse){
        SetPositionLabel(TextPatronymic, Tab.getSelectedIndex(),16, 15, 140, 140, 20);
        SetPositionLabel(TextSurName, Tab.getSelectedIndex(),16, 15, 70, 100, 20);
        SetPositionLabel(TextName,  Tab.getSelectedIndex(),16, 15, 105, 70, 20);
        SetPositionLabel(TextContact, Tab.getSelectedIndex(),16, 15, 175, 90, 20);
        SetPositionLabel(TextProfession, Tab.getSelectedIndex(), 16, 300, 105, 140, 20);
        SetPositionLabel(TextEditDate, Tab.getSelectedIndex(),16,330,240,110,20);

        SetPositionTextField(Name, Tab.getSelectedIndex(),125, 105, 150);
        SetPositionTextField(SurName, Tab.getSelectedIndex(),125, 70, 150);
        SetPositionTextField(Contactt, Tab.getSelectedIndex(),125, 175, 150);
        SetPositionTextField(Profession, Tab.getSelectedIndex(),435, 105, 150);
        SetPositionTextField(Partronymic, Tab.getSelectedIndex(),125, 140, 150);
        SetPositionTextField(Date, Tab.getSelectedIndex(),435,240,150);

        SetPositionButton(Save, Tab.getSelectedIndex(), 300, 300);
        SetPositionButton(Back, Tab.getSelectedIndex(), 150, 300);

        SetPositionCheckBox(ok,Tab.getSelectedIndex(), 240, 240);
        ok.addItemListener(this::itemStateChangedTimeSetInGUI);

        Date.setText(dateFormat.format(date));
        Date.setEditable(false);
        Date.setFont(new Font("serif", Font.PLAIN, 16));

        if (IndexTabUse == 0){
            SetPositionLabel(ParaText, 0,16, 15, 240, 90, 20);
            SetPositionLabel(TextPrepod, 0,16, 300, 140, 140, 25);
            SetPositionLabel(NameLesion, 0,19, 140, 20, 110, 20);
            SetPositionLabel(TextIntarn, 0,16, 300, 175, 120, 20);

            SetPositionTextField(Prepod, 0,435, 140, 150);
        }
        if (IndexTabUse == 3 || IndexTabUse == 0){
            SetPositionLabel(TextPulpit, Tab.getSelectedIndex(),16, 300, 70, 80, 20);
            SetPositionTextField(Pulpit, Tab.getSelectedIndex(),435, 70, 150);
        }
    }
    private void CheckEmployee(){
        SetPositionTextField(JT_Training,1,210, 20, 325);
        SetPositionLabel(NameTraining,1, 19,50, 20, 160, 20);

        SetPositionLabel(EmployeeText,1,16,15, 65, 170, 20);
        SetLabelColorVisible(EmployeeText,Color.BLACK,true);

        SetPositionCheckBox(Yes,1, 180, 65);
        SetPositionCheckBox(No,1, 230, 65);

        Yes.addItemListener(this::itemStateChangedYes);
        No.addItemListener(this::itemStateChangedNo);
    }

    private void SetPositionLabel(JLabel name, int IndexTab, int font, int x, int y, int w, int h) {
        name.setFont(new Font("serif", Font.PLAIN, font));
        name.setBounds(x, y, w, h);
        if (IndexTab == 0){
            One.add(name);
            Two.remove(name);
        }
        if (IndexTab == 1){
            Two.add(name);
            One.remove(name);
        }
    }
    private void SetPositionTextField(JTextField name, int IndexTab, int x, int y, int w) {
        name.setBounds(x, y, w, 25);
        if (IndexTab == 0){
            One.add(name);
            Two.remove(name);
        }
        if (IndexTab == 1){
            Two.add(name);
            One.remove(name);
        }
    }
    private void SetPositionCheckBox(JCheckBox name, int IndexTab, int x, int y) {
        name.setBounds(x, y, 50, 25);
        name.setVisible(true);
        if (IndexTab == 0){
            One.add(name);
            Two.remove(name);
        }
        if (IndexTab == 1){
            Two.add(name);
            One.remove(name);
        }
    }
    private void SetPositionButton(JButton name, int IndexTab, int x, int y) {
        name.setBounds(x, y, 150, 30);
        name.setFont(new Font("serif", Font.PLAIN, 16));
        if (IndexTab == 0){
            One.add(name);
            Two.remove(name);
        }
        if (IndexTab == 1){
            Two.add(name);
            One.remove(name);
        }
    }
    private void SetPositionComboBox(JComboBox name, String[] tab, int x, int y, int w) {
        for (int bly = 0; bly < tab.length; bly++) {
            name.addItem(tab[bly]);
        }
        name.setBounds(x, y, w, 25);
        One.add(name);
    }
    private void SetLabelColorVisible(JLabel name, Color color, boolean visible) {
        name.setForeground(color);
        name.setVisible(visible);
    }

    private void AddSettingsPanelSearch(JPanel name, int IndexTab, int x, int y, int w, int h) {
        name.setLayout(new BorderLayout());
        name.setBounds(x, y, w, h);
        name.setVisible(false);
        if (IndexTab == 0){
            One.add(name);
            Two.remove(name);
        }
        if (IndexTab == 1){
            Two.add(name);
            One.remove(name);
        }
        AddScrollAndList(jScrollPane, ListName);
    }
    private void AddScrollAndList(JScrollPane name, JList name1) {
        name.setViewportView(name1);
        search.add(jScrollPane);
    }
    private void JList(JList name, DefaultListModel title, int w, int h) {
        name.setListData(title.toArray());
        name.setBounds(0, 0, w, h);
        name.setVisibleRowCount(5);
        name.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        name.setLayoutOrientation(JList.VERTICAL);
    }
    private int AutoHeightSearch(int size) {
        if (size > 75) {
            size = 75;
        } else size = size * 25;
        return size;
    }


    private void Scan(JTextField[] name) {
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
            dateBaseHandler.singUpUser(getPidor,SendTimeInBD());
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
    private void Test(JTextField[] name){
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
    private String[] Date (JTextField name [], JComboBox name1 []){
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
    private void Jcombo(ResultSet resultSet,JComboBox name) throws SQLException {
        for (int s = 0; s <name.getItemCount();s++){
            if (String.valueOf(name.getItemAt(s)).equals(resultSet.getString(Const.STUDANT))) {
                name.setSelectedIndex(s);
            }
        }
    }
    private void search(String [] name){
        int t = 0;
        int k = 0;
        String re[] = new String [name.length];

        for (int s = 0; s < name.length; s++) {
            if (name[s] == null) {
                k++;
            } else {
                re[t] = name[s];
                t++;
            }
        }
        String re1[] = new String [name.length - k ];
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
                if (re1[f].equals(re1[i])){
                    int nElems = f;
                    for (int v = nElems; v < re1.length - 1; v++) {
                        re1[v] = re1[v + 1];
                    }
                    f--;
                }else {
                    y++;
                }
            }
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


    private void MethodInputTime(){
        Date.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                    if (Date.getText().length() == 2){
                        InputTimeWithJTF = Date.getText() + ".";
                        Date.setText(InputTimeWithJTF);
                        InputTimeWithJTF = null;
                    }
                    if (Date.getText().length() == 5) {
                        InputTimeWithJTF = Date.getText() + ".";
                        Date.setText(InputTimeWithJTF);
                        InputTimeWithJTF = null;
                    }
                    if (Date.getText().length() == 10) {
                        InputTimeWithJTF = Date.getText() + " ";
                        Date.setText(InputTimeWithJTF);
                        InputTimeWithJTF = null;
                    }
                    if (Date.getText().length() == 13) {
                        InputTimeWithJTF = Date.getText() + ":";
                        Date.setText(InputTimeWithJTF);
                        InputTimeWithJTF = null;
                    }
                    if (Date.getText().length() == 16){
                        InputTimeWithJTF = Date.getText();
                    }
            }
        });
    }
    private void itemStateChangedTimeSetInGUI(ItemEvent e){
        if (e.getStateChange() == ItemEvent.SELECTED){
            keepActionCheckBox =1;
            Date.setEditable(true);
            Date.setText("");
            MethodInputTime();
        }else {
            Date.setEditable(false);
            Date.setText(dateFormat.format(date));
        }
    }
    private String SendTimeInBD(){
        String LastTime;
        if (keepActionCheckBox == 1){
            LastTime = InputTimeWithJTF;
        }else {
            LastTime = dateFormat.format(date);
        }
        return LastTime;
    }
    private void Array(){
        String[] StudentYear = {"1", "2", "3"};
        String[] FormLesson = {"Бюджет", "Контракт"};
        String[] NumberPara = {"1", "2", "3", "4"};
        //String[] NamePeople = {"Інтерн", "Слухач", "Відвідувач", "Лікар", "Парамед", "Сер.Мед. персонал"};
        String[] TrainingMainText = {"Серцево-легенева реанімація", "Люмбальна пункція", "В/в, в/м ін’єкції", "Постановка переферичного венозного катетеру", "Катетеризація центральної вени", "Крикотиреотомія", "Плевральна пункція", "Торакоцентез"};

        SetPositionComboBox(Student,  StudentYear, 435, 175, 50);
        SetPositionComboBox(Training,  FormLesson, 485, 175, 100);
        SetPositionComboBox(Para, NumberPara, 125, 240, 90);
        SetPositionComboBox(TrainingMain, TrainingMainText, 220, 20, 325);
    }
    private void MessageSave(){
        SetPositionLabel(SaveMes, Tab.getSelectedIndex(),16, 460, 300, 250, 25);
        SetPositionLabel(ErrorMes, Tab.getSelectedIndex(),16, 460, 300, 250, 25);
        SetLabelColorVisible(SaveMes, Color.GREEN, false);
        SetLabelColorVisible(ErrorMes, Color.RED, false);
    }
    private void itemStateChangedYes(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            EmployeeText.setVisible(false);
            Yes.setVisible(false);
            No.setVisible(false);
            AddElementForTab(3);
            Two.repaint();
        }
    }
    private void itemStateChangedNo(ItemEvent e){
        if (e.getStateChange() == ItemEvent.SELECTED){
            EmployeeText.setVisible(false);
            Yes.setVisible(false);
            No.setVisible(false);
            AddElementForTab(1);
            Two.repaint();
        }
    }
    private void SearchUserNameTabLesson(DefaultListModel name,String[]ForItems, String[] ForDate, int LengthTable){
        AddSettingsPanelSearch(search,0, 125, 92, 150, 120);
        JList(ListName, defaultListModel, 150, 20);
        if (coun > 0) {
            name.removeAllElements();
            ForItems = new String[LengthTable];
        }
        ResultSet res = dateBaseHandler.seart(SurName.getText());
        coun = 0;
        try {
            while (res.next()) {
                coun++;
                SaveMes.setVisible(false);
                ForItems[coun] = res.getString(Const.USERNAME);
                ForDate[coun] = res.getString(Const.DATE);
            }
        } catch (SQLException a) {
            a.printStackTrace();
        }
        search(ForItems);
        if (SurName.getText().length() < 1 || name.getSize() < 1) {
            search.setVisible(false);
            name.removeAllElements();
        } else search.setVisible(true);
    }
}