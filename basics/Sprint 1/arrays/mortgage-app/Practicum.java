class Practicum {
    public static void main(String[] args) {
        String[] participants = {"Пётр", "Надежда" , "Валентин"};
        String[] documents = {"Паспорт", "Водительские права" , "Свидетельство о рождении"};

        if (participants.length == documents.length) {
            System.out.println("Документы загружены верно. Список документов:");
            for (int i = 0; i < participants.length; i++) {
                System.out.println(participants[i] + ": " + documents[i]);
            }
        } else {
            System.out.println("Количество документов не соответствует количеству участников сделки.");
        }
    }
}