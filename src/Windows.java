import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Windows extends JFrame{
    Windows(){
        super("Name");
        this.setBounds(50, 50, 620, 420);
        Window window = new Window();
        this.getContentPane().add(window.Tab);
    }
}

class Window {
    JTabbedPane Tab = new JTabbedPane();
    private Tab_Lesson tab_lesson = new Tab_Lesson();
    private Tab_Training tab_training = new Tab_Training();

    Window() {
        AddTabInWindows(tab_lesson.lesson, "Навчання");
        AddTabInWindows(tab_training.training, "Трейнінг");
        if (Tab.getSelectedIndex() == 0) {
            ActionLesson();
        }

        Tab.addChangeListener(e -> {
            if (Tab.getSelectedIndex() == 0) {
                ActionLesson();
            }
            if (Tab.getSelectedIndex() == 1) {
                ActionTraining();
            }
            tab_lesson.lesson.repaint();
        });
    }

    private void ActionLesson() {
        tab_training.training.removeAll();
        tab_lesson.Add_Date();
        tab_lesson.Label();
        tab_lesson.TextFile();
        tab_lesson.ComboBox();
        tab_lesson.Button();
        tab_lesson.CheckBox();

    }
    private void ActionTraining(){
        tab_lesson.lesson.removeAll();
        tab_training.TestColeg();
    }

    //Добавляет вкладки
    private void AddTabInWindows(JPanel jpanel, String nameTitle) {
        jpanel.setLayout(null);
        Tab.add(nameTitle, jpanel);
    }

}

class Tab_Lesson {

    JPanel lesson = new JPanel();
    private Search search = new Search();

    private JTextField Date = new JTextField();
    private java.util.Date date = new Date();
    private DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");

    private JTextField Name;
    private JTextField SurName;
    private JTextField Patronymic;
    private JTextField NumberPhone;
    private JTextField Pulpit;
    private JTextField Profession;
    private JTextField Teacher;

    private JComboBox<String> Training = new JComboBox<>();
    private JComboBox<String> Student = new JComboBox<>();
    private JComboBox<String> Para = new JComboBox<>();
    private JComboBox<String> TrainingMain = new JComboBox<>();

    private JLabel SaveMes = new JLabel("SAVE");
    private JLabel ErrorMes = new JLabel("NO DATE");

