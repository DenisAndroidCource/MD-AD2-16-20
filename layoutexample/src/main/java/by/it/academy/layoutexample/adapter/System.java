package by.it.academy.layoutexample.adapter;

public class System {

    void foo(){
        LogitechMemoryCard memoryCard = new LogitechMemoryCard();
        CardReader cardReader = new CardReader(memoryCard);


        Computer computer = new Computer();
        computer.readDataFromCard(cardReader);

    }

}
