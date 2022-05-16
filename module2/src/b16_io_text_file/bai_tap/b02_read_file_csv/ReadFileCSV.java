package b16_io_text_file.bai_tap.b02_read_file_csv;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class ReadFileCSV {
    public void splitString(String filePath) {
        final String delimiter = ",";
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            String[] tempArray;
            while ((line = bufferedReader.readLine()) != null) {
                tempArray = line.split(delimiter);
                for(String tempStr : tempArray) {
                    System.out.println(tempStr + " ");
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
    }

    public static void main(String[] args) {
        ReadFileCSV readFileCSV = new ReadFileCSV();
        readFileCSV.splitString("D:\\A0421I1-DangVanTu\\module2\\src\\b12_java_collection_framework\\text_file\\CSV_file.txt");
    }
}
