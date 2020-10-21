package cote;

public class Veterinarian {
    private PetQueue<String> first;
    private PetQueue<String> last;

    public void accept(String petName) {
        PetQueue<String> pet = new PetQueue<>(petName);
        if (last != null) {
            last.setNext(pet);
        }
        last = pet;
        if (first == null) {
            first = last;
        }
    }

    public String heal() {
        if (first == null) {
            return null;
        }
        String petName = first.getPetName();
        first = first.getNext();

        if (first == null) {
            last = null;
        }
        return petName;
    }

    public static void main(String[] args) {
        Veterinarian veterinarian = new Veterinarian();
        veterinarian.accept("Barkley");
        veterinarian.accept("Mittens");
        System.out.println(veterinarian.heal());
        System.out.println(veterinarian.heal());
    }
}

class PetQueue<String> {
    private String petName;
    private PetQueue<String> next;

    public void setNext(PetQueue<String> next) {
        this.next = next;
    }

    public String getPetName() {
        return petName;
    }

    public PetQueue<String> getNext() {
        return next;
    }

    public PetQueue(String petName) {
        this.petName = petName;
    }
}