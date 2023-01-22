package CRUD;

public enum Operators {

    CREATE(1),
    READ(2),
    UPDATE(3),
    DELETE(4);

    public final int code;

    private Operators(int code) {
        this.code = code;
    }

    public static Operators valueOfLabel(int code) {
        for (Operators e : values()) {
            if (e.code == (code)) {
                return e;
            }
        }
        return null;
    }
}


