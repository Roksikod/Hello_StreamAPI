package lambda;

public class Director {
    /*public void force(Worker worker) {
       worker.work();
    }*/
    public String force(Worker worker, int count) {
        return worker.work(count);
    }
}
