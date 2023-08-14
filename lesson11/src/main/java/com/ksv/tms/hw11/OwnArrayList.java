package com.ksv.tms.hw11;

import java.util.Arrays;

/*Представим, что в Java нет коллекции типа ArrayList. Создать свой класс, симулирующий работу класса динамической коллекции
 - т.е. создать свою кастомную коллекцию. В основе коллекции будет массив. Кастомная коллекция должна хранить элементы
 разных классов(т.е. это generic). Предусмотреть операции добавления элемента, удаления элемента, получение элемента по индексу,
 проверка есть ли элемент в коллекции, метод очистки все коллекции. Предусмотреть конструктор без параметров - создает массив
  размером по умолчанию. Предусмотреть конструктор с задаваемым размером внутреннего массива. Предусмотреть возможность
  автоматического расширения коллекции при добавлении элемента в том случае, когда коллекция уже заполнена.*/
public class OwnArrayList<T> {
    private Object[] innerArray;
    private int nextElIndex = 0;

    public OwnArrayList() {
        innerArray = new Object[5];
    }

    public OwnArrayList(Integer length) {
        innerArray = new Object[length];
    }


    public void addElement(T el) {
        if (nextElIndex >= innerArray.length) {
            innerArray = Arrays.copyOf(innerArray, nextElIndex + 5);
        }
        innerArray[nextElIndex] = el;
        nextElIndex++;
    }

    public void removeElement(int index) {
        if (innerArray[index] != null) {
            innerArray[index] = null;
            for (int i = index; i < innerArray.length - 1; i++) {
                innerArray[i] = innerArray[i + 1];
            }
            nextElIndex--;
        }
    }

    public T getElementByIndex(int index) {
        return (T) innerArray[index];
    }

    public boolean containElement(T o) {
        boolean isContain = false;
        for (int i = 0; i < nextElIndex; i++) {
            if (innerArray[i] != null && innerArray[i].equals(o)) {
                isContain = true;
                break;
            } else if(innerArray[i] == null && o == null){
                isContain = true;
                break;
            }
        }
        return isContain;
    }

    public void clearArray() {
        for (int i = 0; i < innerArray.length; i++) {
            innerArray[i] = null;
        }
        nextElIndex = 0;
    }

    @Override
    public String toString() {
        return "OwnArrayList{" +
                "innerArray=" + Arrays.toString(innerArray) +
                ", nextElIndex=" + nextElIndex +
                '}';
    }
}
