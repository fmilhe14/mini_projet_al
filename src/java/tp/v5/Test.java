package tp.v5;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * Created by francoismilhem on 23/11/2017.
 */
public class Test {

    private static final ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
    private static long diviseur = 100000;

    public static void main(String[] args){

        test_file_mutable();

        System.out.println("-------------------------------------");

        test_file_immutable();
    }

    public static void test_file_mutable(){

        long temps = threadBean.getCurrentThreadCpuTime();

        FileMutableParEtatFileMutable<Integer>  fileMutableParEtatFileMutable= new FileMutableParEtatFileMutable<>(new EtatFileMutableParListeMutable());

        System.out.println("Taille file mutable : 0 = "+fileMutableParEtatFileMutable.taille());

        fileMutableParEtatFileMutable.ajout(1);

        System.out.println("Taille file mutable : 1 = "+fileMutableParEtatFileMutable.taille());
        System.out.println("Tête file mutable : 1 = "+fileMutableParEtatFileMutable.premier());

        fileMutableParEtatFileMutable.ajout(2);
        System.out.println("Suivants  file mutable : 2 = "+fileMutableParEtatFileMutable.suivants().premier());


        fileMutableParEtatFileMutable.retrait();

        System.out.println("Taille file mutable : 1 = "+fileMutableParEtatFileMutable.taille());
        System.out.println("Tête file mutable : 2 = "+fileMutableParEtatFileMutable.premier());

        temps = threadBean.getCurrentThreadCpuTime() - temps;
        System.out.println(fileMutableParEtatFileMutable.getClass() + " - ajout/retrait: " + (temps / diviseur));
    }

    public static void test_file_immutable(){

        long temps = threadBean.getCurrentThreadCpuTime();

        FileImmutableParEtatFileImmutable<Integer>  fileImmutableParEtatFileImmutable= new FileImmutableParEtatFileImmutable<>(new EtatFileImmutableParListeImmutable());

        System.out.println("Taille file immutable : 0 = "+fileImmutableParEtatFileImmutable.taille());

        fileImmutableParEtatFileImmutable.ajout(1);

        System.out.println("Taille file immutable : 1 = "+fileImmutableParEtatFileImmutable.taille());
        System.out.println("Tête file immutable : 1 = "+fileImmutableParEtatFileImmutable.premier());

        fileImmutableParEtatFileImmutable.ajout(2);
        System.out.println("Suivants file immutable : 2 = "+fileImmutableParEtatFileImmutable.suivants().premier());


        fileImmutableParEtatFileImmutable.retrait();

        System.out.println("Taille file immutable : 1 = "+fileImmutableParEtatFileImmutable.taille());
        System.out.println("Tête file immutable : 2 = "+fileImmutableParEtatFileImmutable.premier());

        temps = threadBean.getCurrentThreadCpuTime() - temps;
        System.out.println(fileImmutableParEtatFileImmutable.getClass() + " - ajout/retrait: " + (temps / diviseur));

    }

}
