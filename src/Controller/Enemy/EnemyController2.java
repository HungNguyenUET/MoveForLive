package Controller.Enemy;//package Controller;
//
//import Model.Enemy;
//import View.GameDrawer;
//
///**
// * Created by giaqu on 8/23/2016.
// */
//public class EnemyController2 extends SingleController implements Colliable{
//
//    public EnemyController2(Enemy gameObject, GameDrawer gameDrawer) {
//        super(gameObject, gameDrawer);
//        if(this.getGameObject().getX() == 0) {
//            this.gameVector.dx += 3;
//        }
//        else if(this.getGameObject().getX() == 600) {
//            this.gameVector.dx -= 3;
//        }
//        CollisionPool.instance.add(this);
//    }
//
//    @Override
//    public void onCollide(Colliable colliable) {
//
//
//    }
//}
