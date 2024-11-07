public enum Colors {
    RED("\u001B[31m"),
    BLUE("\u001B[34m"),
    GREEN("\u001B[32m"),
    BLACK("\u001B[30m"),
    WHITE("\u001B[37m"),
    ORANGE("\u001B[33m"),
    PURPLE("\u001B[35m"),
    BROWN("\u001B[36m"),
    GREY("\u001B[90m");

    private final String code;

    Colors(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code + name() + "\u001B[0m";
    }

    //public String getCode(){
        //return code;
    //}

    public static final String RESET = "\u001B[0m";
}
