package net.shvdy;

/**
 * 20.03.2020
 *
 * @author Dmitriy Storozhenko
 * @version 1.0
 */
public class IteratorPattern {
    public static void main(String[] args) {
        Tasks c = new Tasks();

        Iterator it = c.getIterator();

        while(it.hasNext()){
            System.out.println((String)it.next());
        }
    }
}

interface Iterator{
    boolean hasNext();
    Object next();
}

interface Container{
    Iterator getIterator();
}

class Tasks implements Container{
    String[] tasks = {"Построить дом", "Родить сына", "Посадить дерево"};

    @Override
    public Iterator getIterator() {
        return new TaskIterator();
    }

    private class TaskIterator implements Iterator{

        int index = 0;

        @Override
        public boolean hasNext() {
            if(index<tasks.length){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            return tasks[index++];
        }
    }
}