package tp.v2;

/**
 * Created by francoismilhem on 07/11/2017.
 */
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
public class TestFile {
    private static final ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
    private static long diviseur = 100000;

    private static void tester(File file) {
        long temps = threadBean.getCurrentThreadCpuTime();
        file = file.ajout(1);
        file = file.retrait();
        temps = threadBean.getCurrentThreadCpuTime() - temps;
        System.out.println(file.getClass() + " - ajout/retrait: " + (temps / diviseur));
    }

    public static void main(String[] args){


        File<Integer> fileMutableParListeMutable = new FileMutableParListeMutable<>();
        File<Integer> fileImmutableParListe = new FileImmutableParListe<>();

        tester(fileMutableParListeMutable);
        tester(fileImmutableParListe);

    }

}