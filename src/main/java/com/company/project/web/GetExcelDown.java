package com.company.project.web;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/download")
public class GetExcelDown {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<byte[]> download(HttpServletRequest request ) throws IOException {

        File file = new File("/Users/jiangying/Documents/Test-auto/Users/jiang/IdeaProjects/spring-boot-api-project-seed/src/main/resources/banner.txt");
        byte[] body = null;
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + file.getName());
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> entity = new ResponseEntity<>(body, headers, statusCode);
        return entity;
    }

    /**
     * 使用poi生成excel
     * @return
     */
    public List<List<String>> makeExcel() throws Exception {
        //new一个输入流
        FileInputStream inputStream = new FileInputStream("fileName");
        //new一个workbook
        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        //创建一个sheet对象，参数为sheet的索引
        HSSFSheet sheet = workbook.getSheetAt(0);
        //new出存放一张表的二维数组
        List<List<String>> allData = new ArrayList<List<String>>();

        for (Row row:sheet) {
            List<String> oneRow = new ArrayList<String>();
            //不读表头
            if(row.getRowNum()==0)
                continue;
            for (Cell cell : row) {
                cell.setCellType(cell.CELL_TYPE_STRING);
                oneRow.add(cell.getStringCellValue().trim());
            }
            allData.add(oneRow);
        }

        for (int i = 0; i < allData.size(); i++) {
            System.out.println(allData.get(i));
        }
        //关闭workbook
        //workbook.close();
        return allData;
    }
}
