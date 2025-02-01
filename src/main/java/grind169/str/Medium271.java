package grind169.str;

import java.util.ArrayList;
import java.util.List;

//Encode and Decode Strings 加码解码字符串
//https://www.cnblogs.com/grandyang/p/5265628.html
public class Medium271 {
  // Encodes a list of strings to a single string.
  public String encode(List<String> strs){
    StringBuilder stringBuilder=new StringBuilder();
    for(String str:strs){
      stringBuilder.append(str.length()).append("/").append(str);
    }
    return stringBuilder.toString();
  }

  public List<String> decode(String strs){

    List<String> res=new ArrayList<>();
    int i=0;
    while(i<strs.length()){
      int slashIndex= strs.indexOf("/",i);
      Integer length=Integer.valueOf(strs.substring(i,slashIndex));
      String word=strs.substring(slashIndex+1,slashIndex+1+length);
      res.add(word);

      i=slashIndex+1+length;
    }
    return res;
  }
}
