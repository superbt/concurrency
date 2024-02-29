package bt.code.sf.ds.fc;

import bt.code.sf.ds.fc.sub.Add;
import bt.code.sf.ds.fc.sub1.AddFactiory;
import bt.code.sf.ds.fc.sub1.IFactory;

public class MainTest {
    public static void main(String[] args) {
        Operation add = new Add();
        add.setValue1(10);
        add.setValue2(5);
        System.out.println(add.getResule());

        IFactory factory = new AddFactiory();
        Operation oAdd = factory.createOption();

    }
}
