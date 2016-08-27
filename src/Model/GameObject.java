package Model;

import java.awt.*;

/**
 * Created by HungNguyen on 8/27/2016.
 */
public class GameObject {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int point;
    protected int hp;

    protected boolean isAlive;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMiddleX() {
        return this.x + this.width / 2;
    }


    public GameObject(int x, int y, int width, int height, int point, int hp) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.point = point;
        this.hp = hp;
        this.isAlive = true;
    }

    public void move(GameVector gameVector) {
        this.x += gameVector.dx;
        this.y += gameVector.dy;
    }

    public void moveTo(int x, int y){
        this.x = x;
        this.y = y;
    }


    public boolean isAlive() {
        return isAlive;
    }

    public void destroy() {
        this.isAlive = false;
    }

    public boolean overlap(GameObject gameObject) {
        Rectangle rect1 = this.getRect();
        Rectangle rect2 = gameObject.getRect();
        return rect1.intersects(rect2);

    }

    private Rectangle getRect() {
        return new Rectangle(x, y, width, height);
    }

}
