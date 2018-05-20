package com.cuteke.spring.boot.fileserver.pdf;

/**
 * Created by CuteKe on 2018/5/14.
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.layout.font.FontProvider;

/**
 * Creates a PDF document from an XML file using XSLT to convert the XML to HTML.
 */
public class ResumeUtil {
    /** The Base URI of the HTML page. */
    public static final String BASEURI = "src/main/resources/pdf/html/";
    /** Xml Base Dictionary  */
    public static final String XMLBASE="src/main/resources/pdf/xml/";
    /** The XML containing all the data. */
    public static  String XML = String.format("%sresume-test.xml", XMLBASE);
    /** The XSLT needed to transform the XML to HTML. */
    public static  String XSL = String.format("%sresume.xsl", XMLBASE);
    /** The target folder for the result. */
    public static final String XMLTARGET = "src/main/resources/results/xml/";
    public static final String PDFTARGET="src/main/resources/results/pdf/";

    public static final String[] FONTS = {
            "src/main/resources/pdf/fonts/MSYH.ttf",
            "src/main/resources/pdf/fonts/MSYHBD.ttf"
    };

    /**
     * The main method of this example.
     *
     * @param args no arguments are needed to run this example.
     * @throws IOException Signals that an I/O exception has occurred.
     */
//    public static void main(String[] args) throws IOException, TransformerException {
//        File file = new File(PDFTARGET);
//        file.mkdirs();
//        ResumeUtil app = new ResumeUtil();
//        app.createPdf(app.createHtml(XML, XSL), BASEURI, DEST);
//    }

    /**
     * Creates the PDF file.
     *
     * @param html the HTML file as a byte array
     * @param baseUri the base URI
     * @param dest the path to the resulting PDF
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void createPdf(byte[] html, String baseUri, String dest) throws IOException {
        ConverterProperties properties = new ConverterProperties();
        properties.setBaseUri(baseUri);
        FontProvider fontProvider = new DefaultFontProvider(false, false, false);
        for (String font : FONTS) {
            FontProgram fontProgram = FontProgramFactory.createFont(font);
            fontProvider.addFont(fontProgram);
        }
        properties.setFontProvider(fontProvider);
        HtmlConverter.convertToPdf(new ByteArrayInputStream(html), new FileOutputStream(dest), properties);
    }

    /**
     * Creates an HTML file by performing an XSLT transformation on an XML file.
     *
     * @param xmlPath the path to the XML file.
     * @param xslPath the path to the XSL file
     * @return the resulting HTML as a byte[]
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws TransformerException the transformer exception
     */
    public byte[] createHtml(String xmlPath, String xslPath) throws IOException, TransformerException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Writer writer = new OutputStreamWriter(baos);
        StreamSource xml = new StreamSource(new File(xmlPath));
        StreamSource xsl = new StreamSource(new File(xslPath));
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer(xsl);
        transformer.transform(xml, new StreamResult(writer));
        writer.flush();
        writer.close();
        return baos.toByteArray();
    }

}





