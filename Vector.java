package PursellJaques;

public class Vector {

    private Double[] components;
    private int size;

    /**
     * Creates a vector with the specified components
     * @param components The components of the vector.
     */
    public Vector(Double[] components) {
        this.components = components;
        size = components.length;
    }
    /**
     * Creates a zero vector with specified dimensions.
     * @param size The number of dimensions or the size of the vector.
     */
    public Vector(int size) {
        components = new Double[size];
        this.size = size;
    }
    /**
     * 
     * @return the components array of the vector
     */
    public Double[] getComponents() {return components;}
    /**
     * 
     * @return the number of elements in the vector's components array
     */
    public int getSize() {return size;}

}
