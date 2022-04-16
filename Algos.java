import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


class Algos {
    public class Edge {
        int v;
        int w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public class Pair {
        int node;
        int wsf;

        public Pair(int node, int wsf) {
            this.node = node;
            this.wsf = wsf;
        }
    }

    public int[] dijkstra(ArrayList<Edge>[] graph, int src) {
        int V = graph.length;

        int[] dis = new int[V];
        boolean[] vis = new boolean[V];

        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> {
            return a.wsf - b.wsf;
        });

        pq.add(new Pair(src, 0));

        while (pq.size() > 0) {
            Pair t = pq.remove();

            int node = t.node;
            int wsf = t.wsf;

            if (vis[node]) continue;

            vis[node] = true;
            dis[node] = wsf;

            for (Edge e : graph[node]) {
                int v = e.v;
                int w = e.w;

                if (!vis[v]) {
                    pq.add(new Pair(v, wsf + e.w));
                }
            }
        }

        return dis;
    }

    public int[] dijkstra_better(ArrayList<Edge>[] graph, int src) {
        int V = graph.length;

        int[] dis = new int[V];

        Arrays.fill(dis, (int) (1e8));

        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> {
            return a.wsf - b.wsf;
        });

        pq.add(new Pair(src, 0));
        dis[src] = 0;

        while (pq.size() > 0) {
            Pair p = pq.remove();

            int node = p.node;
            int wsf = p.wsf;

            if (dis[node] < wsf) continue;

            for (Edge e : graph[node]) {
                int v = e.v;
                int w = e.w;

                if (dis[v] > wsf + w) {
                    dis[v] = wsf + w;
                    pq.add(new Pair(v, wsf + w));
                }
            }
        }

        return dis;
    }


    // prims algortihm

    class Prims_pair {
        int node;
        int par;
        int weight;

        public Prims_pair(int node, int par, int weight) {
            this.node = node;
            this.par = par;
            this.weight = weight;
        }
    }

    public void addEdge(int u, int v, int w, ArrayList<Edge>[] graph) {
        graph[u].add(new Edge(v, w));
        graph[v].add(new Edge(u, w));
    }

    public ArrayList<Edge>[] prims(ArrayList<Edge>[] graph, int src) {
        int V = graph.length;

        boolean[] vis = new boolean[V];

        ArrayList<Edge>[] mst = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            mst[i] = new ArrayList<>();
        }

        PriorityQueue<Prims_pair> pq = new PriorityQueue<>((Prims_pair a, Prims_pair b) -> {
            return a.weight - b.weight;
        });

        pq.add(new Prims_pair(src, -1, 0));

        while (pq.size() > 0) {
            Prims_pair p = pq.remove();

            int node = p.node;
            int par = p.par;
            int weight = p.weight;

            if (vis[node]) continue;

            vis[node] = true;

            if (par != -1) {
                addEdge(par, node, weight, mst);
            }

            for (Edge e : graph[node]) {
                if (vis[e.v] == false) {
                    pq.add(new Prims_pair(e.v, node, e.w));
                }
            }
        }

        return mst;
    }

    public int[] bellmanFord(int[][] edges, int V, int src) {
        int[] prev = new int[V];

        Arrays.fill(prev, (int) (1e8));

        prev[src] = 0;

        for (int edgeCount = 1; edgeCount <= V; edgeCount++) {
            int[] curr = new int[V];

            // copy prev;
            boolean isAnyUpdate = false;
            for (int i = 0; i < V; i++) {
                curr[i] = prev[i];
            }

            for (int[] e : edges) {
                int u = e[0];
                int v = e[1];
                int w = e[2];

                if (prev[u] + w < curr[v]) {
                    curr[v] = prev[u] + w;
                    isAnyUpdate = true;
                }
            }

            if (isAnyUpdate == false) {
                break;
            }

            prev = curr;
        }

        return prev;
    }

    public static void main(String[] args) {

    }
}
