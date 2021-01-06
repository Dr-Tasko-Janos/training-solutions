package exam02;

public class ArraySelector {

    public String selectEvens(int[] stringArray) {
        String selected = "[";
        if (stringArray.length == 0) {
            return "";
        }
        for (int i = 0; i < stringArray.length; i += 2) {
            selected += (i >= stringArray.length - 2) ? stringArray[i] + "]" : stringArray[i] + ", ";
        }
        return selected;
    }
}
