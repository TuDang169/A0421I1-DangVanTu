package b16_io_text_file.bai_tap.b01_copy_file_text;

import java.util.List;

public class CopyFileText {
    public static void main(String[] args) {
        ReadAndWriteFIle readAndWriteFIle = new ReadAndWriteFIle();
        List<String> textFile = readAndWriteFIle.readFile("D:\\A0421I1-DangVanTu\\module2\\src\\b12_java_collection_framework\\text_file\\text_file.txt");
        readAndWriteFIle.writeFile("D:\\A0421I1-DangVanTu\\module2\\src\\b12_java_collection_framework\\text_file\\new_file.txt", textFile);
    }
}
