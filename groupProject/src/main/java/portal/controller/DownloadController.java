package portal.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping("/download")
public class DownloadController {

    private static final String FILE_PATH = "/s_home/tke1/git/co2015-1718-group-20/groupProject/resources/FDM-General-Services-Brochure-2018.compressed.pdf";
    private static final String APPLICATION_PDF = "application/pdf";

    @RequestMapping(value = "/a", method = RequestMethod.GET, produces = APPLICATION_PDF)
    public @ResponseBody void downloadA(HttpServletResponse response) throws IOException {
        File file = getFile();
        InputStream in = new FileInputStream(file);

        response.setContentType(APPLICATION_PDF);
        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
        response.setHeader("Content-Length", String.valueOf(file.length()));
        FileCopyUtils.copy(in, response.getOutputStream());
    }

    @RequestMapping(value = "/b", method = RequestMethod.GET, produces = APPLICATION_PDF)
    public @ResponseBody HttpEntity<byte[]> downloadB() throws IOException {
        File file = getFile();
        byte[] document = FileCopyUtils.copyToByteArray(file);

        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "pdf"));
        header.set("Content-Disposition", "inline; filename=" + file.getName());
        header.setContentLength(document.length);

        return new HttpEntity<byte[]>(document, header);
    }

    private File getFile() throws FileNotFoundException {
        File file = new File(FILE_PATH);
        if (!file.exists()){
            throw new FileNotFoundException("file with path: " + FILE_PATH + " was not found.");
        }
        return file;
    }

}