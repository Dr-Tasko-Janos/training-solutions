package catalog;

import java.util.List;

public class Validators {

    public static boolean isBlank(String content){
        if(content == null || content.isBlank()){
            return true;
        }
        return false;
    }

    public static boolean isEmpty(List<?> content){
        if(content == null || content.size() == 0){
            return true;
        }
        return false;
    }


}
