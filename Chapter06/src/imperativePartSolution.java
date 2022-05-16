import java.util.HashMap;
import java.util.Map;

public class imperativePartSolution {
	
	public static void main(String... args) {
		imperativePartSolution();
	}
	
	
	private static void replicatePart(Part part) {
        // Replicate part
        System.out.println("Part replicated: " + part);
    }

    private static void imperativePartSolution() {
        Map<Integer, Part> parts = new HashMap<>();
        parts.put(123, new Part(123, "bolt"));
        parts.put(456, new Part(456, "nail"));
        parts.put(789, new Part(789, "wire"));

        int partId = 456; // Some source
        Part part = parts.get(partId);
        part.setOutOfStock(true);
        part.setPartName(part.getPartName() + "-Out-Of-Stock");
        replicatePart(part);
    }
}
