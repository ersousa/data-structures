package linkedlist;

import lombok.Getter;
import lombok.Setter;

public class ListaDuplamenteEncadeada <T> {
        @Getter
        @Setter
        public class ItemListaEncadeada<K> {
            private K dado;
            private ItemListaEncadeada<K> anterior;
            private ItemListaEncadeada<K> proximo;
        }

        ItemListaEncadeada<T> primeiroItem;
        ItemListaEncadeada<T> ultimoItem;
        int tamanho = 0;

        public T add(T dado){
            if(primeiroItem==null){
                this.primeiroItem = new ItemListaEncadeada<>();
                primeiroItem.setDado(dado);
                ultimoItem = primeiroItem;
            } else {
                ItemListaEncadeada<T> item = new ItemListaEncadeada<>();
                item.setDado(dado);
                item.setAnterior(ultimoItem);
                ultimoItem.setProximo(item);
                ultimoItem = item;
            }
        /*System.out.println(primeiroItem.getDado());
        System.out.println(ultimoItem==null?"":ultimoItem.getDado());
        System.out.println(primeiroItem);
        System.out.println(ultimoItem);
        System.out.println();
        System.out.println();*/
            tamanho++;
            return dado;
        }

        public T get(int posicao) throws Exception {
            this.validateRulesList(posicao);

            if (posicao == 0) return primeiroItem.getDado();

            ItemListaEncadeada<T> item = primeiroItem;

            for (int i = 0; i < posicao; i++) {
                item = item.getProximo();
            }

            return item.getDado();
        }

        private ItemListaEncadeada<T> getItem(int posicao) throws Exception {
            this.validateRulesList(posicao);

            if (posicao == 0) return primeiroItem;

            ItemListaEncadeada<T> item = primeiroItem;

            for (int i = 0; i < posicao; i++) {
                item = item.getProximo();
            }

            return item;
        }

        public T remove(int posicao) throws Exception {

            if (posicao == 0) {
                T dado = primeiroItem.getDado();
                primeiroItem = primeiroItem.getProximo();
                return dado;
            }

            ItemListaEncadeada<T> itemAtual = this.getItem(posicao);
            ItemListaEncadeada<T> itemAnterior = itemAtual.getAnterior();

            if (itemAtual == ultimoItem) {
                ultimoItem = itemAnterior;
                itemAnterior.setProximo(null);
            } else {
                itemAnterior.setProximo(itemAtual.getProximo());
            }

            return itemAtual.getDado();
        }

        public T validateRulesList(int posicao) throws Exception {
            if (posicao < 0) throw new Exception("Posi????o n??o pode ser negativa");
            if (posicao >= tamanho) throw new IndexOutOfBoundsException("Posi????o acima do tamanho da lista");

            return null;
        }

        public void printList() {
            ItemListaEncadeada<T> item = primeiroItem;

            System.out.println("\n");
            System.out.println("primeiroItem: " +  primeiroItem.getDado());
            System.out.println("ultimoItem: "  + ultimoItem.getDado());

            while (item.getProximo() != null) {
                System.out.println(item.getDado());
                item = item.getProximo();
            }

            System.out.println(item.getDado());
        }

        public void printListReverse() {
            ItemListaEncadeada<T> item = ultimoItem;

            System.out.println("\n");
            System.out.println("primeiroItem: " +  ultimoItem.getDado());
            System.out.println("ultimoItem: "  + primeiroItem.getDado());

            while (item.getAnterior() != null) {
                System.out.println(item.getDado());
                item = item.getAnterior();
            }

            System.out.println(item.getDado());
        }

        public static void main(String[] args) throws Exception {
            ListaDuplamenteEncadeada<String> lista = new ListaDuplamenteEncadeada<>();

            lista.add("Ana");
            lista.add("Andr??");
            lista.add("Ultimo");
            lista.add("F??bio");

            lista.printList();

            lista.printListReverse();

            //lista.remove(3);

            //lista.printList();
        }

    }

