

public class LinkedListElement<T> {
    private LinkedListElement<T> next;
    private LinkedListElement<T> previous;

    // boolean is_circular;

    private T object;

    /* does not add the element to a list! */
    public LinkedListElement(T object) {
        this.object = object;

        this.next = null;
        this.previous = null;
        // this.is_circular = false;
    }

    public T getObject() {
        return object;
    }

    /* May return null if there is no next element (end of list) */
    public LinkedListElement<T> next() {
        return next;
    }

    public LinkedListElement<T> previous() {
        return previous;
    }

    public void addAfter(LinkedListElement<T> element) {
        element.previous = this;
        element.next = this.next;

        if (this.next != null) {
            this.next.previous = element;
        }
        this.next = element;
        // this.next.is_circular = this.is_circular;
    }

    // /* converts this into a circular (double) linked list */
    // /* can be called on any element */
    // /* removed because it can cause issues in weirdly structured linked lists */
    // public void makeCircular() {
    //     if (is_circular) {
    //         /* return early because it is not necessary (and futile) to make a circular list more circular */
    //         return;
    //     }
    //     LinkedListElement<T> last = this.next;
    //     LinkedListElement<T> first = this.previous;
    //     is_circular = true;

    //     if (last == null) {
    //         last = this;
    //     } else {
    //         last.is_circular = true;
    //         while (last.next != null) {
    //             last = last.next;
    //             last.is_circular = true;
    //         }
    //     }

    //     if (first == null) {
    //         first = this;
    //     } else {
    //         first.is_circular = true;
    //         while (first.previous != null) {
    //             first = first.previous;
    //             first.is_circular = true;
    //         }
    //     }

    //     last.next = first;
    //     first.previous = last;
    // }

    // public boolean isCircular() {

    //     return is_circular;
    // }

    public void setNext(LinkedListElement<T> next) {
        this.next = next;
    }

    public void setPrevious(LinkedListElement<T> previous) {
        this.previous = previous;
    }

    /* may return null if next is null! */
    public LinkedListElement<T> removeNext() {
        LinkedListElement<T> removed = null;
        if (this.next != null) {
            this.next = this.next.next;
            removed = this.next.previous;
            this.next.previous = this;
        }
        return removed;
    }

    public String toString() {
        return this.object.toString();
    }
}