    void TextFile() {

         lesson.add(search.search);

         Name = new JTextField();
         Add_JTF_InTab(Name, 125, 105, 150);

         SurName = new JTextField();
         Add_JTF_InTab(SurName, 124, 70, 151);
         ActionInputSurName(SurName,Const.USERNAME,1);
         search.KillList(lesson);

         Patronymic = new JTextField();
         Add_JTF_InTab(Patronymic, 125, 140, 150);

         NumberPhone = new JTextField();
         Add_JTF_InTab(NumberPhone, 125, 175, 150);

         Pulpit = new JTextField();
         Add_JTF_InTab(Pulpit,435, 70, 150);
         ActionInputSurName(Pulpit, Const.PULPIT,2);

         Profession = new JTextField();
         Add_JTF_InTab(Profession,435, 105, 150);
         ActionInputSurName(Profession,Const.PROFESSION,3);

         Teacher = new JTextField();
         Add_JTF_InTab(Teacher, 435, 140, 150);
         ActionInputSurName(Teacher,Const.PREPOD,4);

         //Заполнение из базы данных
         search.SetAllTextField(SurName,NumberPhone,Patronymic,Name,Profession,Pulpit,Teacher,Training,Student);


    }
     //Action Input SurName :: Check SurName
     private void ActionInputSurName(JTextField name, String paramater, int index){
        name.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                //search.Settings();
                if (name.getText().length() > 0 ){
                    search.SearchSurName(name, paramater,index);
                    search.search.setVisible(true);
                }else {
                    search.search.setVisible(false);
                }
                lesson.validate();
                lesson.repaint();
            }
        });
    }

    //Add JTextField
    private void Add_JTF_InTab(JTextField name, int x, int y, int w){
        name.setBounds(x, y, w, 25);
        lesson.add(name);
    }

    void Label(){
         JLabel TextName = new JLabel("Ім'я");
         Add_JL(TextName, 16,15, 105, 70, 20);

         JLabel TextSurName = new JLabel("Призвище");
         Add_JL(TextSurName, 16, 15, 70, 100, 20);

         JLabel TextPatronymic = new JLabel("По батькові");
         Add_JL(TextPatronymic,16, 15, 140, 140, 20);

         JLabel TextContact = new JLabel("Номер");
         Add_JL(TextContact,16, 15, 175, 90, 20);

         JLabel TextPulpit = new JLabel("Кафедра");
         Add_JL(TextPulpit,16, 300, 70, 80, 20);

         JLabel TextProfession = new JLabel("Спеціальність");
         Add_JL(TextProfession,16, 300, 105, 140, 20);

         JLabel TextIntarn = new JLabel("Курс/Форма");
         Add_JL(TextIntarn, 16, 300, 175, 120, 20);

         JLabel TextEditDate = new JLabel("Змінити дату");
         Add_JL(TextEditDate,16,330,240,110,20);

         JLabel ParaText = new JLabel("Пара");
         Add_JL(ParaText, 16, 15, 240, 90, 20);

         JLabel NameLesion = new JLabel("Заняття");
         Add_JL(NameLesion, 19, 140, 20, 110, 20);

         JLabel TextTeacher = new JLabel("Викладач");
         Add_JL(TextTeacher, 16, 300, 140, 140, 25);

         SaveMes.setForeground(new Color(0,175,0));
         Add_JL(SaveMes,16, 460, 300, 250, 25);
         SaveMes.setVisible(false);

         ErrorMes.setForeground(new Color(175,0,0));
         Add_JL(ErrorMes,16, 460, 300, 250, 25);
         ErrorMes.setVisible(false);
     }
    //Добавить JLabel
    private void Add_JL(JLabel name, int font, int x, int y, int w, int h){
        name.setFont(new Font("serif", Font.PLAIN, font));
        name.setBounds(x, y, w, h);
        lesson.add(name);
    }

    void ComboBox(){

         String[] FormLesson = {"Бюджет", "Контракт"};
         Add_JCB(Training,  FormLesson, 485, 175, 100);

         String[] StudentYear = {"1", "2", "3"};
         Add_JCB(Student,  StudentYear, 435, 175, 50);

         String[] TrainingMainText = {"Серцево-легенева реанімація", "Люмбальна пункція", "В/в, в/м ін’єкції", "Постановка переферичного венозного катетеру", "Катетеризація центральної вени", "Крикотиреотомія", "Плевральна пункція", "Торакоцентез"};
         Add_JCB(TrainingMain, TrainingMainText, 220, 20, 325);

         String[] NumberPara = {"1", "2", "3", "4"};
         Add_JCB(Para, NumberPara, 125, 240, 90);
    }
    //Add JComboBox
    private void Add_JCB(JComboBox<String> name, String[] tab, int x, int y, int w){
        //Добавляет содержимое в комбобокс
        name.removeAllItems();
        for (String value : tab) {
            name.addItem(value);
        }
        name.setBounds(x, y, w, 25);
        lesson.add(name);
    }

    void Button(){
        JButton Back = new JButton("Назад");
        Add_JB(Back,150);
        Back.addActionListener(e -> {

            MainPanel mainPanel = new MainPanel();
            mainPanel.setVisible(true);
        });

        JButton Save = new JButton("Зберегти");
        Add_JB(Save,300);
        Save.addActionListener(e -> {
            //Отправление данных в базу данных
            search.SendDateInBaseDate(SurName,NumberPhone,Patronymic,Name,Profession,Pulpit,Teacher, Training.getItemAt(Training.getSelectedIndex()),
                    Student.getItemAt(Student.getSelectedIndex()),Date.getText(),TrainingMain.getItemAt(TrainingMain.getSelectedIndex()),
                    Para.getItemAt(Para.getSelectedIndex()));
            //Очистить поля после сохранения, выбить строку сохранено и через 3 секунди убрать ее
            SaveMes.setVisible(true);
            SurName.setText("");
            NumberPhone.setText("");
            Patronymic.setText("");
            Name.setText("");
            Profession.setText("");
            Pulpit.setText("");
            Teacher.setText("");
            lesson.addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    super.mouseMoved(e);
                    SaveMes.setVisible(false);
                }
            });
        });
    }
    //Add Button
    private void Add_JB(JButton name, int x) {
        name.setBounds(x, 300, 150, 30);
        name.setFont(new Font("serif", Font.PLAIN, 16));
        lesson.add(name);
    }

    void CheckBox(){
        JCheckBox ok = new JCheckBox("Так");
        Add_CheckBox(ok);
        ok.addItemListener(this::itemStateChangedTimeSetInGUI);
    }
    //Add CheckBox
    private void Add_CheckBox(JCheckBox name) {
        name.setBounds(240, 240, 50, 25);
        name.setVisible(true);
        lesson.add(name);
    }
    //Edit date
    private void itemStateChangedTimeSetInGUI(ItemEvent e){
        if (e.getStateChange() == ItemEvent.SELECTED){
            Date.setEditable(true);
            Date.setText("");
            HelpInputTime();
        }else {
            Date.setText(dateFormat.format(date));
        }
    }
    //Add Date and Time
    void Add_Date(){
        Add_JTF_InTab(Date, 435, 240, 150);

        Date.setText(dateFormat.format(date));
        Date.setEditable(false);
        Date.setFont(new Font("serif", Font.PLAIN, 16));
    }
    //ставит знаки при вводе цифер
    private void HelpInputTime(){
        Date.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String InputTimeWithJTF;
                super.keyReleased(e);
                if (Date.getText().length() == 2){
                    InputTimeWithJTF = Date.getText() + ".";
                    Date.setText(InputTimeWithJTF);
                }
                if (Date.getText().length() == 5) {
                    InputTimeWithJTF = Date.getText() + ".";
                    Date.setText(InputTimeWithJTF);
                }
                if (Date.getText().length() == 10) {
                    InputTimeWithJTF = Date.getText() + " ";
                    Date.setText(InputTimeWithJTF);
                }
                if (Date.getText().length() == 13) {
                    InputTimeWithJTF = Date.getText() + ":";
                    Date.setText(InputTimeWithJTF);
                }
            }
        });
    }
}

