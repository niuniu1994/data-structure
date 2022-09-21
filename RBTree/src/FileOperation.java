import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FileOperation {

    // 读取文件名称为filename中的内容，并将其中包含的所有词语放进words中
    public static boolean readFile(String filename, ArrayList<String> words) {
        if (filename == null || words == null) {
            System.out.println("filename is null or words is null");
            return false;
        }

        //文本输入

        Scanner scanner;
        File file = new File(filename);
        try {
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis));
                scanner.useLocale(Locale.ENGLISH);
            } else
                return false;
        } catch (FileNotFoundException e) {
            System.out.println("Can not open" + filename);
            return false;
        }

        // 简单分词
        // 这个分词方式相对简陋, 没有考虑很多文本处理中的特殊问题
        // 在这里只做demo展示用

        if(scanner.hasNextLine()){
            String contents = scanner.useDelimiter("\\A").next();

            int start = FileOperation.firstIndex(contents,0);
            for(int i = start + 1; i < contents.length();) {
                if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstIndex(contents, i);
                    i = start + 1;
                } else
                    i++;
            }
        }
        return true;
    }

    private static int firstIndex(String s, int Start){
        for(int i = Start; i < s.length();i++){
            if(Character.isLetter(s.charAt(i)));
                return i;
        }
        return s.length();
    }
}
