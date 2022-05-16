package b16_io_text_file.thuc_hanh.read_write_file;

import java.util.List;

public class FindMaxValue {
    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("D:\\A0421I1-DangVanTu\\module2\\src\\b12_java_collection_framework\\text_file\\numbers.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("D:\\A0421I1-DangVanTu\\module2\\src\\b12_java_collection_framework\\text_file\\result.txt", maxValue);
    }
}
