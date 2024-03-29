public class Main {
    public static void main(String[] args) {
        Lista<Integer> listaDeEnteros = new Lista<>();
        listaDeEnteros.add(5);
        listaDeEnteros.add(10);
        listaDeEnteros.add(15);

        Lista<String> listaDeCadenas = new Lista<>();
        listaDeCadenas.add("Hola");
        listaDeCadenas.add("Mundo");
        listaDeCadenas.add("!");


        System.out.println("Tamaño de la lista: " + listaDeEnteros.size());
        System.out.println("Elemento en la posición 1: " + listaDeEnteros.get(1));

        listaDeEnteros.set(1, 25);
        System.out.println("Elemento en la posición 1 después de modificar: " + listaDeEnteros.get(1));

        listaDeEnteros.delete(0);
        System.out.println("Tamaño de la lista después de eliminar un elemento: " + listaDeEnteros.size());

        System.out.println("Contenido de la lista: " + listaDeEnteros.toString());


        System.out.println("lista strings");

        System.out.println("Tamaño de la lista: " + listaDeCadenas.size());
        System.out.println("Elemento en la posición 1: " + listaDeCadenas.get(1));

        listaDeCadenas.set(1, "Mundo cruel");
        System.out.println("Elemento en la posición 1 después de modificar: " + listaDeCadenas.get(1));

        listaDeCadenas.delete(0);
        System.out.println("Tamaño de la lista después de eliminar un elemento: " + listaDeCadenas.size());

        System.out.println("Contenido de la lista: " + listaDeCadenas.toString());
    }

    public static class NodeList <T> {
        //El propio elemento
        private T elem;
        //La referencia al siguiente elemento
        private NodeList <T> next = null;
        //La referencia al anterior elemento
        private NodeList <T> prev = null;

        public NodeList(T elemento)
        {
            this.elem = elemento;
        }

        //Getters
        public T getElement()






        {
            return this.elem;
        }
        public NodeList <T> getNext()
        {
            return this.next;
        }
        public NodeList <T> getPrev()
        {
            return this.prev;
        }

        //Setters
        public void setElem(T elemento)
        {
            this.elem = elemento;
        }
        public void setNext(NodeList<T> siguiente)
        {
            this.next = siguiente;
        }
        public void setPrev(NodeList<T> anterior)
        {
            this.prev = anterior;
        }
    }

    public static class Lista <T> {
        //El primer elemento de la lista
        private NodeList<T> first = null;
        //El tamaño de la lista
        private int length = 0;

        /**
         Devuelve el tamaño.
         */
        public int size()
        {
            return this.length;
        }

        /**
         Añade un elemento al final de lista

         @param elem: El valor del elemento a añadir.
         */
        public void add(T elem)
        {
            NodeList <T> act = new NodeList<>(elem); //Creamos el nuevo elemento
            if(this.first != null) //Si la lista no está vacía
            {
                NodeList<T> last = this.first;
                //Busca el que no tenga siguiente, es decir, el último.
                while(last.getNext() != null)
                {
                    last = last.getNext();
                }
                last.setNext(act);
                act.setPrev(last);
            }else{
                this.first = act;
            }

            this.length++;
        }

        /**
         Busca un elemento dado un índice y lo devuelve.

         @param index: El índice del elemento a buscar empezando en 0
         */
        private NodeList<T> search(int index)
        {
            NodeList<T> act = this.first;
            for(int i = 0; i < index; i++)
            {
                act = act.getNext();
            }
            return act;
        }

        /**
         Devuelve el valor del elemento en una posición dada.

         @param index: La posición del elemento a buscar empezando en 0.
         */
        public T get(int index) throws IndexOutOfBoundsException
        {
            //Si el índice está dentro de los parámetros.
            if(index >= 0 && index < this.length)
            {
                NodeList<T> elem = search(index);
                return elem.getElement();
            }
            throw new IndexOutOfBoundsException();
        }

        /**
         Cambia el valor del elemento en una posición dada.

         @param index: La posición del elemento a cambiar empezando en 0.
         @param elem: El valor a establecer
         */
        public void set(int index, T elem) throws IndexOutOfBoundsException
        {
            //Si el índice está dentro de los parámetros.
            if(index >= 0 && index < this.length)
            {
                NodeList<T> act = search(index);
                act.setElem(elem);
            }else{
                throw new IndexOutOfBoundsException();
            }
        }

        /**
         Elimina el elemento en una posición dada.

         @param index: La posición del elemento a borrar empezando en 0.
         */
        public void delete(int index)
        {
            if(index >= 0 && index < this.length && this.first != null)
            {
                if(this.length == 1)
                {
                    this.first = null;
                }else{
                    if(index == 0)
                    {
                        this.first = this.first.getNext();
                        this.first.setPrev(null);
                    }else{
                        NodeList<T> act = search(index);
                        act.getPrev().setNext(act.getNext());
                        if(act.getNext() != null)
                        {
                            act.getNext().setPrev(act.getPrev());
                        }
                    }

                }
                this.length--;
            }
        }

        /**
         Muestra por pantalla el valor de todos los elementos de la lista.
         */
        public String toString() {
            if (this.length > 0) {
                NodeList<T> act = this.first;
                StringBuilder list = new StringBuilder("[" + act.getElement());
                for (int i = 1; i < this.length; i++) {
                    act = act.getNext();
                    list.append(",").append(act.getElement());
                }
                return list + "]";
            } else {
                return "Lista vacía";
            }
        }
    }
}