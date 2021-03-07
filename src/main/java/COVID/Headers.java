package COVID;

public enum Headers {

    citizen_name("Időpont"), zip("Irányítószám"), age("Életkor"), email("E-mail"), ssn("TAJ szám");
    private String head;

    Headers(String head) {
        this.head = head;
    }
    //Időpont;Név;Irányítószám;Életkor;E-mail cím;TAJ szám
    public String getHead() {
        return head;
    }
}
