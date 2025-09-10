package org.example;

public class Main {
    public static void main(String[] args) {
        ProducerDAO dao = new ProducerDAO();

        // CREATE — добавляем производителя с ID "hp_1"
        dao.insertProducer("jkdshfv_1", "Pixar-ish", "USA", "http://hpPix.com");

        // READ — выводим всех производителей
        dao.getAllProducers().forEach(System.out::println);

        // UPDATE — обновляем данные производителя с ID "hp_1"
        dao.updateProducer("jkdshfv_1", "Pixar Inc.", "Vietnam", "http://hp.com/updated");

        // DELETE — удаляем производителя с ID "hp_2"
        dao.deleteProducer("jkdshfv_1");
    }
}