class Tab_Training{

   // Windows windows= new Windows();


    private JTextField Date = new JTextField();
    private java.util.Date date = new Date();
    private DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");

    JPanel training = new JPanel();

    private int selectYes;

    private Search search = new Search();

    private JTextField Pulpit = new JTextField();
    private JTextField Profession = new JTextField();
    private JTextField SurName = new JTextField();
    private JTextField NumberPhone = new JTextField();
    private JTextField Training = new JTextField();
    private JTextField PlaceWork = new JTextField();
    private JTextField Name = new JTextField();
    private JTextField Patronymic = new JTextField();

    private JLabel SaveMes = new JLabel("SAVE");

    void TestColeg(){
        JLabel EmployeeText = new JLabel("Співробітник НМАПО");
        Add_JL(EmployeeText,16,15, 65, 170, 20);

        JCheckBox Yes = new JCheckBox("Так");
        Add_CheckBox(Yes, 180, 65);
        Yes.addItemListener(this::itemStateChangedYes);

        JCheckBox No = new JCheckBox("Ні");
        Add_CheckBox(No,230, 65);
        No.addItemListener(this::itemStateChangedNo);
    }
    //CheckBox select yes
    private void itemStateChangedYes(ItemEvent e) {
        training.removeAll();
        if (e.getStateChange() == ItemEvent.SELECTED) {
            selectYes = 1;
            TextFile();
            Label();
            CheckBox();
            Button();
            Add_Date();

            training.repaint();
        }
    }
    //CheckBox select no
    private void itemStateChangedNo(ItemEvent e){
        training.removeAll();
        if (e.getStateChange() == ItemEvent.SELECTED){
            if (e.getStateChange() == ItemEvent.SELECTED) {
                selectYes = 0;
                TextFile();
                Label();
                CheckBox();
                Button();
                Add_Date();

                training.repaint();
            }
        }
    }

    private void TextFile(){

        training.add(search.search);

        if (selectYes == 1){

            Add_JTF_InTab(Pulpit,435, 70, 150);
        }else {

            Add_JTF_InTab(PlaceWork,435, 70, 150);
        }


        Add_JTF_InTab(Profession,435, 105, 150);


        Add_JTF_InTab(Name, 125, 105, 150);


        Add_JTF_InTab(SurName, 124, 70, 151);
        ActionInputSurName(SurName,Const.USERNAME);
        search.KillList(training);

        Add_JTF_InTab(Patronymic, 125, 140, 150);


        Add_JTF_InTab(NumberPhone, 125, 175, 150);


        Add_JTF_InTab(Training,210, 20, 325);

        search.SetAllTextFieldTraining(SurName,NumberPhone,Patronymic,Name,Profession,Pulpit);
    }
    //Add JTextField
    private void Add_JTF_InTab(JTextField name, int x, int y, int w){
        name.setBounds(x, y, w, 25);
        training.add(name);
    }

