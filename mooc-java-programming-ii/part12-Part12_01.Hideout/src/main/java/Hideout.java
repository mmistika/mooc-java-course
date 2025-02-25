
public class Hideout<T> {
    
    private T object;

    public Hideout() {
        this.object = null;
    }
    
    public void putIntoHideout(T toHide) {
        this.object = toHide;
    }
    
    public T takeFromHideout() {
        T obj = this.object;
        if (obj != null) {
            this.object = null;
        }
        return obj;
    }
    
    public boolean isInHideout() {
        return this.object != null;
    }
}
