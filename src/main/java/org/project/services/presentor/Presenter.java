package org.project.services.presentor;

import org.project.services.matrixMath.Matrix;

public class Presenter {
    private Matrix matrix;

    public Presenter(Matrix matrix) {
        this.matrix = matrix;
    }

    public Library getGraphs() {
        return new Library(this.matrix);
    }
}
