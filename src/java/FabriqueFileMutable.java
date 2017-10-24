public interface FabriqueFileMutable {

    default File fileMutable() {

        return new FileMutable();
    }
}
