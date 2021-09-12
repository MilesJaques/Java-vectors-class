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

    public String toString() {
        String s = "<"+components[0]+", ";
        for (int i = 1; i < size-1; i++) {
            s += components[i] + ", ";
        }
        return s + components[size-1] + ">";
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
     * @return  a scalar 
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

    /**
     * 
     * @param v the other vector
     * @return a vector that is perpendicular to both {@code v} and {@code this}
     * @throws ArithmeticException
     */
    public Vector crossProduct(Vector v) throws ArithmeticException{
        Double[] otherComponents = v.getComponents();
        if (!(size == 3 && otherComponents.length == 3)) {
            throw new ArithmeticException();
        }

        return new Vector(new Double[] {components[1]*otherComponents[2]-components[2]*otherComponents[1],
                                        (components[0]*otherComponents[2]-components[2]*otherComponents[0])*-1,
                                        components[0]*otherComponents[1]-components[1]*otherComponents[0]});
    }

    /**
     * 
     * @param scalar the scalar to multiply the vector by
     * @return a scaled vector
     */
    public Vector scalarMultiplication(double scalar) {
        Double[] newComponents = new Double[size];
        for (int i = 0; i < size; i++) {
            newComponents[i] = components[i]*scalar;
        }

        return new Vector(newComponents);
    }

    /**
     * 
     * @return the magnitude of the vector
     */
    public double getMagnitude() {
        double sumOfComponents = 0;
        for (double d: components) {
            sumOfComponents += d*d;
        }

        return Math.sqrt(sumOfComponents);
    }

    /**
     * 
     * @return the angle of a 2D vector relative to the normal line
     */
    public double getTheta() {
        return Math.atan(components[1] / components[0]);
    }
}
