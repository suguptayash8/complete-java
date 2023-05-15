package references;

import java.lang.ref.SoftReference;

/**
 * Here are some situations where you might use soft references in Java:
 *
 * Caching: If your application needs to cache data that is expensive to compute, you can use a soft reference to store the data in memory. This allows the data to be retrieved quickly if it is needed again, but also allows the JVM to free up memory if necessary.
 *
 * Image processing: If your application is processing large images, you can use soft references to store intermediate results. This can help reduce the memory footprint of your application, while still allowing it to operate efficiently.
 *
 * Large collections: If your application needs to store a large collection of objects, you can use soft references to ensure that the memory usage remains reasonable. This can be especially useful if the collection is rarely accessed, but still needs to be available when needed.
 */
public class SoftReferenceExample {
    SoftReferenceExample(){

    }

    public void buildSoftReference(){

        ComputedData computedData = new ComputedData("808.0633", "1453");
        SoftReference<ComputedData> computedDataSoftReferenceExample = new SoftReference(computedData);
        computedDataSoftReferenceExample.get();
    }
}

class ComputedData {
    String value;
    String totalDataSample;


    ComputedData(String value, String totalDataSample){
        this.value = value;
        this.totalDataSample = totalDataSample;
    }
}