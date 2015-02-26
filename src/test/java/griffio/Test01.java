package griffio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

@Test
public class Test01 {

  static Logger log = LoggerFactory.getLogger(Test01.class);

  @Test
  public void do_it() throws Exception {
    log.info("done it");
  }
}
