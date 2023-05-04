package lesson9_testsystem;

public record Answer(String text) {

    public String getFmtText(int index) {
        if (index % 2 == 0) {   //formatting for pretty print in 2 columns
            return String.format("%-20s", "\n" + (index + 1) + ": " + this.text());
        }
        return String.format("%-20s", (index + 1) + ": " + this.text());

    }
}
