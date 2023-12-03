package bunchbysoh;

public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  };

  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    CountsBySoH counts = new CountsBySoH();
    for (int capacity : presentCapacities) {
            double SoH = 100.0 * capacity / 120;

            if (SoH > 80) {
                counts.healthy++;
            } else if (SoH <= 80 && SoH >= 62) {
                counts.exchange++;
            } else {
                counts.failed++;
            }
        }
    return counts;
  }

  static void testBucketingByHealth() {
    System.out.println("Counting batteries by SoH...\n");
    int[] presentCapacities = {113, 116, 80, 95, 92, 70};
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    assert(counts.healthy == 2);
    assert(counts.exchange == 3);
    assert(counts.failed == 1);

    // Large dataset (boundary condition)
    int[] largeDataSet = {110, 115, 80, 95, 92, 70, 105, 98, 75, 88, 77, 120, 62, 45};
    CountsBySoH largeDataCounts = countBatteriesByHealth(largeDataSet);
    assert(largeDataCounts.healthy == 5);
    assert(largeDataCounts.exchange == 6);
    assert(largeDataCounts.failed == 3);

  }

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}
