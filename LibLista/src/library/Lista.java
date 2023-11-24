package library;

public class Lista<T> {
    No<T> first = null;

    public boolean isEmpty() {
        if (first == null) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        int count = 0;
        if (isEmpty()) {
            No<T> aux = first;
            while (aux != null) {
                count += 1;
                aux = aux.next;
            }
        }
        return count;
    }

    private No<T> getNo(int pos) throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista Vazia");
        }

        int size = size();

        if (pos < 0 || pos > size - 1) {
            throw new Exception("Posição inválida");
        }

        No<T> aux = first;
        int index = 0;

        while (index < pos) {
            aux = aux.next;
            index++;
        }
        return aux;
    }

    public void addFirst(T value) {
        No<T> element = new No<>();
        element.dado = value;
        element.next = first;
        first = element;
    }

    public void addLast(T value) throws Exception{
        int size = size();
        if(isEmpty()) {
           addFirst(value);
        } else{
        No<T> element = new No<>();
        element.dado = value;
        element.next = null;
        No<T> last = getNo(size-1);
        last.next = element;
    }}

    public void add(T value, int pos) throws Exception {
        int size = size();
        if(pos< 0 || pos > size){
            throw new Exception("Posição inválida");
        }
        if(pos == 0){
            addFirst(value);
        }else {
            No<T> element = new No<>();
            element.dado = value;
            No<T> previous = getNo(pos-1);
            element.next = previous.next;
            previous.next = element;
        }
    }

    public void removeFirst() throws Exception{
        if(isEmpty()){
            throw new Exception("Lista Vazia");
        }
        first = first.next;
    }

    public void removeLast() throws Exception{
        if(isEmpty()){
            throw new Exception("Lista vazia");
        }
        int size = size();
        if(size == 1){
            removeFirst();
        }else {
            No<T> penult= getNo(size - 2);
            penult.next = null;
        }
    }

    public void remove(int pos) throws Exception{
        int size = size();
        if(pos < 0 || pos > -1){
            throw new Exception("Posição inválida");
        }
        if(isEmpty()){
            throw new Exception("Lista Vazia");
        }
        if(pos == 0){
            removeFirst();
        }else if(pos == size-1){
            removeLast();
        }else {
            No<T> previous = getNo(pos-1);
            No<T> current = getNo(pos);
            previous.next = current.next;
        }
    }

    public T get(int pos) throws Exception{
        if(isEmpty()) {
            throw new Exception("Lista Vazia");
        }

        int size = size();

        if(pos < 0 || pos > size - 1) {
            throw new Exception("Posição Inválida");
        }

        int counter = 0;
        No<T> aux = first;
        

        while(counter < pos){
            aux = aux.next;
            counter++;  
        }
        return aux.dado;
    }
}
