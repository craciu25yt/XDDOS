package XD.XDDOS.gui;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class BrowserOpener {
    // yes i did copy some of your code @XDMEOW
    private final Runtime rt = Runtime.getRuntime();
    private final String[] browsers = { "google-chrome", "firefox", "mozilla", "epiphany", "konqueror","netscape", "opera", "links", "lynx" };
    
    public void openUrl(String url) throws URISyntaxException {
       
        String osname = System.getProperty("os.name");
        
            if(osname.toLowerCase().startsWith("linux")) {
                StringBuffer cmd = new StringBuffer();
                    for (int i = 0; i < browsers.length; i++)
                        if(i == 0)
                        cmd.append(String.format(    "%s \"%s\"", browsers[i], url));
                        else
                        cmd.append(String.format(" || %s \"%s\"", browsers[i], url)); 
        
                try 
                {
                    rt.exec(new String[] { "sh", "-c", cmd.toString() });
                }
                 catch (Exception e) {e.printStackTrace();}
            }
            if(osname.toLowerCase().startsWith("win")){
        
                try { 
        
                  try {
                    Desktop.getDesktop().browse(new URI(url));
                } catch (IOException e1) {
                    e1.printStackTrace();
            }
            if(osname.toLowerCase().startsWith("mac")){
                try {rt.exec("open " + url);
                } 
            catch (IOException e) {e.printStackTrace();}
                }
        
            } finally {}
        }
    }
}
