package griffio;

import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Fixtures {

  public static String fixture(String resourceName) throws IOException {
    return Resources.toString(Resources.getResource(resourceName), StandardCharsets.UTF_8);
  }

  public static String fixture(URL resource) throws IOException {
    return Resources.toString(resource, StandardCharsets.UTF_8);
  }

}
