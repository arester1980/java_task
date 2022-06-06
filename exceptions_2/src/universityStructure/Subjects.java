package src.universityStructure;

public enum Subjects {
    CRIMINAL, CIVIL, PRODUCTION, SOURCE, SOFTWARE, DELIVERY;

    @Override
    public String toString() {
        return this.name();
    }
}
