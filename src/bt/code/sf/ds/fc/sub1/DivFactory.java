package bt.code.sf.ds.fc.sub1;

import bt.code.sf.ds.fc.Operation;
import bt.code.sf.ds.fc.sub.Div;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp;

public class DivFactory implements IFactory {
    @Override
    public Operation createOption() {
        return new Div();
    }
}
