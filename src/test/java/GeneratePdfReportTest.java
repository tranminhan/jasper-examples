import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by atran on 10/5/14.
 */
public class GeneratePdfReportTest
{
    @Test
    public void shouldGeneratePdfReport1() throws JRException, IOException
    {
        Files.deleteIfExists(Paths.get("report1.pdf"));

        final JasperDesign design = JRXmlLoader.load(new File("src/main/resources/report1.jrxml"));
        final JasperReport report = JasperCompileManager.compileReport(design);
        final Map<String, Object> params = new HashMap<String, Object>();
        final JasperPrint print = JasperFillManager.fillReport(report, params, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(print, "report1.pdf");
    }

    @Test
    public void shouldGeneratePdfReport2() throws JRException, IOException
    {
        Files.deleteIfExists(Paths.get("report2.pdf"));

        final JasperDesign design = JRXmlLoader.load(new File("src/main/resources/report2.jrxml"));
        final JasperReport report = JasperCompileManager.compileReport(design);
        final Map<String, Object> params = new HashMap<String, Object>();
        final JasperPrint print = JasperFillManager.fillReport(report, params, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(print, "report2.pdf");
    }

    @Test
    public void shouldGeneratePdfReportI18n_US() throws JRException, IOException
    {
        final String OUTPUT_FILENAME = "reportI18n_US.pdf";
        Files.deleteIfExists(Paths.get(OUTPUT_FILENAME));

        final JasperDesign design = JRXmlLoader.load(new File("src/main/resources/I18nReport.jrxml"));
        final JasperReport report = JasperCompileManager.compileReport(design);
        final Map<String, Object> params = new HashMap<String, Object>();
        params.put(JRParameter.REPORT_LOCALE, Locale.US);
        final JasperPrint print = JasperFillManager.fillReport(report, params, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(print, OUTPUT_FILENAME);
    }

    @Test
    public void shouldGeneratePdfReportI18n_FRENCH() throws JRException, IOException
    {
        final String OUTPUT_FILENAME = "reportI18n_FRENCH.pdf";
        Files.deleteIfExists(Paths.get(OUTPUT_FILENAME));

        final JasperDesign design = JRXmlLoader.load(new File("src/main/resources/I18nReport.jrxml"));
        final JasperReport report = JasperCompileManager.compileReport(design);
        final Map<String, Object> params = new HashMap<String, Object>();
        params.put(JRParameter.REPORT_LOCALE, Locale.FRENCH);
        final JasperPrint print = JasperFillManager.fillReport(report, params, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(print, OUTPUT_FILENAME);
    }

    @Test
    public void shouldGeneratePdfReportI18n_VIETNAMESE() throws JRException, IOException
    {
        final String OUTPUT_FILENAME = "reportI18n_VN.pdf";
        Files.deleteIfExists(Paths.get(OUTPUT_FILENAME));

        final JasperDesign design = JRXmlLoader.load(new File("src/main/resources/I18nReport.jrxml"));
        final JasperReport report = JasperCompileManager.compileReport(design);
        final Map<String, Object> params = new HashMap<String, Object>();
        params.put(JRParameter.REPORT_LOCALE, new Locale("vi", "vi"));
        final JasperPrint print = JasperFillManager.fillReport(report, params, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(print, OUTPUT_FILENAME);
    }
}