    private void Label(){

        JLabel NameTraining = new JLabel("Назва тренінгу");
        Add_JL(NameTraining, 19,50, 20, 160, 20);

        JLabel TextName = new JLabel("Ім'я");
        Add_JL(TextName, 16,15, 105, 70, 20);

        JLabel TextSurName = new JLabel("Призвище");
        Add_JL(TextSurName, 16, 15, 70, 100, 20);

        JLabel TextPatronymic = new JLabel("По батькові");
        Add_JL(TextPatronymic,16, 15, 140, 140, 20);

        JLabel TextContact = new JLabel("Номер");
        Add_JL(TextContact,16, 15, 175, 90, 20);

        if (selectYes == 1){
            JLabel TextPulpit = new JLabel("Кафедра");
            Add_JL(TextPulpit,16, 300, 70, 80, 20);
        }else {
            JLabel TextPlaceWork = new JLabel("Місце роботи");
            Add_JL(TextPlaceWork,16, 300, 70, 140, 20);
        }

        JLabel TextProfession = new JLabel("Спеціальність");
        Add_JL(TextProfession,16, 300, 105, 140, 20);

        JLabel TextEditDate = new JLabel("Змінити дату");
        Add_JL(TextEditDate,16,330,240,110,20);


        Add_JL(SaveMes,16, 460, 300, 250, 25);
        SaveMes.setForeground(new Color(0,180,0));
        SaveMes.setVisible(false);

       // JLabel ErrorMes = new JLabel("NO DATE");
       // Add_JL(ErrorMes,16, 460, 300, 250, 25);
    }
    //Добавить JLabel
    private void Add_JL(JLabel name, int font, int x, int y, int w, int h){
        name.setFont(new Font("serif", Font.PLAIN, font));
        name.setBounds(x, y, w, h);
        training.add(name);
    }

    private void CheckBox(){
        JCheckBox ok = new JCheckBox("Так");
        Add_CheckBox(ok,240, 240);
        ok.addItemListener(this::itemStateChangedTimeSetInGUI);
    }
    //Add CheckBox
    private void Add_CheckBox(JCheckBox name, int x, int y) {
        name.setBounds(x, y, 50, 25);
        name.setVisible(true);
        training.add(name);
    }

    private void Button(){
        JButton Back = new JButton("Назад");
        Add_JB(Back,150);
        Back.addActionListener(e -> {
           //windows.dispose();
            MainPanel mainPanel = new MainPanel();
            mainPanel.setVisible(true);
        });

        JButton Save = new JButton("Зберегти");
        Add_JB(Save,300);
        Save.addActionListener(e -> {
            if (selectYes == 1){
                search.SendDateInBaseDateTraining(SurName,NumberPhone,Patronymic,Name,Profession,Pulpit, Date.getText(),Training.getText());
            }else {
                search.SendDateInBaseDateTrainingwithPlaceWork(SurName,NumberPhone,Patronymic,Name,Profession,PlaceWork, Date.getText(),Training.getText());
            }
            SaveMes.setVisible(true);
            SurName.setText("");
            NumberPhone.setText("");
            Patronymic.setText("");
            Name.setText("");
            Profession.setText("");
            Pulpit.setText("");
            PlaceWork.setText("");
            training.addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    super.mouseMoved(e);
                    SaveMes.setVisible(false);
                }
            });
        });
    }
    //Add Button
    private void Add_JB(JButton name, int x) {
        name.setBounds(x, 300, 150, 30);
        name.setFont(new Font("serif", Font.PLAIN, 16));
        training.add(name);
    }

    private void Add_Date(){

        Add_JTF_InTab(Date, 435, 240, 150);

        Date.setText(dateFormat.format(date));
        Date.setEditable(false);
        Date.setFont(new Font("serif", Font.PLAIN, 16));
    }

    private void ActionInputSurName(JTextField name, String paramater){
        name.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                //search.Settings();
                if (name.getText().length() > 0 ){
                    search.SearchSurName(name, paramater, 1);
                    search.search.setVisible(true);
                }else {
                    search.search.setVisible(false);
                }
                training.validate();
                training.repaint();
            }
        });
    }

    //Edit date
    private void itemStateChangedTimeSetInGUI(ItemEvent e){
        if (e.getStateChange() == ItemEvent.SELECTED){
            Date.setEditable(true);
            Date.setText("");
            HelpInputTime();
        }else {
            Date.setText(dateFormat.format(date));
        }
    }
    //ставит знаки при вводе цифер
    private void HelpInputTime(){
        Date.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String InputTimeWithJTF;
                super.keyReleased(e);
                if (Date.getText().length() == 2){
                    InputTimeWithJTF = Date.getText() + ".";
                    Date.setText(InputTimeWithJTF);
                }
                if (Date.getText().length() == 5) {
                    InputTimeWithJTF = Date.getText() + ".";
                    Date.setText(InputTimeWithJTF);
                }
                if (Date.getText().length() == 10) {
                    InputTimeWithJTF = Date.getText() + " ";
                    Date.setText(InputTimeWithJTF);
                }
                if (Date.getText().length() == 13) {
                    InputTimeWithJTF = Date.getText() + ":";
                    Date.setText(InputTimeWithJTF);
                }
            }
        });
    }
}

