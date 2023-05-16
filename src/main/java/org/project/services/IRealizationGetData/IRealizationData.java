package org.project.services.IRealizationGetData;

import java.io.IOException;

public interface IRealizationData {
    double[][] readData(String filePath) throws IOException;
}
