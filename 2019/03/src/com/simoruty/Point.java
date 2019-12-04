package com.simoruty;

import java.util.Objects;

public class Point {
    private int x;
    private int y;
    private int steps;

    public Point(int x, int y, int steps) {
        this.x = x;
        this.y = y;
        this.steps = steps;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public Point(int x,int y){
        this.x = x;
        this.y = y;
        steps=0;
    }

    public void incX(int x){ this.x += x; }

    public void incY(int y){
        this.y += y;
    }

    public void decX(int x){
        this.x -= x;
    }

    public void decY(int y){
        this.y -= y;
    }

    public void incX(){ this.x++; }

    public void incY(){
        this.y++;
    }

    public void decX(){
        this.x--;
    }

    public void decY(){
        this.y--;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", steps=" + steps +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
