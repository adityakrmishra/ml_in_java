import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DataLoaderTest {

    @Test
    public void testLoadCSV() {
        String filePath = "data/sample.csv";
        double[][] data = DataLoader.loadCSV(filePath);

        assertNotNull(data);
        assertEquals(5, data.length); // Assuming the CSV has 5 rows
        assertEquals(3, data[0].length); // Assuming the CSV has 3 columns
    }

    @Test
    public void testLoadCSVEmptyFile() {
        String filePath = "data/empty.csv";
        double[][] data = DataLoader.loadCSV(filePath);

        assertNotNull(data);
        assertEquals(0, data.length);
    }

    @Test
    public void testLoadCSVInvalidFile() {
        String filePath = "data/invalid.csv";
        assertThrows(Exception.class, () -> {
            DataLoader.loadCSV(filePath);
        });
    }
}
