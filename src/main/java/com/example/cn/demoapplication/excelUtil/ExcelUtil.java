package com.example.cn.demoapplication.excelUtil;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @program: demoapplication
 * @description: 操作excel工具类
 * @author: huyaou
 * @create: 2019-10-16 14:48
 */
public class ExcelUtil {

    /**
     * 生产环境读取文件对象
     */
    private static Workbook workbookS;

    /**
     * 测试环境读取文件对象
     */
    private static Workbook workbookC;

    /**
     * sheet 页 对象
     */
    private static Sheet sheet;

    /**
     * 测试环境下的文件数据行
     */
    private static Row rowc;

    /**
     * 生产环境下的文件数据行
     */
    private static Row rows;

    /**
     * 测试环境下的文件数据列
     */
    private static XSSFCell cellc;

    /**
     * 生产环境下的文件数据列
     */
    private static XSSFCell cells;

    private static HashSet set;

    private static File file;

    private static FileOutputStream fileOutputStream;

    private static String[] zhibiao;

    private ExcelUtil() {
    }

    /**
     * 初始化对象参数
     * @param spath 生产文件路径
     * @param cpath 测试文件路径
     */
    private static void init(String spath, String cpath) {

        if (StringUtils.isBlank(spath) || StringUtils.isBlank(cpath)) {
            throw new RuntimeException("文件路径为空!");
        }

        set = new HashSet();
        set.add("资产负债表");
        set.add("利润表");
        set.add("现金流量表");

        try {
            InputStream is = new FileInputStream(spath);
            InputStream ic = new FileInputStream(cpath);

            String exts = spath.substring(spath.lastIndexOf("."));
            String extc = cpath.substring(cpath.lastIndexOf("."));

            if (".xls".equals(exts)) {
                workbookS = new HSSFWorkbook(is);
            } else if (".xlsx".equals(exts)) {
                workbookS = new XSSFWorkbook(is);
            } else {
                workbookS = null;
            }

            if (".xls".equals(extc)) {
                workbookC = new HSSFWorkbook(ic);
            } else if (".xlsx".equals(extc)) {
                workbookC = new XSSFWorkbook(ic);
            } else {
                workbookC = null;
            }

            zhibiao = new String[]{"2018-12-31", "2017-12-31", "2016-12-31", "2015-12-31", "2014-12-31"};

        } catch (FileNotFoundException e) {
            System.out.println(e.getLocalizedMessage() + "找不到文件");
        } catch (IOException e) {
            System.out.println(e.getMessage() + "io的异常");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 读取不同环境下的相同表的文件的相同项数据，并比较是否一致
     * @throws Exception
     */
    public static void chechData(String spath, String cpath) throws Exception {
        init(spath, cpath);
        if (workbookS == null || workbookC == null) {
            throw new RuntimeException("workbook对象为空");
        }
        //测试环境的文件的sheet页数量
        int numberOfSheetC = workbookC.getNumberOfSheets();

        //生产环境的文件的sheet页数量
        int numberOfSheetS = workbookS.getNumberOfSheets();

        if (numberOfSheetC <= 0 || numberOfSheetS <= 0) {
            return;
        }

        String sheetName;
        //该行的名称
        String rowName;
        Iterator<Cell> cellIterator;

        //读取测试文件的sheet
        for (int i = 0; i < numberOfSheetC; i++) {
            sheet = workbookC.getSheetAt(i);
            sheetName = sheet.getSheetName();
            //
            if (!set.contains(sheetName)) {
                continue;
            }
            //企业名称
            String companyName = sheet.getRow(0).getCell(1).getStringCellValue();
            String substring = companyName.substring(0, 4);

            //标准报表存放路径
            //file = new File("D:\\standard\\" + substring + "_" + sheetName +  ".txt");
            //原始报表存放路径
            file = new File("D:\\orign\\" + substring + "_" + sheetName +  ".txt");
            if (!file.exists()) {
                file.getParentFile().mkdir();
            }
            fileOutputStream = new FileOutputStream(file);

            fileOutputStream.write((companyName +"\n\n").getBytes());
            fileOutputStream.flush();


            //该sheet页的总行数
            int totalNum = sheet.getLastRowNum();

            for (int num = 6; num <= totalNum; num++) {
                rowc = sheet.getRow(num);

                rows = workbookS.getSheetAt(i).getRow(num);

                if (rowc == null || rows == null) {
                    continue;
                }
                rowName = "";
                cellIterator = rowc.cellIterator();
                //遍历该行的所有列
                while (cellIterator.hasNext()) {
                    cellc = (XSSFCell) cellIterator.next();
                    if (StringUtils.isBlank(rowName)) {
                        rowName = cellc.getRawValue();
                    }
                    if (cellc.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                        cells = (XSSFCell) workbookS.getSheetAt(i).getRow(num).getCell(cellc.getColumnIndex());

                        checkValue(cellc.getRawValue(), cells.getRawValue(), sheetName, rowName, zhibiao[cellc.getColumnIndex()-1]);
                    }
                }
                fileOutputStream.write("\n".getBytes());
                fileOutputStream.flush();
            }
            fileOutputStream.close();
        }

        System.out.println("----执行结束----");
    }

    /**
     * 判断测试环境下和生产环境下的相同文件的相同位置数据是否一致
     * @param valuec
     * @param values
     * @param sheetName
     * @param rowName
     * @param columName
     * @throws Exception
     */
    private static void checkValue(String valuec, String values, String sheetName, String rowName, String columName) throws Exception {
        StringBuilder builder = new StringBuilder();
        if (StringUtils.isNotBlank(values)) {
            if (!valuec.equals(values)) {
                builder.append("生产 -- " + sheetName +" -- " + rowName + " -- " + columName  + " -- 数据不一致\n");
            }
        } else {
            builder.append("生产 -- " + sheetName + " -- " + rowName + " -- " + columName  + " -- 数据为空\n");
        }

        if (StringUtils.isNotBlank(builder.toString())) {
            fileOutputStream.write(builder.toString().getBytes());
            fileOutputStream.flush();
        }
    }
}
