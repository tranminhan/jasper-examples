import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by atran on 10/5/14.
 */
public class GeneratePdfReportTest
{
    @Test
    public void shouldGeneratePdf() throws JRException, IOException
    {
        Files.deleteIfExists(Paths.get("report1.pdf"));

        final JasperDesign design = JRXmlLoader.load(new File("src/main/resources/report1.jrxml"));
        final JasperReport report = JasperCompileManager.compileReport(design);
        final Map<String, Object> params = new HashMap<String, Object>();
        final JasperPrint print = JasperFillManager.fillReport(report, params, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(print, "report1.pdf");
    }
}