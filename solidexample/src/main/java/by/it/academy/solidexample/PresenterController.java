package by.it.academy.solidexample;

public class PresenterController {

    private Presenter presenter;

    void foo(){
        presenter = new Presenter(new SqliteDatabaseImpl());
        presenter = new Presenter(new RealmDatabaseImpl());
    }
}
