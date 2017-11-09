package tp.v1;

public interface FabriqueFileMutable {

    default File fileMutable() {

        return new FileMutable();
    }
}
