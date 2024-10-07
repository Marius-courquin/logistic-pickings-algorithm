package com.ig2i.instances;

import com.ig2i.instances.models.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InstanceReader {

    public Instance readInstance(InstanceFile instanceFile) throws IOException {
        var path = instanceFile.getPath();
        var instance = new Instance();

        readLocations(instance, path);

        var reader = getReader(path);
        readNbLocations(instance, reader);
        readNbProducts(instance, reader);
        readNbBoxesTrolley(instance, reader);
        readNbDimensionsCapacity(instance, reader);
        readBoxCapacity(instance, reader);

        readProducts(instance, reader);
        readNbOrders(instance, reader);
        readOrders(instance, reader);

        readNbVerticesIntersections(instance, reader);
        readDepartingDepot(instance, reader);
        readArrivingDepot(instance, reader);
        readArcs(instance, reader);
        readShortestPaths(instance, reader);
        
        return instance;
    }

    private BufferedReader getReader(String path) throws IOException {
        return new BufferedReader(new FileReader(path));
    }

    private void readLocations(Instance instance, String path) throws IOException {
        var reader = getReader(path);
        String line;

        while ((line = reader.readLine()) != null) {
            if (line.startsWith(InstanceFileDelimiter.LOCATIONS.getDelimiter())) {
                while ((line = reader.readLine()) != null && !line.startsWith(" ")) {
                    var location = LocationParser.parse(line);
                    instance.addLocation(location);
                }
            }
        }

        reader.close();
    }

    private void readNbLocations(Instance instance, BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith(InstanceFileDelimiter.NB_LOCATIONS.getDelimiter())) {
                line = reader.readLine();
                instance.setNumberOfLocations(Integer.parseInt(line.split(" ")[0]));
                break;
            }
        }
    }

    private void readNbProducts(Instance instance, BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith(InstanceFileDelimiter.NB_PRODUCTS.getDelimiter())) {
                line = reader.readLine();
                instance.setNumberOfProducts(Integer.parseInt(line.split(" ")[0]));
                break;
            }
        }
    }

    private void readNbBoxesTrolley(Instance instance, BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith(InstanceFileDelimiter.NB_BOXES_TROLLEY.getDelimiter())) {
                line = reader.readLine();
                instance.setNumberOfBoxesTrolley(Integer.parseInt(line.split(" ")[0]));
                break;
            }
        }
    }

    private void readNbDimensionsCapacity(Instance instance, BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith(InstanceFileDelimiter.NB_DIMENSIONS_CAPACITY.getDelimiter())) {
                line = reader.readLine();
                instance.setNumberOfDimensionsCapacity(Integer.parseInt(line.split(" ")[0]));
                break;
            }
        }
    }

    private void readBoxCapacity(Instance instance, BufferedReader reader) throws IOException {
        String line;
        BoxCapacity boxCapacity = null;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith(InstanceFileDelimiter.BOX_CAPACITY.getDelimiter())) {
                line = reader.readLine();
                boxCapacity = BoxCapacityParser.parse(line);
            }

            if (line.startsWith(InstanceFileDelimiter.MIXED_ORDERS.getDelimiter())) {
                line = reader.readLine();
                boxCapacity = BoxCapacityParser.parseMixedOrders(line, boxCapacity);
                instance.setBoxCapacity(boxCapacity);
                break;
            }
        }
    }

    private void readProducts(Instance instance, BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith(InstanceFileDelimiter.PRODUCTS.getDelimiter())) {
                while ((line = reader.readLine()) != null && !line.startsWith(" ")) {
                    var product = ProductParser.parse(instance, line);
                    instance.addProduct(product);
                }
                break;
            }
        }
    }

    private void readNbOrders(Instance instance, BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith(InstanceFileDelimiter.NB_ORDERS.getDelimiter())) {
                line = reader.readLine();
                instance.setNumberOfOrders(Integer.parseInt(line.split(" ")[0]));
                break;
            }
        }
    }

    private void readOrders(Instance instance, BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith(InstanceFileDelimiter.ORDERS.getDelimiter())) {
                while ((line = reader.readLine()) != null && !line.startsWith(" ")) {
                    var order = OrderParser.parse(instance, line);
                    instance.addOrder(order);
                }
                break;
            }
        }
    }

    private void readNbVerticesIntersections(Instance instance, BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith(InstanceFileDelimiter.NB_VERTICES_INTERSECTIONS.getDelimiter())) {
                line = reader.readLine();
                instance.setNumberOfVerticesIntersections(Integer.parseInt(line.split(" ")[0]));
                break;
            }
        }
    }

    private void readDepartingDepot(Instance instance, BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith(InstanceFileDelimiter.DEPARTING_DEPOT.getDelimiter())) {
                line = reader.readLine();
                instance.setDepartingDepot(Integer.parseInt(line.split(" ")[0]));
                break;
            }
        }
    }

    private void readArrivingDepot(Instance instance, BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith(InstanceFileDelimiter.ARRIVAL_DEPOT.getDelimiter())) {
                line = reader.readLine();
                instance.setArrivingDepot(Integer.parseInt(line.split(" ")[0]));
                break;
            }
        }
    }

    private void readArcs(Instance instance, BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith(InstanceFileDelimiter.ARCS.getDelimiter())) {
                while ((line = reader.readLine()) != null && !line.startsWith(" ")) {
                    var arc = ArcParser.parse(instance, line);
                    instance.addArc(arc);
                }
                break;
            }
        }
    }

    private void readShortestPaths(Instance instance, BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.startsWith(InstanceFileDelimiter.SHORTEST_PATH.getDelimiter())) {
                while ((line = reader.readLine()) != null && !line.startsWith(" ")) {
                    var shortestPath = ShortestPathParser.parse(instance, line);
                    instance.addShortestPath(shortestPath);
                }
                break;
            }
        }
    }

    private static class ProductParser {
        public static Product parse(Instance instance, String line) {
            var parts = line.split(" ");
            var id = Integer.parseInt(parts[0]);
            var locationId = Integer.parseInt(parts[1]);
            var weight = Integer.parseInt(parts[2]);
            var volume = Integer.parseInt(parts[3]);
            var location = instance.getLocationById(locationId);
            return Product.of(id, weight, volume, location);
        }
    }

    private static class LocationParser {
        public static Location parse(String line) {
            var parts = line.split(" ");
            var id = Integer.parseInt(parts[0]);
            var longitude = Integer.parseInt(parts[1]);
            var latitude = Integer.parseInt(parts[2]);
            var name = parts[3];
            return Location.of(id, longitude, latitude, name);
        }
    }

    private static class BoxCapacityParser {
        public static BoxCapacity parse(String line) {
            var parts = line.split(" ");
            var weight = Integer.parseInt(parts[0]);
            var volume = Integer.parseInt(parts[1]);
            return BoxCapacity.of(weight, volume);
        }

        public static BoxCapacity parseMixedOrders(String line, BoxCapacity boxCapacity) {
            var parts = line.split(" ");
            var mixedOrders = Integer.parseInt(parts[0]);
            boxCapacity.setMixedOrdersAllowed(mixedOrders == 1);
            return boxCapacity;
        }
    }

    private static class OrderParser {
        public static Order parse(Instance instance, String line) {
            var parts = line.split(" ");
            var id = Integer.parseInt(parts[0]);
            var nbOfBoxes = Integer.parseInt(parts[1]);
            var nbProducts = Integer.parseInt(parts[2]);
            var order = new Order(id, nbOfBoxes, nbProducts);
            for (int i = 3; i < parts.length; i += 2) {
                var product = instance.getProductById(Integer.parseInt(parts[i]));
                var quantity = Integer.parseInt(parts[i + 1]);
                var article = Article.of(quantity, product, id);
                order.addArticle(article);
            }
            return order;
        }
    }

    private static class ArcParser {
        public static Arc parse(Instance instance, String line) {
            var parts = line.split(" ");
            var start = Integer.parseInt(parts[0]);
            var end = Integer.parseInt(parts[1]);

            var distance = Integer.parseInt(parts[2]);
            return Arc.of(instance.getLocationById(start), instance.getLocationById(end), distance);
        }
    }

    private static class ShortestPathParser {
        public static ShortestPath parse(Instance instance, String line) {
            var parts = line.split(" ");
            var start = Integer.parseInt(parts[0]);
            var end = Integer.parseInt(parts[1]);
            var distance = Integer.parseInt(parts[2]);
            return ShortestPath.of(instance.getLocationById(start), instance.getLocationById(end), distance);
        }
    }

}
