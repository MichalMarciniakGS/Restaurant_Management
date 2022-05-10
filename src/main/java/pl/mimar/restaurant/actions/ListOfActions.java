package pl.mimar.restaurant.actions;

public enum ListOfActions {
    ADD("add"),
    DELETE("delete"),
    DELETE_SPECIFIC("delete specific"),
    DELETE_ALL("delete all"),
    READ("read"),
    READ_SPECIFIC("read specific"),
    READ_ALL("read all"),
    SORT("sort"),
    EXIT("exit");

    private final String name;

    ListOfActions(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
