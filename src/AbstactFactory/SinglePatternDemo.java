package AbstactFactory;

public class SinglePatternDemo {
    public static void main(String[]args){
          SingleObject object=SingleObject.getIstance();
          object.showMessage();
    }
}
