package PursellJaques;

import java.io.IOError;

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
        for (int i = 0; i < size; i++) {
            components[i] = 0.0;
        }
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

    /**
     * Adds two vectors.
     * @param v the vector to be added
     * @return A vector that is th the addition of two same-size vectors.
     */
    public Vector add(Vector v) throws ArithmeticException {
        Double[] otherComponents = v.getComponents();
        if (size != otherComponents.length) {
            throw new ArithmeticException();
        }
        Double[] newComponents = new Double[size];

        for (int i = 0; i < size; i++) {
            newComponents[i] = components[i] + otherComponents[i];
        }

        return new Vector(newComponents);
    }

    /**
     * Adds two vectors.
     * @param v the vector to be subtracted.
     * @return A vector that is the difference of two same-size vectors.
     * @throws ArithmeticException
     */
    public Vector subtract(Vector v) throws ArithmeticException {
        Double[] otherComponents = v.getComponents();
        if (size != otherComponents.length) {
            throw new ArithmeticException();
        }
        Double[] newComponents = new Double[size];

        for (int i = 0; i < size; i++) {
            newComponents[i] = components[i] - otherComponents[i];
        }

        return new Vector(newComponents);
    }

    /**
     * 
     * @param v the other vector
     * @return  
     * @throws ArithmeticException
     */
    public double dotProduct(Vector v) throws ArithmeticException {
        Double[] otherComponents = v.getComponents();
        if (size != otherComponents.length) {
            throw new ArithmeticException();
        }
        double product = 0;

        for (int i = 0; i < size; i++) {
            product += components[i] * otherComponents[i];
        }

        return product;
    }

}
