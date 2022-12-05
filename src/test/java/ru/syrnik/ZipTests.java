package ru.syrnik;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ZipTests {
    ClassLoader cl = ZipTests.class.getClassLoader();

    @Test
    public void unZipAndParseFiles() throws Exception {
        try (
                InputStream resource = cl.getResourceAsStream("zip/cars.zip");
                ZipInputStream zis = new ZipInputStream(resource)
        ) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {
                if (entry.getName().contains("pdf")) {
                    PDF pdf = new PDF(zis);
                    assertThat(pdf.author).isEqualTo("Andrew");
                } else if (entry.getName().contains("xls")) {
                    XLS xls = new XLS(zis);
                    assertThat(xls.excel.getSheetAt(0).getRow(1).getCell(1).getStringCellValue()).isEqualTo("Vesta");
                } else if (entry.getName().contains("csv")) {
                    CSVReader reader = new CSVReader(new InputStreamReader(zis));
                    List<String[]> list = reader.readAll();
                    assertThat(list.get(1)[1]).isEqualTo("Vesta");
                }
            }
        }
    }
}
