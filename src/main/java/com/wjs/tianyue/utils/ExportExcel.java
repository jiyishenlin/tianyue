package com.wjs.tianyue.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.wjs.tianyue.mvc.pojo.Tb_Supliter;


public class ExportExcel {
	/**
     * 生成Excel
     * titleName 主标题
     * cell      列标题数组
     * 
     */
    public static String ExprotExcelXLSX(String titleName, String[] cell, List<List<String>> all) {
    	
        int rows = all.size();//行
        int cols = all.get(0).size();//列
    	
    	
        XSSFWorkbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet("0");
        for (int i = 0; i < cols; i++) {
            sheet.setColumnWidth(i, 4300);
        }

        /**
         * 数据单元格 样式
         */
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setTopBorderColor(HSSFColor.BLACK.index);
        cellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
        cellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
        cellStyle.setRightBorderColor(HSSFColor.BLACK.index);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
        //cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 上下居中

        /**
         * 数据标题单元格 样式
         */
        CellStyle cellTitleStyle = wb.createCellStyle();
        cellTitleStyle.setBorderTop(BorderStyle.THIN);
        cellTitleStyle.setBorderBottom(BorderStyle.THIN);
        cellTitleStyle.setBorderLeft(BorderStyle.THIN);
        cellTitleStyle.setBorderRight(BorderStyle.THIN);
        cellTitleStyle.setTopBorderColor(HSSFColor.BLACK.index);
        cellTitleStyle.setBottomBorderColor(HSSFColor.BLACK.index);
        cellTitleStyle.setLeftBorderColor(HSSFColor.BLACK.index);
        cellTitleStyle.setRightBorderColor(HSSFColor.BLACK.index);
        //cellTitleStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
        cellTitleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中
        cellTitleStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 上下居中

        /**
         * 标题样式 样式
         */
        XSSFFont titleFont = wb.createFont();
        titleFont.setFontHeight(24);
        titleFont.setBold(true);
        CellStyle titleCellStyle = wb.createCellStyle();
        titleCellStyle.setBorderTop(BorderStyle.THIN);
        titleCellStyle.setBorderBottom(BorderStyle.THIN);
        titleCellStyle.setBorderLeft(BorderStyle.THIN);
        titleCellStyle.setBorderRight(BorderStyle.THIN);
        titleCellStyle.setTopBorderColor(HSSFColor.BLACK.index);
        titleCellStyle.setBottomBorderColor(HSSFColor.BLACK.index);
        titleCellStyle.setLeftBorderColor(HSSFColor.BLACK.index);
        titleCellStyle.setRightBorderColor(HSSFColor.BLACK.index);
        titleCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 水平居中
        titleCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 上下居中
        titleCellStyle.setFont(titleFont);

        /**
         * 主 标题 在这里插入主标题
         */
        Row titleRow;
        Cell titleCell;
        sheet.addMergedRegion(new CellRangeAddress((short) 0, (short) 2, (short) 0, (short) (cols-1)));
        for (int i = 0; i <= 2; i++) {
            titleRow = sheet.createRow(i);
            for (int j = 0; j < cols; j++) {
                titleCell = titleRow.createCell(j);
                titleCell.setCellType(CellType.STRING);
                titleCell.setCellStyle(titleCellStyle);
                titleCell.setCellValue(titleName);
            }
        }

        /**
         * 列 标题 在这里插入标题
         */
        Row rowLabel;
        Cell cellLabel;
        for (int i = 3; i < 4; i++) {
            rowLabel = sheet.createRow(i);
            for (int j = 0; j < cols; j++) {
                cellLabel = rowLabel.createCell(j);
                cellLabel.setCellType(CellType.STRING);
                cellLabel.setCellStyle(cellTitleStyle);
                cellLabel.setCellValue(cell[j]);
            }
        }

        /**
         * 列 数据 在这里插入数据
         */
        Row rowCheck;
        Cell cellCheck;
        for (int i = 3; i < rows+3; i++) {
            rowCheck = sheet.createRow((i + 1));
            for (int j = 0; j < cols; j++) {
                cellCheck = rowCheck.createCell(j);
                cellCheck.setCellType(CellType.STRING);
                cellCheck.setCellStyle(cellStyle);
                //cellCheck.setCellValue("测试 - 0" + (i - 2));
                cellCheck.setCellValue(all.get(i-3).get(j));
            }
        }

        


        /**
         * 页脚
         */
        setExcelFooterName("表格", 0, wb);

        /**
         * 进行导出
         */
        String succ = exportOutPutExcel("C:\\Users\\Administrator\\Desktop\\abc\\ExportExcel.xlsx", wb);

        return succ;
    }

    /**
     * 设置Excel页脚
     */
    public static void setExcelFooterName(String customExcelFooterName, int setExcelFooterNumber, XSSFWorkbook wb) {
        wb.setSheetName(setExcelFooterNumber, customExcelFooterName);
    }

    /**
     * 输出流 导出Excel到桌面
     */
    public static String exportOutPutExcel(String exportPositionPath, XSSFWorkbook wb) {
    	String succ = "";
        try {
            File file = new File(exportPositionPath);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            wb.write(fileOutputStream);
            fileOutputStream.close();
            succ = "succ";
        } catch (IOException e) {
            System.err.println(e.getMessage());
            succ = e.getMessage();
        }
        return succ;
    }

    public static void main(String[] args) {
        List<Tb_Supliter> list  = new ArrayList<Tb_Supliter>();
        List<List<String>> all = new ArrayList<List<String>>();
        for(int i = 0; i<list.size();i++){
        	List<String> title = new ArrayList<String>();
        	title.add(list.get(i).getId().toString());
        	title.add(list.get(i).getSupname());
        	title.add(list.get(i).getSupaddr());
        	title.add(list.get(i).getName());
        	title.add(list.get(i).getTel());
        	all.add(title);
        }
    	String[] cell = {"a","b","c","d","e"};
        ExportExcel.ExprotExcelXLSX("2018年度能源科技进步奖", cell, all);
    }

}
