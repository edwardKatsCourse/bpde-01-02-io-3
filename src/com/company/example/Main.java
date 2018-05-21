package com.company.example;

import java.io.*;
import java.util.stream.Collectors;

public class Main {
    static String filename = "C:\\Users\\Edward\\Desktop\\BPDE-01-02. Writer and Reader\\text.txt";

    public static void main(String[] args) throws IOException {


        Reader reader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(reader);
        readAllLinesFromBufferReader_3(bufferedReader);
    }

    public static void inputStreamToReaderConverter() throws IOException {
        InputStream inputStream = new FileInputStream(filename);

//        byte [] buff = new byte[1000];
//        while (inputStream.available() > 0) {
//            inputStream.read(buff);
//        }
//        String s = new String(buff);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        //Other languages (pseudo code)
        //String allFileContent = reader.readLine();
        //List<String> lines = allFileContent.split["\n"];


//        Read buffered reader out out 2 lines in text file
        //Line 1
        System.out.println(bufferedReader.readLine());

        //Line 2
        System.out.println(bufferedReader.readLine());

        //null
        System.out.println(bufferedReader.readLine());


        bufferedReader.close();
//        bufferedReader.readLine(); -> IOException, because stream is already closed.
//        Cannot read from a closed stream


        //Interview stupid question
//        boolean b = false;
//        if (b = true) {
//            System.out.println("if");
//        } else if (b) {
//            System.out.println("else if");
//        } else {
//            System.out.println("else");
//        }
    }

    public static void outputStreamToWriterConverter() throws FileNotFoundException {
        OutputStream outputStream = new FileOutputStream(filename);

        Writer writer = new OutputStreamWriter(outputStream);

        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        //BufferedWriter has .newLine() method
        //Regular Writers do not have
    }

    public static void readAllLinesFromBufferReader_1(BufferedReader bufferedReader) throws IOException {
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }
    }

    public static void readAllLinesFromBufferReader_2(BufferedReader bufferedReader) throws IOException {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static void readAllLinesFromBufferReader_3(BufferedReader bufferedReader) {
        //Apache Commons Library (3rd party)
        //1 -> 0001
        //10 -> 0010

        //1 -> 1000
        //10 -> 1000
        String textFile = bufferedReader
                .lines()
                .collect(Collectors.joining("\n"));

        System.out.println(textFile);

    }

    public static void readerWriterExample() throws IOException {
        //OutputStream  / InputStream
        //Writer        / Reader

        //UTF-8, UTF-16, ascii -> char


        Writer writer = new FileWriter(filename);


        writer.write("Hello from writer");
        writer.flush();
        writer.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

        String line = bufferedReader.readLine();
        System.out.println(line);
    }
}
