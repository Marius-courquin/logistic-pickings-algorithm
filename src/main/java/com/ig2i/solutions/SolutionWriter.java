package com.ig2i.solutions;

import com.ig2i.instances.models.Article;
import com.ig2i.solutions.models.Parcel;
import com.ig2i.solutions.models.Solution;
import com.ig2i.solutions.models.Tour;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SolutionWriter {

    private int currentParcelId = 0;

    private static final String PATH = "src/main/resources/solutions/";
    private static final String SUFFIX = "_sol.txt";

    public void writeSolution(Solution solution) throws IOException {
            var file = new File(PATH + solution.getInstanceFile() + SUFFIX);
            var writer = new FileWriter(file);

            writeNbTour(solution, writer);

            writeTours(solution, writer);

            writer.close();
    }

    private void writeNbTour(Solution solution, FileWriter fileWriter) throws IOException {
            fileWriter.write(SolutionFileDelimiter.NB_TOUR.toString());
            fileWriter.write(solution.getTourCount() + "\n");
    }

    private void writeTours(Solution solution, FileWriter fileWriter) throws IOException {
        Tour tour;
        for (int i = 0; i < solution.getTourCount(); i++) {
            tour = solution.getTourByIndex(i);
            writeTourNbParcels(tour, i + 1, fileWriter);
            writeTourParcels(tour, fileWriter);
        }
    }

    private void writeTourNbParcels(Tour tour, int tourId, FileWriter fileWriter) throws IOException {
        fileWriter.write(SolutionFileDelimiter.TOUR_NB_PARCELS + "\n");
        fileWriter.write(tourId + " " + tour.getParcelCount() + "\n");
    }

    private void writeTourParcels(Tour tour, FileWriter fileWriter) throws IOException {
        fileWriter.write(SolutionFileDelimiter.TOUR_PARCELS + "\n");
        for (Parcel parcel : tour.getParcel()) {
            writeParcel(parcel, fileWriter);
        }
    }

    private void writeParcel(Parcel parcel, FileWriter fileWriter) throws IOException {
        fileWriter.write(currentParcelId++ + " " + parcel.getOrderId() + " " + parcel.getArticleCount() + " ");
        for (Article article : parcel.getArticles()) {
            writeParcelArticles(article, fileWriter);
        }
        fileWriter.write("\n");
    }

    private void writeParcelArticles(Article article, FileWriter fileWriter) throws IOException {
        fileWriter.write(article.getProduct().getId() + " " + article.getQuantity() + " ");
    }


}
