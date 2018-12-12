package com.example.zaq.lib;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * Created by Zhang Aqi on 2018/12/12. 10:17
 * mail:1095187377@qq.com
 */
public class DimenUtil {
    private static void generateXmlFile(int vValueCount, int yValueCount) {

        StringBuffer sbForX = new StringBuffer();
        sbForX.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
        sbForX.append("<resources>");
        for (int i = 1; i <= vValueCount; i++) {
            sbForX.append("<dimen name=\"PX_" + i + "\">" + i +"px" + "</dimen>\n");
        }
        sbForX.append("</resources>");

        File fileDir = new File("./values" + File.separator);
        fileDir.mkdir();

        File xCountFile = new File(fileDir.getAbsolutePath(), "dimens.xml");
        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream(xCountFile));
            pw.print(sbForX.toString());
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int xMaxValue = 1200;
        int yMaxValue = 800;
        try {
            if (args.length >= 2) {
                xMaxValue = Integer.parseInt(args[0]);
                yMaxValue = Integer.parseInt(args[1]);
            } else if (args.length >= 1) {
                xMaxValue = Integer.parseInt(args[0]);
                yMaxValue = Integer.parseInt(args[0]);
            }
        } catch (NumberFormatException e) {
            System.err.println("right input params : java -jar xxx.jar xMaxValue,yMaxValue;");
            e.printStackTrace();
            System.exit(-1);
        }

        generateXmlFile(xMaxValue, yMaxValue);
    }
}
