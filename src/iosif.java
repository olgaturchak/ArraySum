public class iosif {
    public class LinkedList<T> {

        private Node<T> head;

        private static class Node<T>{

            private final T value;
            private Node<T> next;

            public Node(T value) {
                this.value = value;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "value=" + value +
                        ", next=" + next +
                        '}';
            }
        }
    }
}
