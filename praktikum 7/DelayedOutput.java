/**
 * DelayedOutput.java 
 * Mencetak output dengan input delaymilisec dan menggunakan threading agar proses tidak terblokir selama delay
 * @author 18222042 Eldwin Pradipta
 */
public class DelayedOutput {
  public static void printDelayed(int delayMillisec, String output) {
      // TODO print output setelah di delay selama delayMillisec
      // PENTING: gunakan threading agar tidak blocking
        Thread uhuy = new Thread(() -> {
            try {
                Thread.sleep(delayMillisec);
            }
            catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
            System.out.println(output);
        });
        uhuy.start();
  }
}
