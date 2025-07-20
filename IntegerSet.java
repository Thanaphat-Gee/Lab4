/** ADT ที่เก็บจำนวนเต็มไม่ซ้ำกันและเรียงลำดับจากน้อยไปมาก
 */
public class IntegerSet {
    private String s;

    // Rep Invariant (RI):
    //  - s ต้องไม่ซ้ำกัน
    //  - ตัวเลขใน s ต้องเรียงจากน้อยไปมาก เช่น "1 3 5"
    //
    // Abstraction Function (AF):
    //  - AF(s) = เซตของจำนวนเต็มที่อยู่ในสตริง s

    public IntegerSet() {
        s = "";
        checkRep();
    }

    private void checkRep() {
        if (s.equals("")) return;
        String[] parts = s.split(" ");
        for (int i = 0; i < parts.length - 1; i++) {
            int current = Integer.parseInt(parts[i]);
            int next = Integer.parseInt(parts[i + 1]);
            if (current >= next) {
                throw new RuntimeException("Rep invariant violated!");
            }
        }
    }

    public void add(int n) {
    if (contains(n)) {
        return;
    }

    if (s.equals("")) {
        s = n + "";
        checkRep();
        return;
    }

    String[] parts = s.split(" ");
    String newString = "";
    boolean added = false;

    for (int i = 0; i < parts.length; i++) {
        int val = Integer.parseInt(parts[i]);
        if (!added && n < val) {
            newString = newString + n + " ";
            added = true;
        }
        newString = newString + val + " ";
    }

    if (!added) {
        newString = newString + n + " ";
    }

    s = newString.trim();

    checkRep();
}

    public void remove(int n) {
    if (s.equals("")) {
        return;
    }

    String[] parts = s.split(" ");
    String newString = "";

    for (int i = 0; i < parts.length; i++) {
        int val = Integer.parseInt(parts[i]);
        if (val != n) {
            newString = newString + val + " ";
        }
    }

    s = newString.trim();

    checkRep();
}


    public boolean contains(int n) {
    if (s.equals("")) {
        return false;
    }

    String[] parts = s.split(" ");
    for (int i = 0; i < parts.length; i++) {
        int val = Integer.parseInt(parts[i]);
        if (val == n) {
            return true;
        }
    }

    return false;
}


    public int size() {
    if (s.equals("")) {
        return 0;
    } else {
        String[] parts = s.trim().split(" ");
        return parts.length;
    }
}
    @Override
    public String toString() {
        if (s.equals("")) return "{}";
        String[] parts = s.split(" ");
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < parts.length; i++) {
            sb.append(parts[i]);
            if (i < parts.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}

