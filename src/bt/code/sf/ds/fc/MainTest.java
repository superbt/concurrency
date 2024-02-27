package bt.code.sf.ds.fc;

import bt.code.sf.ds.fc.sub.Add;

public class MainTest {
    public static void main(String[] args) {
        Operation add = new Add();
        add.setValue1(10);
        add.setValue2(5);
        System.out.println(add.getResule());
    }
}
