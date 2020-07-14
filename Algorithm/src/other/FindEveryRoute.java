package other;

import java.util.*;

public class FindEveryRoute {
    public static void main(String[] args) {

        String origin = "A"; //입력 line: 1
        String dest = "G"; //입력 line: 2

        System.out.println(solution(origin, dest));
    }

    public static String solution(String origin, String dest) {
        if (origin.equals(dest)) return "0";

        Route root = getDefaultRoute();
        Route originRoute = findOriginRoute(root, origin);
        if (originRoute == null) return "-1";

        LinkedList<Integer> answer = new LinkedList<>();


        findDestRoute(0, originRoute, dest, answer);
        if (answer.size() == 0) return "-1";
        else return answer.toString();
    }

    public static Route findOriginRoute(Route route, String origin) {
        if (route.name.equals(origin)) return route;

        Route originRoute = null;

        LinkedList<Route> childRoutes = route.routes;

        for (Route child : childRoutes) {
                originRoute = findOriginRoute(child, origin);
        }

        return originRoute;
    }

    public static void findDestRoute(int length, Route route, String dest, LinkedList<Integer> availableRoute) {
        LinkedList<Route> childRoutes = route.routes;

        for (Route child : childRoutes) {
            if (child.name.equals(dest)) {
                availableRoute.add(length + route.getLength(child));
            } else {
                findDestRoute(length + route.getLength(child), child, dest, availableRoute);
            }
        }
    }

    public static Route getDefaultRoute() {
        Route root = new Route("A");
        Route routeB = new Route("B");
        Route routeC = new Route("C");
        Route routeF = new Route("F");

        root.addRoute(1, routeB);
        root.addRoute(2, routeC);
        root.addRoute(4, routeF);

        Route routeE = new Route("E");
        Route routeD = new Route("D");
        routeB.addRoute(1, routeE);
        routeB.addRoute(3, routeD);

        routeC.addRoute(2, routeD);

        Route routeG = new Route("G");
        routeF.addRoute(3, routeG);

        Route routeK = new Route("K");
        routeD.addRoute(2, routeK);
        routeD.addRoute(1, routeG);

        Route routeH = new Route("H");
        routeE.addRoute(1, routeH);

        Route routeI = new Route("I");
        Route routeJ = new Route("J");

        routeG.addRoute(1, routeH);
        routeG.addRoute(3, routeJ);
        routeG.addRoute(2, routeI);

        routeI.addRoute(2, routeJ);

        routeH.addRoute(1, routeJ);

        return root;
    }

    static class Route implements Comparable<Route>{
        String name;
        LinkedList<Route> routes;
        HashMap<Route, Integer> distances;

        public Route(String name) {
            this(name, new LinkedList<>(), new HashMap<>());
        }

        public Route(String name, LinkedList<Route> routes, HashMap<Route, Integer> distances) {
            this.name = name;
            this.routes = routes;
            this.distances = distances;
        }

        public void addRoute(int distance, Route route) {
            this.routes.add(route);
            this.distances.put(route, distance);

            Collections.sort(routes);
        }

        public int getLength(Route route) {
            return distances.get(route);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(this.name);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Route) {
                Route route = (Route)obj;
                return this.name.equals(route.name);
            }
            return false;
        }

        @Override
        public int compareTo(Route o) {
            return this.name.compareTo(o.name);
        }
    }
}
