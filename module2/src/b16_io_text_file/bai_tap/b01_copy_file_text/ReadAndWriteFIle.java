package b16_io_text_file.bai_tap.b01_copy_file_text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFIle {
    public List<String> readFile(String filePath){
        List<String> textFile = new ArrayList<>();
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
                }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null){
                textFile.add(line);
            }
            br.close();
        } catch (Exception e) {
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
        return textFile;
    }
    public void writeFile(String filePath, List<String> textFile){
        try {
            FileWriter writer = new FileWriter(filePath, true);
            File file = new File(filePath);
            if (file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(String.valueOf(textFile));
            bufferedWriter.close();
        } catch (Exception e) {
            System.err.println("Fie in ra lỗi or đã tồn tại!");
        }
    }
}