class Search{

    JPanel search = new JPanel();

    private DateBaseHandler dateBaseHandler = new DateBaseHandler();

    private final int[] i = {0};
    private final int[] u = {0};

    private JList<String> ListName = new JList<>();
    private JScrollPane jScrollPane = new JScrollPane();
    private DefaultListModel defaultListModel = new DefaultListModel();

    private void Settings(int x, int y) {
        search.setBounds(x, y, 150, AutoHeightSearch(defaultListModel.getSize()));
        search.setLayout(new BorderLayout());
        //Add jScrollPanel in panel "Search"
        jScrollPane.setViewportView(ListName);
        search.add(jScrollPane);
        //Settings for JList in panel "Search"
        JListSetting(ListName, defaultListModel);
    }

    //Settings for JList in panel "Search"
    private void JListSetting(JList name, DefaultListModel title) {
        name.setListData(title.toArray());
        name.setBounds(0, 0, 150, 20);
        name.setVisibleRowCount(5);
        name.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        name.setLayoutOrientation(JList.VERTICAL);
    }
    //Поиск по фамиилии
    void SearchSurName( JTextField jTextField, String parameter, int index){
        String[]ForItems  = new String[100];
        //Очистка списка от старых данных
        defaultListModel.removeAllElements();
        //Обращение к базе данных
        ResultSet res = dateBaseHandler.seart(jTextField.getText(),parameter);
        int coun = 0;
        try {
            while (res.next()) {
                coun++;
                ForItems[coun] = res.getString(parameter);
            }
        } catch (SQLException a) {
            a.printStackTrace();
        }
        SortingDate(ForItems);
        //если не найдено скрыть панель поиска
        if (jTextField.getText().length() < 1 || defaultListModel.getSize() < 1) {
            search.setVisible(false);
            defaultListModel.removeAllElements();
        }
        else {
            search.setVisible(true);
        }
        if(index == 1) {
            Settings(125,92);
        }
        if(index == 2) {
            Settings(435,92);
        }
        if(index == 3) {
            Settings(435,127);
        }
        if(index == 4) {
            Settings(435,162);
        }
    }
    //Сортировка получившихся данных и добавление в список
    private void SortingDate(String [] name){
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
    //Настройка длины списка
    private int AutoHeightSearch(int size) {
        if (size > 5) {
            size = 75;
        } else size = size * 20;
        return size;
    }
    //При нажатии за границами списка он закроится
    void KillList(JPanel name){
        name.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                search.setVisible(false);
            }
        });
    }
    //По выбраной фамилии заполнять остальные строки
    void SetAllTextField(JTextField surname, JTextField numberPhone, JTextField pertronymic, JTextField name, JTextField profession, JTextField pulpit,
                            JTextField teacher, JComboBox formlesson, JComboBox student) {
        surname.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                ListName.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) { super.mouseClicked(e);
                    ResultSet res = dateBaseHandler.seart(ListName.getSelectedValue(),Const.USERNAME);
                    int coun = 0;
                    try {
                                    while (res.next()) {
                                        coun++;
                                        surname.setText(res.getString(Const.USERNAME));
                                        numberPhone.setText(res.getString(Const.CONTACTT));
                                        pertronymic.setText(res.getString(Const.PARTRONYMIC));
                                        profession.setText(res.getString(Const.PROFESSION));
                                        pulpit.setText(res.getString(Const.PULPIT));
                                        name.setText(res.getString(Const.NAME));
                                        //teacher.setText(res.getString(Const.PREPOD));
                                        if (res.getString(Const.TRAINING).equals(String.valueOf(formlesson.getSelectedItem()))) {
                                            formlesson.setSelectedIndex(0);
                                        } else {
                                            formlesson.setSelectedIndex(1);
                                        }
                                        JСombo(res, student);
                                    }
                                } catch (SQLException a) {
                                    a.printStackTrace();
                                }
                    search.setVisible(false);
                    }
                });
            }
        });
        MouseListener mouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                pulpit.setText(ListName.getSelectedValue());
                search.setVisible(false);
            }
        };
        MouseListener listener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                teacher.setText(ListName.getSelectedValue());
                search.setVisible(false);
            }
        };

       pulpit.addKeyListener(new KeyAdapter() {
           @Override
           public void keyReleased(KeyEvent e) {
               super.keyReleased(e);

               if (i[0] == 0){
                   ListName.addMouseListener(mouseListener);
               }
               i[0]++;
               if(pulpit.getText().length()>3){
                   ListName.removeMouseListener(mouseListener);
                   ListName.addMouseListener(listener);
               }
           }
       });

        teacher.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if (u[0] == 0){
                    ListName.addMouseListener(listener);
                }
                u[0]++;

                if(teacher.getText().length()>3){
                    ListName.removeMouseListener(listener);
                }
            }
        });


    }
    void SetAllTextFieldTraining(JTextField surname, JTextField numberPhone, JTextField pertronymic, JTextField name, JTextField profession, JTextField pulpit) {
        surname.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                ListName.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) { super.mouseClicked(e);
                    ResultSet res = dateBaseHandler.seart(ListName.getSelectedValue(),Const.USERNAME);
                    int coun = 0;
                    try {
                        while (res.next()) {
                            coun++;
                            surname.setText(res.getString(Const.USERNAME));
                            numberPhone.setText(res.getString(Const.CONTACTT));
                            pertronymic.setText(res.getString(Const.PARTRONYMIC));
                            profession.setText(res.getString(Const.PROFESSION));
                            pulpit.setText(res.getString(Const.PULPIT));
                            name.setText(res.getString(Const.NAME));
                        }
                    } catch (SQLException a) {
                        a.printStackTrace();
                    }
                    search.setVisible(false);
                    }
                });
            }
        });
    }

    //Заполнение строк форма/курс
    private void JСombo(ResultSet resultSet,JComboBox name) throws SQLException {
        for (int s = 0; s <name.getItemCount();s++){
            if (String.valueOf(name.getItemAt(s)).equals(resultSet.getString(Const.STUDANT))) {
                name.setSelectedIndex(s);
            }
        }
    }

    void SendDateInBaseDate(JTextField surname, JTextField numberPhone, JTextField pertronymic, JTextField name, JTextField profession, JTextField pulpit,
                            JTextField teacher, String formlesson, String student, String time, String traningMain, String para){

        dateBaseHandler.singUpUser(name.getText(),surname.getText(),pertronymic.getText(),pulpit.getText(),profession.getText(),
                                    numberPhone.getText(),teacher.getText(),formlesson,student,
                                        traningMain, para,time);
    }
    void SendDateInBaseDateTraining(JTextField surname, JTextField numberPhone, JTextField pertronymic, JTextField name, JTextField profession, JTextField pulpit,
                              String time, String traningMain){
        dateBaseHandler.singUpUserTraining(name.getText(),surname.getText(),pertronymic.getText(),pulpit.getText(),profession.getText(), numberPhone.getText(), traningMain, time);
    }
    void SendDateInBaseDateTrainingwithPlaceWork(JTextField surname, JTextField numberPhone, JTextField pertronymic, JTextField name, JTextField profession, JTextField placeWork,
                              String time, String traningMain){
        dateBaseHandler.singUpUserWithPlaceWork(name.getText(),surname.getText(),pertronymic.getText(),placeWork.getText(),profession.getText(), numberPhone.getText(), traningMain, time);
    }
}