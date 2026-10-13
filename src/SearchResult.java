public class SearchResult {
    public final int index;      
    public final long steps;     
    public final long nanos;     

    public SearchResult(int index, long steps, long nanos) {
        this.index = index; this.steps = steps; this.nanos = nanos;
    }
    public boolean found() { return index >= 0; }
}
