package disjointsets;

public class DisjointSet {
    int n;
    int[] parent;
    int[] size;

    public DisjointSet(int n) {
        this.n = n;
        initializeParent(n);
    }

    private void initializeParent(int n) {
        this.parent = new int[n];
        this.size = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
    }

    public void union(int u, int v) {
        int uParent = find(u);
        int vParent = find(v);
        
        if (uParent == vParent) {
            return;
        }
        if (size[uParent] >= size[vParent]) {
            parent[vParent] = uParent;
            size[uParent] += size[vParent];
        } else {
            parent[uParent] = vParent;
            size[vParent] += size[uParent];
        }
    }

    public int find(int u) {
        if (parent[u] == u) {
            return u;
        }
        // Path Compression.
        return parent[u] = find(parent[u]);
    }
}