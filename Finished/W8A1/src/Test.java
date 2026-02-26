

public class Test {
    public static void main(String[] args) {
        LinkedListElement<PhoneBook> start = new LinkedListElement<PhoneBook>(
            new PhoneBook(
                "John Doe",
                "1600 Pensylvania Ave Washington DC, United States",
                "jdoe@whitehouse.gov",
                "+1 (999)-999-1234"
            )
        );

        start.addAfter(
            new LinkedListElement<PhoneBook>(
                new PhoneBook(
                    "Baltassar Kallirrhoe",
                    "20 Baldursgata Reykjavík, Iceland",
                    "BKallirrhoe@example.com",
                    "+354 (314)-159-2653"
                )
            )
        );

        start.addAfter(
            new LinkedListElement<PhoneBook>(
                new PhoneBook(
                    "Galenos Ismayil",
                    "2319 11th St N #203",
                    "GIsmayil@example.com",
                    "+1 (703) 522-6618"
                )
            )
        );

        start.addAfter(
            new LinkedListElement<PhoneBook>(
                new PhoneBook(
                    "Hed Shankar",
                    "4812 Cyclone St",
                    "HShankar@example.com",
                    "+1 (501) 847-4255"
                )
            )
        );

        do {
            System.out.println(start);
        } while ((start = start.next()) != null);

    }
}
