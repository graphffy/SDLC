
package RepetitioUIMockup {

    part def MainPage {
        part header : Header;
        part navigation : NavigationPanel;
        part dashboard : Dashboard;
    }

    part def Header {
        attribute applicationName = "Repetitio";
        attribute userName = "Иван";
        attribute notificationsEnabled = true;
    }

    part def NavigationPanel {
        attribute menuItems = "Главная, Экзамены, Повторения, Статистика";
    }

    part def Dashboard {
        part examList : ExamList;
        part readinessPanel : ReadinessPanel;
        part repetitionPanel : RepetitionPanel;
        part weakTopicsPanel : WeakTopicsPanel;
    }

    part def ExamList {
        attribute title = "Мои экзамены";
        attribute examName = "Базы данных";
        attribute examDate = "25.12.2026";
    }

    part def ReadinessPanel {
        attribute title = "Готовность к экзамену";
        attribute readinessPercent : Real = 75.0;
    }

    part def RepetitionPanel {
        attribute title = "Ближайшие повторения";
        attribute topicName = "Нормализация баз данных";
        attribute repetitionDate = "Сегодня";
    }

    part def WeakTopicsPanel {
        attribute title = "Слабые темы";
        attribute topicName = "Транзакции";
        attribute testResult : Real = 45.0;
    }

    part mainPage : MainPage;
}

